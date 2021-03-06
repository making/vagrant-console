package vagrant;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@Slf4j
public class AbstractCommandResultSupplier implements Supplier<List<String>> {
    private final List<String> args;

    public AbstractCommandResultSupplier(String command, String... args) {
        this.args = new ArrayList<>();
        this.args.add(command);
        for (String arg : args) {
            this.args.add(arg);
        }
    }

    @Override
    public List<String> get() {
        try {
            Process p = new ProcessBuilder(this.args.toArray(new String[this.args.size()])).start();
            log.info("{} => process start", this.args);
            p.waitFor();
            log.info("{} => process exit({})", this.args, p.exitValue());
            try (InputStream stream = p.getInputStream();
                 BufferedReader reader = new BufferedReader(new InputStreamReader(stream))) {
                return reader.lines().collect(Collectors.toList());
            }
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return Collections.emptyList();
        }
    }
}
