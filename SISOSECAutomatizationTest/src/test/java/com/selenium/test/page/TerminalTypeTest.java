package com.selenium.test.page;

import com.selenium.ipage.ITestPage;
import com.selenium.pageimpl.HomePage;
import com.selenium.pageimpl.TerminalTypePageImpl;
import com.selenium.util.Credentials;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.Test;

/**
 *
 * @author CHRISTHIAN
 */
public class TerminalTypeTest
{
  
  private final ITestPage ttype = new TerminalTypePageImpl();

  @Test
  public void createTerminal()
  {
    HomePage page = HomePage.getInstance();
    page.signIn(Credentials.USER_SISOSEC, Credentials.PASS_SISOSEC);
    page.driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
    
//    ttype.create(new SISOSEC_TERMINALTYPE());

  }

  @Test
  public void editTerminal()
  {
    HomePage page = HomePage.getInstance();
    page.signIn(Credentials.USER_SISOSEC, Credentials.PASS_SISOSEC);
    page.driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
    
//    ttype.edit(new SISOSEC_TERMINALTYPE());
    

  }

  @Test
  public void fixTerminal()
  {
    HomePage page = HomePage.getInstance();
    page.signIn(Credentials.USER_SISOSEC, Credentials.PASS_SISOSEC);
    page.driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
    
//    ttype.fix(new SISOSEC_TERMINALTYPE());

  }

  @Test
  public void deleteTerminal()
  {
    HomePage page = HomePage.getInstance();
    page.signIn(Credentials.USER_SISOSEC, Credentials.PASS_SISOSEC);
    page.driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
    
//    ttype.delete(new SISOSEC_TERMINALTYPE());

  }

}
