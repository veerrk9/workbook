package com.guru99.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day5Test 
{
	@SuppressWarnings("deprecation")
	@Test
	public void test1() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://live.techpanda.org/");
		
		System.out.println("Application opened");
		
		driver.findElement(By.xpath("(//span[text()='Account'])[1]")).click();
		System.out.println("Clicked on account");
		
		driver.findElement(By.xpath("(//a[contains(@href,'account') and @title='My Account' and text()='My Account'])[1]")).click();
		System.out.println("Clicked on my account");
		
		driver.findElement(By.xpath("//a[@title='Create an Account']")).click();
		System.out.println("Clicked create my account");
		
		driver.findElement(By.id("firstname")).sendKeys("Ravi");
		System.out.println("Entered first name");
		
		driver.findElement(By.name("middlename")).sendKeys("Kumar");
		System.out.println("Entered middle name");
		
		driver.findElement(By.id("lastname")).sendKeys("Sharma");
		System.out.println("Entered last name");
		
		driver.findElement(By.id("email_address")).sendKeys("ravisharma111@kumar.com");
		System.out.println("Entered email id");
		
		driver.findElement(By.id("password")).sendKeys("123456789");
		System.out.println("Entered password");
		
		driver.findElement(By.id("confirmation")).sendKeys("123456789");
		System.out.println("Entered confirm password");
		
		driver.findElement(By.xpath("//button[@title='Register']")).click();
		System.out.println("Clicked on register");
		
		String sucessMSG = driver.findElement(By.xpath("//li[@class='success-msg']//child::span")).getText();
		if(sucessMSG == "Thank you for registering with Main Website Store.")
		{
			System.out.println("Verified registration is done");
		}
		else
		{
			System.out.println("registartion failed");
		}
		
		driver.findElement(By.linkText("TV")).click();
		System.out.println("clicked on tv");
		
		driver.findElement(By.xpath("(//li/a[@class='link-wishlist'])[1]")).click();
		System.out.println("product added to wishlist");
		
		driver.findElement(By.xpath("//span[contains(text(),'Share Wishlist')]")).click();
		System.out.println("clicked on share list");
		
		driver.findElement(By.id("email_address")).sendKeys("xyz@xyz.com");
		System.out.println("enetered email id to share wishlist");
		
		driver.findElement(By.xpath("//span[contains(text(),'Share Wishlist')]")).click();
		System.out.println("clicked on share list");
		
		
		String msg = driver.findElement(By.xpath(".//li/ul/li/span")).getText();
		if(msg == "Your Wishlist has been shared.")
		{
			System.out.println("wishlist shared sucessfully");
		}
		else
		{
			System.out.println("wishlist share failed");
		}
		
		Thread.sleep(2000);
		driver.close();
		
		
		
		
	}

}
