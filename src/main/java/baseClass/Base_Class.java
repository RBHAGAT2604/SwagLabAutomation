package baseClass;

import java.net.MalformedURLException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import propertiesFileUtil.PropertiesFileUtil;
import utility.Keywords;


public class Base_Class {
	
public Keywords keyword = new Keywords();
	

	@BeforeClass
	public void browserSetup() {
		
			
				try {
					keyword.launchBrowser("chrome");
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		
		keyword.launchURL(PropertiesFileUtil.getTestData("swagLabURL"));
		
	}

	@AfterClass
	public void tearDown() {
		keyword.driver.quit();
	}


}
