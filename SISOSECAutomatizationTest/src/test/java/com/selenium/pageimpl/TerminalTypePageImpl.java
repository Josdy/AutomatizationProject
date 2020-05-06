package com.selenium.pageimpl;

import com.selenium.config.BaseConfig;
import com.selenium.helpers.Helpers;
import com.selenium.ipage.ITestPage;
import org.openqa.selenium.By;

public class TerminalTypePageImpl extends BaseConfig implements ITestPage
{

  Helpers help = new Helpers();

  public TerminalTypePageImpl()
  {
    super();
  }

  @Override
  public void create(Object entitie)
  {
//    driver.findElement(By.xpath("//div[contains(text(), 'Nuevo')]")).click();
//    driver.findElement(By.name("TERMINALTYPE")).sendKeys(idTerminalType);
//    driver.findElement(By.name("DESCRIPTION")).sendKeys(desc);
//    help.wait(2);
//    driver.findElement(By.xpath("//div[contains(text(), 'Guardar')]")).click();
//    help.wait(2);
  }

  @Override
  public void fix(Object entitie)
  {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void edit(Object entitie)
  {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void delete(Object entitie)
  {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

}
