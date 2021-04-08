package test.functional;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;

import static org.junit.Assert.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;

public class FunctionalTest {

	private WebDriver driver;

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver","/Library/Java/JUNIT/chromedriver");
		driver = new ChromeDriver();
	    	// Seems no more working in last Chrome versions
		// driver.manage().window().maximize();
  		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
     }

    // Test de la Story #1-homepage (https://trello.com/c/WKTneu9o/1-homepage)
	@Test
    public void testHomepage() throws Exception {
        driver.get("https://www.meetup.com/fr-FR/");

        // n°1 : le titre de la page d'acceuil doit être 
		assertEquals(driver.getTitle(), "Partagez vos passions | Meetup");
    

        // n°2: la description de la page d'acceuil doit être 

        assertEquals(driver.findElement(By.name("description")).getAttribute("content"), "Partagez vos passions et faites bouger votre ville ! Meetup vous aide à rencontrer des personnes près de chez vous, autour de vos centres dintérêt.");    
    }
    // Test de la Story n ...
    // TODO
    // To Be Completed By Coders From Coding Factory

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

}
