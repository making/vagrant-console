package vagrant;

import java.nio.file.Paths;
import java.util.List;
import java.util.StringTokenizer;
import java.util.function.Supplier;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GlobalStatusCommand extends AbstractCommand {
    private static final Pattern STATUS_LINE_PATTERN = Pattern.compile("^[a-f0-9]{7}\\s");

    public GlobalStatusCommand(Supplier<List<String>> commandResultSupplier) {
        super(commandResultSupplier);
    }

    public GlobalStatusCommand() {
        super(new VagrantCommandResultSupplier("global-status"));
    }


    public Stream<GlobalStatus> stream() {
        return run()
                .stream()
                .filter(x -> STATUS_LINE_PATTERN.matcher(x).find())
                .map(String::trim)
                .map(x -> {
                    StringTokenizer tokenizer = new StringTokenizer(x);
                    return GlobalStatus.builder()
                            .id(tokenizer.nextToken())
                            .name(tokenizer.nextToken())
                            .provider(tokenizer.nextToken())
                            .state(GlobalStatus.MachineState.of(tokenizer.nextToken()))
                            .directory(Paths.get(tokenizer.nextToken()))
                            .build();
                });
    }

    public List<GlobalStatus> list() {
        return stream().collect(Collectors.toList());
    }
}
