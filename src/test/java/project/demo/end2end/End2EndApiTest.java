package project.demo.end2end;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class End2EndApiTest {
    private final Logger logger = LogManager.getLogger(End2EndApiTest.class);

    @Test(
            groups = {"end2end", "api"}
    )
    public void end2endTestApi1() {
        logger.info("end2endTestApi1");
        final String textFetchedFromUI = "test1";

        assertThatThrownBy(() -> assertThat(textFetchedFromUI).isEqualTo("test0"))
                .hasMessageMatching(".*expected.*test\\[0\\].*")
                .hasMessageMatching(".*but was.*test\\[1\\].*");
    }
}
