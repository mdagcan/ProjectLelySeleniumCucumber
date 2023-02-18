package lelyFE.operations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import lelyFE.utilities.DriverManager;


public class ClickOperation {

    private final WebDriver webDriver;
    private final WaitOperation waitOperation;

    public ClickOperation() {

        DriverManager driverManager = new DriverManager();
        webDriver = driverManager.getDriver();
        waitOperation = new WaitOperation();
    }

    public void click(By by) {

        WebElement element = webDriver.findElement(by);
        element.click();
    }

    public void selectFromDropDownList(By by, String text) {

        waitOperation.wait(3);
        Select docList = new Select(webDriver.findElement(by));
        docList.selectByVisibleText(text);
    }

}
