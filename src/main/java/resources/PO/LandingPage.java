package resources.PO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage extends BasePage {

    private static String loginPageUrl = "https://www.trendyol.com/";
    private static String popupCloseButtonId = "//a[@class='fancybox-item fancybox-close']";
    private static String loginButtonId = "accountBtn";

    public LandingPage(WebDriver driver, WebDriverWait wait, Actions actions) {
        super(driver, wait, actions);
    }

    public void goTo() {
        driver.get(loginPageUrl);
    } //gets loginpage url and opens it

    public void closePopup() {
        waitUntilPageContainElements(popupCloseButtonId);
        click(By.xpath(popupCloseButtonId));
    }

    public void verifyPage() {
        waitClickable(By.id(loginButtonId));
    }
}
