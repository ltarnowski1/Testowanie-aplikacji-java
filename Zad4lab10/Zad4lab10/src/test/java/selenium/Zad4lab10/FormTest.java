package selenium.Zad4lab10;
import java.util.concurrent.TimeUnit;

import org.hamcrest.core.Is;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.google.common.base.Converter;

import junit.framework.TestCase;


public class FormTest 
{
	private static WebDriver driver;
	WebElement element;
	
	@BeforeClass
	public static void driverSetup() {		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}
	
	@Test
	public void fillFormTest(){
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.onbeforeunload = function() {};"); 
		
		Form form = new Form(driver);
		form.selectSex();
		Assert.assertEquals("Mężczyzna", form.isMan());
		
		form.selectFrequency();
		Assert.assertEquals("Tylko jak smutam", form.isSmutamChecked());
		
		form.selectAlco();
		Assert.assertTrue(Boolean.parseBoolean(form.isBarmanskaChecked()));
		Assert.assertTrue(Boolean.parseBoolean(form.isLubelskaChecked()));
		Assert.assertEquals(2, form.checkBoxListSize());
	}
	
	@Test
	public void unvalidFillFormTest()
	{	
		Form form = new Form(driver);
		form.selectTooManyAlco();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
		Assert.assertEquals("Nie można wybrać więcej niż 2 alkohole", form.getTooManyAlcoError());	
	}

	@Test
	public void sendingEmptyForm()
	{	
		Form form = new Form(driver);
		form.sendForm();	
		Assert.assertEquals("Odpowiedź na to pytanie jest wymagana", form.getRequiredFieldError());
		Assert.assertEquals("Odpowiedź na to pytanie jest wymagana", form.getRequiredFieldError2());
	}

	@AfterClass
	public static void cleanp() {
		driver.close();
	}
}
