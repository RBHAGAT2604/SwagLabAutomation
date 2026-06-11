package byKeywordDrivenFramework;

import org.apache.log4j.Logger;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import baseClass.Base_Class;
import listeners.MyListeners;
import propertiesFileUtil.PropertiesFileUtil;
import utility.Keywords;

@Listeners(MyListeners.class)
public class SwagLabPage extends Base_Class{
	
	private static final Logger log = Logger.getLogger(SwagLabPage.class);
	
//	
//	@DataProvider(name = "diffTestData")
//	public Object[][] testData() {
//		Object [][]usernameAndPassword = {{"standard_user", "secret_sauce"},{"locked_out_user","secret_sauce"},{"problem_user","secret_sauce"},{"performance_glitch_user","secret_sauce"},{"error_user","secret_sauce"},{"visual_user","secret_sauce"}};
//		return usernameAndPassword;
//	}
	
	
	@Test(priority=1)
	public void login() {
		keyword.fluentWait(PropertiesFileUtil.getLocators("swagUserName"));
		keyword.enterText(PropertiesFileUtil.getLocators("swagUserName"),PropertiesFileUtil.getTestData("swagUserName"));
		keyword.enterText(PropertiesFileUtil.getLocators("swagPassword"), PropertiesFileUtil.getTestData("swagPassword"));
		keyword.click(PropertiesFileUtil.getLocators("swagLoginBtn"));
		log.info("login successfull");
		
	}
	@Test(dependsOnMethods = "login")
	public void addItem() {
		//login("standard_user", "secret_sauce");
		keyword.fluentWait(PropertiesFileUtil.getLocators("backPack"));
		keyword.click(PropertiesFileUtil.getLocators("backPack"));
		keyword.click(PropertiesFileUtil.getLocators("bikeLight"));
		keyword.click(PropertiesFileUtil.getLocators("clickOnCart"));
		log.info("item added");
	}
	@Test(dependsOnMethods = "addItem")
	public void cartOption() {
		//addItem();
		Keywords.driver.executeScript("window.scrollBy(0,450)");
		keyword.fluentWait(PropertiesFileUtil.getLocators("checkOutOption"));
		
		keyword.click(PropertiesFileUtil.getLocators("checkOutOption"));
		
		log.info("cart page");
	}
	
	@Test(dependsOnMethods = "cartOption")
	public void checkoutOption() {
		//cartOption();
		Keywords.driver.executeScript("window.scrollBy(0,-400)");
		keyword.enterText(PropertiesFileUtil.getLocators("firstName"), PropertiesFileUtil.getTestData("firstName"));
		keyword.enterText(PropertiesFileUtil.getLocators("lastName"), PropertiesFileUtil.getTestData("lastName"));
		keyword.enterText(PropertiesFileUtil.getLocators("postalCode"), PropertiesFileUtil.getTestData("postalCode"));
		Keywords.driver.executeScript("window.scrollBy(0,400)");
		keyword.click(PropertiesFileUtil.getLocators("continueBtn"));
		log.info("personal details added");
		
		
	}
	@Test(dependsOnMethods = "checkoutOption")
	public void finishBtn() {
		//checkoutOption();
		keyword.implicitWait();
		Keywords.driver.executeScript("window.scrollBy(0,300)");
		keyword.click("//button[@id='finish']");
		log.info("finish order");
	}
	
	@Test(dependsOnMethods = "finishBtn")
	public void thankYouText() {
		//finishBtn();
		keyword.implicitWait();
		Keywords.driver.executeScript("window.scrollBy(0,-400)");
		String thankyouText = keyword.getText(PropertiesFileUtil.getLocators("thankYouText"));
		System.out.println(thankyouText);
		log.info("thankyou text");

	}


}
