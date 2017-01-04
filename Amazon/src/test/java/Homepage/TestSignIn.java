package Homepage;

import base.CommonAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Bilal on 03-01-2017.
 */
public class TestSignIn extends CommonAPI{
    @Test(priority = 3)
    public void testSignInBlankCredentials() throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath( ".//*[@id='nav-link-yourAccount']"))).moveToElement(driver.findElement(By.xpath(".//*[@id='nav-flyout-ya-signin']/a/span"))).click().build().perform();
        Thread.sleep(3000);
        clickByXpath(".//*[@id='signInSubmit']");
        Thread.sleep(3000);
        Assert.assertTrue(driver.findElement(By.xpath(".//*[@id='auth-email-missing-alert']/div/div")).getText().equals("Enter your e-mail address or mobile phone number"));
        Assert.assertTrue(driver.findElement(By.xpath(".//*[@id='auth-password-missing-alert']/div/div")).getText().contains("Enter your password"));
    }
    @Test(priority = 4)
    public void testSignInNoPassword() throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath( ".//*[@id='nav-link-yourAccount']"))).moveToElement(driver.findElement(By.xpath(".//*[@id='nav-flyout-ya-signin']/a/span"))).click().build().perform();
        Thread.sleep(3000);
        typeByXpath(".//*[@id='ap_email']","incorrectUser");
        clickByXpath(".//*[@id='signInSubmit']");
        Thread.sleep(3000);
        Assert.assertTrue(driver.findElement(By.xpath(".//*[@id='auth-password-missing-alert']/div/div")).getText().contains("Enter your password"));

    }
    @Test(priority = 5)
    public void testSignInIncorrectCredentials() throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath( ".//*[@id='nav-link-yourAccount']"))).moveToElement(driver.findElement(By.xpath(".//*[@id='nav-flyout-ya-signin']/a/span"))).click().build().perform();
        Thread.sleep(3000);
        typeByXpath(".//*[@id='ap_email']","incorrectUser");
        typeByXpath(".//*[@id='ap_password']","incorrectPassword");
        clickByXpath(".//*[@id='signInSubmit']");
        Thread.sleep(3000);
        Assert.assertTrue(driver.findElement(By.xpath(".//*[@id='auth-error-message-box']/div/div/ul/li/span")).getText().contains("We cannot find an account with that e-mail address"));

    }

}
