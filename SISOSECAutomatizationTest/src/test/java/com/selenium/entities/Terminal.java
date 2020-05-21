package com.selenium.entities;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.selenium.helpers.Helpers;

public class Terminal {
	public WebDriver driver;

	public Terminal(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[contains(text(), 'Editar')]")
	private WebElement editbtn;

	Helpers help = new Helpers();
	String label;

	public void createTerminal(WebDriver driver, String TerminalId, String desc, int TerminalTypeId) {
	
		driver.findElement(By.xpath("//div[contains(text(), 'Nuevo')]")).click();
		Actions actions = new Actions(driver);

		List<WebElement> combox = driver.findElements(By.className("selectItemLiteText"));
		actions.moveToElement(combox.get(1)).click().sendKeys(Keys.ARROW_DOWN , Keys.ENTER).perform();
		help.wait(2);
		actions.moveToElement(combox.get(2)).click().sendKeys(Keys.ARROW_DOWN , Keys.ENTER).perform();
		help.wait(2);
		actions.moveToElement(combox.get(3)).click().sendKeys(Keys.ARROW_DOWN , Keys.ENTER).perform();
		help.wait(2);
		actions.moveToElement(combox.get(4)).click().sendKeys(Keys.ARROW_DOWN , Keys.ENTER).perform();
		help.wait(2);
		actions.moveToElement(combox.get(5)).click().sendKeys(Keys.ARROW_DOWN , Keys.ENTER).perform();
		help.wait(2);
		actions.moveToElement(combox.get(7)).click().sendKeys(Keys.DOWN,Keys.ENTER).perform();
		help.wait(2);
		actions.moveToElement(combox.get(0)).click().perform();
		driver.findElement(By.id("isc_PickListMenu_0_row_" + String.valueOf(TerminalTypeId-1))).click();
		driver.findElement(By.name("TERMINALID")).sendKeys(TerminalId);
		driver.findElement(By.xpath("//div[contains(text(), 'Guardar')]")).click();
		help.wait(4);
		/*
		List<WebElement> dropdowns = driver.findElements(By.className("pickListCell"));
		try {
		} catch (org.openqa.selenium.StaleElementReferenceException e) {
		}
		*/
		
		

	}

	public void fixTerminal(WebDriver driver, String Terminal) {
		driver.findElement(By.xpath("//div[contains(text(), 'Tipo terminal')]")).click();
		help.wait(2);
		driver.findElement(By.className("headerButtonSelectedOver")).click();
		help.wait(2);
		Actions action = new Actions(driver);
		WebElement elementLocator = driver.findElement(By.xpath("//td/div[contains(text(), '" + Terminal + "')]"));
		action.contextClick(elementLocator).perform();
		help.wait(3);
		driver.findElement(By.xpath("//div[contains(text(), 'Corregir')]")).click();
		help.wait(2);

	}

	public void editTerminal(WebDriver driver, String Terminal) {
		driver.findElement(By.xpath("//div[contains(text(), 'Tipo terminal')]")).click();
		help.wait(2);
		driver.findElement(By.className("headerButtonSelectedOver")).click();
		help.wait(2);
		Actions action = new Actions(driver);
		WebElement elementLocator = driver.findElement(By.xpath("//td/div[contains(., '" + Terminal + "')]"));
		action.contextClick(elementLocator).perform();
		help.wait(2);
		driver.findElement(By.xpath("//div[contains(text(), 'Editar')]")).click();
		driver.findElement(By.name("DESCRIPTION")).sendKeys(" edit");
		help.wait(2);
		driver.findElement(By.xpath("//div[contains(text(), 'Guardar')]")).click();
		help.wait(4);

	}

	public void deleteTerminal(WebDriver driver, String desc) {
		Actions action = new Actions(driver);
		WebElement elementLocator = driver.findElement(By.xpath("//div[contains(text(), '" + desc + "')]"));
		action.contextClick(elementLocator).perform();
		driver.findElement(By.xpath("//td/div[contains(., 'Eliminar')]")).click();

		help.wait(2);
		driver.findElement(By.xpath("//td[contains(text(), 'Aceptar')]")).click();
		//driver.findElement(By.xpath("//tbody/tr/td/table/tbody/tr/td[2]/img")).click();
		help.wait(4);

	}

}
