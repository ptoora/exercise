package com.mycompany.app;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    WebDriver driver;
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Test :-)
     */
    public void testApp()
    {
        // get driver
        driver = new FirefoxDriver();

        // onto landing Page
        LandingPage landingPage = new LandingPage(driver);

        // get help options and validate and print
        List actualOptions = landingPage.getHelpSectionOptions();
        ArrayList<String> expectedOptions = new ArrayList<String>();
        expectedOptions.add("Browse Help");
        expectedOptions.add("All Help topics");
        expectedOptions.add("Contact us");
        expectedOptions.add("O2 Gurus");
        expectedOptions.add("O2 Community");
        assertEquals(expectedOptions, actualOptions);
        System.out.println(expectedOptions);
        ContactUsPage contactUsPage = landingPage.selectContactUs();
        contactUsPage.selectIveGotATechnicalQuestion();
        driver.quit();
    }

}
