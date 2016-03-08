package TestCode.TestCode;

import java.util.Arrays;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumTestSample extends TestSeleniumBase {
    @Test
    public void test_request() {
        Arrays.stream(DRIVERS).forEach(driver -> testBrowser(driver).quit());
    }

    private final WebDriver testBrowser(final WebDriver driver) {
        driver.get("http://www.google.com");
        final WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("Cheese!");
        element.submit();
        T.ln(driver.getTitle());
        new WebDriverWait(driver, 10).until(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(final WebDriver arg0) {
                return arg0.getTitle().toLowerCase().startsWith("cheese!");
            }
        });
        T.ln(driver.getTitle());
        return driver;
    }
}
