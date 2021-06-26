package ro.qatools.postman;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PostmanEchoServiceTest {
    public static final String EXPECTED_200_STATUS_CODE_URL = "https://postman-echo.com/status/200";
    public static final String EXPECTED_1_SECOND_DELAY_URL = "https://postman-echo.com/delay/1";

    @Test(
            groups = {"unit"}
    )
    public void getStatusUrlTest() {
        assertThat(PostmanEchoService.STATUS.getUrl(200))
                .isEqualTo(EXPECTED_200_STATUS_CODE_URL);
    }

    @Test(
            groups = {"unit"}
    )
    public void getDelayUrlTest() {
        assertThat(PostmanEchoService.DELAY.getUrl(1))
                .isEqualTo(EXPECTED_1_SECOND_DELAY_URL);
    }
}
