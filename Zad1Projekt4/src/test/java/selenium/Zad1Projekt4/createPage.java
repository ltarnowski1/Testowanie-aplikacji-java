package selenium.Zad1Projekt4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class createPage {
	
	@FindBy(id="corpse_first_name")
	private WebElement corpse_first_name;
	
	@FindBy(id="corpse_last_name")
	private WebElement corpse_last_name;
	
	@FindBy(id="corpse_pesel")
	private WebElement corpse_pesel;
	
	@FindBy(id="corpse_date_of_birth")
	private WebElement corpse_date_of_birth;
	
	@FindBy(id="corpse_date_of_death")
	private WebElement corpse_date_of_death;
	
	@FindBy(xpath="//*[@id='ui-datepicker-div']/table/tbody/tr[1]/td[1]/a")
	private WebElement date_of_birth_selection;
	
	@FindBy(xpath="//*[@id='ui-datepicker-div']/table/tbody/tr[1]/td[1]/a")
	private WebElement date_of_death_selection;
	
	@FindBy(xpath="//*[@id='new_corpse']/div[6]/div/button")
	private WebElement createButton;
	
	WebElement get_corpse_first_name(){ return corpse_first_name; }
	WebElement get_corpse_last_name(){ return corpse_last_name; }
	WebElement get_corpse_pesel(){ return corpse_pesel; }
	WebElement get_corpse_date_of_birth(){ return corpse_date_of_birth; }
	WebElement get_corpse_date_of_death(){ return corpse_date_of_death; }
	WebElement get_date_of_birth_selection(){ return date_of_birth_selection; }
	WebElement get_date_of_death_selection(){ return date_of_death_selection; }
	WebElement get_createButton(){ return createButton; }
	
	public createPage(){
		
	}
	
	public createPage(WebDriver driver) {
	  PageFactory.initElements(driver, this);
	}
}
