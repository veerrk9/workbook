package com.guru99.selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Day2Test 
{
	@Test
	public void test1() 
	{
		System.setProperty("webdriver.chrome.driver", "D://eclipse personal//chrome driver//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Step1 visit http://live.techpanda.org/
		driver.get("http://live.techpanda.org/");
		System.out.println("Url opened");
		
		//Step 2 click on mobile menu
		driver.findElement(By.xpath("//a[text()='Mobile']")).click();
		System.out.println("clicked on mobile menu");
		
		//Step3 Read the value of sony xperia mobile
		List<WebElement> mobileList = driver.findElements(By.xpath("//li[@class='item last']/a"));
		int i =0;
		String amount = null;
		
		for(WebElement mobile : mobileList)
		{
			i++;
			String mobileTitle = mobile.getAttribute("title");
			System.out.println(mobileTitle);
			
			
			if(mobileTitle.equalsIgnoreCase("Xperia"))
			{
				 WebElement selectedMobile = driver.findElement(By.xpath("((//li[@class='item last']/a)["+i+"]/following-sibling::div/descendant::div)[1]"));
				 amount = selectedMobile.getText();
				 driver.findElement(By.xpath("(//li[@class='item last']/a)["+i+"]")).click();
				System.out.println(amount);
				break;
			}
			
		}
		
		String actualAmount = driver.findElement(By.xpath("//span[@class='price']")).getText();
		System.out.println("Amount 2 :- " +actualAmount);
		Assert.assertEquals(actualAmount, amount);
		driver.close();
		
		//Step 4 Read value from cart
		//String grandTotal = driver.findElement(By.xpath("//table[@id='shopping-cart-totals-table']//tfoot//tr//td//strong//span")).getText();
		
	}

}
