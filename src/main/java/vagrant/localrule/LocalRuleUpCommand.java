package vagrant.localrule;

import vagrant.AbstractCommand;

import java.nio.file.Path;
import java.util.List;
import java.util.function.Supplier;

public class LocalRuleUpCommand extends AbstractCommand {
    public LocalRuleUpCommand(Supplier<List<String>> commandResultSupplier) {
        super(commandResultSupplier);
    }

    public LocalRuleUpCommand(Path base, boolean isFast) {
        super(new ShVagrantUpCommandResultSupplier(base, isFast));
    }
}
