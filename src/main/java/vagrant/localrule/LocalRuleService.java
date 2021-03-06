package vagrant.localrule;


import lombok.Data;
import vagrant.GlobalStatusCommand;
import vagrant.vboxmanage.ListVmsCommand;
import vagrant.vboxmanage.SharedFolder;
import vagrant.vboxmanage.VmInfo;

import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Data
public class LocalRuleService {
    private final ListVmsCommand listVmsCommand;
    private final GlobalStatusCommand globalStatusCommand;

    public List<LocalRule> list() {
        Map<Path, VmInfo> map = listVmsCommand.stream()
                .collect(Collectors.toMap(x -> x.getSharedFolders().stream()
                                .filter(info -> "vagrant".equals(info.getName()))
                                .map(SharedFolder::getHostPath)
                                .findFirst().get(),
                        Function.identity()));
        return globalStatusCommand.stream()
                .map(x -> new LocalRule(x, map.get(x.getDirectory())))
                .sorted()
                .collect(Collectors.toList());
    }

}
