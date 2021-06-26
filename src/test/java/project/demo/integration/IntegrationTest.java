package project.demo.integration;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.SoftAssertionError;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import ro.qatools.postman.PostmanEchoService;

import java.util.stream.IntStream;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;

@Slf4j
public class IntegrationTest {

    @Test(
            groups = {"integration", "api"},
            expectedExceptions = SoftAssertionError.class,
            expectedExceptionsMessageRegExp = ".*Expecting.*<501>.*between.*[200, 300].*"
    )
    public void integrationTest1() {
        log.info("integrationTest1");

        final SoftAssertions softly = new SoftAssertions();

        IntStream.of(501, 202, 200, 404, 203)
                .sorted()
                .mapToObj(PostmanEchoService.STATUS::getUrl)
                .peek(log::info)
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
        log.info(String.format("integrationTest2(%s)", delay));

        final String delayUrl = PostmanEchoService.DELAY.getUrl(delay);
        log.info(String.format("Test %s", delayUrl));

        given().when().get(delayUrl)
                .then()
                .statusCode(200)
                .and()
                .time(greaterThan(delay * 1000L))
                .and()
                .time(lessThan((delay + 3) * 1000L));
    }

}
