package resources.PO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.*;
import java.util.List;
import java.util.Random;


public class BasePage {

    //Base page contains common methods which are used other classes

    public WebDriver driver;
    public WebDriverWait wait;
    public Actions actions;


    public BasePage(WebDriver driver, WebDriverWait wait, Actions actions) {

        this.driver = driver;
        this.wait = wait;
        this.actions = actions;

    }

    public void click(By elementLocation) { //click method via element location (xpath, css locator etc.)

        driver.findElement(elementLocation).click();

    }

    public void writeText(By elementLocation, String text) { //This method sending keys to specified element location

        driver.findElement(elementLocation).sendKeys(text);

    }

    public void waitUntilPageContainElements(String elementName) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementName))); //Wait until specified element is loaded

    }

    public void waitUntilPageContainElementsList(String elementName) {

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(elementName))); //Wait until specified element is loaded

    }

    public void moveMouse(String xpath) {
        WebElement element = driver.findElement(By.xpath(xpath));
        actions.moveToElement(element).perform();
    }

    public void dropBoxSelect(String id, int index) {
        Select date = new Select(driver.findElement(By.id(id)));
        date.selectByIndex(index);
    }

    public void assertionTest(String xpath, String comparer) {
        WebElement element = driver.findElement(By.xpath(xpath));
        Assert.assertEquals(element.getText(), comparer);
    }

    public void waitClickable(By elementLocation) {
        wait.until(ExpectedConditions.elementToBeClickable(elementLocation));
    }

    public void randomSelection(By elementLocation) {

        List<WebElement> elements = driver.findElements(elementLocation);
        int maxCount = elements.size();
        Random random = new Random();
        int randomCount = random.nextInt(maxCount);
        elements.get(randomCount).click();

    }

    public String getText(String elementLoaction) {

        String name = driver.findElement(By.xpath(elementLoaction)).getText();
        System.out.println(name);

        return name;
    }

    public String getProductName(String elementLoaction) {

        String name = driver.findElement(By.xpath(elementLoaction)).getText();
        System.out.println(name);

        return name;
    }

    public String getProductPrice(String elementLoaction) {

        String price = driver.findElement(By.xpath(elementLoaction)).getAttribute("textContent");
        System.out.println();

        return price;
    }

    public String getProductQuantitiy(String elementLoaction) {

        String price = driver.findElement(By.xpath(elementLoaction)).getAttribute("value");
        System.out.println();

        return price;
    }

    public String getProductPriceSize(By elementLocation) {

        List<WebElement> elements = driver.findElements(elementLocation);
        int priceSize = elements.size();
        if (priceSize < 2) {
            System.out.println("priceSize = " + priceSize);
            return "//div[@style='display:flex']/div[@class='pr-bx-w']/div[@class='pr-bx-nm']/span";
        } else if (priceSize == 2) {
            System.out.println("priceSize = " + priceSize);
            return "//div[@style='display:flex']/div[@class='pr-bx-w']/div[@class='pr-bx-nm with-org-prc']/span[2]";
        }
        return null;
    }

    public void file(String path, String productName, String productPrice) {
        try {
            File myObj = new File(path);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        try {
            FileWriter myWriter = new FileWriter(path);
            myWriter.write(productName + "\r\n" + productPrice);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public String[] readFile(String path){
        String csvFile = "test.csv";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";


        try {

            br = new BufferedReader(new FileReader(csvFile));
            line = br.readLine();
            if (line != null) {

                // use comma as separator
                return line.split(cvsSplitBy);

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }


}







