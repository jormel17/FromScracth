package Academy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObject.ForgotPasswod;
import pageObject.LadingPage;
import pageObject.LoginPage;
import resources.base;

import java.io.IOException;

public class HomePages extends base {

    public static Logger log = LogManager.getLogger(base.class.getName());
    public WebDriver driver;

    @BeforeTest
    public void initialize() throws IOException {
        driver = initializedDriver();
        log.info("Driver is initialized");


    }

    @Test(dataProvider = "getData")
    public void BasePagesNavitgation(String Email, String pass) throws IOException {
        driver.get(pro.getProperty("url"));
        log.info("Navigate to home page");
        driver.manage().window().maximize();

        LadingPage l = new LadingPage(driver);
        LoginPage lp =l.getLogin();
        lp.getEmail().sendKeys(Email);
        lp.getpassword().sendKeys(pass);
        log.info("Successfully validated Text message");
        lp.getLogin1().click();

        ForgotPasswod fp= lp.ForgotPassword();
        fp.getEmail().sendKeys("xxx");
        fp.sendMeIntruction().click();

    }

    @DataProvider
    public Object[][] getData() {
        Object[][] data = new Object[2][2];

        data[0][0] = "asdasd@gmail.com";
        data[0][1] = "123123213";


        data[1][0] = "testasdfacek@adasd.com";
        data[1][1] = "123123213";
        return data;
    }

@AfterTest
    public void teardown()
    {
        driver.close();
    }

}