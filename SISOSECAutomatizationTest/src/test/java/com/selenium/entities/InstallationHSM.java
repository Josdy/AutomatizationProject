package com.selenium.entities;

import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.selenium.helpers.Helpers;

public class InstallationHSM {
	public WebDriver driver;

	public InstallationHSM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[contains(text(), 'Editar')]")
	private WebElement editbtn;

	Helpers help = new Helpers();
	String label;
	public void createInstallationHSM(WebDriver driver) {

		List<WebElement> tabbutton = driver.findElements(By.className("tabButtonTop"));
		for (WebElement tab : tabbutton) {
			if (tab.getText().equals("HSM")) {
				tab.click();
				break;
				
			}
		}
		driver.findElement(By.xpath("//div[contains(text(), 'Actualizar')]")).click();
		help.wait(5);
		}

	public void fixInstallationHSM(WebDriver driver, String InstallationHSM) {
		Actions action = new Actions(driver);
		WebElement elementLocator = driver.findElement(By.xpath("//td[contains(., '" + InstallationHSM + "')]"));
		action.contextClick(elementLocator).perform();
		help.wait(3);
		driver.findElement(By.xpath("//div[contains(text(), 'Corregir')]")).click();
		help.wait(2);

	}

	public void editInstallationHSM(WebDriver driver, String InstallationHSM) {

		driver.findElement(By.xpath("//div[contains(text(), 'Tipo llave')]")).click();
		help.wait(2);
		driver.findElement(By.className("headerButtonSelectedOver")).click();
		Actions action = new Actions(driver);
		WebElement elementLocator = driver.findElement(By.xpath("//td[contains(., '" + InstallationHSM + "')]"));
		action.contextClick(elementLocator).perform();
		help.wait(2);
		driver.findElement(By.xpath("//div[contains(text(), 'Editar')]")).click();
		driver.findElement(By.name("DESCRIPTION")).sendKeys(" edit");
		help.wait(2);
		driver.findElement(By.xpath("//div[contains(text(), 'Guardar')]")).click();
		help.wait(4);

	}

	public void deleteInstallationHSM(WebDriver driver, String desc) {
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
