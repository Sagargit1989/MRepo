package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FlipCartHomePage {

    public WebDriver driver;

    public FlipCartHomePage(WebDriver driver){
        this.driver=driver;
    }

    By title= By.xpath("//img[@title=\"Flipkart\"]");


    public WebElement getTitle(){
        return  driver.findElement(title);
    }

}

