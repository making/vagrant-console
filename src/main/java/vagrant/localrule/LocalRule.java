package vagrant.localrule;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import vagrant.GlobalStatus;
import vagrant.vboxmanage.VmInfo;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocalRule {
    private GlobalStatus status;
    private VmInfo vmInfo;
}
