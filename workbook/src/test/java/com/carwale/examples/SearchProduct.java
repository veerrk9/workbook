package com.carwale.examples;

import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import net.bytebuddy.implementation.bind.annotation.Default;

public class SearchProduct 
{
	
	
	public void test()
	{
		System.setProperty("webdriver.chrome.driver", "D://eclipse personal//chrome driver//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.carwale.com/");
		
		WebElement searchBox = driver.findElement(By.xpath("(//div[@class='o-brXWGL']/input)[2]"));
		
		Actions act = new Actions(driver);
		act.moveToElement(searchBox).click().build().perform();
		searchBox.sendKeys("xuv 300");
		
		List<WebElement> list = driver.findElements(By.xpath("//li[@class='o-brXWGL o-fznJDS o-fznJFI  o-bCRRBE o-frwuxB kpH936 nX7uS1 ']"));
		
		for(WebElement li : list)
		{
			System.out.println(li.getText());
		}

		
	}
	
	@Test
	@Parameters({ "first-name" ,"first-name1"})
	public void test2(@Optional("dummy") String name1 , @Optional("dummy") String name2) 
	{
		System.out.println(name1 +" : "+ name2);
	}
	
	@Test(dataProvider = "emails" , dataProviderClass = SearchProduct.class)
	public void test1(String name1 , String name2 ) 
	{
		System.out.println(name1 +" : "+ name2);
	}
	
	@DataProvider(name = "emails")
	public Object[][] names() 
	{
		 
		Object [][] emails = {{"RAVI","123"},{"VEER","234"}};
		return emails;
		
	}
	
	@DataProvider(name = "emails1")
	public Object[][] names1() 
	{
		 
		Object [][] emails = {{"aaa","123"},{"bbb","234"}};
		return emails;
		
	}
	
	public void dummy1() 
	{
		
		RequestSpecification reqSpec = new RequestSpecBuilder().setContentType(ContentType.JSON).build();
		
		ResponseSpecification resSpec = new ResponseSpecBuilder().expectStatusCode(200).build();
		
		
		
	}
}
