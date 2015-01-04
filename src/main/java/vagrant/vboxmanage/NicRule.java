package vagrant.vboxmanage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NicRule {
    private String nickName;
    private String ruleName;
    private String protocol;
    private String hostIp;
    private int hostPort;
    private String guestIp;
    private int guestPort;
}
