package vagrant;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public abstract class AbstractCommand {
    // for testability
    protected final Supplier<List<String>> commandResultSupplier;

    public AbstractCommand(Supplier<List<String>> commandResultSupplier) {
        this.commandResultSupplier = commandResultSupplier;
    }

    public List<String> run() {
        return this.commandResultSupplier.get();
    }

    public String runToString() {
        return run().stream().collect(Collectors.joining(System.lineSeparator()));
    }
}
