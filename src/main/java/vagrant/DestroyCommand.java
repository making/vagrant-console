package vagrant;


public class DestroyCommand extends AbstractCommand {
    public DestroyCommand(String id) {
        super(new VagrantCommandResultSupplier("destroy", "-f", id));
    }
}
