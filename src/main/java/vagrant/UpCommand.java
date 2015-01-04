package vagrant;


public class UpCommand extends AbstractCommand {
    public UpCommand(String id) {
        super(new VagrantCommandResultSupplier("up", id));
    }
}
