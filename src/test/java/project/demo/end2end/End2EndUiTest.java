package project.demo.end2end;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class End2EndUiTest {
    private static User user;

    @BeforeClass
    public static void beforeClass() {
        //TODO - this throws NPE
        //user = new User("John", "Doe", 30, false);
    }

    @Test(
            groups = {"end2end", "ui"}
    )
    public void end2endUiTest1() {
        user = new User("John", "Doe", 30, false);

        log.info("end2endUiTest1");
        assertThat(user.getFullName()).isEqualTo("John Doe");
    }
}
