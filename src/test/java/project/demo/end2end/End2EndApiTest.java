package project.demo.end2end;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@Slf4j
public class End2EndApiTest {

    @Test(
            groups = {"end2end", "api"}
    )
    public void end2endTestApi1() {
        log.info("end2endTestApi1");
        final String textFetchedFromUI = "test1";

        assertThatThrownBy(() -> assertThat(textFetchedFromUI).isEqualTo("test0"))
                .hasMessageMatching(".*expected.*test\\[0\\].*")
                .hasMessageMatching(".*but was.*test\\[1\\].*");
    }
}
