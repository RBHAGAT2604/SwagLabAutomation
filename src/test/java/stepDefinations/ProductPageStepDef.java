package stepDefinations;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.ProductPage;
import propertiesFileUtil.PropertiesFileUtil;
import utility.Keywords;

public class ProductPageStepDef {
	Keywords keyword = new Keywords();
	ProductPage pp;

	@Given("User is logged into the Swag Labs application")
	public void user_is_logged_into_the_swag_labs_application() {
		LoginPage lp = new LoginPage();
	    lp.enterUserName(PropertiesFileUtil.getTestData("swagUserName"));
	    lp.enterPassword(PropertiesFileUtil.getTestData("swagPassword"));
	    lp.clickLoginBtn();
	}

	@When("add Sauce Labs Backpack to the cart")
	public void add_sauce_labs_backpack_to_the_cart() {
		pp = new ProductPage();
		pp.waitForproductTextToBeVisible();
		pp.clickOnBackPack();
	}

	@And("add Sauce Labs Bike Light to the cart")
	public void add_sauce_labs_bike_light_to_the_cart() {
		pp = new ProductPage();
		pp.clickOnBikeLight();
	}

	@And("clicks on the cart icon")
	public void clicks_on_the_cart_icon() {
		pp = new ProductPage();
	    pp.clickOnCartOption();
	}

	@Then("User should be redirected to the cart page")
	public void user_should_be_redirected_to_the_cart_page() {
		pp = new ProductPage();
		keyword.driver.executeScript("window.scrollBy(0,250)");
	   pp.getYourCartText();
	}



}
