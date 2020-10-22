package end2end;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class End2EndTest2 {
    private final Logger logger = LogManager.getLogger(End2EndTest2.class);

    @Test(
            groups = {"end2end"}
    )
    public void end2endTest2() {
        logger.info("end2endTest2");

        assertThatThrownBy(() -> assertThat("test1").isEqualTo("test0"))
                .hasMessageMatching(".*expected.*test\\[0\\].*")
                .hasMessageMatching(".*but was.*test\\[1\\].*");
    }
}
