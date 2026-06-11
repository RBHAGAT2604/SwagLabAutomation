package hooks;

import java.net.MalformedURLException;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import propertiesFileUtil.PropertiesFileUtil;
import utility.Keywords;

public class Hooks {
	
Keywords keyword = new Keywords();
	
	@Before
	public void setup() {
		try {
			keyword.launchBrowser("chrome");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		keyword.launchURL(PropertiesFileUtil.getTestData("swagLabURL"));
	}
	
	@After
	public void tearDown() {
		keyword.quitBrowser();
	}


}
