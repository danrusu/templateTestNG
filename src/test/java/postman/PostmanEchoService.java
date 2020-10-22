package postman;

public enum PostmanEchoService {
    STATUS,
    DELAY;

    public static String URL = "https://postman-echo.com";

    public String getUrl(final int urlParam) {
        return String.format("%s/%s/%d",
                URL, this.name().toLowerCase(), urlParam);
    }
}
