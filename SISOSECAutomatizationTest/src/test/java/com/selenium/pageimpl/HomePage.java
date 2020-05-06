package com.selenium.pageimpl;

import com.selenium.config.BaseConfig;
import com.selenium.util.WaitWebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 *
 * @author CHRISTHIAN
 */
public class HomePage extends BaseConfig
{

  private static HomePage instance;

  private HomePage()
  {
    super();
    PageFactory.initElements(driver, getInstance());
  }

  public static HomePage getInstance()
  {
    if (instance == null)
    {
      instance = new HomePage();
    }

    return instance;
  }

  //ELEMENTS OF LOGIN
  //create Element 
  @FindBy(name = "userName")
  private WebElement username;

  @FindBy(xpath = "//div[contains(text(), 'Siguiente')]")
  private WebElement nextbtn;

  @FindBy(name = "password")
  private WebElement password;

  @FindBy(xpath = "//div[contains(text(), 'Iniciar sesión')]")
  private WebElement loginbtn;

  public void signIn(String user, String password)
  {
    //WRITE USERNAME
    username.sendKeys(user);
    nextbtn.click();
    
    //WRITE PASSWORD
    WaitWebDriver.waitVisibility(driver, this.password, 5);
    this.password.sendKeys(password);
    
    //CLICK BUTTON FOR SIGN IN
    WaitWebDriver.waitClickable(driver, loginbtn, 8);
    loginbtn.click();

  }

}
