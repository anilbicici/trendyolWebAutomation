package resources.PO;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;

public class LoginPage extends BasePage {

    private static String loginButtonId = "accountBtn";
    private static String emailFieldXpath = "//input[@id='login-email']";
    private static String passwordFieldId = "login-password-input";
    private static String loginButton1Xpath = "//button[@type='submit']";
    private static String email; //= "anilbchg@gmail.com";
    private static String password; //= "Web1234Test";
    private static String[] userInfo;


    //LoginPage includes basepage methods which are commonly used in test scenarios
    public LoginPage(WebDriver driver, WebDriverWait wait, Actions actions) {
        super(driver, wait, actions);
        userInfo = readFile("login.csv");
        email = userInfo[0];
        password = userInfo[1];
    }

    public void clickLoginButton() {
        click(By.id(loginButtonId));
    }

    public void fillEmail() {
        waitUntilPageContainElements(emailFieldXpath);
        writeText(By.xpath(emailFieldXpath), email);
    }

    public void fillPassword() {
        writeText(By.id(passwordFieldId), password);
    }

    public void clickLoginButton1() {
        click(By.xpath(loginButton1Xpath));
    }
}