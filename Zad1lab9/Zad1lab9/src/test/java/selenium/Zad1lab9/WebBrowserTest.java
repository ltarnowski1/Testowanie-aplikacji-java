package selenium.Zad1lab9;

import static org.junit.Assert.*;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.apache.commons.io.FileUtils;

import junit.framework.Assert;


public class WebBrowserTest {

	private static WebDriver driver;
	WebElement searchBox;

	@BeforeClass
	public static void driverSetup() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
	}

	@Test
	public void SearchTest(){
		driver.get("http://www.google.pl");
		searchBox = driver.findElement(By.id("lst-ib"));
		searchBox.clear();
		searchBox.sendKeys("selenium");
		driver.findElement(By.name("btnG")).click();
		assertEquals("Google", driver.getTitle());
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    assertNotNull(screenshot);
		try {
			FileUtils.copyFile(screenshot, new File("resources/google.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	

	@AfterClass
	public static void cleanp() {
		driver.quit();
	}
}
