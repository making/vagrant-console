package vagrant;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;


public class VagrantHouseKeeperTest {
    Path tmpFile;

    @Before
    public void setUp() throws Exception {
        tmpFile = Files.createTempFile("VagrantHouseKeeperTest", ".txt");
        Files.write(tmpFile, Arrays.asList("hoge", "foo", "bar"));
        System.out.println(tmpFile.toAbsolutePath());
    }

    @After
    public void tearDown() throws Exception {
       if (tmpFile.toFile().exists()) {
           tmpFile.toFile().delete();
       }
    }

    @Test
    public void testLoadUnhaltKeyword() throws Exception {
        VagrantHouseKeeper houseKeeper = new VagrantHouseKeeper();
        houseKeeper.unhaltPath = new FileSystemResource(tmpFile.toFile());
        assertThat(houseKeeper.loadUnhaltKeyword(), is(new HashSet<String>() {
            {
                add("hoge");
                add("foo");
                add("bar");
            }
        }));
        assertThat(tmpFile.toFile().exists(), is(false));
    }


    @Test
    public void testLoadUnhaltKeyword_notExist() throws Exception {
        VagrantHouseKeeper houseKeeper = new VagrantHouseKeeper();
        houseKeeper.unhaltPath = new ClassPathResource("foo/bar.txt");
        assertThat(houseKeeper.loadUnhaltKeyword(), is(Collections.emptySet()));
    }
}