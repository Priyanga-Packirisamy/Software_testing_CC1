package com.selenium.Cse;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class CC1Q1 {
  WebDriver driver;
  @Test
  public void f() throws InterruptedException {
	    driver.findElement(By.name("user-name")).sendKeys("standard_user");
		driver.findElement(By.name("password")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
		Thread.sleep(3000);
		
		//add to cart button 
		driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")).click();
		Thread.sleep(3000);
	  
		//viewing cart
		driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();
    	Thread.sleep(3000);
    	//checkout button 
    	driver.findElement(By.xpath("//*[@id=\"checkout\"]")).click();
    	Thread.sleep(3000);
    	
    	//filling form and continue
    	driver.findElement(By.name("firstName")).sendKeys("Priyanga");
		driver.findElement(By.name("lastName")).sendKeys("Packirisamy");
		driver.findElement(By.name("postalCode")).sendKeys("610001");
		driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
    	
		//printing the name and price
		String product = driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div")).getText();
		String price = driver.findElement(By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[1]/div[3]/div[2]/div[2]/div")).getText();
		System.out.println("Product : "+product);
		System.out.println("Price : "+price);
		
		//assert title
		String s1 = driver.getTitle();
		Assert.assertEquals(driver.getTitle(),"Swag Labs");
		System.out.println("Title : "+s1);
		
		//assert url
		String t1 = driver.getCurrentUrl();
        Assert.assertEquals(t1,"https://www.saucedemo.com/checkout-step-two.html");
        System.out.println("Url : "+t1);
				
    	
    	
  }
  @BeforeTest
  public void beforeTest() throws InterruptedException {
	    WebDriverManager.edgedriver().setup();
	    driver = new EdgeDriver();
	    driver.get("https://www.saucedemo.com/");
	    driver.manage().window().maximize();
	    Thread.sleep(3000);
  }

  @AfterTest
  public void afterTest() {
  }

}