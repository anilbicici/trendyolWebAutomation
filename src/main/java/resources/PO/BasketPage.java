package resources.PO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BasketPage extends BasePage {

    String basketButtonXpath = "//*[@id='myBasketListItem']";
    String basketPrice = "//div[@class='pb-basket-item-price']";
    String quantitiyIncrementButtonXpath = "//button[@class='ty-numeric-counter-button']";
    String quantitiyXpath = "//input[@class='counter-content']";
    String updateSuccesXpath = "//div[contains(text(),'Sepet başarıyla güncellendi')]";
    String deleteButtonXpath = "//button/i[@class='i-trash']";
    String popupDeleteButtonXpath = "//button[@class='btn-item btn-remove']";
    String basketEmptyTextXpath = "//div[@class='col-lg-8 col-md-8 col-xs-8']/p/span";
    ProductDetailPage productDetailPage = new ProductDetailPage(driver, wait, actions);

    public BasketPage(WebDriver driver, WebDriverWait wait, Actions actions) {
        super(driver, wait, actions);
    }

    public void goToBasketPage() {
        click(By.xpath(basketButtonXpath));
    }

    public void comparePrices() {
        waitUntilPageContainElements(basketPrice);
        String compare_2 = getProductPrice(basketPrice);
        String compare_1 = productDetailPage.returnProductPrice();
        System.out.println("compare 1 :" + compare_1 + " " + "compare_2:" + compare_2);

        Assert.assertTrue(compare_2.contains(compare_1));

    }

    public void increaseProductQuantity() {
        click(By.xpath(quantitiyIncrementButtonXpath));
    }

    public void verifyProductQuantity() {
        waitUntilPageContainElements(updateSuccesXpath);
        String quantitiy = getProductQuantitiy(quantitiyXpath);
        Assert.assertEquals(quantitiy, "2");

    }

    public void deleteProduct() {
        click(By.xpath(deleteButtonXpath));
        waitUntilPageContainElements(popupDeleteButtonXpath);
        click(By.xpath(popupDeleteButtonXpath));
    }

    public void verifyEmptyBasket() {
        waitUntilPageContainElements(basketEmptyTextXpath);
        String emptyComparison = getText(basketEmptyTextXpath);
        Assert.assertEquals(emptyComparison, "Sepetinizde ürün bulunmamaktadır.");
    }

}
