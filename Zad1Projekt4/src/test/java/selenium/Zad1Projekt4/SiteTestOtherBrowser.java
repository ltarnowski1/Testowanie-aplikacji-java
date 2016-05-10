package selenium.Zad1Projekt4;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SiteTestOtherBrowser {
	
	private static WebDriver driver;
	WebElement element;
	WebDriverWait wait = new WebDriverWait(driver, 10);
	
	@BeforeClass
	public static void driverSetup() {		
		System.setProperty("webdriver.edge.driver", "MicrosoftWebDriver.exe");
		driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}
	
	@Before
	public void homePage(){
		driver.get("http://morgue.herokuapp.com");		
		element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[2]/div/h1")));
		Assert.assertEquals("Morgue", element.getText());
	}
	
	public void login(){
		element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/nav/div/form[2]/a[1]")));
		element.click();
		element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='user_email']")));
		element.click();
		element.sendKeys("test@gmail.com");
		element = driver.findElement(By.id("user_password"));
		element.clear();
		element.click();
		element.sendKeys("87654321");
		element = driver.findElement(By.name("commit"));
		element.click();
		element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div/p")));
	}
	
	public void logout(){
		element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/nav/div/form[2]/a[2]")));
		element.click();
	}
	
	@Test
	public void loginTest(){
		this.login();
		Assert.assertEquals("Signed in successfully.", element.getText());
		this.logout();
	}
	
	@Test
	public void logoutTest(){
		this.login();
		this.logout();
		element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div/p")));
		Assert.assertEquals("Signed out successfully.", element.getText());
	}
	
	@Test
	public void editAccountTest() {
		this.login();
		element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/nav/div/form[2]/a[1]")));
		element.click();
		element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/nav/div/form[2]/a[1]")));
		Assert.assertEquals("Edit account", element.getText());
		element = driver.findElement(By.xpath("//*[@id='user_email']"));
		element.clear();
		element.sendKeys("test1@gmail.com");	
		element = driver.findElement(By.xpath("//*[@id='user_password']"));
		element.clear();
		element.sendKeys("12345678");	
		element = driver.findElement(By.xpath("//*[@id='user_password_confirmation']"));
		element.clear();
		element.sendKeys("12345678");
		element = driver.findElement(By.xpath("//*[@id='user_current_password']"));
		element.clear();
		element.sendKeys("87654321");
		element = driver.findElement(By.xpath("//*[@id='edit_user']/div[3]/input"));
		element.click();	
		element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div/p")));
		Assert.assertEquals("Your account has been updated successfully.", element.getText());
		
		
		element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/nav/div/form[2]/a[1]")));
		element.click();
		element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/nav/div/form[2]/a[1]")));
		Assert.assertEquals("Edit account", element.getText());
		element = driver.findElement(By.xpath("//*[@id='user_email']"));
		element.clear();
		element.sendKeys("test@gmail.com");	
		element = driver.findElement(By.xpath("//*[@id='user_password']"));
		element.clear();
		element.sendKeys("87654321");	
		element = driver.findElement(By.xpath("//*[@id='user_password_confirmation']"));
		element.clear();
		element.sendKeys("87654321");
		element = driver.findElement(By.xpath("//*[@id='user_current_password']"));
		element.clear();
		element.sendKeys("12345678");
		element = driver.findElement(By.xpath("//*[@id='edit_user']/div[3]/input"));
		element.click();
		element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div/p")));
		this.logout();
	}
	
	@Test
	public void viewPageTest(){
		this.login();
		driver.get("http://morgue.herokuapp.com/corpses");
		crudPage cPage = new crudPage(driver);
		Assert.assertEquals(cPage.getCorpseInscription().getText(), "Corpses");
		this.logout();
	}
	
	@Test
	public void createTest(){
		this.login();
		driver.get("http://morgue.herokuapp.com/corpses");
		crudPage crudPage = new crudPage(driver);
		crudPage.getCreateButton().click();

		createPage cPage = new createPage(driver);
		cPage.get_corpse_first_name().click();
		cPage.get_corpse_first_name().sendKeys("testName");
		cPage.get_corpse_last_name().click();
		cPage.get_corpse_last_name().sendKeys("testLastName");
		cPage.get_corpse_pesel().click();
		cPage.get_corpse_pesel().sendKeys("93112106038");
		cPage.get_corpse_date_of_birth().click();
		cPage.get_date_of_birth_selection().click();
		cPage.get_corpse_date_of_death().click();
		cPage.get_date_of_death_selection().click();
		cPage.get_createButton().click();
		crudPage.getsearchField().click();
		crudPage.getsearchField().sendKeys("testName");
		crudPage.getSearchButton().click();
		element = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr[2]/td[1]"));
		Assert.assertEquals(element.getText(), "testName");
		this.logout();
	}
	
	@Test
	public void invalidCorpseCreateTest(){
		String parentWindow;
		parentWindow = driver.getWindowHandle(); 
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "n");
		
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}
		driver.get("http://morgue.herokuapp.com");
		
		this.login();
		element = driver.findElement(By.xpath("/html/body/nav/div/form[1]/a[2]"));
		element.click();
		crudPage crudPage = new crudPage(driver);
		crudPage.getCreateButton().click();
		createPage cPage = new createPage(driver);
		cPage.get_corpse_first_name().click();
		cPage.get_corpse_first_name().sendKeys("t");
		cPage.get_corpse_last_name().click();
		cPage.get_corpse_last_name().sendKeys("t");
		cPage.get_corpse_pesel().click();
		cPage.get_corpse_pesel().sendKeys("t");
		cPage.get_createButton().click();

		element = driver.findElement(By.xpath("//*[@id='new_corpse']/ul/li[3]"));
		Assert.assertEquals(element.getText(), "First name is too short (minimum is 3 characters)");
		element = driver.findElement(By.xpath("//*[@id='new_corpse']/ul/li[4]"));
		Assert.assertEquals(element.getText(), "Last name is too short (minimum is 3 characters)");
		element = driver.findElement(By.xpath("//*[@id='new_corpse']/ul/li[5]"));
		Assert.assertEquals(element.getText(), "Pesel is the wrong length (should be 11 characters)");
		element = driver.findElement(By.xpath("//*[@id='new_corpse']/ul/li[1]"));
		Assert.assertEquals(element.getText(), "Date of birth can't be blank");
		element = driver.findElement(By.xpath("//*[@id='new_corpse']/ul/li[2]"));
		Assert.assertEquals(element.getText(), "Date of death can't be blank");
		this.logout();
	}
	
	@AfterClass
	public static void cleanp() {
		driver.quit();
	}
}
