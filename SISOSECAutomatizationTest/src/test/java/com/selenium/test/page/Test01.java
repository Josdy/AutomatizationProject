package com.selenium.test.page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.selenium.config.BaseConfig;
import com.selenium.entities.bk.TerminalType;
import com.selenium.page.bk.HomePage;

public class Test01 extends BaseConfig
{

  @Test
  public void example01()
  {
    // create instance HomePage
    HomePage homePage = new HomePage(driver);
    homePage.LogIn("jvaldez", "Sanms**2020");
    driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
    
    
    
    //driver.findElement(By.xpath("//table/tbody/tr/td[1]/img")).click();
    driver.findElement(By.id("web_MenuNavTree_0_valueCell6")).click();
    driver.findElement(By.xpath("//table/tbody/tr/td[2]/img")).click();
    driver.findElement(By.id("web_MenuNavTree_0_valueCell6")).click();
    TerminalType tt = new TerminalType(driver);
    tt.createTerminalType(driver, 6, "99", "TTS");
    tt.deleteTerminalType(driver, "TTS");
    //tt.fixTerminalType(driver, "2");
    //tt.editTerminalType(driver, "1");

  }
}
