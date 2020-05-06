package com.selenium.test.page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.selenium.config.BaseConfig;
import com.selenium.entities.bk.TerminalType;
import com.selenium.page.bk.HomePage;
import com.selenium.util.Credentials;

public class Test02 extends BaseConfig
{

  @Test
  public void example02()
  {
    HomePage homePage = new HomePage(driver);
    homePage.LogIn(Credentials.USER_SISOSEC, Credentials.PASS_SISOSEC);
    
    driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
    //driver.findElement(By.xpath("//table/tbody/tr/td[1]/img")).click();
    driver.findElement(By.id("web_MenuNavTree_0_valueCell6")).click();
    driver.findElement(By.xpath("//table/tbody/tr/td[2]/img")).click();
    driver.findElement(By.id("web_MenuNavTree_0_valueCell6")).click();
    TerminalType tt = new TerminalType(driver);
    tt.fixTerminalType(driver, "2");
    tt.editTerminalType(driver, "1");
  }
}
