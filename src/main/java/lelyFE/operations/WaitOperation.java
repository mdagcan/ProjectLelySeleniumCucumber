package lelyFE.operations;

import org.openqa.selenium.WebDriver;
import lelyFE.utilities.DriverManager;

public class WaitOperation {
    private final WebDriver webDriver;
    public WaitOperation() {
        DriverManager driverManager = new DriverManager();
        webDriver = driverManager.getDriver();
    }
    public void wait(int second) {
        try {
            Thread.sleep(second * 1000);
        } catch (Exception e) {
        }
    }
}
