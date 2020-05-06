package com.selenium.pageimpl;

import com.selenium.config.BaseConfig;
import com.selenium.helpers.Helpers;
import com.selenium.ipage.ITestPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class TerminalTypePageImpl extends BaseConfig implements ITestPage
{

  Helpers help = new Helpers();

  public TerminalTypePageImpl()
  {
    super();
    driver.findElement(By.id("web_MenuNavTree_0_valueCell6")).click();
    driver.findElement(By.xpath("//table/tbody/tr/td[2]/img")).click();
    driver.findElement(By.id("web_MenuNavTree_0_valueCell6")).click();
  }

  @Override
  public void create(Object entitie)
  {
    //ACCESS TO MENU NAV TREE

    //CREATE TERMINAL
    driver.findElement(By.xpath("//div[contains(text(), 'Nuevo')]")).click();
    driver.findElement(By.name("TERMINALTYPE")).sendKeys(entitie.toString());
    driver.findElement(By.name("DESCRIPTION")).sendKeys(entitie.toString());

    //WAIT
    help.wait(2);

    //SAVE
    driver.findElement(By.xpath("//div[contains(text(), 'Guardar')]")).click();
    help.wait(2);
  }

  @Override
  public void fix(Object entitie)
  {
    Actions action = new Actions(driver);
    WebElement elementLocator = driver.findElement(By.xpath("//tbody/tr[" + entitie.toString() + "]/td[3]/div"));
    action.contextClick(elementLocator).perform();

    help.wait(3);

    driver.findElement(By.xpath("//div[contains(text(), 'Corregir')]")).click();

    help.wait(2);
  }

  @Override
  public void edit(Object entitie)
  {
    driver.findElement(By.xpath("//tbody/tr[" + entitie.toString() + "]/td[3]/div")).click();
    driver.findElement(By.xpath("//div[contains(text(), 'Actualizar')]")).click();

    Actions action = new Actions(driver);
    WebElement elementLocator = driver.findElement(By.xpath("//tbody/tr[" + entitie.toString() + "]/td[3]/div"));
    action.contextClick(elementLocator).perform();

    help.wait(2);

    driver.findElement(By.xpath("//div[contains(text(), 'Editar')]")).click();
    driver.findElement(By.name("DESCRIPTION")).sendKeys(" edit");

    help.wait(2);

    driver.findElement(By.xpath("//div[contains(text(), 'Guardar')]")).click();

    help.wait(4);
  }

  @Override
  public void delete(Object entitie)
  {
    Actions action = new Actions(driver);
    WebElement elementLocator = driver.findElement(By.xpath("//div[contains(text(), '" + entitie.toString() + "')]"));
    action.contextClick(elementLocator).perform();
    driver.findElement(By.xpath("//td/div[contains(text(), 'Eliminar')]")).click();
    
    help.wait(2);
    
    driver.findElement(By.xpath("//td[contains(text(), 'Aceptar')]")).click();
    driver.findElement(By.xpath("//tbody/tr/td/table/tbody/tr/td[2]/img")).click();
    
    help.wait(4);
  }

}
