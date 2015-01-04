package vagrant;

import org.junit.Ignore;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public class GlobalStatusCommandTest {

    @Before
    public void setUp() throws Exception {

    }

    @Test
    @Ignore
    public void testList() throws Exception {
        GlobalStatusCommand command = new GlobalStatusCommand();
        command.stream().forEach(System.out::println);
    }

    @Test
    @Ignore
    public void testDestroy() throws Exception {
        DestroyCommand command = new DestroyCommand("4fb6caf");
        System.out.println(command.runToString());
    }

    @Test
    @Ignore
    public void testListAndHalt() throws Exception {
        GlobalStatusCommand command = new GlobalStatusCommand();
        command.stream().sorted().forEach(x -> {
            System.out.println(x);
            if (x.getState() == GlobalStatus.MachineState.RUNNING) {
                System.out.println(new HaltCommand(x.getId()).runToString());
            }
        });
    }

    @Test
    public void testListAndUp() throws Exception {
        GlobalStatusCommand command = new GlobalStatusCommand();
        command.stream().sorted((x, y) -> y.compareTo(x)).findFirst().ifPresent(x -> {
            System.out.println(x);
            if (x.getState() == GlobalStatus.MachineState.POWEROFF) {
                System.out.println(new UpCommand(x.getId()).runToString());
            }
        });
    }

    @Test
    public void testStream() throws Exception {
        GlobalStatusCommand command = new GlobalStatusCommand(() -> Arrays.asList(("908b6a2  default virtualbox poweroff /vagrant/terasoluna-batch3-java7.0.72/0001\n" +
                "888437f  default virtualbox running  /vagrant/postgresql9.3.5/0001\n" +
                "bfa22f9  default virtualbox poweroff /vagrant/terasoluna-batch3-java8.0.25/0001\n" +
                "1fc282a  default virtualbox running  /vagrant/oracle12.1.0.2.0/0001\n" +
                "6fbef2a  default virtualbox running  /vagrant/tomcat7-java7/0001\n" +
                "0e12980  default virtualbox poweroff /vagrant/resin4-java7/0001\n" +
                "7953c2b  default virtualbox poweroff /vagrant/weblogic12.1.3-java7/0001\n" +
                "bc75a9b  default virtualbox running  /vagrant/jenkins-java7/0001\n" +
                "64cc508  default virtualbox poweroff /vagrant/tomcat7-java8/0001\n" +
                "85bd43f  default virtualbox poweroff /vagrant/tomcat7-java8/0002\n" +
                "3ab991a  default virtualbox poweroff /vagrant/postgresql9.3.5/0002\n" +
                "9b91637  default virtualbox poweroff /vagrant/tomcat7-java7/0002\n" +
                "da4b296  default virtualbox running  /vagrant/postgresql9.3.5/0003\n" +
                "fa381ac  default virtualbox running  /vagrant/terasoluna-batch3-java8.0.25/0003\n" +
                "fa11f5a  default virtualbox running  /vagrant/oracle12.1.0.2.0/0002\n" +
                "220106b  default virtualbox running  /vagrant/terasoluna-batch3-java7.0.72/00022")
                .split("\n")));
        command.stream()
                .sorted()
                .forEach(System.out::println);
    }
}