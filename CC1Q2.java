package com.selenium.Cse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;
import org.openqa.selenium.support.ui.Select;


public class CC1Q2 {
  @Test
  public void f() throws InterruptedException {
	  WebDriverManager.edgedriver().setup();
		WebDriver driver=new EdgeDriver();
		
		driver.get("https://www.saucedemo.com/");

		driver.manage().window().maximize();
		
		Thread.sleep(3000);

	    driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user");
	    driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
	    driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
	    
	    Thread.sleep(3000);

	    Select dropdown = new Select(driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select")));
	    
	    dropdown.selectByIndex(0);
	    
	    String a_actual = "Sauce Labs Backpack";
	    String a_check = driver.findElement(By.xpath("//*[@id=\"item_4_title_link\"]/div")).getText();
	    
	    Assert.assertEquals(a_actual, a_check);
	    
	    dropdown.selectByIndex(1);
	    
	    String b_actual = "Test.allTheThings() T-Shirt (Red)";
	    String b_check = driver.findElement(By.xpath("//*[@id=\"item_3_title_link\"]/div")).getText();
	    
	    Assert.assertEquals(b_actual, b_check);
	    
	    dropdown.selectByIndex(2);
	    

  }
}
