import PageObjects.FlipCartHomePage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import resources.Base;
import PageObjects.FlipCartLoginPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestProgram extends Base {

    public WebDriver driver;
    public static Logger log = LogManager.getLogger(TestProgram.class.getName());

    @BeforeTest

    public void initialize() throws IOException
    {

        driver =initilizeDriver();
       // driver.get(prop.getProperty("url"));
        driver.get("https://www.flipkart.com/");

        //To test git
        System.out.println("Git test");
    }

    @Test(priority = 0)
    public void flipcartLogin() throws Exception{

        log.info("Opened Flipcart");
        driver.manage().timeouts().implicitlyWait(5000,TimeUnit.MILLISECONDS);
        FlipCartLoginPage flp= new FlipCartLoginPage(driver);

        flp.getUsername().sendKeys("tosagarkk@gmail.com");
        log.info("Given username");
        flp.getPassword().sendKeys("Sagar@1989");
        log.info("Given password");
        flp.getLogin().click();
        log.info("Logged in to flipcart");

    }
    @Test(priority = 1)
    public void verifyHeader() throws Exception{
        FlipCartHomePage fhp=new FlipCartHomePage(driver);
       String s= fhp.getTitle().getText();
       System.out.println(s);
        Assert.assertEquals(fhp.getTitle().getText(), "Flipcart");

    }

@AfterTest
public void teardown()
{
    driver.close();

}
}
