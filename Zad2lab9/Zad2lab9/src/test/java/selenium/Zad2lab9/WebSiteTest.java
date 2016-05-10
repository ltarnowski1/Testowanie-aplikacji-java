package selenium.Zad2lab9;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.security.auth.login.LoginContext;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import static org.junit.Assert.*;


public class WebSiteTest {

	private static WebDriver driver;
	WebElement element;
	
	@BeforeClass
	public static void driverSetup() {
		System.setProperty("webdriver.edge.driver", "MicrosoftWebDriver.exe");
		driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}

	@Before
	public void homePage(){
		driver.get("http://morgue.herokuapp.com");
			
	}
	
	@Test
	public void LoginTest()
	{
		driver.findElement(By.linkText("Log in")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		element = driver.findElement(By.id("user_email"));
		element.clear();
		element.click();
		element.sendKeys("test@gmail.com");
		element = driver.findElement(By.id("user_password"));
		element.clear();
		element.click();
		element.sendKeys("87654321");
		element = driver.findElement(By.name("commit"));
		element.click();
		String s = driver.findElement(By.xpath("//div[@class='jumbotron statement']")).getText();
		assertEquals(s, "Signed in successfully.");
		element = driver.findElement(By.xpath("//a[@href='/users/sign_out']"));
		element.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void RegistrationTest()
	{
		element = driver.findElement(By.xpath("//a[@href='/users/sign_up']"));
		element.click();
		element = driver.findElement(By.id("user_email"));
		element.clear();
		element.click();
		element.sendKeys("7@gmail.com");
		element = driver.findElement(By.id("user_password"));
		element.clear();
		element.click();
		element.sendKeys("87654321");
		element = driver.findElement(By.id("user_password_confirmation"));
		element.clear();
		element.click();
		element.sendKeys("87654321");
		driver.findElement(By.xpath("//input[@value='Sign up']")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String s = driver.findElement(By.xpath("//div[@class='jumbotron statement']")).getText();
		assertEquals(s, "Welcome! You have signed up successfully.");
		element = driver.findElement(By.xpath("//a[@href='/users/sign_out']"));
		element.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void usedLoginRegistrationTest()
	{

		element = driver.findElement(By.xpath("//a[@href='/users/sign_up']"));
		element.click();
		element = driver.findElement(By.id("user_email"));
		element.clear();
		element.click();
		element.sendKeys("3@gmail.com");
		driver.findElement(By.name("commit")).click();
		String s = driver.findElement(By.xpath("//div[@id='error_explanation']/h2")).getText();
		assertEquals(s, "2 errors prohibited this user from being saved:");

	}

	@AfterClass
	public static void cleanp() {
		driver.quit();
	}
}
