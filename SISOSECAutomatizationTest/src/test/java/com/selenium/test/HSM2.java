package com.selenium.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.selenium.config.BaseConfig;
import com.selenium.entities.*;

import com.selenium.helpers.Helpers;
import com.selenium.page.HomePage;

public class HSM2 extends BaseConfig {

	@Test
	public void example01() {
		Helpers help = new Helpers();
		// create instance HomePage
		HomePage homePage = new HomePage(driver);
		homePage.LogIn("jvaldez", "Sanms**2020");
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		// driver.findElement(By.xpath("//table/tbody/tr/td[1]/img")).click();
		driver.findElement(By.id("web_MenuNavTree_0_valueCell2")).click();
		driver.findElement(By.xpath("//table/tbody/tr/td[2]/img")).click();
		help.wait(3);
		driver.findElement(By.id("web_MenuNavTree_0_valueCell2")).click();
		driver.findElement(By.className("hSplitbar")).click();
		/*
		 * TerminalType tt = new TerminalType(driver); tt.createTerminalType(driver, 6,
		 * "99", "TTS"); tt.deleteTerminalType(driver, "TTS");
		 */
		// tt.fixTerminalType(driver, "2");
		// tt.editTerminalType(driver, "1");
		HSM h = new HSM(driver);
		h.fixHSM(driver, "SANMS01");
		h.editHSM(driver, "TEST");
		
		
	}
}
