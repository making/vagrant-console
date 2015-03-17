package vagrant.vboxmanage;

import vagrant.AbstractCommand;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;


public class ListVmsCommand extends AbstractCommand {
    private static final Pattern NICRULE_PATTERN = Pattern.compile("(NIC [0-9]+) Rule\\([0-9]+\\):\\s+name = ([a-zA-Z0-9]+), protocol = ([a-zA-Z0-9]+), host ip = ([a-zA-Z0-9\\.]*), host port = ([0-9]+), guest ip = ([a-zA-Z0-9\\.]*), guest port = ([0-9]+)");
    private static final Pattern SHAREDFOLDER_PATTERN = Pattern.compile("Name: '(.+)', Host path: '(.+)' \\(machine mapping\\), writable");

    public ListVmsCommand() {
        super(new VboxManageCommandResultSupplier("list", "-l", "vms"));
    }

    public ListVmsCommand(Supplier<List<String>> supplier) {
        super(supplier);
    }

    public List<VmInfo> list() {
        Iterator<String> iterator = run().iterator();
        List<VmInfo> list = new ArrayList<>();
        VmInfo.VmInfoBuilder builder = null;
        while (iterator.hasNext()) {
            String line = iterator.next();
            if (line.startsWith("Name:            ")) {
                if (builder == null) {
                    // first time
                    builder = VmInfo.builder();
                } else {
                    list.add(builder.build());
                    builder = VmInfo.builder();
                }
                builder.name(line.substring("Name:            ".length()));
            } else if (line.startsWith("Guest OS:        ") && builder != null) {
                builder.guestOS(line.substring("Guest OS:        ".length()));
            } else if (line.startsWith("UUID:            ") && builder != null) {
                builder.uuid(UUID.fromString(line.substring("UUID:            ".length())));
            } else if (line.startsWith("Config file:     ") && builder != null) {
                builder.configFile(Paths.get(line.substring("Config file:     ".length())));
            } else if (line.startsWith("Memory size:     ") && builder != null) {
                builder.memorySize(line.substring("Memory size:     ".length()));
            } else if (line.startsWith("Number of CPUs:  ") && builder != null) {
                builder.numberOfCpus(Integer.parseInt(line.substring("Number of CPUs:  ".length())));
            } else if (line.startsWith("State:           ") && builder != null) {
                builder.state(line.substring("State:           ".length()));
            } else if (line.startsWith("NIC ") && builder != null) {
                List<NicRule> nickRules = new ArrayList<>();
                parseNic(line, iterator, nickRules);
                builder.nicRules(nickRules);
            } else if (line.startsWith("Shared folders:") && builder != null) {
                iterator.next(); // skip empty line
                List<SharedFolder> sharedFolders = new ArrayList<>();
                parseSharedFolders(iterator.next(), iterator, sharedFolders);
                builder.sharedFolders(sharedFolders);
            } else if (line.startsWith("Description:") && builder != null) {
                String description = iterator.next();
                builder.description(description);
            }
        }
        if (builder != null) {
            list.add(builder.build());
        }
        return list;
    }

    private void parseNic(String line, Iterator<String> iterator, List<NicRule> nickRules) {
        if (!line.startsWith("NIC")) return;
        boolean isEnabled = !line.substring("NIC 1:           ".length()).startsWith("disabled");
        if (isEnabled) {
            String ruleLine = iterator.next();
            if (ruleLine.contains("Rule(")) {
                Matcher matcher = NICRULE_PATTERN.matcher(ruleLine);
                if (matcher.matches()) {
                    nickRules.add(
                            NicRule.builder()
                                    .nickName(matcher.group(1))
                                    .ruleName(matcher.group(2))
                                    .protocol(matcher.group(3))
                                    .hostIp(matcher.group(4))
                                    .hostPort(Integer.parseInt(matcher.group(5)))
                                    .guestIp(matcher.group(6))
                                    .guestPort(Integer.parseInt(matcher.group(7)))
                                    .build());
                }
            }
            parseNic(ruleLine, iterator, nickRules);
        } else {
            parseNic(iterator.next(), iterator, nickRules);
        }
    }

    private void parseSharedFolders(String line, Iterator<String> iterator, List<SharedFolder> sharedFolders) {
        if (!line.startsWith("Name:")) return;
        Matcher matcher = SHAREDFOLDER_PATTERN.matcher(line);
        if (matcher.matches()) {
            String name = matcher.group(1);
            sharedFolders.add(SharedFolder.builder()
                    .name(name.startsWith("/") ? name.substring(1) : name)
                    .hostPath(Paths.get(matcher.group(2)))
                    .build());
        }
        parseSharedFolders(iterator.next(), iterator, sharedFolders);
    }

    public Stream<VmInfo> stream() {
        return list().stream();
    }
}
