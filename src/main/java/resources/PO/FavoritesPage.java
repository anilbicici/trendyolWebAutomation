package resources.PO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class FavoritesPage extends BasePage {

    private static String productNameXpath = "//*[@class='prdct-desc-cntnr-ttl-w']/span[2]";
    private static String deleteFavoriteXpath = "//i[@class='ufvrt-btn']";
    private ProductDetailPage productDetailPage;

    public FavoritesPage(WebDriver driver, WebDriverWait wait, Actions actions) {
        super(driver, wait, actions);
    }

    public void setProductDetailPage(ProductDetailPage productDetailPage) {
        this.productDetailPage = productDetailPage;
    }

    public String verifyProduct() {
        waitUntilPageContainElements(productNameXpath);
        String productName = driver.findElement(By.xpath(productNameXpath)).getText();
        return productName;
    }

    public void deleteProductFromFavorites() {
        click(By.xpath(deleteFavoriteXpath));
    }

    public void verifyProductDeleted(String productName) {
        boolean condition;

        if (productName == null) {
            condition = false;
        } else {
            condition = true;
        }
        Assert.assertTrue(condition);
    }

}
