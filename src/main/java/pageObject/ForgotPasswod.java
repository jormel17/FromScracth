package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPasswod {

    public WebDriver driver;
    By email = By.xpath("//input[@id='user_email']");
    By sendMeIntructions= By.cssSelector("[type='submit']");

    public ForgotPasswod(WebDriver driver)
    {
        this.driver = driver;
    }



    public WebElement getEmail(){

        return  driver.findElement(email);


    }
    public WebElement sendMeIntruction(){

        return  driver.findElement(sendMeIntructions);


    }



}
