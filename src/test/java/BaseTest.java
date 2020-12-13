import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


public class BaseTest {

    public WebDriver driver;
    public WebDriverWait wait;
    public Actions actions;

    @Parameters("Browser")

    @BeforeClass //Run once before first test method
    public void browserParameter(String Browser) {
        System.setProperty("webdriver.chrome.driver", "C:\\bin\\chromedriver.exe");
        //When you change the browser parameter that located in testNG.xml this method works to open desired browser

        if (Browser.equalsIgnoreCase("ch")) {
            driver = new ChromeDriver();
            wait = new WebDriverWait(driver, 20);
            driver.manage().window().maximize();
            actions = new Actions(driver);
        } else if (Browser.equalsIgnoreCase("ff")) {
            driver = new FirefoxDriver();
            wait = new WebDriverWait(driver, 15);
            driver.manage().window().maximize();
            actions = new Actions(driver);
        } else if (Browser.equalsIgnoreCase("ie")) {
            driver = new InternetExplorerDriver();
            wait = new WebDriverWait(driver, 15);
            driver.manage().window().maximize();
            actions = new Actions(driver);
        }

    }

    @AfterClass // Run after test methods
    //Closes the test browser after test cases are completed.
    public void tearDown() {

       // driver.quit();

    }

}
