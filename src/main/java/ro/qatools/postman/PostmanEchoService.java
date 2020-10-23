package ro.qatools.postman;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public enum PostmanEchoService {
    STATUS,
    DELAY;

    public static String URL = "https://postman-echo.com";

    public String getUrl(final int urlParam) {
        return String.format("%s/%s/%d",
                URL, this.name().toLowerCase(), urlParam);
    }

    public static void main(final String[] args) {
        final Logger logger = LogManager.getLogger(PostmanEchoService.class);
        logger.error("error");
    }
}
