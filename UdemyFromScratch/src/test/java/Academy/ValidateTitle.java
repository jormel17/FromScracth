package Academy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.LadingPage;
import resources.base;

import java.io.IOException;

public class ValidateTitle extends base {

    public static Logger log = LogManager.getLogger(base.class.getName());
    public WebDriver driver;


    @BeforeTest
    public void initialized() throws IOException {
        driver = initializedDriver();
        driver.get(pro.getProperty("url"));
        log.info("navigated to home page");

        driver.manage().window().maximize();
    }

    @Test
    public void BasePagesNavitgation() {

        LadingPage l= new LadingPage(driver);
        Assert.assertEquals(l.getTitle().getText(),"FEATURED COURSES");
        log.info("Successfully validated Text message");
    }

@AfterTest
    public void TearDown()
    {
        driver.close();
    }
    
}
