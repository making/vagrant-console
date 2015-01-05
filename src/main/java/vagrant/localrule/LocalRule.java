package vagrant.localrule;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import vagrant.GlobalStatus;
import vagrant.vboxmanage.VmInfo;

import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocalRule implements Comparable<LocalRule> {
    private GlobalStatus status;
    private VmInfo vmInfo;
    private boolean isFast;

    @Override
    public int compareTo(LocalRule o) {
        return Objects.compare(this, o, (x, y) -> x.getStatus().compareTo(y.getStatus()));
    }
}
