package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FlipCartLoginPage {

    public WebDriver driver;

    public FlipCartLoginPage(WebDriver driver){
        this.driver=driver;
    }

    By username= By.xpath("//div[@class=\"_39M2dM JB4AMj\"]//input[@type=\"text\"]");
    By password= By.xpath("//div[@class=\"_39M2dM JB4AMj\"]//input[@type=\"password\"]");
    By login = By.xpath("//button[@class=\"_2AkmmA _1LctnI _7UHT_c\"]/span");

    public WebElement getUsername(){
        return  driver.findElement(username);
    }
    public WebElement getPassword(){
        return  driver.findElement(password);
    }
    public WebElement getLogin(){
        return  driver.findElement(login);
    }
}

