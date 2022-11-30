package myaccounts;

import com.google.common.base.Verify;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class MyAccountsTest extends Utility {
    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    public void selectMyAccountOptions(String option) {
        String anyOption = option.toLowerCase();
        String expression = "//a[text()='" + anyOption + "']";
        driver.findElement(By.xpath(expression)).click();
    }

    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        //1.1 Click on My Account Link.
        clickOnElement(By.xpath("//span[text()='My Account']"));

        //1.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        clickOnElement(By.xpath("//a[text()='Register']"));
        //selectMyAccountOptions("Register");

        //1.3 Verify the text “Register Account”.
        String expectedText = "Register Account";
        String actualText = getTextFromElement(By.xpath("//h1[text()='Register Account']"));
        Assert.assertEquals("Text : Register Account", expectedText, actualText);
    }

    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        //2.1 Click on My Account Link.
        clickOnElement(By.xpath("//span[text()='My Account']"));

        //2.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        //selectMyAccountOptions("Login");
        clickOnElement(By.xpath("//a[text()='Login']"));

        //2.3 Verify the text “Returning Customer”.
        String expectedText = "Returning Customer";
        String actualText = getTextFromElement(By.xpath("//h2[text()='Returning Customer']"));
        Assert.assertEquals("Text : Returning Customer", expectedText, actualText);
    }

    @Test
    public void verifyThatUserRegisterAccountSuccessfully() {
        //3.1 Click on My Account Link.
        clickOnElement(By.xpath("//span[text()='My Account']"));
        //3.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        clickOnElement(By.xpath("//a[text()='Register']"));
        //3.3 Enter First Name
        sendTextToElements(By.id("input-firstname"), "Raj");
        //3.4 Enter Last Name
        sendTextToElements(By.id("input-lastname"), "Mangukiya");
        //3.5 Enter Email
        sendTextToElements(By.id("input-email"), "raj230@gmail.com");
        //3.6 Enter Telephone
        sendTextToElements(By.id("input-telephone"), "07171002233");
        //3.7 Enter Password
        sendTextToElements(By.id("input-password"), "test@123");
        //3.8 Enter Password Confirm
        sendTextToElements(By.id("input-confirm"), "test@123");
        //3.9 Select Subscribe Yes radio button
        clickOnElement(By.xpath("//body/div[@id='account-register']/div[1]/div[1]/form[1]/fieldset[3]/div[1]/div[1]/label[1]/input[1]"));
        //3.10 Click on Privacy Policy check box
        clickOnElement(By.name("agree"));
        //3.11 Click on Continue button
        clickOnElement(By.xpath("//input[@value='Continue']"));
        //3.12 Verify the message “Your Account Has Been Created!”
        String expectedMessage = "Your Account Has Been Created!";
        String actualMessage = getTextFromElement(By.xpath("//h1[text()='Your Account Has Been Created!']"));
        Assert.assertEquals("Text : Your Account Has Been Created!", expectedMessage, actualMessage);

        //3.13 Click on Continue button
        clickOnElement(By.xpath("//a[text()='Continue']"));
        //3.14 Click on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
        //3.15 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        clickOnElement(By.xpath("//a[contains(text(),'Logout')]"));
        //3.16 Verify the text “Account Logout”
        String expectedText = "Account Logout";
        String actualText = getTextFromElement(By.xpath("//h1[contains(text(),'Account Logout')]"));
        Assert.assertEquals("Text : Account logout", expectedText, actualText);
        //3.17 Click on Continue button
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
    }

    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() {
        //4.1 Click on My Account Link.
        clickOnElement(By.xpath("//span[text()='My Account']"));
        //4.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        clickOnElement(By.xpath("//a[contains(text(),'Login')]"));
        //4.3 Enter Email address
        sendTextToElements(By.xpath("//input[@id='input-email']"), "raj231@gmail.com");
        //4.5 Enter Password
        sendTextToElements(By.xpath("//input[@id='input-password']"), "test@123");
        //4.6 Click on Login button
        clickOnElement(By.xpath("//body/div[@id='account-login']/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/input[1]"));
        //4.7 Verify text “My Account”
        String expectedText = "My Account";
        String actualText = getTextFromElement(By.xpath("//h2[contains(text(),'My Account')]"));
        //4.8 Click on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
        //4.9 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        clickOnElement(By.xpath("//body/nav[@id='top']/div[1]/div[2]/ul[1]/li[2]/ul[1]/li[5]/a[1]"));
        //4.10 Verify the text “Account Logout”
        String expectedText1 = "Account Logout";
        String actualText1 = getTextFromElement(By.xpath("//h1[contains(text(),'Account Logout')]"));
        Assert.assertEquals("Text : Account logout", expectedText1, actualText1);
        //4.11 Click on Continue button
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
    }

    @After
    public void testDown() {
        closeBrowser();
    }
}
