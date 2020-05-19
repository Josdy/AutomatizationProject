package com.selenium.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.selenium.config.BaseConfig;
import com.selenium.entities.TerminalType;
import com.selenium.helpers.Helpers;
import com.selenium.page.HomePage;



public class TerminalType2 extends BaseConfig {

  @Test
  public void example02() {
	  HomePage homePage = new HomePage(driver);
	  Helpers help = new Helpers();
		homePage.LogIn("jvaldez", "Sanms**2020");
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		//driver.findElement(By.xpath("//table/tbody/tr/td[1]/img")).click();
		driver.findElement(By.id("web_MenuNavTree_0_valueCell6")).click();
		driver.findElement(By.xpath("//table/tbody/tr/td[2]/img")).click();
		help.wait(3);
		driver.findElement(By.id("web_MenuNavTree_0_valueCell6")).click();
		driver.findElement(By.className("hSplitbar")).click();
		TerminalType tt = new TerminalType(driver);
		tt.fixTerminalType(driver, "NACAR");
		tt.editTerminalType(driver, "ATM");
  } 
}
