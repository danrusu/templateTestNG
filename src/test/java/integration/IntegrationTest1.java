package integration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.SoftAssertionError;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import postman.PostmanEchoService;

import java.util.stream.Stream;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;


public class IntegrationTest1 {
    private final Logger logger = LogManager.getLogger(IntegrationTest1.class);

    @Test(
            groups = {"integration"},
            expectedExceptions = SoftAssertionError.class,
            expectedExceptionsMessageRegExp = ".*Expecting.*<501>.*between.*[200, 300].*"
    )
    public void integrationTest1() {
        logger.info("integrationTest1");

        final SoftAssertions softly = new SoftAssertions();

        Stream.of(501, 202, 200, 404, 203)
                .sorted()
                .map(PostmanEchoService.STATUS::getUrl)
                .peek(logger::info)
                .forEach(url -> softly.assertThat(getStatusCode(url)).isBetween(200, 300));

        softly.assertAll();
    }

    private int getStatusCode(final String url) {
        return given().when().get(url).thenReturn().statusCode();
    }

    @Test(
            groups = {"integration"},
            dataProvider = "wait-provider",
            dataProviderClass = WaitsDataProvider.class
    )
    public void integrationTest2(final int delay) {
        logger.info(String.format("integrationTest2(%s)", delay));

        final String delayUrl = PostmanEchoService.DELAY.getUrl(delay);
        logger.info(String.format("Test %s", delayUrl));

        given().when().get(delayUrl)
                .then()
                .statusCode(200)
                .and()
                .time(greaterThan(delay * 1000L))
                .and()
                .time(lessThan((delay + 3) * 1000L));
    }

}
