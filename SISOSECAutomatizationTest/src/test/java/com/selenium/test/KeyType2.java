package com.selenium.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.selenium.config.BaseConfig;
import com.selenium.entities.KeyType;

import com.selenium.helpers.Helpers;
import com.selenium.page.HomePage;

public class KeyType2 extends BaseConfig {

	@Test
	public void example01() {
		Helpers help = new Helpers();
		// create instance HomePage
		HomePage homePage = new HomePage(driver);
		homePage.LogIn("jvaldez", "Sanms**2020");
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		driver.findElement(By.id("web_MenuNavTree_0_valueCell3")).click();
		driver.findElement(By.xpath("//table/tbody/tr/td[2]/img")).click();
		help.wait(3);
		driver.findElement(By.id("web_MenuNavTree_0_valueCell3")).click();
		KeyType kt = new KeyType(driver);
		kt.fixKeyType(driver, "KPFK");
		kt.deleteKeyType(driver, "KeyTest");
	}
}
