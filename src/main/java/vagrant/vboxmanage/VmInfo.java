package vagrant.vboxmanage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Builder;

import java.nio.file.Path;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VmInfo {
    private String name;
    private String guestOS;
    private UUID uuid;
    private Path configFile;
    private String memorySize;
    private int numberOfCpus;
    private String state;
    private List<NicRule> nicRules;
    private List<SharedFolder> sharedFolders;
}
