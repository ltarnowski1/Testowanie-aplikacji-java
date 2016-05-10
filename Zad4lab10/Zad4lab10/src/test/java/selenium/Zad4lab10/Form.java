package selenium.Zad4lab10;
import org.openqa.selenium.*;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Form {
	private WebDriver driver;

	@FindBy(how = How.XPATH, using = "//*[@id='mG61Hd']/div/div[2]/div[2]/div[1]/div[2]/div[2]")
	private WebElement sex;
	
	@FindBy(how = How.XPATH, using = "id('mG61Hd')/div/div[2]/div[2]/div[1]/div[2]/div[3]/div[3]")
	private WebElement man;
	
	@FindBy(how = How.XPATH, using = "id('mG61Hd')/div/div[2]/div[2]/div[2]/div[2]/div/content/label[2]/div[2]/div/span")
	private WebElement smutam_radioButton;
	
	@FindBy(how = How.XPATH, using = "//*[@id='mG61Hd']/div/div[2]/div[2]/div[3]/div[2]/div[1]/label/div[1]")
	private WebElement barmanska_checkBox;
	
	@FindBy(how = How.XPATH, using = "//*[@id='mG61Hd']/div/div[2]/div[2]/div[3]/div[2]/div[2]/label/div[1]")
	private WebElement lubelska_checkBox;
	
	@FindBy(how = How.XPATH, using = "//*[@id='mG61Hd']/div/div[2]/div[2]/div[3]/div[2]/div[3]/label/div[1]")
	private WebElement gorzalka_checkBox;
	
	@FindBy(how = How.XPATH, using = "//*[@id='i.err.581678982']")
	private WebElement tooManyAlco_error;
	
	@FindBy(how = How.XPATH, using = "//*[@id='i.err.906377358']")
	private WebElement requiredField_error;
	
	@FindBy(how = How.XPATH, using = "//*[@id='i.err.543052220']")
	private WebElement requiredField_error2;
	
	@FindBy(how = How.XPATH, using = "//*[@id='mG61Hd']/div/div[2]/div[3]/div/div/div/content/span")
	private WebElement sendButton;
	
	private List<WebElement> checkboxList = new ArrayList<WebElement>();
	private static String PAGE_URL = "https://docs.google.com/forms/d/17_O3KgczSA6JF7j7dMFN2cXkzwt_18yhp-mgxpPROTM/viewform";

	public Form(WebDriver driver) {
		this.driver = driver;
		driver.get(PAGE_URL);
		PageFactory.initElements(driver, this);
	}

	public void selectSex() {
		sex.click();
		Actions actions = new Actions(driver);
		actions.moveToElement(man);
		actions.perform();
		man.click();
	}
	
	public void selectFrequency()
	{
		smutam_radioButton.click();
	}
	
	public void selectAlco()
	{
		barmanska_checkBox.click();
		lubelska_checkBox.click();
		checkboxList.add(barmanska_checkBox);
		checkboxList.add(lubelska_checkBox);
	}
	
	public void selectTooManyAlco()
	{
		barmanska_checkBox.click();
		lubelska_checkBox.click();
		gorzalka_checkBox.click();
	}
	
	public String isMan()
	{
		return man.getText();
	}
	
	public String isSmutamChecked()
	{
		return smutam_radioButton.getText();
	}
	
	public String isBarmanskaChecked()
	{
		return barmanska_checkBox.getAttribute("aria-checked");
	}
	
	public String isLubelskaChecked()
	{
		return lubelska_checkBox.getAttribute("aria-checked");
	}
	
	public int checkBoxListSize()
	{
		return checkboxList.size();
	}
	
	public String getTooManyAlcoError(){
		return tooManyAlco_error.getText();
	}
	
	public void sendForm() {
		sendButton.click();
	}
	
	public String getRequiredFieldError()
	{
		return requiredField_error.getText();
	}

	public String getRequiredFieldError2()
	{
		return requiredField_error2.getText();
	}
}
