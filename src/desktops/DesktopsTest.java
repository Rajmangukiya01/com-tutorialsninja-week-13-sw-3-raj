package desktops;

import com.google.common.base.Verify;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class DesktopsTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductArrangeInAlphabeticalOrder() {
        // Mouse hover on Desktops Tab and click
        mouseHoverToElementAndClick(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[1]/a[1]"));

        //Click on "Show all documents"
        clickOnElement(By.xpath("//a[text()='Show All Desktops']"));

        //Select sort by position "Name : Z to A"
        clickOnElement(By.id("input-sort"));
        selectByVisibleTextFromDropDown(By.id("input-sort"), "Name (Z - A)");

        //Verify the Product will arrange in Descending order
    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessfully() throws InterruptedException {
        // Mouse hover on Desktops Tab and click
        Thread.sleep(5000);
        mouseHoverToElementAndClick(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[1]/a[1]"));

        //Click on "Show all documents"
        Thread.sleep(5000);
        clickOnElement(By.xpath("//a[text()='Show All Desktops']"));

        //Select sort by position "Name : A to Z"
        clickOnElement(By.id("input-sort"));
        selectByVisibleTextFromDropDown(By.id("input-sort"), "Name (A - Z)");

        // Select product “HP LP3065”
        clickOnElement(By.xpath("//img[@title='HP LP3065']"));

        //Verify the Text "HP LP3065"
        String expectedText = "HP LP3065";
        String actualText = getTextFromElement(By.xpath("//h1[text()='HP LP3065']"));
        Assert.assertEquals(expectedText, actualText);

//        //Select Delivery Date "2022-11-30"
//        String date = "30";
//        String month = "11";
//        String year = "2022";
//
//        clickOnElement(By.xpath("//body/div[@id='product-product']/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/span[1]/button[1]"));
//        while (true) {
//            String monthYear = driver.findElement(By.xpath("//th[contains(text(),'April 2011')]")).getText();
//            String arr[] = monthYear.split(" ");
//            String mon = arr[0];
//            String yer = arr[1];
//            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
//                break;
//            } else {
//                clickOnElement(By.xpath("//body[1]/div[4]/div[1]/div[1]/table[1]/thead[1]/tr[1]/th[3]"));
//            }
//    }

        //2.7.Enter Qty "1” using Select class.
        driver.findElement(By.xpath("//input[@value='1' and @size='2']")).clear();
        sendTextToElements(By.xpath("//input[@value='1' and @size='2']"), "1");

        //2.8 Click on “Add to Cart” button
        clickOnElement(By.id("button-cart"));

        //2.9 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
        String expectedMessage = "Success: You have added HP LP3065 to your shopping cart!\n" + "×";
        String actualMessage = getTextFromElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
        Assert.assertEquals("Success Message", expectedMessage, actualMessage);

        //2.10 Click on link “shopping cart”display into success message
        Thread.sleep(5000);
        clickOnElement(By.xpath("//a[text()='shopping cart']"));

        //2.11 Verify the text "Shopping Cart"
        String expectedText1 = "Shopping Cart  (1.00kg)";
        String actualText1 = getTextFromElement(By.xpath("//h1[contains(text(),' (1.00kg)')]"));
        Assert.assertEquals("Shopping cart text", expectedText1, actualText1);

        //2.12 Verify the Product name "HP LP3065"
        String expectedName = "HP LP3065";
        String actualName = getTextFromElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]"));
        Assert.assertEquals("Product name", expectedName, actualName);

        //2.13 Verify the Delivery Date "2022-11-30"


        //2.14 Verify the Model "Product21"
        String expectedModel = "Product 21";
        String actualModel = getTextFromElement(By.xpath("//td[text()='Product 21']"));
        Assert.assertEquals("Model", expectedModel, actualModel);

        //Change currency
        clickOnElement(By.xpath("//body/nav[@id='top']/div[1]/div[1]/form[1]/div[1]/button[1]"));
        clickOnElement(By.xpath("//button[contains(text(),'£ Pound Sterling')]"));

        //2.15 Verify the Total "£74.73"
        String expectedTotal = "£74.73";
        String actualTotal = getTextFromElement(By.xpath("//tbody/tr[1]/td[6]"));
        Assert.assertEquals("Total : £74.73", expectedTotal, actualTotal);
    }

    @After
    public void testDown() {
        closeBrowser();
    }
}
