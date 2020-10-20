package integration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

import java.util.stream.Stream;

import static io.restassured.RestAssured.given;


public class IntegrationTest {
    Logger logger = LogManager.getLogger(IntegrationTest.class);
    public static String POSTMAN_ECHO_STATUS_URL = "https://postman-echo.com/status/";

    @Test(
            groups = {"integration"}
    )

    public void integrationTest() {
        System.out.println("integration test");
        final SoftAssertions softly = new SoftAssertions();

        Stream.of(501, 202, 400, 200, 203, 404)
                .sorted()
                .map(this::getStatusUrl)
                .peek(this::logToConsole)
                .forEach(url -> softly.assertThat(getStatusCode(url)).isBetween(200, 300));

        softly.assertAll();
    }

    private void logToConsole(final String url) {
        logger.info(String.format("verifying status code for: %s", url));
    }

    private int getStatusCode(final String url) {
        return given().get(url).statusCode();
    }

    private String getStatusUrl(final int status) {
        return String.format("%s%d", POSTMAN_ECHO_STATUS_URL, status);
    }

}
