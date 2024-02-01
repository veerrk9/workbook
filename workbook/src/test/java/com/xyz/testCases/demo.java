package com.xyz.testCases;


import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import com.xyz.utilities.ExcelUtils;
import com.xyz.utilities.ReadConfig;

public class demo {

	public static void main(String[] args) throws IOException  
	{
		System.setProperty("webdriver.chrome.driver", "D://eclipse personal//chrome driver//chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.navigate().to("");
		driver.navigate().forward();
		driver.navigate().back();
		driver.navigate().refresh();
		
		driver.manage().window().maximize();
		driver.manage().window().minimize();
		driver.switchTo().newWindow(WindowType.WINDOW.TAB);
		
		  File cc = driver.findElement(By.id("")).getScreenshotAs(OutputType.FILE);
		 List<WebElement> list = driver.findElements(By.id(""));
		 Set<String> window = driver.getWindowHandles();
		 
		 driver.manage().window().maximize();
		 
		 By id = By.id("");
		 By xpath = By.xpath("");
		 
		 
		 
		
	}

}
