package Academy;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObject.LadingPage;
import pageObject.LoginPage;
import resource.Base;

import java.io.IOException;

public class HomePages extends Base {
    public WebDriver driver;


    @Test(dataProvider = "getData")
    public void BasePagesNavitgation(String Email, String pass) throws IOException {
        driver.get(pro.getProperty("url"));
        //driver.manage().window().maximize();

        LadingPage l = new LadingPage(driver);
        l.getLogin().click();
        LoginPage lp = new LoginPage(driver);
        lp.getEmail().sendKeys(Email);
        lp.getpassword().sendKeys(pass);
        lp.getLogin1().click();

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

    @BeforeTest
    public void initialize() throws IOException {
        driver = initializedDriver();

    }

}