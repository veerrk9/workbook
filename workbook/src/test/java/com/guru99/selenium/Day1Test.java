package com.guru99.selenium;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day1Test 
{
	@Test
	public void Test1() throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "D://eclipse personal//chrome driver//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Openbrowser and hit the url
		driver.get("http://live.techpanda.org/index.php/");
		
		String title = driver.getTitle();
		
		//print current title
		
		System.out.println(title);
		
		//click on mobile menu
		driver.findElement(By.xpath("//a[normalize-space()='Mobile']")).click();
		
		String title1 = driver.getTitle();
		
	//print current title
		
		System.out.println(title1);
		
		System.out.println("Titles before sort");
		ArrayList originalList = new ArrayList();
		List<WebElement> listOfItems = driver.findElements(By.xpath("//li[@class='item last']/a"));
		
		for(WebElement options : listOfItems)
		{
			String titles = options.getAttribute("Title");
			originalList.add(titles);
		}
		
		//select sort by 
		WebElement sortBy = driver.findElement(By.xpath("(//select[@title='Sort By'])[1]"));
		
		Select s = new Select(sortBy);
		List<WebElement> options = s.getOptions();
		
		for(WebElement option : options)
		{
			if(option.getText().equalsIgnoreCase("Name"))
			{
				s.selectByVisibleText(option.getText());
				break;
			}
		}
		
		Thread.sleep(2000);
		
		System.out.println("Titles after sort");
		ArrayList afterSortList = new ArrayList();
		List<WebElement> listOfItems1 = driver.findElements(By.xpath("//li[@class='item last']/a"));
		
		for(WebElement options1 : listOfItems1)
		{
			String titles = options1.getAttribute("Title");
			afterSortList.add(titles);
		}
		
		  if (originalList != afterSortList) {
			   System.out.println("Dropdown sorted");
			  } else {
			   System.out.println("Dropdown NOT sorted");
			  }
		  
		  System.out.println("originalList:" + originalList);
		  System.out.println("tempList:" + afterSortList);
		  
		  
			  driver.close();
		
	}

}
