package com.mycompany.app;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Unit test for O2 exercise
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
     * Test method
     */
    public void testApp()
    {
        // get driver and setup
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

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

        // get to opening times
        ContactUsPage contactUsPage = landingPage.selectContactUs();
        contactUsPage.selectIveGotATechnicalQuestion();
        contactUsPage.selectPreferToSpeakToSomeone();
        contactUsPage.selectPayAndGoTeam();

        // validate and print opening times first section
        List actualTimes = contactUsPage.getOpeningTimes();
        ArrayList<String> expectedTimes = new ArrayList<String>();
        expectedTimes.add("Monday - Friday");
        expectedTimes.add("08:00 - 21:00");
        expectedTimes.add("Saturday");
        expectedTimes.add("08:00 - 20:00");
        expectedTimes.add("Sunday");
        expectedTimes.add("09:00 - 18:00");
        assertEquals(expectedTimes, actualTimes);
        System.out.println(actualTimes);

        // exit
        driver.quit();
    }

}
