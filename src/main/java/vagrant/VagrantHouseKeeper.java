package vagrant;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.scheduling.annotation.Scheduled;

import javax.inject.Named;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Named
@Slf4j
public class VagrantHouseKeeper {
    @Value("${unhalt.path:file:/tmp/unhalt.txt}")
    Resource unhaltPath;

    public Set<String> loadUnhaltKeyword() {
        if (!unhaltPath.exists()) {
            return Collections.emptySet();
        }
        try {
            try (Stream<String> lines = Files.lines(unhaltPath.getFile().toPath())) {
                return lines.collect(Collectors.toSet());
            } finally {
                unhaltPath.getFile().delete();
            }
        } catch (IOException e) {
            log.error("!!!", e);
            return Collections.emptySet();
        }
    }

    @Scheduled(cron = "0 0 1 * * *") // every 1 am
    public void scheduledHalt() {
        log.info("scheduled halt start");
        Set<String> keywords = loadUnhaltKeyword();
        new GlobalStatusCommand().stream()
                .filter(status -> status.getState() == GlobalStatus.MachineState.RUNNING)
                .filter(status -> !status.getDirectory().toString().contains("jenkins") /* hardcoded */)
                .filter(status -> !keywords.stream().anyMatch(keyword -> status.getDirectory().toString().contains(keyword)))
                .forEach(status -> {
                    log.info("halt {}", status);
                    new HaltCommand(status.getId()).run();
                });
        log.info("scheduled halt end");
    }
}
