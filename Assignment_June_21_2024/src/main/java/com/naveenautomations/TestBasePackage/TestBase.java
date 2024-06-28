package com.naveenautomations.TestBasePackage;

import java.time.Duration;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import com.naveenautomationalab.listeners.WebDriverEvents;
import com.naveenautomationslabs.browsers.Browsers;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;

	public static WebDriverWait wait;

//	private final String webBrowser = "Chrome";

	private final static Browsers webBrowser = Browsers.CHROME;

	private final String URL = "https://naveenautomationlabs.com/opencart/index.php?route=account/login";

	public static Logger logger;
	private WebDriverEvents events;
	@SuppressWarnings("deprecation")
	private EventFiringWebDriver eDriver;

	
	@BeforeClass
	public void setUpLogger() {
		logger = logger.getLogger(TestBase.class);
		PropertyConfigurator.configure("log4j.properties");
		BasicConfigurator.configure();
		logger.setLevel(Level.ALL);
				
	}
	
	public void initialise() {
		initialiseWebDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(URL);
	}

	private void initialiseWebDriver() {

		switch (webBrowser) {
		case CHROME:
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case EDGE:
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		default:
			throw new InvalidArgumentException("Pass Correct Browser Name");
		}
		
		//initialisig even firing webdriver
		eDriver = new EventFiringWebDriver(driver);
		
		//initialising webdriver events
		events = new WebDriverEvents();
		
		//Register the event
		eDriver.register(events);
		driver = eDriver;
		
	}

	// WE CAN DO THIS AS WELL UUSING STRING VALUE OF ENUM COMPONENTS
	private void initialiseWebDriver2() {

		switch (webBrowser.getBrowserNameWithCompanies()) {
		case "Google Chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;

		case "Microsoft Edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		default:
			throw new InvalidArgumentException("Pass Correct Browser Name");
		}
	}

	public void tearDown() {
		driver.quit();
	}

	public void selectDropdownByValueOrText(WebElement element, String value, String text) {
		Select select = new Select(element);
		try {
			select.selectByValue(value);
		} catch (Exception e) {
			select.selectByVisibleText(text);
		}
	}

	public static String getTextFromElements(WebElement element) {
		return new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(element))
				.getText().trim().replaceAll("\n", "");
	}

}
