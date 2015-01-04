package vagrant.vboxmanage;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.Test;

import java.util.Arrays;

public class ListVmsCommandTest {
    @Test
    @Ignore
    public void testFoo() throws Exception {
        new ListVmsCommand().stream()
                .forEach(System.out::println);
    }

    @Test
    public void test() throws Exception {
        ListVmsCommand command = new ListVmsCommand(() -> Arrays.asList(("Name:            apsrv01_default_1393153752357_51723\n" +
                "Groups:          /\n" +
                "Guest OS:        Red Hat (64 bit)\n" +
                "UUID:            ecaac198-2a0a-4233-b599-ab8bd94d7286\n" +
                "Config file:     /home/maki/VirtualBox VMs/apsrv01_default_1393153752357_51723/apsrv01_default_1393153752357_51723.vbox\n" +
                "Snapshot folder: /home/maki/VirtualBox VMs/apsrv01_default_1393153752357_51723/Snapshots\n" +
                "Log folder:      /home/maki/VirtualBox VMs/apsrv01_default_1393153752357_51723/Logs\n" +
                "Hardware UUID:   ecaac198-2a0a-4233-b599-ab8bd94d7286\n" +
                "Memory size:     2048MB\n" +
                "Page Fusion:     off\n" +
                "VRAM size:       8MB\n" +
                "CPU exec cap:    100%\n" +
                "HPET:            off\n" +
                "Chipset:         piix3\n" +
                "Firmware:        BIOS\n" +
                "Number of CPUs:  1\n" +
                "PAE:             on\n" +
                "Long Mode:       on\n" +
                "Synthetic CPU:   off\n" +
                "CPUID overrides: None\n" +
                "Boot menu mode:  message and menu\n" +
                "Boot Device (1): HardDisk\n" +
                "Boot Device (2): DVD\n" +
                "Boot Device (3): Not Assigned\n" +
                "Boot Device (4): Not Assigned\n" +
                "ACPI:            on\n" +
                "IOAPIC:          on\n" +
                "Time offset:     0ms\n" +
                "RTC:             UTC\n" +
                "Hardw. virt.ext: on\n" +
                "Nested Paging:   on\n" +
                "Large Pages:     on\n" +
                "VT-x VPID:       on\n" +
                "VT-x unr. exec.: on\n" +
                "State:           aborted (since 2014-03-09T10:17:39.000000000)\n" +
                "Monitor count:   1\n" +
                "3D Acceleration: off\n" +
                "2D Video Acceleration: off\n" +
                "Teleporter Enabled: off\n" +
                "Teleporter Port: 0\n" +
                "Teleporter Address:\n" +
                "Teleporter Password:\n" +
                "Tracing Enabled: off\n" +
                "Allow Tracing to Access VM: off\n" +
                "Tracing Configuration:\n" +
                "Autostart Enabled: off\n" +
                "Autostart Delay: 0\n" +
                "Default Frontend:\n" +
                "Storage Controller Name (0):            IDE Controller\n" +
                "Storage Controller Type (0):            PIIX4\n" +
                "Storage Controller Instance Number (0): 0\n" +
                "Storage Controller Max Port Count (0):  2\n" +
                "Storage Controller Port Count (0):      2\n" +
                "Storage Controller Bootable (0):        on\n" +
                "IDE Controller (0, 0): /home/maki/VirtualBox VMs/apsrv01_default_1393153752357_51723/centos65-disk1.vmdk (UUID: ec7d1f0e-e956-4f62-8f12-90dfe6b80297)\n" +
                "NIC 1:           MAC: 08002773BF1C, Attachment: NAT, Cable connected: on, Trace: off (file: none), Type: 82540EM, Reported speed: 0 Mbps, Boot priority: 0, Promisc Policy: deny, Bandwidth group: none\n" +
                "NIC 1 Settings:  MTU: 0, Socket (send: 64, receive: 64), TCP Window (send:64, receive: 64)\n" +
                "NIC 1 Rule(0):   name = ssh, protocol = tcp, host ip = 127.0.0.1, host port = 2222, guest ip = , guest port = 22\n" +
                "NIC 2:           disabled\n" +
                "NIC 3:           disabled\n" +
                "NIC 4:           disabled\n" +
                "NIC 5:           disabled\n" +
                "NIC 6:           disabled\n" +
                "NIC 7:           disabled\n" +
                "NIC 8:           disabled\n" +
                "Pointing Device: PS/2 Mouse\n" +
                "Keyboard Device: PS/2 Keyboard\n" +
                "UART 1:          disabled\n" +
                "UART 2:          disabled\n" +
                "LPT 1:           disabled\n" +
                "LPT 2:           disabled\n" +
                "Audio:           disabled\n" +
                "Clipboard Mode:  disabled\n" +
                "Drag'n'drop Mode: disabled\n" +
                "VRDE:            disabled\n" +
                "USB:             disabled\n" +
                "EHCI:            disabled\n" +
                "\n" +
                "USB Device Filters:\n" +
                "\n" +
                "<none>\n" +
                "\n" +
                "Bandwidth groups:  <none>\n" +
                "\n" +
                "Shared folders:\n" +
                "\n" +
                "Name: '/vagrant', Host path: '/opt/vm/apsrv01' (machine mapping), writable\n" +
                "\n" +
                "Video capturing:    not active\n" +
                "Capture screens:    0\n" +
                "Capture file:       /home/maki/VirtualBox VMs/apsrv01_default_1393153752357_51723/apsrv01_default_1393153752357_51723.webm\n" +
                "Capture dimensions: 1024x768\n" +
                "Capture rate:       512 kbps\n" +
                "Capture FPS:        25\n" +
                "\n" +
                "Guest:\n" +
                "\n" +
                "Configured memory balloon size:      0 MB\n" +
                "\n" +
                "\n" +
                "Name:            base_default_1396768434663_40468\n" +
                "Groups:          /\n" +
                "Guest OS:        Red Hat (64 bit)\n" +
                "UUID:            c83dfc41-b76f-4351-b95d-09a6a06377b0\n" +
                "Config file:     /home/maki/VirtualBox VMs/base_default_1396768434663_40468/base_default_1396768434663_40468.vbox\n" +
                "Snapshot folder: /home/maki/VirtualBox VMs/base_default_1396768434663_40468/Snapshots\n" +
                "Log folder:      /home/maki/VirtualBox VMs/base_default_1396768434663_40468/Logs\n" +
                "Hardware UUID:   c83dfc41-b76f-4351-b95d-09a6a06377b0\n" +
                "Memory size:     512MB\n" +
                "Page Fusion:     off\n" +
                "VRAM size:       8MB\n" +
                "CPU exec cap:    100%\n" +
                "HPET:            off\n" +
                "Chipset:         piix3\n" +
                "Firmware:        BIOS\n" +
                "Number of CPUs:  1\n" +
                "PAE:             on\n" +
                "Long Mode:       on\n" +
                "Synthetic CPU:   off\n" +
                "CPUID overrides: None\n" +
                "Boot menu mode:  message and menu\n" +
                "Boot Device (1): HardDisk\n" +
                "Boot Device (2): DVD\n" +
                "Boot Device (3): Not Assigned\n" +
                "Boot Device (4): Not Assigned\n" +
                "ACPI:            on\n" +
                "IOAPIC:          on\n" +
                "Time offset:     0ms\n" +
                "RTC:             UTC\n" +
                "Hardw. virt.ext: on\n" +
                "Nested Paging:   on\n" +
                "Large Pages:     on\n" +
                "VT-x VPID:       on\n" +
                "VT-x unr. exec.: on\n" +
                "State:           powered off (since 2014-04-06T07:17:51.000000000)\n" +
                "Monitor count:   1\n" +
                "3D Acceleration: off\n" +
                "2D Video Acceleration: off\n" +
                "Teleporter Enabled: off\n" +
                "Teleporter Port: 0\n" +
                "Teleporter Address:\n" +
                "Teleporter Password:\n" +
                "Tracing Enabled: off\n" +
                "Allow Tracing to Access VM: off\n" +
                "Tracing Configuration:\n" +
                "Autostart Enabled: off\n" +
                "Autostart Delay: 0\n" +
                "Default Frontend:\n" +
                "Storage Controller Name (0):            IDE Controller\n" +
                "Storage Controller Type (0):            PIIX4\n" +
                "Storage Controller Instance Number (0): 0\n" +
                "Storage Controller Max Port Count (0):  2\n" +
                "Storage Controller Port Count (0):      2\n" +
                "Storage Controller Bootable (0):        on\n" +
                "IDE Controller (0, 0): /home/maki/VirtualBox VMs/base_default_1396768434663_40468/centos65-disk1.vmdk (UUID: 4a004d94-4daf-4399-a86e-4c40d0394071)\n" +
                "NIC 1:           MAC: 08002773BF1C, Attachment: NAT, Cable connected: on, Trace: off (file: none), Type: 82540EM, Reported speed: 0 Mbps, Boot priority: 0, Promisc Policy: deny, Bandwidth group: none\n" +
                "NIC 1 Settings:  MTU: 0, Socket (send: 64, receive: 64), TCP Window (send:64, receive: 64)\n" +
                "NIC 1 Rule(0):   name = ssh, protocol = tcp, host ip = 127.0.0.1, host port = 2222, guest ip = , guest port = 22\n" +
                "NIC 2:           disabled\n" +
                "NIC 3:           disabled\n" +
                "NIC 4:           disabled\n" +
                "NIC 5:           disabled\n" +
                "NIC 6:           disabled\n" +
                "NIC 7:           disabled\n" +
                "NIC 8:           disabled\n" +
                "Pointing Device: PS/2 Mouse\n" +
                "Keyboard Device: PS/2 Keyboard\n" +
                "UART 1:          disabled\n" +
                "UART 2:          disabled\n" +
                "LPT 1:           disabled\n" +
                "LPT 2:           disabled\n" +
                "Audio:           disabled\n" +
                "Clipboard Mode:  disabled\n" +
                "Drag'n'drop Mode: disabled\n" +
                "VRDE:            disabled\n" +
                "USB:             disabled\n" +
                "EHCI:            disabled\n" +
                "\n" +
                "USB Device Filters:\n" +
                "\n" +
                "<none>\n" +
                "\n" +
                "Bandwidth groups:  <none>\n" +
                "\n" +
                "Shared folders:\n" +
                "\n" +
                "Name: '/vagrant', Host path: '/home/maki/work/my-vagrant-conf/base' (machine mapping), writable\n" +
                "\n" +
                "Video capturing:    not active\n" +
                "Capture screens:    0\n" +
                "Capture file:       /home/maki/VirtualBox VMs/base_default_1396768434663_40468/base_default_1396768434663_40468.webm\n" +
                "Capture dimensions: 1024x768\n" +
                "Capture rate:       512 kbps\n" +
                "Capture FPS:        25\n" +
                "\n" +
                "Guest:\n" +
                "\n" +
                "Configured memory balloon size:      0 MB\n" +
                "\n" +
                "\n" +
                "Name:            centos7_default_1410694136720_70867\n" +
                "Groups:          /\n" +
                "Guest OS:        Red Hat (64 bit)\n" +
                "UUID:            637eebac-899e-448b-a642-3088f0dbc34f\n" +
                "Config file:     /home/maki/VirtualBox VMs/centos7_default_1410694136720_70867/centos7_default_1410694136720_70867.vbox\n" +
                "Snapshot folder: /home/maki/VirtualBox VMs/centos7_default_1410694136720_70867/Snapshots\n" +
                "Log folder:      /home/maki/VirtualBox VMs/centos7_default_1410694136720_70867/Logs\n" +
                "Hardware UUID:   637eebac-899e-448b-a642-3088f0dbc34f\n" +
                "Memory size:     1024MB\n" +
                "Page Fusion:     off\n" +
                "VRAM size:       8MB\n" +
                "CPU exec cap:    100%\n" +
                "HPET:            off\n" +
                "Chipset:         piix3\n" +
                "Firmware:        BIOS\n" +
                "Number of CPUs:  2\n" +
                "PAE:             on\n" +
                "Long Mode:       on\n" +
                "Synthetic CPU:   off\n" +
                "CPUID overrides: None\n" +
                "Boot menu mode:  message and menu\n" +
                "Boot Device (1): HardDisk\n" +
                "Boot Device (2): DVD\n" +
                "Boot Device (3): Not Assigned\n" +
                "Boot Device (4): Not Assigned\n" +
                "ACPI:            on\n" +
                "IOAPIC:          on\n" +
                "Time offset:     0ms\n" +
                "RTC:             UTC\n" +
                "Hardw. virt.ext: on\n" +
                "Nested Paging:   on\n" +
                "Large Pages:     on\n" +
                "VT-x VPID:       on\n" +
                "VT-x unr. exec.: on\n" +
                "State:           powered off (since 2014-09-14T16:58:30.000000000)\n" +
                "Monitor count:   1\n" +
                "3D Acceleration: off\n" +
                "2D Video Acceleration: off\n" +
                "Teleporter Enabled: off\n" +
                "Teleporter Port: 0\n" +
                "Teleporter Address:\n" +
                "Teleporter Password:\n" +
                "Tracing Enabled: off\n" +
                "Allow Tracing to Access VM: off\n" +
                "Tracing Configuration:\n" +
                "Autostart Enabled: off\n" +
                "Autostart Delay: 0\n" +
                "Default Frontend:\n" +
                "Storage Controller Name (0):            IDE Controller\n" +
                "Storage Controller Type (0):            PIIX4\n" +
                "Storage Controller Instance Number (0): 0\n" +
                "Storage Controller Max Port Count (0):  2\n" +
                "Storage Controller Port Count (0):      2\n" +
                "Storage Controller Bootable (0):        on\n" +
                "IDE Controller (0, 0): /home/maki/VirtualBox VMs/centos7_default_1410694136720_70867/centos7.0-disk1.vmdk (UUID: a9217709-bda2-4f74-87e9-cf745f9975a4)\n" +
                "NIC 1:           MAC: 080027BA8F35, Attachment: NAT, Cable connected: on, Trace: off (file: none), Type: 82540EM, Reported speed: 0 Mbps, Boot priority: 0, Promisc Policy: deny, Bandwidth group: none\n" +
                "NIC 1 Settings:  MTU: 0, Socket (send: 64, receive: 64), TCP Window (send:64, receive: 64)\n" +
                "NIC 1 Rule(0):   name = ssh, protocol = tcp, host ip = 127.0.0.1, host port = 2222, guest ip = , guest port = 22\n" +
                "NIC 2:           disabled\n" +
                "NIC 3:           disabled\n" +
                "NIC 4:           disabled\n" +
                "NIC 5:           disabled\n" +
                "NIC 6:           disabled\n" +
                "NIC 7:           disabled\n" +
                "NIC 8:           disabled\n" +
                "Pointing Device: PS/2 Mouse\n" +
                "Keyboard Device: PS/2 Keyboard\n" +
                "UART 1:          disabled\n" +
                "UART 2:          disabled\n" +
                "LPT 1:           disabled\n" +
                "LPT 2:           disabled\n" +
                "Audio:           disabled\n" +
                "Clipboard Mode:  disabled\n" +
                "Drag'n'drop Mode: disabled\n" +
                "VRDE:            disabled\n" +
                "USB:             disabled\n" +
                "EHCI:            disabled\n" +
                "\n" +
                "USB Device Filters:\n" +
                "\n" +
                "<none>\n" +
                "\n" +
                "Bandwidth groups:  <none>\n" +
                "\n" +
                "Shared folders:\n" +
                "\n" +
                "Name: 'vagrant', Host path: '/home/maki/work/centos7' (machine mapping), writable\n" +
                "\n" +
                "Video capturing:    not active\n" +
                "Capture screens:    0\n" +
                "Capture file:       /home/maki/VirtualBox VMs/centos7_default_1410694136720_70867/centos7_default_1410694136720_70867.webm\n" +
                "Capture dimensions: 1024x768\n" +
                "Capture rate:       512 kbps\n" +
                "Capture FPS:        25\n" +
                "\n" +
                "Guest:\n" +
                "\n" +
                "Configured memory balloon size:      0 MB\n" +
                "\n" +
                "\n" +
                "Name:            oradb\n" +
                "Groups:          /\n" +
                "Guest OS:        Oracle (64 bit)\n" +
                "UUID:            9e974f70-a9fe-40b1-bb57-fa44a12d23a7\n" +
                "Config file:     /home/maki/VirtualBox VMs/oradb/oradb.vbox\n" +
                "Snapshot folder: /home/maki/VirtualBox VMs/oradb/Snapshots\n" +
                "Log folder:      /home/maki/VirtualBox VMs/oradb/Logs\n" +
                "Hardware UUID:   9e974f70-a9fe-40b1-bb57-fa44a12d23a7\n" +
                "Memory size:     2048MB\n" +
                "Page Fusion:     off\n" +
                "VRAM size:       12MB\n" +
                "CPU exec cap:    100%\n" +
                "HPET:            off\n" +
                "Chipset:         piix3\n" +
                "Firmware:        BIOS\n" +
                "Number of CPUs:  2\n" +
                "PAE:             on\n" +
                "Long Mode:       on\n" +
                "Synthetic CPU:   off\n" +
                "CPUID overrides: None\n" +
                "Boot menu mode:  message and menu\n" +
                "Boot Device (1): DVD\n" +
                "Boot Device (2): HardDisk\n" +
                "Boot Device (3): Not Assigned\n" +
                "Boot Device (4): Not Assigned\n" +
                "ACPI:            on\n" +
                "IOAPIC:          on\n" +
                "Time offset:     0ms\n" +
                "RTC:             UTC\n" +
                "Hardw. virt.ext: on\n" +
                "Nested Paging:   on\n" +
                "Large Pages:     off\n" +
                "VT-x VPID:       on\n" +
                "VT-x unr. exec.: on\n" +
                "State:           powered off (since 2014-12-16T13:44:06.000000000)\n" +
                "Monitor count:   1\n" +
                "3D Acceleration: off\n" +
                "2D Video Acceleration: off\n" +
                "Teleporter Enabled: off\n" +
                "Teleporter Port: 0\n" +
                "Teleporter Address:\n" +
                "Teleporter Password:\n" +
                "Tracing Enabled: off\n" +
                "Allow Tracing to Access VM: off\n" +
                "Tracing Configuration:\n" +
                "Autostart Enabled: off\n" +
                "Autostart Delay: 0\n" +
                "Default Frontend:\n" +
                "Storage Controller Name (0):            IDE\n" +
                "Storage Controller Type (0):            PIIX4\n" +
                "Storage Controller Instance Number (0): 0\n" +
                "Storage Controller Max Port Count (0):  2\n" +
                "Storage Controller Port Count (0):      2\n" +
                "Storage Controller Bootable (0):        on\n" +
                "Storage Controller Name (1):            SATA\n" +
                "Storage Controller Type (1):            IntelAhci\n" +
                "Storage Controller Instance Number (1): 0\n" +
                "Storage Controller Max Port Count (1):  30\n" +
                "Storage Controller Port Count (1):      1\n" +
                "Storage Controller Bootable (1):        on\n" +
                "IDE (1, 0): Empty\n" +
                "SATA (0, 0): /home/maki/VirtualBox VMs/oradb/box-disk2.vmdk (UUID: d41f4f63-7f6c-4d3c-b85e-5ffd87acee2e)\n" +
                "NIC 1:           MAC: 0800278695B1, Attachment: NAT, Cable connected: on, Trace: off (file: none), Type: 82540EM, Reported speed: 0 Mbps, Boot priority: 0, Promisc Policy: deny, Bandwidth group: none\n" +
                "NIC 1 Settings:  MTU: 0, Socket (send: 64, receive: 64), TCP Window (send:64, receive: 64)\n" +
                "NIC 1 Rule(0):   name = ssh, protocol = tcp, host ip = 127.0.0.1, host port = 2222, guest ip = , guest port = 22\n" +
                "NIC 1 Rule(1):   name = tcp1158, protocol = tcp, host ip = , host port = 1158, guest ip = , guest port = 1158\n" +
                "NIC 1 Rule(2):   name = tcp1521, protocol = tcp, host ip = , host port = 1521, guest ip = , guest port = 1521\n" +
                "NIC 2:           disabled\n" +
                "NIC 3:           disabled\n" +
                "NIC 4:           disabled\n" +
                "NIC 5:           disabled\n" +
                "NIC 6:           disabled\n" +
                "NIC 7:           disabled\n" +
                "NIC 8:           disabled\n" +
                "Pointing Device: PS/2 Mouse\n" +
                "Keyboard Device: PS/2 Keyboard\n" +
                "UART 1:          disabled\n" +
                "UART 2:          disabled\n" +
                "LPT 1:           disabled\n" +
                "LPT 2:           disabled\n" +
                "Audio:           disabled\n" +
                "Clipboard Mode:  disabled\n" +
                "Drag'n'drop Mode: disabled\n" +
                "VRDE:            disabled\n" +
                "USB:             enabled\n" +
                "EHCI:            enabled\n" +
                "\n" +
                "USB Device Filters:\n" +
                "\n" +
                "<none>\n" +
                "\n" +
                "Bandwidth groups:  <none>\n" +
                "\n" +
                "Shared folders:\n" +
                "\n" +
                "Name: 'vagrant', Host path: '/home/maki/work/vagrant-oracle-11g' (machine mapping), writable\n" +
                "Name: 'tmp_vagrant-puppet-3_manifests', Host path: '/home/maki/work/vagrant-oracle-11g/manifests' (machine mapping), writable\n" +
                "Name: 'tmp_vagrant-puppet-3_modules-0', Host path: '/home/maki/work/vagrant-oracle-11g/modules' (machine mapping), writable\n" +
                "\n" +
                "Video capturing:    not active\n" +
                "Capture screens:    0\n" +
                "Capture file:       /home/maki/VirtualBox VMs/oradb/oradb.webm\n" +
                "Capture dimensions: 1024x768\n" +
                "Capture rate:       512 kbps\n" +
                "Capture FPS:        25\n" +
                "\n" +
                "Description:\n" +
                "Oracle Linux 6 x86_64\n" +
                "Guest:\n" +
                "\n" +
                "Configured memory balloon size:      0 MB\n" +
                "\n" +
                "\n" +
                "Name:            foundationdb_default_1418736862696_38931\n" +
                "Groups:          /\n" +
                "Guest OS:        Red Hat (64 bit)\n" +
                "UUID:            70a7aff3-b0a1-4764-881b-5b0ff6723487\n" +
                "Config file:     /home/maki/VirtualBox VMs/foundationdb_default_1418736862696_38931/foundationdb_default_1418736862696_38931.vbox\n" +
                "Snapshot folder: /home/maki/VirtualBox VMs/foundationdb_default_1418736862696_38931/Snapshots\n" +
                "Log folder:      /home/maki/VirtualBox VMs/foundationdb_default_1418736862696_38931/Logs\n" +
                "Hardware UUID:   70a7aff3-b0a1-4764-881b-5b0ff6723487\n" +
                "Memory size:     5120MB\n" +
                "Page Fusion:     off\n" +
                "VRAM size:       8MB\n" +
                "CPU exec cap:    100%\n" +
                "HPET:            off\n" +
                "Chipset:         piix3\n" +
                "Firmware:        BIOS\n" +
                "Number of CPUs:  1\n" +
                "PAE:             on\n" +
                "Long Mode:       on\n" +
                "Synthetic CPU:   off\n" +
                "CPUID overrides: None\n" +
                "Boot menu mode:  message and menu\n" +
                "Boot Device (1): HardDisk\n" +
                "Boot Device (2): DVD\n" +
                "Boot Device (3): Not Assigned\n" +
                "Boot Device (4): Not Assigned\n" +
                "ACPI:            on\n" +
                "IOAPIC:          on\n" +
                "Time offset:     0ms\n" +
                "RTC:             UTC\n" +
                "Hardw. virt.ext: on\n" +
                "Nested Paging:   on\n" +
                "Large Pages:     on\n" +
                "VT-x VPID:       on\n" +
                "VT-x unr. exec.: on\n" +
                "State:           powered off (since 2014-12-16T14:59:26.000000000)\n" +
                "Monitor count:   1\n" +
                "3D Acceleration: off\n" +
                "2D Video Acceleration: off\n" +
                "Teleporter Enabled: off\n" +
                "Teleporter Port: 0\n" +
                "Teleporter Address:\n" +
                "Teleporter Password:\n" +
                "Tracing Enabled: off\n" +
                "Allow Tracing to Access VM: off\n" +
                "Tracing Configuration:\n" +
                "Autostart Enabled: off\n" +
                "Autostart Delay: 0\n" +
                "Default Frontend:\n" +
                "Storage Controller Name (0):            IDE Controller\n" +
                "Storage Controller Type (0):            PIIX4\n" +
                "Storage Controller Instance Number (0): 0\n" +
                "Storage Controller Max Port Count (0):  2\n" +
                "Storage Controller Port Count (0):      2\n" +
                "Storage Controller Bootable (0):        on\n" +
                "IDE Controller (0, 0): /home/maki/VirtualBox VMs/foundationdb_default_1418736862696_38931/centos65-disk1.vmdk (UUID: 3c273443-b8ef-4ad8-923f-0421ed439e92)\n" +
                "NIC 1:           MAC: 08002773BF1C, Attachment: NAT, Cable connected: on, Trace: off (file: none), Type: 82540EM, Reported speed: 0 Mbps, Boot priority: 0, Promisc Policy: deny, Bandwidth group: none\n" +
                "NIC 1 Settings:  MTU: 0, Socket (send: 64, receive: 64), TCP Window (send:64, receive: 64)\n" +
                "NIC 1 Rule(0):   name = ssh, protocol = tcp, host ip = 127.0.0.1, host port = 2200, guest ip = , guest port = 22\n" +
                "NIC 1 Rule(1):   name = tcp15432, protocol = tcp, host ip = , host port = 15432, guest ip = , guest port = 15432\n" +
                "NIC 2:           disabled\n" +
                "NIC 3:           disabled\n" +
                "NIC 4:           disabled\n" +
                "NIC 5:           disabled\n" +
                "NIC 6:           disabled\n" +
                "NIC 7:           disabled\n" +
                "NIC 8:           disabled\n" +
                "Pointing Device: PS/2 Mouse\n" +
                "Keyboard Device: PS/2 Keyboard\n" +
                "UART 1:          disabled\n" +
                "UART 2:          disabled\n" +
                "LPT 1:           disabled\n" +
                "LPT 2:           disabled\n" +
                "Audio:           disabled\n" +
                "Clipboard Mode:  disabled\n" +
                "Drag'n'drop Mode: disabled\n" +
                "VRDE:            disabled\n" +
                "USB:             disabled\n" +
                "EHCI:            disabled\n" +
                "\n" +
                "USB Device Filters:\n" +
                "\n" +
                "<none>\n" +
                "\n" +
                "Bandwidth groups:  <none>\n" +
                "\n" +
                "Shared folders:\n" +
                "\n" +
                "Name: 'vagrant', Host path: '/home/maki/vagrant/foundationdb' (machine mapping), writable\n" +
                "\n" +
                "Video capturing:    not active\n" +
                "Capture screens:    0\n" +
                "Capture file:       /home/maki/VirtualBox VMs/foundationdb_default_1418736862696_38931/foundationdb_default_1418736862696_38931.webm\n" +
                "Capture dimensions: 1024x768\n" +
                "Capture rate:       512 kbps\n" +
                "Capture FPS:        25\n" +
                "\n" +
                "Guest:\n" +
                "\n" +
                "Configured memory balloon size:      0 MB")
                .split("\n")));
        command.stream()
                .forEach(System.out::println);
    }
}