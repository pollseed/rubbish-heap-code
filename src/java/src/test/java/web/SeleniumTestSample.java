package web;

import java.util.Arrays;

import junit.framework.TestCase;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumTestSample extends TestCase {
    private static final WebDriver[] DRIVERS;
    static {
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
        DRIVERS = new WebDriver[] { new ChromeDriver(), new FirefoxDriver() };
    }

    @Test
    public void test_request() {
        Arrays.stream(DRIVERS).forEach(driver -> testBrowser(driver).quit());
    }

    private static final WebDriver testBrowser(final WebDriver driver) {
        driver.get("http://www.google.com");
        final WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("Cheese!");
        element.submit();
        System.out.println(driver.getTitle());
        new WebDriverWait(driver, 10).until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(final WebDriver arg0) {
                return arg0.getTitle().toLowerCase().startsWith("cheese!");
            }
        });
        System.out.println(driver.getTitle());
        return driver;
    }
}
