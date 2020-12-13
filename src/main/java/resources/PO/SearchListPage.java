package resources.PO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SearchListPage extends BasePage {

    private static String descriptionXpath = "//div[@class='dscrptn']";
    private static String productsXpath = "//img[@class='p-card-img']";


    public SearchListPage(WebDriver driver, WebDriverWait wait, Actions actions) {
        super(driver, wait, actions);
    }

    public void verifyResults() {
        Assert.assertNotNull(descriptionXpath);
    }

    public void clickSecondPage() {

    }

    public void verifySecondPage() {
    }

    public void selectRandomProduct() {

        waitUntilPageContainElementsList(productsXpath);
        randomSelection(By.xpath(productsXpath));

    }

}
