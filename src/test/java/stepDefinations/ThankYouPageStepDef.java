package stepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;
import pages.LoginPage;
import pages.PersonalInfoPage;
import pages.ProductPage;
import pages.ThankyouPage;
import pages.finishBtnPage;
import propertiesFileUtil.PropertiesFileUtil;
import utility.Keywords;

public class ThankYouPageStepDef {
	
	
	Keywords keyword = new Keywords();
	ThankyouPage tp;
	
	@Given("User has clicked on finish button and thankyou page displayed")
	public void user_has_clicked_on_finish_button_and_thankyou_page_displayed() {
		ProductPage pp = new ProductPage();
		LoginPage lp = new LoginPage();
		CartPage cp = new CartPage();
		PersonalInfoPage pip = new PersonalInfoPage();
		finishBtnPage fp = new finishBtnPage();
		
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
	    
	    fp.click_on_finishBtn();
	    fp.getCompleteText();
	    
	}

	@When("to click on back home button")
	public void to_click_on_back_home_button() {
		tp = new ThankyouPage();
	   tp.clickOnBackHome();
	}

	@Then("to get home page swab lab text")
	public void to_get_home_page_swab_lab_text() {
		tp.waitForHomePage();
		tp.toBackOnHomePage();
	    
	}


}
