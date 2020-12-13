import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import resources.PO.*;

public class MainTest extends BaseTest {

    public LandingPage landingPage;
    public LoginPage loginPage;
    public MainPage mainPage;
    public SearchListPage searchListPage;
    public ProductDetailPage productDetailPage;
    public FavoritesPage favoritesPage;
    public BasketPage basketPage;


    @BeforeMethod //Run before each method class
    public void initialize() {

        landingPage = new LandingPage(driver, wait, actions);
        loginPage = new LoginPage(driver, wait, actions);
        mainPage = new MainPage(driver, wait, actions);
        searchListPage = new SearchListPage(driver, wait, actions);
        productDetailPage = new ProductDetailPage(driver, wait, actions);
        favoritesPage = new FavoritesPage(driver, wait, actions);
        basketPage = new BasketPage(driver, wait, actions);

    }

    @Test(priority = 0)
    public void goToTrenyol() {
        landingPage.goTo();
        landingPage.closePopup();
        landingPage.verifyPage();
    }

    @Test(priority = 1)
    public void loginTrendyol() {
        loginPage.clickLoginButton();
        loginPage.fillEmail();
        loginPage.fillPassword();
        loginPage.clickLoginButton1();

    }

    @Test(priority = 2)
    public void searchProduct() throws InterruptedException {
        mainPage.closePopup();
        mainPage.writeProductName();
        mainPage.clickSearchButton();

    }

    @Test(priority = 3)
    public void searchResult() throws InterruptedException {

        searchListPage.verifyResults();
        searchListPage.selectRandomProduct();

    }

    @Test(priority = 4)
    public void productDetail() {

        productDetailPage.getProductDetails();
        productDetailPage.getProductPrice();
        productDetailPage.fileWriteProductDetais();
        productDetailPage.addProductToBasket();

    }

    @Test(priority = 5)
    public void basketPageTransactions() {
        basketPage.goToBasketPage();
        basketPage.comparePrices();
        basketPage.increaseProductQuantity();
        basketPage.verifyProductQuantity();
        basketPage.deleteProduct();
        basketPage.verifyEmptyBasket();

    }

}
