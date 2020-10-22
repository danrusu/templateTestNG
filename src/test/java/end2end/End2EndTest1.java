package end2end;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ro.qatools.base.Person;

import static org.assertj.core.api.Assertions.assertThat;


public class End2EndTest1 {
    private final Logger logger = LogManager.getLogger(End2EndTest1.class);
    private static Person person;

    @BeforeClass
    public static void beforeClass() {
        //TODO - this throws NPE
        //person = new Person("John", "Doe", 30, false);
    }

    @Test(
            groups = {"end2end"}
    )
    public void end2endTest1() {
        person = new Person("John", "Doe", 30, false);

        logger.info("end2endTest1");
        assertThat(person.getFullName()).isEqualTo("John Doe");
    }
}
