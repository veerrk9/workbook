package com.api;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OauthExample1 
{
	@Test
	public void test1() throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://sso.teachable.com/secure/9521/identity/login/password");
		
		driver.findElement(By.xpath("//div[contains(text(),'Log in with Google')]")).click();
		
		Thread.sleep(3000);
		
		
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("8668743848");
		driver.findElement(By.xpath("(//span[@jsname='V67aGc'])[2]")).click();
	}

}
