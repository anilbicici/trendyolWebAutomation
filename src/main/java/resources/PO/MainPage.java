package resources.PO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends BasePage {

    public static String productName = "speaker";
    private static String popupCloseButtonXpath = "//*[@class='modal-close']";
    private static String searchBoxXpath = "//input[@type='text']";
    private static String searchButtonXpath = "//div/i[@class='search-icon']";
    private static String suggestions = "//div[@class='suggestions-container']";

    public MainPage(WebDriver driver, WebDriverWait wait, Actions actions) {
        super(driver, wait, actions);
    }

    public void closePopup() {
        waitUntilPageContainElements(popupCloseButtonXpath);
        click(By.xpath(popupCloseButtonXpath));
    }

    public void writeProductName() {
        waitUntilPageContainElements(searchBoxXpath);
        writeText(By.xpath(searchBoxXpath), productName);
    }

    public void clickSearchButton() {
        waitUntilPageContainElements(suggestions);
        click(By.xpath(searchButtonXpath));
    }

}

