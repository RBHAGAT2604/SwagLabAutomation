package stepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductPage;
import propertiesFileUtil.PropertiesFileUtil;
import utility.Keywords;

public class CartPageStepDef {
	ProductPage pp;
	CartPage cp;
	Keywords keyword = new Keywords();
	
	@Given("User has clicked on add to cart button")
	public void user_has_clicked_on_add_to_cart_button() {
		ProductPage pp = new ProductPage();
		LoginPage lp = new LoginPage();
		cp = new CartPage();
		lp.waitElementToBeVisible();
		lp.enterUserName(PropertiesFileUtil.getTestData("swagUserName"));
	    lp.enterPassword(PropertiesFileUtil.getTestData("swagPassword"));
	    lp.clickLoginBtn();
	    
	    pp.clickOnBackPack();
	    pp.clickOnBikeLight();
	    pp.clickOnCartOption();
	    System.out.println("Current URL = " + Keywords.driver.getCurrentUrl());
	
	}

	@When("click on checkout option")
	public void click_on_checkout_option() {
		
		keyword.fluentWait("//span[text()='Your Cart']");
		cp.removeBackpack();
		keyword.driver.executeScript("window.scrollBy(0,350)");
		
		cp.clickOnCheckout();
	}

	@Then("personal info page should be open")
	public void personal_info_page_should_be_open() {
		keyword.fluentWait("//span[text()='Checkout: Your Information']");
	   cp.getInfoText();
	}


}
