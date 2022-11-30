package laptopsandnotebooks;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LaptopsAndNotebooksTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() {
        //Mouse hover on Laptops & Notebooks Tab.and click
        mouseHoverToElementAndClick(By.xpath("//a[text()='Laptops & Notebooks']"));

        // Click on “Show All Laptops & Notebooks”
        clickOnElement(By.xpath("//a[text()='Show All Laptops & Notebooks']"));

        // Select Sort By "Price (High > Low)"
        clickOnElement(By.id("input-sort"));
        selectByVisibleTextFromDropDown(By.id("input-sort"), "Price (High > Low)");

        // Verify the Product price will arrange in High to Low order.

    }

    @Test
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException {
        //Mouse hover on Laptops & Notebooks Tab.and click
        mouseHoverToElementAndClick(By.xpath("//a[text()='Laptops & Notebooks']"));

        // Click on “Show All Laptops & Notebooks”
        clickOnElement(By.xpath("//a[text()='Show All Laptops & Notebooks']"));

        // Select Sort By "Price (High > Low)"
        clickOnElement(By.id("input-sort"));
        selectByVisibleTextFromDropDown(By.id("input-sort"), "Price (High > Low)");

        //Select Product “MacBook”
        clickOnElement(By.xpath("//body/div[@id='product-category']/div[1]/div[1]/div[4]/div[4]/div[1]/div[1]/a[1]/img[1]"));

        // Verify the text “MacBook”
        //Expected text
        String expectedText = "MacBook";
        //Actual text
        String actualText = getTextFromElement(By.xpath("//h1[text()='MacBook']"));
        //Compare text
        Assert.assertEquals("MacBook text", expectedText, actualText);

        //Click on ‘Add To Cart’ button
        clickOnElement(By.id("button-cart"));

        //Verify the message “Success: You have added MacBook to your shopping cart!”
        String expectedText1 = "Success: You have added MacBook to your shopping cart!\n" +
                "×";
        String actualText1 = getTextFromElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
        Assert.assertEquals(expectedText1, actualText1);

        // Click on link “shopping cart” display into success message
        clickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));

        // Verify the text "Shopping Cart"
        String expectedText2 = "Shopping Cart  (0.00kg)";
        String actualText2 = getTextFromElement(By.xpath("//h1[contains(text(),' (0.00kg)')]"));
        Assert.assertEquals("Shopping Cart text", expectedText2, actualText2);

        //Verify the Product name "MacBook"
        String expectedProductName = "MacBook";
        String actualProductName = getTextFromElement(By.xpath("//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]"));
        Assert.assertEquals("MacBook Product Name", expectedProductName, actualProductName);

        // Change Quantity "2"
        driver.findElement(By.xpath("//input[@value='1']")).clear();
        sendTextToElements(By.xpath("//input[@value='1']"), "2");

        //Click on “Update” Tab
        clickOnElement(By.xpath("//button[@data-original-title='Update']"));

        //Verify the message “Success: You have modified your shopping cart!”
        String expectedMessage = "Success: You have modified your shopping cart!\n" +
                "×";
        String actualMessage = getTextFromElement(By.xpath("//body/div[@id='checkout-cart']/div[1]"));
        Assert.assertEquals("Message : Success: You have modified your shopping cart!", expectedMessage, actualMessage);

        //Change currency
        clickOnElement(By.xpath("//span[contains(text(),'Currency')]"));
        clickOnElement(By.xpath("//button[contains(text(),'£ Pound Sterling')]"));

        // Verify the Total £737.45
        String expectedTotal = "£737.45";
        String actualTotal = getTextFromElement(By.xpath("//tbody/tr[1]/td[6]"));
        Assert.assertEquals("Total = £737.45", expectedTotal, actualTotal);


        // Click on “Checkout” button
        clickOnElement(By.xpath("//a[text()='Checkout']"));

        // Verify the text “Checkout”
        String expectedText3 = "Checkout";
        String actualText3 = getTextFromElement(By.xpath("//h1[text()='Checkout']"));
        Assert.assertEquals("Text : Checkout", expectedText3, actualText3);

        // Verify the Text “New Customer”
        Thread.sleep(5000);
        String expectedText4 = "New Customer";
        String actualText4 = getTextFromElement(By.xpath("//h2[contains(text(),'New Customer')]"));
        Assert.assertEquals("Text : New Customer", expectedText4, actualText4);


        // Click on “Guest Checkout” radio button
        clickOnElement(By.xpath("//body/div[@id='checkout-checkout']/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/label[1]/input[1]"));

        //Click on “Continue” tab
        clickOnElement(By.id("button-account"));

        //Fill the mandatory fields
        sendTextToElements(By.name("firstname"), "Raj");
        sendTextToElements(By.name("lastname"), "Mangukiya");
        sendTextToElements(By.id("input-payment-email"), "raj123@gmail.com");
        sendTextToElements(By.name("telephone"), "07766554433");
        sendTextToElements(By.name("address_1"), "100, High road");
        sendTextToElements(By.name("city"), "London");
        sendTextToElements(By.name("postcode"), "A1 2AB");
        selectByVisibleTextFromDropDown(By.id("input-payment-country"), "United Kingdom");
        selectByVisibleTextFromDropDown(By.id("input-payment-zone"), "Greater London");

        //Click on “Continue” Button
        clickOnElement(By.id("button-guest"));

        // Add Comments About your order into text area
        sendTextToElements(By.name("comment"), "Order should be delivered on time");

        // Check the Terms & Conditions check box
        clickOnElement(By.name("agree"));

        //Click on “Continue” button
        clickOnElement(By.id("button-payment-method"));

        //Verify the message “Warning: Payment method required!”
        String expectedMessage1 = "Warning: Payment method required!\n" +
                "×";
        String actualMessage1 = getTextFromElement(By.xpath("//div[text()='Warning: Payment method required!']"));
        Assert.assertEquals("Warning message", expectedMessage1, actualMessage1);
    }

    @After
    public void testDown() {
        closeBrowser();
    }
}
