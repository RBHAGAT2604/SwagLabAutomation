package pages;

import org.apache.log4j.Logger;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import propertiesFile.PropertiesFileUtil;
import utility.Keywords;

public class ThankyouPage {
	Keywords keyword = new Keywords();
	private static final Logger log = Logger.getLogger(ThankyouPage.class);

	
	public ThankyouPage(){
		PageFactory.initElements(Keywords.driver, this);
		
		}
	
	@FindBy(xpath = "//h2[text()='Thank you for your order!']")
	WebElement thankyouText;
	
	
	@FindBy (css="button.btn.btn_primary.btn_small")
	WebElement backHome;
	
	@FindBy (xpath="//div[@class='app_logo']")
	WebElement homePage;
	
	public void getThankyoutext() {
		thankyouText.getText();
	}
	
	public void clickOnBackHome() {
		 Keywords.driver.executeScript(
			        "arguments[0].click();",
			        backHome
			    );
	}
	
	public void toBackOnHomePage() {
		String getSwagLabText = homePage.getText();
		log.info(getSwagLabText);
	}
	
	public void waitForHomePage() {
		keyword.fluentWait("//div[@class='app_logo']");
		keyword.fluentWait(PropertiesFileUtil.getLocators("productText"));
	}

}
