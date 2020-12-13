package resources.PO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductDetailPage extends BasePage {

    private static String path = "C:\\Users\\anilbicici\\OneDrive\\Masaüstü\\trendyolTest.txt";
    private static String productName;
    private static String productNameXpath = "//h1[@class='pr-new-br']/span";
    private static String productPriceXpath = "//div[@style='display:flex']/div[@class='pr-bx-w']/div[@class='pr-bx-nm with-org-prc']/span";
    private static String addBasketButtonXpath = "//button[@class='pr-in-btn add-to-bs']";
    private static String getProductPriceXpathFinal;
    private static String priceComparison_1;

    public ProductDetailPage(WebDriver driver, WebDriverWait wait, Actions actions) {
        super(driver, wait, actions);

    }

    public void getProductDetails() {
        waitUntilPageContainElements(productNameXpath);
        productName = getProductName(productNameXpath);
        getProductPriceXpathFinal = getProductPriceSize(By.xpath(productPriceXpath));

    }

    public String getProductPrice() {
        waitUntilPageContainElements(getProductPriceXpathFinal);
        priceComparison_1 = getProductPrice(getProductPriceXpathFinal);
        System.out.println("1. price : " + priceComparison_1);
        return priceComparison_1;
    }

    public String returnProductPrice() {
        return priceComparison_1;
    }

    public void fileWriteProductDetais() {
        file(path, productName, priceComparison_1);
    }

    public void addProductToBasket() {
        waitUntilPageContainElements(addBasketButtonXpath);
        click(By.xpath(addBasketButtonXpath));
    }


}


