package vagrant;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.ArrayList;
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
            ProcessBuilder pb = new ProcessBuilder(this.args.toArray(new String[this.args.size()]));
            pb.redirectErrorStream(true);
            Process p = pb.start();
            log.info("{} => process start", this.args);
            //p.waitFor();
            try (InputStream stream = p.getInputStream();
                 BufferedReader reader = new BufferedReader(new InputStreamReader(stream))) {
                List<String> result = reader.lines().collect(Collectors.toList());
                while (stream.read() >= 0) ;
                return result;
            } finally {
                log.info("{} => process exit({})", this.args, "dummy"/* p.exitValue()*/);
            }
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }/* catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return Collections.emptyList();
        }*/
    }
}
