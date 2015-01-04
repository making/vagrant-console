package vagrant;


public class HaltCommand extends AbstractCommand {
    public HaltCommand(String id) {
        super(new VagrantCommandResultSupplier("halt", id));
    }
}
