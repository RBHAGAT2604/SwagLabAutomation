package byPageObjectModel;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import baseClass.Base_Class;
import byKeywordDrivenFramework.OrangeHRMLogin;
import pages.CartPage;
import pages.LoginPage;
import pages.PersonalInfoPage;
import pages.ProductPage;
import pages.ThankyouPage;
import pages.finishBtnPage;
import propertiesFileUtil.PropertiesFileUtil;
import utility.Keywords;

public class SwagLabByPOM extends Base_Class {

	private static final Logger log = Logger.getLogger(SwagLabByPOM.class);

	Keywords keyword = new Keywords();

	@Test(priority = 1)
	public void to_Verify_Successfull_Login() {
		LoginPage lp = new LoginPage();
		lp.waitElementToBeVisible();
		lp.enterUserName(PropertiesFileUtil.getTestData("swagUserName"));
		lp.enterPassword(PropertiesFileUtil.getTestData("swagPassword"));
		lp.clickLoginBtn();
		lp.getProductText();
	}

	@Test(dependsOnMethods = "to_Verify_Successfull_Login")
	public void to_Add_Product() {
		// to_Verify_Successfull_Login();
		log.info(keyword.driver.getCurrentUrl());
		ProductPage pp = new ProductPage();
		pp.waitForproductTextToBeVisible();
		pp.clickOnBackPack();
		pp.clickOnBikeLight();
		pp.clickOnCartOption();
		
		pp.getYourCartText();
		log.info("products added to cart ");
	}

	@Test(dependsOnMethods = "to_Add_Product")
	public void to_Check_Cart_Page() {
		// to_Add_Product();
		CartPage cp = new CartPage();
		keyword.driver.executeScript("window.scrollBy(0,250)");
		cp.clickOnCheckout();
		cp.getInfoText();
		log.info("cart page chheck");
	}

	@Test(dependsOnMethods = "to_Check_Cart_Page")
	public void to_verify_personal_info() {
		// to_Check_Cart_Page();
		PersonalInfoPage pip = new PersonalInfoPage();
		pip.enterFirstname(PropertiesFileUtil.getTestData("firstName"));
		pip.enterLastname(PropertiesFileUtil.getTestData("lastName"));
		pip.enterPostalCode(PropertiesFileUtil.getTestData("postalCode"));
		keyword.driver.executeScript("window.scrollBy(0,250)");
		pip.clickOnContinueBtn();
		pip.getOverviewText();
		log.info("personal details added");

	}

	@Test(dependsOnMethods = "to_verify_personal_info")
	public void to_click_on_finishBtn() {
		finishBtnPage fp = new finishBtnPage();
		keyword.driver.executeScript("window.scrollBy(0,500)");
		fp.click_on_finishBtn();
		fp.getCompleteText();
		log.info("overview of details");
	}

	@Test(dependsOnMethods = "to_click_on_finishBtn")
	public void to_get_thankyou_text() {
		ThankyouPage tp = new ThankyouPage();
		tp.getThankyoutext();
		log.info("order finished");
	}

}
