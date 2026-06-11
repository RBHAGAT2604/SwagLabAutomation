package stepDefinations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.And;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;
import pages.LoginPage;
import pages.PersonalInfoPage;
import pages.ProductPage;
import propertiesFileUtil.PropertiesFileUtil;
import utility.Keywords;

public class PersonalInfoStepDef {
	
	
	Keywords keyword = new Keywords();
	PersonalInfoPage pip;
	
	@Given("User has clicked on checkout button")
	public void user_has_clicked_on_checkout_button() {
		ProductPage pp = new ProductPage();
		LoginPage lp = new LoginPage();
		CartPage cp = new CartPage();
		
		lp.enterUserName(PropertiesFileUtil.getTestData("swagUserName"));
	    lp.enterPassword(PropertiesFileUtil.getTestData("swagPassword"));
	    lp.clickLoginBtn();
	    
	    pp.clickOnBackPack();
	    pp.clickOnBikeLight();
	    pp.clickOnCartOption();
	    
	    keyword.driver.executeScript("window.scrollBy(0,450)");
		cp.clickOnCheckout();
		
	}

	@When("user enter personal details")
	public void user_enter_personal_details() {
		pip = new PersonalInfoPage();
		keyword.fluentWait("//span[text()='Checkout: Your Information']");
		keyword.fluentWait("//input[@id='first-name']");
	    pip.enterFirstname(PropertiesFileUtil.getTestData("firstName"));
	    
	    pip.enterLastname(PropertiesFileUtil.getTestData("lastName"));
	    pip.enterPostalCode(PropertiesFileUtil.getTestData("postalCode"));
	   
	}



	@And("user click on continue button")
	public void user_click_on_continue_button() {
		keyword.driver.executeScript("window.scrollBy(0,250)");
		keyword.implicitWait();
		
	    pip.clickOnContinueBtn();
	    
	   
	}

	@Then("Overview page should display")
	public void overview_page_should_display() {
		keyword.fluentWait("//span[text()='Checkout: Overview']");
	    pip.getOverviewText();
	}



}
