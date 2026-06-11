package pages;

import org.apache.log4j.Logger;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.Keywords;

public class finishBtnPage {
	
	Keywords keyword = new Keywords();
	private static final Logger log = Logger.getLogger(finishBtnPage.class);

	
	public finishBtnPage(){
		PageFactory.initElements(Keywords.driver, this);
		
		
	}
	
	@FindBy(xpath="//button[@id='finish']")
	WebElement finishBtn;
	
	@FindBy(xpath="//div[text()='secret_sauce']")
	WebElement completeText;
	
	
	
	public void click_on_finishBtn() {
		//keyword.fluentWait("//button[@id='finish']");
		 Keywords.driver.executeScript(
			        "arguments[0].click();",
			        finishBtn
			    );
	}
	
	public void getCompleteText() {
		String getThankyouText = completeText.getText();
		log.info(getThankyouText);
	}

}
