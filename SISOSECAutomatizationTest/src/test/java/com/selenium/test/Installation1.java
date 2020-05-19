package com.selenium.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.selenium.config.BaseConfig;
import com.selenium.entities.*;

import com.selenium.helpers.Helpers;
import com.selenium.page.HomePage;

public class Installation1 extends BaseConfig {

	@Test
	public void example01() {
		Helpers help = new Helpers();
		// create instance HomePage
		HomePage homePage = new HomePage(driver);
		homePage.LogIn("jvaldez", "Sanms**2020");
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		// driver.findElement(By.xpath("//table/tbody/tr/td[1]/img")).click();
		driver.findElement(By.id("web_MenuNavTree_0_valueCell4")).click();
		driver.findElement(By.xpath("//table/tbody/tr/td[2]/img")).click();
		help.wait(3);
		driver.findElement(By.id("web_MenuNavTree_0_valueCell4")).click();
		driver.findElement(By.className("hSplitbar")).click();
		Installation h = new Installation(driver);
		
		h.fixInstallation(driver, "BBVA - TEST");
		h.editInstallation(driver, "BBVA - TEST");
		
		
	}
}
