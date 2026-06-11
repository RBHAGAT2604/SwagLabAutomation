package pages;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.Keywords;


public class LoginPage {
	
	private static final Logger log = Logger.getLogger(LoginPage.class);

	

	@FindBy(css="input[name='user-name']")
	WebElement userNameTextBox;
	
	@FindBy(css="input[name='password']")
	WebElement passwordTextBox;
	
	@FindBy(css="input[name='login-button']")
	WebElement loginBtn;
	
	@FindBy(xpath = "//span[text()='Products']")
	WebElement productText;
	
	
	public LoginPage(){
		PageFactory.initElements(Keywords.driver, this);
	}
	
	
	public void enterUserName(String username) {
		userNameTextBox.sendKeys(username);
	}
	
	public void enterPassword(String password) {
		passwordTextBox.sendKeys(password);
	}
	
	public void clickLoginBtn() {
		loginBtn.click();
	}
	
	public void getProductText() {
		String producttext = productText.getText();
		log.info(producttext);
	}
	
public void waitElementToBeVisible() {
		

	    WebDriverWait wait =
	            new WebDriverWait(Keywords.driver, Duration.ofSeconds(20));

	    wait.until(ExpectedConditions.visibilityOf(userNameTextBox));
	}

}
