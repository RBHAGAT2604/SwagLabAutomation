package stepDefinations;

import java.net.MalformedURLException;



import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import propertiesFileUtil.PropertiesFileUtil;
import utility.Keywords;

public class LoginPageDataProviderStepDef {
	
Keywords keyword = new Keywords();
LoginPage lp;
	
	@Given("browser for sauceLab should be open")
	public void browser_should_be_open() {
	    try {
			keyword.launchBrowser("Chrome");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@And("valid URL of sauceLab should be passed")
	public void valid_url_should_be_passed() {
	   keyword.launchURL("https://www.saucedemo.com/");
	}

	@When("user enter valid username and password of sauceLab")
	public void user_enter_valid_username_and_password() {
		lp = new LoginPage();
		lp.enterUserName(PropertiesFileUtil.getTestData("swagUserName"));
		lp.enterPassword(PropertiesFileUtil.getTestData("swagPassword"));
	    
	}
	
	@And ("user should click on login button of sauceLab")
	public void user_should_click_on_login_button() {
		lp = new LoginPage();
		lp.clickLoginBtn();
	}

	@Then("login successfully of sauceLab")
	public void login_successfully() {
		keyword.implicitWait();
		String productText = keyword.getText(PropertiesFileUtil.getLocators("productText"));
	    Assert.assertEquals(productText, "Products","user not login successfully");
	}
	
	@When ("user enter valid username {string} and password {string} of sauceLab")
	public void enter_diff_username_and_password(String username, String password) {
		lp = new LoginPage();
		lp.enterUserName(PropertiesFileUtil.getTestData(username));
		lp.enterPassword(PropertiesFileUtil.getTestData(password));
	}


}
