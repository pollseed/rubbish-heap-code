package TestCode.TestCode;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestSeleniumBase extends TestBaseStandard {
    protected static final WebDriver[] DRIVERS;
    static {
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
        DRIVERS = new WebDriver[] { new ChromeDriver(), new FirefoxDriver() };
    }
}
