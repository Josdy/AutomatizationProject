package com.selenium.entities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.PageFactory;

import com.selenium.helpers.Helpers;

public class HSM {
	public WebDriver driver;

	public HSM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	Helpers help = new Helpers();

	public void createHSM(WebDriver driver, String HSM, String Host, String Service, String TO, String MaxConn) {

		driver.findElement(By.xpath("//div[contains(text(), 'Nuevo')]")).click();
		
		driver.findElement(By.name("HSMID")).sendKeys(HSM);
		Actions actions = new Actions(driver);

		List<WebElement> combox = driver.findElements(By.className("selectItemLiteText"));
		actions.moveToElement(combox.get(0)).click().sendKeys(Keys.ARROW_DOWN , Keys.ENTER).perform();
		help.wait(2);
		actions.moveToElement(combox.get(1)).click().sendKeys(Keys.ARROW_DOWN , Keys.ENTER).perform();
		help.wait(2);
		actions.moveToElement(combox.get(2)).click().sendKeys(Keys.ARROW_DOWN , Keys.ENTER).perform();
		help.wait(2);
		actions.moveToElement(combox.get(3)).click().sendKeys(Keys.ARROW_DOWN , Keys.ENTER).perform();
		help.wait(2);
		actions.moveToElement(combox.get(4)).click().sendKeys(Keys.ARROW_DOWN , Keys.ENTER).perform();
		
		//WebElement element = driver.findElement(By.className("selectItemLiteText"));
		//element.sendKeys(Keys.DOWN);
		//element = driver.findElement(By.className("selectItemLiteText"));
		//element.sendKeys(Keys.DOWN);
		driver.findElement(By.name("HOST")).sendKeys(Host);
		driver.findElement(By.name("SERVICE")).sendKeys(Service);
		driver.findElement(By.name("TIMEOUT")).sendKeys(TO);
		driver.findElement(By.name("MAXCONNECTION")).sendKeys(MaxConn);
		
		/*
		 * 
		 * 
		 * 
		 * element = driver.findElement(By.className("selectItemLiteText"));
		 * element.sendKeys(Keys.DOWN);
		 */
		/*
		 * WebElement element = driver.findElement(By.name("PART_LENGTH"));
		 * element.sendKeys(Keys.TAB, Keys.DOWN, Keys.DOWN); help.wait(3);
		 */
		driver.findElement(By.xpath("//div[contains(text(), 'Guardar')]")).click();
		help.wait(8);

	}

	public void fixHSM(WebDriver driver, String HSM) {
		Actions action = new Actions(driver);
		WebElement elementLocator = driver.findElement(By.xpath("//td/div[contains(., '" + HSM + "')]"));
		action.contextClick(elementLocator).perform();
		help.wait(3);
		driver.findElement(By.xpath("//div[contains(text(), 'Corregir')]")).click();
		help.wait(2);

	}

	public void editHSM(WebDriver driver, String HSM) {

		Actions action = new Actions(driver);
		WebElement elementLocator = driver.findElement(By.xpath("//td/div[contains(., '" + HSM + "')]"));
		action.contextClick(elementLocator).perform();
		driver.findElement(By.xpath("//div[contains(text(), 'Editar')]")).click();
		driver.findElement(By.name("DESCRIPTION")).sendKeys(" edit");
		help.wait(2);
		driver.findElement(By.xpath("//div[contains(text(), 'Guardar')]")).click();
		help.wait(8);

	}

	public void deleteHSM(WebDriver driver, String desc) {
		Actions action = new Actions(driver);
		WebElement elementLocator = driver.findElement(By.xpath("//div[contains(text(), '" + desc + "')]"));
		action.contextClick(elementLocator).perform();
		driver.findElement(By.xpath("//td/div[contains(., 'Eliminar')]")).click();

		help.wait(2);
		driver.findElement(By.xpath("//td[contains(text(), 'Aceptar')]")).click();
		driver.findElement(By.xpath("//tbody/tr/td/table/tbody/tr/td[2]/img")).click();
		help.wait(4);

	}

}
