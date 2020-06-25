package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    public WebDriver driver;
    private By email = By.xpath("//input[@id='user_email']");
    private By password = By.xpath("//input[@id='user_password']");
    private By login = By.xpath("//input[@name='commit']");
    private By ForgotPass = By.cssSelector("[href*='password/new']");

    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public ForgotPasswod ForgotPassword(){
        driver.findElement(ForgotPass).click();
        return new ForgotPasswod(driver);
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
