package utility;

import java.awt.image.BufferedImage;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.NoSuchElementException;
import java.util.Random;

import javax.imageio.ImageIO;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class Keywords {
	
	private static final Logger log = Logger.getLogger(Keywords.class);

	public static RemoteWebDriver driver = null;
	public static FluentWait wait = new FluentWait(driver);

	public void launchBrowser(String browserName) throws MalformedURLException {
		
//		boolean isGridOn = true;
//		
//		if(isGridOn) {
//		DesiredCapabilities cap = new DesiredCapabilities();
//		cap.setBrowserName("Chrome");
//		driver = new RemoteWebDriver(new URL("http:/10.221.99.182:4444"), cap);
//		}
//		else
		if (browserName.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		} else if (browserName.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
			log.error("invalid browser name, so chrome browser is opened");

		}
		driver.manage().window().maximize();

	}

	public void launchURL(String url) {

		driver.get(url);

	}
	
	public void quitBrowser() {

		driver.quit();

	}
	

	public void fluentWait(String xpath) {
		wait = new FluentWait(driver);
		wait.withTimeout(Duration.ofSeconds(60));
		wait.pollingEvery(Duration.ofMillis(500));
		wait.ignoring(NoSuchElementException.class);
		wait.withMessage("Element is not present within given time");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));

	}

	public void enterText(String xpath, String text) {
		driver.findElement(By.xpath(xpath)).sendKeys(text);
	}

	public void click(String xpath) {
		driver.findElement(By.xpath(xpath)).click();
	}

	public String getText(String xpath) {
		String actualtext = driver.findElement(By.xpath(xpath)).getText();
		return actualtext;
	}
	
	public String getShadowRootText(String parentRoot, String shadowRoot) {
		String actualtext = driver.findElement(By.xpath(parentRoot)).getShadowRoot().findElement(By.cssSelector(shadowRoot)).getText();
		return actualtext;
	}

	public void implicitWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	}

	public void hardAssert(String expected, String actual) {
		Assert.assertEquals(expected, actual, "actual is not matched with expected");
	}

	public void locatorStrategies(String locatorType, String locatorValue) {
		if (locatorType.equalsIgnoreCase("xpath")) {
			driver.findElement(By.xpath(locatorValue)).click();
		} else if (locatorType.equalsIgnoreCase("id")) {
			driver.findElement(By.id(locatorValue)).click();
		} else if (locatorType.equalsIgnoreCase("className")) {
			driver.findElement(By.className(locatorValue)).click();
		} else if (locatorType.equalsIgnoreCase("tagName")) {
			driver.findElement(By.tagName(locatorValue)).click();
		} else if (locatorType.equalsIgnoreCase("partialLinkText")) {
			driver.findElement(By.partialLinkText(locatorValue)).click();
		} else if (locatorType.equalsIgnoreCase("Name")) {
			driver.findElement(By.name(locatorValue)).click();
		} else {
			driver.findElement(By.xpath(locatorValue)).click();
			log.error("invalid locator name, so I took xpath");
		}

	}

	public static String getCurrentTimeDate() {
		// get the current time and date
		LocalDateTime localTime = LocalDateTime.now();
		// define the format
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");
		// format the current date and time
		String formattedNow = localTime.format(formatter);
		// print the formatted date and time
		System.out.println(formattedNow);
		return formattedNow;
	}

	public void screenshotByAshot() throws IOException {
		Screenshot scr = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(500)).takeScreenshot(driver);
		File img = driver.getScreenshotAs(OutputType.FILE);
		BufferedImage img2 = scr.getImage();
		ImageIO.write(img2, "png", new File("src/screenshot/" + getCurrentTimeDate() + "_screenshotUsingAshot"));
	}
	
	public void scroll() {
		driver.executeScript("window.scrollBy(0,250)");
	}
	
	public String randomString() {
		String randomString = RandomStringUtils.randomAlphanumeric(12).toUpperCase();
		return randomString;
	}
	
	public String randomNumber() {
		Random ran = new Random();
		String randomNumber = Integer.toString(ran.nextInt(6)+ 5352);
		return randomNumber;
	}

}
