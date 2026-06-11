package stepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;
import pages.LoginPage;
import pages.PersonalInfoPage;
import pages.ProductPage;
import pages.finishBtnPage;
import propertiesFileUtil.PropertiesFileUtil;
import utility.Keywords;

public class OverviewPageStepDef {
	finishBtnPage fp;
	Keywords keyword = new Keywords();
	
	@Given("User has entered the personal info and click on continue button")
	public void user_has_entered_the_personal_info_and_click_on_continue_button() {
		ProductPage pp = new ProductPage();
		LoginPage lp = new LoginPage();
		CartPage cp = new CartPage();
		PersonalInfoPage pip = new PersonalInfoPage();
		
		lp.enterUserName(PropertiesFileUtil.getTestData("swagUserName"));
	    lp.enterPassword(PropertiesFileUtil.getTestData("swagPassword"));
	    lp.clickLoginBtn();
	    
	    pp.clickOnBackPack();
	    pp.clickOnBikeLight();
	    pp.clickOnCartOption();
	    
	    keyword.driver.executeScript("window.scrollBy(0,450)");
		cp.clickOnCheckout();
		
		pip.enterFirstname(PropertiesFileUtil.getTestData("firstName"));
		pip.enterLastname(PropertiesFileUtil.getTestData("lastName"));
		pip.enterPostalCode(PropertiesFileUtil.getTestData("postalCode"));
		keyword.driver.executeScript("window.scrollBy(0,350)");
	    pip.clickOnContinueBtn();
	}

	@When("user click on finish button")
	public void user_click_on_finish_button() {
		fp = new finishBtnPage();
		keyword.driver.executeScript("window.scrollBy(0,350)");
	    fp.click_on_finishBtn();
	}

	@Then("Thank you page should display")
	public void thank_you_page_should_display() {
		keyword.fluentWait("//div[text()='secret_sauce']");
	    fp.getCompleteText();
	}



}
