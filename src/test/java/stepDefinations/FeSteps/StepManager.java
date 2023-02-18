package stepDefinations.FeSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import lelyFE.locators.Locators;
import lelyFE.operations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StepManager {
    private WebDriver webDriver;
    final String baseURL = "https://www.lely.com/";
    private final ClickOperation clickOperation = new ClickOperation();
    private final ScrollOperation scrollOperation = new ScrollOperation();
    private final SendKeyOperation sendKeyOperation = new SendKeyOperation();
    private final AssertionOperation assertionOperation = new AssertionOperation();
    private final MainOperation mainOperation = new MainOperation();
    private final Locators locators = new Locators();

    @And("^User click (.*)$")
    public void userClickToWebElement(String webElement) {
        By locator = locators.getPageLocators().get(webElement);
        clickOperation.click(locator);
    }
    @And("^User check (.*) is opened$")
    public void userCheckWebElementIsOpened(String webElement) {
        By locator = locators.getPageLocators().get(webElement);
        assertionOperation.assertIsPresent(locator);
    }
    @And("^User enter (.*) into (.*)$")
    public void userEnterKeyIntoWebElement(String key, String webElement) {
        By locator = locators.getPageLocators().get(webElement);
        sendKeyOperation.sendKey(key, locator);
    }
    @Then("^User check (.*) have (.*)$")
    public void userCheckWebElementHaveKey(String webElement, String key) {
        By locator = locators.getPageLocators().get(webElement);
        assertionOperation.containsText(locator, key);
    }
    @And("^User go to link (.*)$")
    public void userGoToLink(String link) {
        webDriver.get(baseURL + link);
    }
    @And("^User select drop down from (.*) - (.*)$")
    public void userSelectDropDownFrom(String webElement, String key) {
        By locator = locators.getPageLocators().get(webElement);
        clickOperation.selectFromDropDownList(locator, key);
    }
    @And("^User scroll to (.*)$")
    public void userScrollTo(String webElement) {
        By locator = locators.getPageLocators().get(webElement);
        scrollOperation.scrollToElement(locator);
    }
    @And("User switch the tab")
    public void userSwitchTheTab() {
        mainOperation.switchToTab();
    }
    @And("User check the new tab is file opened")
    public void userCheckTheNewTabIsFileOpened() {
        assertionOperation.checkEquals(mainOperation.getTagText(), mainOperation.getTheUrl());
    }
    @Then("User check the file is downloaded")
    public void userCheckTheFileIsDownloaded() {
        mainOperation.checkFile(mainOperation.getTagText());
    }
}
