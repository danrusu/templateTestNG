package ro.qatools.postman;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class UnitTest1 {
    private final Logger logger = LogManager.getLogger(UnitTest1.class);

    @Test(
            groups = {"unit"}
    )
    public void unitTest1() {
        logger.info("unitTest1");
    }
}
