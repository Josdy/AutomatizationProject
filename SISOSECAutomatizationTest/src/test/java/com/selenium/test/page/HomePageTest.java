package com.selenium.test.page;

import com.selenium.pageimpl.HomePage;
import com.selenium.util.Credentials;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.Test;

/**
 *
 * @author CHRISTHIAN
 */
public class HomePageTest
{
  
  @Test
  public void signIN()
  {
    HomePage homepage = HomePage.getInstance();
    homepage.signIn(Credentials.USER_SISOSEC, Credentials.PASS_SISOSEC);
    homepage.driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
  }
}
