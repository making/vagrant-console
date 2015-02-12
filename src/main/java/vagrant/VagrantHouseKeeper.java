package vagrant;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;

import javax.inject.Named;

@Named
@Slf4j
public class VagrantHouseKeeper {

    @Scheduled(cron = "0 0 1 * * *") // every 1 am
    public void scheduledHalt() {
        log.info("scheduled halt start");
        new GlobalStatusCommand().stream()
                .filter(status -> status.getState() == GlobalStatus.MachineState.RUNNING)
                .filter(status -> !status.getDirectory().toString().contains("jenkins"))
                .forEach(status -> {
                    log.info("halt {}", status);
                    new HaltCommand(status.getId()).run();
                });
        log.info("scheduled halt end");
    }
}
