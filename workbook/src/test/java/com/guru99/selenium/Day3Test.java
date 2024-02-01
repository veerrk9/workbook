package com.guru99.selenium;

import org.testng.annotations.Test;
import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Day3Test 
{
	@Test
	public void test1()
	{
		//System.setProperty("webdriver.chrome.driver", "D://eclipse personal//chrome driver//chromedriver.exe");
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Step1 visit http://live.techpanda.org/
		driver.get("http://live.techpanda.org/");
		System.out.println("Url opened");
		
		//click on mobile
		WebElement mobileClick = driver.findElement(By.xpath("//a[normalize-space()='Mobile']"));
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		
		wait.until(ExpectedConditions.elementToBeClickable(mobileClick));
		
		driver.findElement(By.xpath("(//span[normalize-space()='Add to Cart'])[3]")).click();
		
		WebElement qty = driver.findElement(By.xpath("//input[@class='input-text qty']"));
		qty.clear();
		qty.sendKeys("1000");
		
		
	}

}
