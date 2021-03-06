package com.selenium.page;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.selenium.config.BaseConfig;

import com.selenium.util.WaitWebDriver;

public class HomePage extends BaseConfig {

  public HomePage(WebDriver driver) {
    super();
    this.driver = driver;
    PageFactory.initElements(driver, this);
    }

  //create Element 
  
  @FindBy(name = "userName")
  private WebElement username; 
  
  @FindBy(xpath = "//div[contains(text(), 'Siguiente')]")
  private WebElement nextbtn; 
  
  @FindBy(name = "password")
  private WebElement password; 
  
  @FindBy(xpath = "//div[contains(text(), 'Iniciar sesion')]")
  private WebElement loginbtn; 
  
  //create method
  public void LogIn(String user, String pass) {
		username.sendKeys(user);
		nextbtn.click();
		WaitWebDriver.waitVisibility(driver, password, 5);
		password.sendKeys(pass , Keys.ENTER);
	//	WaitWebDriver.waitClickable(driver, loginbtn, 8);
		//loginbtn.click();
		
	}

  
}
