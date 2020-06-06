package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    public WebDriver driver;
    By email = By.xpath("//input[@id='user_email']");
    By password = By.xpath("//input[@id='user_password']");
    By login = By.xpath("//input[@name='commit']");

    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public WebElement getEmail(){

        return  driver.findElement(email);

    }
    public WebElement getpassword(){

        return  driver.findElement(password);

    }
    public WebElement getLogin1(){

        return  driver.findElement(login);

    }

}
