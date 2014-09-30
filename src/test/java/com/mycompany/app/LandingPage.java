package com.mycompany.app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Parsh Toora
 * Date: 30/09/14
 * Time: 10:32
 * To change this template use File | Settings | File Templates.
 */
public class LandingPage {
    WebDriver driver;
     public LandingPage(WebDriver driver) {
         driver.get("https://www.o2.co.uk/");
         this.driver = driver;
     }
     public List getHelpSectionOptions() {

         WebElement elm = driver.findElement(By.xpath("//*[@id='pn5']/a"));
         elm.click();
         try {
             Thread.sleep(2000);
         } catch (Exception e) {}
         List<WebElement> elementsList =  driver.findElements(By.xpath("//*[@id='pn5']/ul/li/a"));
         List<String> options = new ArrayList<String>();
         for(WebElement option:elementsList) {
             options.add(option.getText());
         }
         return options;
     }


    public ContactUsPage selectContactUs () {
        List<WebElement> elementsList =  driver.findElements(By.xpath("//*[@id='pn5']/ul/li/a"));
        elementsList.get(2).click();
        return new ContactUsPage(driver);
    }
}
