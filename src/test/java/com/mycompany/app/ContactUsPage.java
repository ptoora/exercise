package com.mycompany.app;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Parsh Toora
 * Date: 30/09/14
 * Time: 10:45
 * To change this template use File | Settings | File Templates.
 */

public class ContactUsPage {

    WebDriver driver;
    public ContactUsPage(WebDriver driver) {
       this.driver = driver;
    }
    public ContactUsPage selectIveGotATechnicalQuestion( ) {
        WebElement elm = driver.findElement(By.xpath("//h2[contains(@onclick,'TECHNICAL')]//a"));
        elm.click();
        return this;
    }

    public ContactUsPage selectPreferToSpeakToSomeone() {
        WebElement elm = driver.findElement(By.xpath("//*[@id='contacts-q26']"));
        elm.click();
        return this;
    }

    public ContactUsPage selectPayAndGoTeam() {
        //JavascriptExecutor executor = (JavascriptExecutor)driver;
        //executor.executeScript("document.getElementsByClassName('trigger')[2].click();");
        WebElement elm = driver.findElement(By.xpath("(//h4[@class='paygoteam h'])[2]/a"));
        elm.click();
        return this;

    }

    public List<String> getOpeningTimes() {

        List<WebElement> elementsList =  driver.findElements(By.xpath("//*[@class='paygoteam inner']//*[@class='times']//tbody//td"));
        List<String> times = new ArrayList<String>();
        int i=0;
        for(WebElement option:elementsList) {
            ++i;
            if (i>8 && i<15){
                times.add(option.getText());
            }
        }
        return times;
    }
}

