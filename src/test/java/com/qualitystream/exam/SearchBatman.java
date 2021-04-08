package com.qualitystream.exam;



import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchBatman {
	
	private WebDriver driver;
	
	@Before
	
	public void setup () {
		
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\bombo\\eclipse-workspace\\.metadata\\QualityStreamExam\\src\\test\\resources\\chomedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:3000/shows");
		
	}
	
	@Test
	 
	public void testGuitarInventoryPage() {
		WebElement searchbox = driver.findElement(By.name("search"));
		
		searchbox.clear ();
		
		searchbox.sendKeys("Batman");
		searchbox.submit();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		assertEquals("Guitar Inventory", driver.getTitle());
		driver.navigate().to("https://www.tvmaze.com/shows/975/batman");
		driver.navigate().back();
		//String color = driver.findElement(By.className("card light-blue darken-1")).getCssValue("background-color");
		String color = driver.findElement(By.xpath("//div[@class='container']/child::div[4]")).getCssValue("background-color");
		WebElement mydiv = driver.findElement(By.xpath("//div[@class='container']/child::div[4]"));
		JavascriptExecutor js = (JavascriptExecutor) ((JavascriptExecutor) driver).executeScript("arguments[0].style.backgroundColor = '#4a148c'", mydiv);
	    driver.findElement(By.xpath("//div[@class='container']/child::a")).click();
	   
		
		
		System.out.println("este es el color de background" +color);
		
	}
	
	@After
	public void tearDown() {
		//driver.quit();
	}

}
