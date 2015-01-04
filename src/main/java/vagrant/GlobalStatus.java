package vagrant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

import java.nio.file.Path;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GlobalStatus implements Comparable<GlobalStatus> {
    private String id;
    private String name;
    private String provider;
    private MachineState state;
    private Path directory;

    @Override
    public int compareTo(GlobalStatus o) {
        int ret = this.getState().compareTo(o.getState());
        return (ret == 0) ? this.getDirectory().compareTo(o.getDirectory()) : ret;
    }

    public static enum MachineState {
        RUNNING, POWEROFF, STOPPED, SUSPENDED;

        public static MachineState of(String name) {
            return MachineState.valueOf(name.toUpperCase());
        }
    }
}
