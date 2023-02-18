package lelyFE.operations;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import lelyFE.utilities.DriverManager;

import java.io.File;

public class MainOperation {
    private final WebDriver webDriver;
    private final WaitOperation waitOperation;
    private String tagText = "";
    public String getTagText() {
        return tagText;
    }
    public MainOperation() {
        DriverManager driverManager = new DriverManager();
        webDriver = driverManager.getDriver();
        waitOperation = new WaitOperation();
    }
    public void switchToTab() {
        String mainTab = webDriver.getWindowHandle();
        for (String windowHandle : webDriver.getWindowHandles()) {
            if (!mainTab.contentEquals(windowHandle)) {
                webDriver.switchTo().window(windowHandle);
                break;
            }
        }
    }
    public String getTheUrl() {
        return webDriver.getCurrentUrl();
    }
    public void getAttribute(By by, String attribute) {
        WebElement element = webDriver.findElement(by);
        tagText = element.getAttribute(attribute);
    }
    public void checkFile(String link) {
        waitOperation.wait(4);
        String docName = getFileNameFromLink(link) + ".pdf";
        String home = System.getProperty("user.home");
        File folder = new File(home + "/Downloads/");
        File[] listOfFiles = folder.listFiles();
        for (File listOfFile : listOfFiles) {
            if (listOfFile.isFile()) {
                String fileName = listOfFile.getName();
                if (fileName.matches(docName)) {
                }
            }
        }
    }
    public String getFileNameFromLink(String linkText) {
        return StringUtils.substringBetween(linkText, "name=", ".");
    }
}
