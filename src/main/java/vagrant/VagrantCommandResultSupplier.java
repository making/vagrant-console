package vagrant;

public class VagrantCommandResultSupplier extends AbstractCommandResultSupplier {

    public VagrantCommandResultSupplier(String... args) {
        super("vagrant", args);
    }
}
