package vagrant;

import lombok.extern.slf4j.Slf4j;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;

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
            String line;
            try (InputStream stream = p.getInputStream();
                 ByteArrayOutputStream out = new ByteArrayOutputStream();) {
                int b;
                while ((b = stream.read()) != -1) {
                    out.write(b);
                }
                line = new String(out.toByteArray());
            }
            int exitValue = p.waitFor();
            log.info("{} => process exit({})", this.args, exitValue);
            return Arrays.asList(line.split(System.lineSeparator()));
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return Collections.emptyList();
        }
    }
}
