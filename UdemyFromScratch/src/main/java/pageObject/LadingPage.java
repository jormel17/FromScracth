package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LadingPage {

    public WebDriver driver;
    By signing = By.xpath("//span[contains(text(),'Login')]");
    By title = By.xpath("//h2[contains(text(),'Featured Courses')]");


    public LadingPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public LoginPage getLogin(){

        driver.findElement(signing).click();
        LoginPage lp = new LoginPage(driver);
        return lp;
    }

    public WebElement getTitle(){

        return  driver.findElement(title);

    }


}
