package stepDefinations.FeSteps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import lelyFE.utilities.DriverManager;


public class BaseStep {
    private WebDriver webDriver;
    private final DriverManager driver;
    final String baseURL = "https://www.lely.com/en";
    public BaseStep() {
        driver = new DriverManager();
    }
    @Before
    public void StartTest(Scenario scenario) {
        driver.setUpDriver();
        webDriver = driver.getDriver();
    }
    @Given("^User go to homepage$")
    public void userGoToPage() {
        webDriver.get(baseURL);
    }
    @After
    public void closeDriver() {
        driver.tearDown();
    }
}
