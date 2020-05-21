package com.selenium.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.selenium.config.BaseConfig;
import com.selenium.entities.*;
import com.selenium.helpers.Helpers;
import com.selenium.page.HomePage;

public class Emisor2 extends BaseConfig {

	@Test
  public void example02() {
	  HomePage homePage = new HomePage(driver);
	  Helpers help = new Helpers();
		homePage.LogIn("jvaldez", "Sanms**2020");
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		//driver.findElement(By.xpath("//table/tbody/tr/td[1]/img")).click();
		driver.findElement(By.id("web_MenuNavTree_0_valueCell8")).click();
		driver.findElement(By.xpath("//table/tbody/tr/td[2]/img")).click();
		help.wait(3);
		driver.findElement(By.id("web_MenuNavTree_0_valueCell8")).click();
		driver.findElement(By.className("hSplitbar")).click();
		driver.findElement(By.xpath("//div[contains(text(), 'Filtrar')]")).click();
		Emisor tt = new Emisor(driver);
		//tt.createEmisor(driver, "12345900", "QA Test", "6", "16", "4", "4", "16");	
	
		//tt.editEmisor(driver, "12345900");
		
		tt.fixEmisor(driver, "VISA Test");
		tt.deleteEmisor(driver, "12345900");
  }
}
