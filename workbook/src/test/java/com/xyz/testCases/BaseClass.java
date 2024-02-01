package com.xyz.testCases;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.xyz.utilities.ReadConfig;

public class BaseClass 
{
	
	public static WebDriver driver;
	public static Logger logger;
	
	@BeforeClass
	public void setup() 
	{
		String baseURL = ReadConfig.getProperty("baseURL");
		String browser = ReadConfig.getProperty("browserName");
		System.setProperty("webdriver.chrome.driver", "D://eclipse personal//chrome driver//chromedriver.exe");
		
		switch (browser.toLowerCase()) 
		{
			case "chrome":
				driver = new ChromeDriver();
				break;
			
			case "firefox":
				driver = new FirefoxDriver();
				break;
		
			case "edge":
				driver = new EdgeDriver();
				break;

			default:
				driver = new ChromeDriver();
				break;
		}
		
		logger = LogManager.getLogger("MyLogs");
		driver.manage().window().maximize();
		logger.info("browser open");
		logger.info("url open");
		driver.get(baseURL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	@AfterClass
	public void tesrDown() 
	{
		driver.close();
		//driver.quit();
		logger.info("browser closed");
		
	}

}
