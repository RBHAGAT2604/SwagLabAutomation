package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import utility.Keywords;

public class PersonalInfoPage {
	
	private static final Logger log = Logger.getLogger(PersonalInfoPage.class);


	public PersonalInfoPage(){
		PageFactory.initElements(Keywords.driver, this);
		
		
	}
	
	@FindBy(xpath = "//input[@id='first-name']")
	WebElement firstName;
	
	@FindBy(xpath = "//input[@id='last-name']")
	WebElement lastName;
	
	@FindBy(xpath = "//input[@id='postal-code']")
	WebElement postalCode;
	
	@FindBy (xpath = "//input[@id='continue']")
	WebElement coninueBtn;
	
	@FindBy (xpath = "//span[text()='Checkout: Overview']")
	WebElement overviewText;
	
	public void enterFirstname(String firstname) {
				firstName.sendKeys(firstname);
				
	}
	
	public void enterLastname(String lastname) {
		
		lastName.sendKeys(lastname);
		
	}
	
	public void enterPostalCode(String postalcode) {
		
		postalCode.sendKeys(postalcode);
		
	}
	
	public void clickOnContinueBtn() {
		 Keywords.driver.executeScript(
			        "arguments[0].click();",
			        coninueBtn
			    );
		

	}
	
	public void getOverviewText() {
	
		String getOverviewText = overviewText.getText();
		log.info(getOverviewText);
		Assert.assertEquals(getOverviewText, "Checkout: Overview");
	}
}
