package lelyFE.operations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import lelyFE.utilities.DriverManager;

public class SendKeyOperation {
    private final WebDriver webDriver;
    public SendKeyOperation() {
        DriverManager driverManager = new DriverManager();
        webDriver = driverManager.getDriver();
    }
    public void sendKey(String text, By by) {
        WebElement element = webDriver.findElement(by);
        element.sendKeys(text);
    }
}
