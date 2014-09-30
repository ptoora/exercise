package com.mycompany.app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
        WebElement elm = driver.findElement(By.xpath("//h2[contains(@onclick,'PAYG VOICE')]//a"));
        elm.click();
        return this;

    }

    public void getOpeningTimes() {

    }
}

