package vagrant.localrule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import vagrant.DestroyCommand;
import vagrant.HaltCommand;
import vagrant.UpCommand;

import java.nio.file.Path;

@Service
@Slf4j
public class AsyncLocalRuleService {
    @Async
    public void up(String id) {
        log.info("up -> {}", id);
        String result = new UpCommand(id).runToString();
        log.info("done -> {}", id);
        log.info(result);
    }

    @Async
    public void localRulUp(Path base, boolean isFast) {
        log.info("up -> base={} isFast={}", base, isFast);
        String result = new LocalRuleUpCommand(base, isFast).runToString();
        log.info("done -> base={} isFast={}", base, isFast);
        log.info(result);
    }

    @Async
    public void halt(String id) {
        log.info("halt -> {}", id);
        String result = new HaltCommand(id).runToString();
        log.info("done -> {}", id);
        log.info(result);
    }

    @Async
    public void destroy(String id) {
        log.info("destroy -> {}", id);
        String result = new DestroyCommand(id).runToString();
        log.info("done -> {}", id);
        log.info(result);
    }
}
