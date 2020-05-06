package com.selenium.config;

import com.selenium.util.Util;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseConfig
{

	public WebDriver driver;

	@BeforeMethod()
	public void getDriver ( )
	{

		System.setProperty(Util.WEB_DRIVERCHROME, Util.EXECUTE_DRIVERCHROME);
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		// driver.navigate().to("http://192.168.1.89:9080/sisosecB03010/");
		driver.navigate().to(Util.URLBASE_SISOSEC);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@AfterMethod()
	public void teardownTest ( )
	{
		// Close browser and end the session
		driver.quit();
	}
}
