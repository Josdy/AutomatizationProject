package com.selenium.entities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.selenium.helpers.Helpers;


public class TerminalType {
	public WebDriver driver;

	public TerminalType(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[contains(text(), 'Editar')]")
	private WebElement editbtn;

	Helpers help = new Helpers();

	public void createTerminalType(WebDriver driver, int idOpcion, String idTerminalType, String desc) {
		driver.findElement(By.xpath("//div[contains(text(), 'Nuevo')]")).click();
		driver.findElement(By.name("TERMINALTYPE")).sendKeys(idTerminalType);
		driver.findElement(By.name("DESCRIPTION")).sendKeys(desc);
		help.wait(2);
		driver.findElement(By.xpath("//div[contains(text(), 'Guardar')]")).click();
		help.wait(2);

	}

	public void fixTerminalType(WebDriver driver, String idTerminalType) {
		Actions action = new Actions(driver);
		WebElement elementLocator = driver.findElement(By.xpath("//tbody/tr[" + idTerminalType + "]/td[3]/div"));
		action.contextClick(elementLocator).perform();
		help.wait(3);
		driver.findElement(By.xpath("//div[contains(text(), 'Corregir')]")).click();
		help.wait(2);

	}

	public void editTerminalType(WebDriver driver, String idTerminalType) {

		driver.findElement(By.xpath("//tbody/tr[" + idTerminalType + "]/td[3]/div")).click();
		driver.findElement(By.xpath("//div[contains(text(), 'Actualizar')]")).click();
		Actions action = new Actions(driver);
		WebElement elementLocator = driver.findElement(By.xpath("//tbody/tr[" + idTerminalType + "]/td[3]/div"));
		action.contextClick(elementLocator).perform();
		help.wait(2);
		driver.findElement(By.xpath("//div[contains(text(), 'Editar')]")).click();
		driver.findElement(By.name("DESCRIPTION")).sendKeys(" edit");
		help.wait(2);
		driver.findElement(By.xpath("//div[contains(text(), 'Guardar')]")).click();
		help.wait(4);

	}

	public void deleteTerminalType(WebDriver driver, String desc) {
		Actions action = new Actions(driver);
		WebElement elementLocator = driver.findElement(By.xpath("//div[contains(text(), '" + desc + "')]"));
		action.contextClick(elementLocator).perform();
		driver.findElement(By.xpath("//td/div[contains(text(), 'Eliminar')]")).click();
		help.wait(2);
		driver.findElement(By.xpath("//td[contains(text(), 'Aceptar')]")).click();
		driver.findElement(By.xpath("//tbody/tr/td/table/tbody/tr/td[2]/img")).click();
		help.wait(4);

	}

}
