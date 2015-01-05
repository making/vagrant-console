package vagrant.localrule;

import vagrant.AbstractCommandResultSupplier;

import java.nio.file.Path;
import java.util.regex.Pattern;

public class ShVagrantUpCommandResultSupplier extends AbstractCommandResultSupplier {
    public ShVagrantUpCommandResultSupplier(Path base, boolean isFast) {
        super("sh", "-c", "(cd " + createShDir(base) + ";sh " + (isFast ? "vagrant-up-fast.sh" : "vagrant-up.sh") + ")");
    }

    static String createShDir(Path base) {
        String shDir = base.toAbsolutePath().toUri().toString();
        return shDir.replaceAll(Pattern.quote("file://"), "").replaceAll(Pattern.quote(":/"), "/");
    }
}
