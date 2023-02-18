package lelyFE.locators;

import org.openqa.selenium.By;
import java.util.HashMap;

public class Locators {
    private HashMap<String, By> PageLocators;
    public HashMap<String, By> getPageLocators() {
        if (PageLocators == null)
            PageLocators = new HashMap<String, By>();
        if (PageLocators.size() <= 0)
            initPageLocators();
        return PageLocators;
    }
    private void addID(String key, By value){
        PageLocators.put(key, value);
    }

    private void initPageLocators() {
        addID("acceptCookiesButton",    By.xpath("//*[@id='cookienotice-button-accept']"));
        addID("topPageSearchButton",    By.xpath("//*[@data-do=\"trigger-search\"]"));
        addID("searchArea",             By.xpath("//form[@class='global-search-container menu-item search-active']"));
        addID("searchBoxField",         By.xpath("//input[@id='global-search']"));
        addID("resultSearchArea",       By.xpath("//button[contains(.,'Search')]"));
        addID("searchButton",           By.xpath("//button[contains(.,'Search')]"));
        addID("findDocDropDownButton",  By.xpath("//span[@id='select2-id_machine_type-container']"));
        addID("first_viewThisDocument", By.xpath("(//a[contains(text(),'View this document')])[1]"));
        addID("second_DocDownloadBut",  By.xpath("(//a[contains(text(),'Download')])[2]"));
        addID("dropDownList",           By.xpath("//select[@id='id_q']"));

    }
}
