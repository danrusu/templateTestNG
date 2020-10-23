package project.demo.end2end;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class End2EndUiTest {
    private final Logger logger = LogManager.getLogger(End2EndUiTest.class);
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

        logger.info("end2endUiTest1");
        assertThat(user.getFullName()).isEqualTo("John Doe");
    }
}
