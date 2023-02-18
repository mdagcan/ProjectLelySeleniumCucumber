package lelyFE.operations;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import lelyFE.utilities.DriverManager;

import java.util.List;

public class AssertionOperation {
    private final WebDriver webDriver;
    public AssertionOperation() {
        DriverManager driverManager = new DriverManager();
        webDriver = driverManager.getDriver();
    }
    public void assertIsPresent(By by) {
        List<WebElement> elements = webDriver.findElements(by);
        Assert.assertFalse(elements.isEmpty());
    }
    public void containsText(By by, String expectedText) {
        List<WebElement> elements = webDriver.findElements(by);
        for (WebElement element : elements) {
            if (!element.getText().toLowerCase().contains(expectedText.toLowerCase())) {
                Assert.fail("One of the text does not have the keyword");
            }
        }
    }
    public void checkEquals(String expectedValue, String actualValue) {
        if (!expectedValue.equals(actualValue)) {
            Assert.fail(String.format("'%s' and '%s' are not equal!", expectedValue, actualValue));
        }
    }
}
