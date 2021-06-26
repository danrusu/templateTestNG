package project.demo.end2end;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ro.qatools.webdriver.WebDriverStrategy;

import java.util.Optional;

import static org.openqa.selenium.support.ui.ExpectedConditions.textToBe;

@Slf4j
public class End2EndUiTest {
    public WebDriver webDriver;

    @BeforeClass(alwaysRun = true)
    public static void beforeClass() {
        log.info("Once before all tests within this class");
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeEachSetup() {
        log.info("Before each test method within this class");
        webDriver = WebDriverStrategy.CHROME.getDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void afterEachTearDown() {
        log.info("After each test method within this class");
        Optional.ofNullable(webDriver).ifPresent(driver -> driver.quit());
    }

    @Test(
            groups = {"end2end", "ui"}
    )
    public void simpleCalculatorSumTest() {
        // You can use Page Object Model pattern if you reuse page elements or actions.
        log.info("simpleCalculatorSumTest");

        // navigate to simple calculator web page
        webDriver.get("http://qatools.ro/calculate/appApi.html");

        // set number inputs
        webDriver.findElement(By.id("nr1")).sendKeys("10");
        webDriver.findElement(By.id("nr2")).sendKeys("5");

        // set operation
        webDriver.findElement(By.cssSelector("select")).click();
        webDriver.findElement(By.xpath(
                String.format("//option[contains(text(), \"%s\")]", "SUM"))
        ).click();

        // calculate 
        webDriver.findElement(By.cssSelector("button[name=\"calculate\"]")).click();

        // wait for the expected result (assertion)
        new WebDriverWait(webDriver, 5)
                .until(textToBe(
                        By.cssSelector("[data-qa-test=\"result\"]"),
                        "15"));
    }
}
