package vagrant.vboxmanage;

import vagrant.AbstractCommandResultSupplier;

public class VboxManageCommandResultSupplier extends AbstractCommandResultSupplier {
    public VboxManageCommandResultSupplier(String... args) {
        super("VBoxManage", args);
    }
}
