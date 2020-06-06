package Academy;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObject.LadingPage;
import pageObject.LoginPage;
import resource.Base;

import java.io.IOException;

public class ValidateTitle extends Base {
    public WebDriver driver;

    @Test
    public void BasePagesNavitgation() throws IOException {

        LadingPage l= new LadingPage(driver);
        Assert.assertEquals(l.getTitle().getText(),"FEATURED COURSES");

    }

@AfterTest
    public void TearDown()
    {
        driver.close();
    }

    @BeforeTest
    public void initialized() throws IOException {
        driver = initializedDriver();
        //initializedDriver
        driver.get(pro.getProperty("url"));
        driver.manage().window().maximize();
    }

}
