package Homepage;

import base.CommonAPI;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

/**
 * Created by Bilal on 03-01-2017.
 */
public class TestHomePageSignIn extends CommonAPI {
    @Test
    public void alibabaSignInNavigate() throws InterruptedException {
        Actions actions = new Actions(driver);
        Thread.sleep(5000);
        actions.moveToElement(driver.findElement(By.cssSelector(".J-hd-m-notify-tab-trigger.sc-hd-ms-trigger.sc-hd-ms-unsign"))).moveToElement(driver.findElement(By.xpath(".//*[@id='J_SC_header']/header/div[2]/div[3]/div[1]/div[2]/div[1]/div[2]/a[1]"))).click().build().perform();
        Thread.sleep((5000));
        Assert.assertTrue(driver.findElement(By.cssSelector(".sc-hd-ms-btsignin")).isDisplayed());

    }
}
