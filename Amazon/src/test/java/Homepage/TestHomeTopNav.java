package Homepage;

import base.CommonAPI;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

/**
 * Created by Bilal on 03-01-2017.
 */
public class TestHomeTopNav extends CommonAPI{
    @Test(priority = 1)
    public void testYourStoreLink(){
        clickByXpath(".//*[@id='nav-your-amazon']");
        Assert.assertTrue(driver.findElement(By.xpath(".//*[@id='a-page']/div[1]/div[3]/div/div/form/div/div/div/h1")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath(".//*[@id='signInSubmit']")).isDisplayed());
    }
    @Test(priority = 2)
    public void testDealsStoreLink(){
        clickByXpath(".//*[@id='nav-xshop']/a[2]");
        Assert.assertTrue(driver.getTitle().contains("New Deals. Every Day."));
    }
}
