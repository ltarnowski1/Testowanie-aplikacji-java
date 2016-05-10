package selenium.Zad1Projekt4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class crudPage {
	
	@FindBy(xpath="/html/body/h1")
	private WebElement corpseInscription;
	
	@FindBy(xpath="//*[@id='search-form']/a")
	private WebElement createButton;
	
	@FindBy(xpath="//*[@id='search-form']/button")
	private WebElement searchButton;

	@FindBy(xpath="//*[@id='search']")
	private WebElement searchField;
	
	WebElement getCorpseInscription(){ return corpseInscription; }
	WebElement getCreateButton(){ return createButton; }
	WebElement getSearchButton(){ return searchButton; }
	WebElement getsearchField(){ return searchField; }
	
	public crudPage(){
		
	}
	
	public crudPage(WebDriver driver) {
	  PageFactory.initElements(driver, this);
	}


}
