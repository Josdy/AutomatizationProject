package com.selenium.entities;

import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.selenium.helpers.Helpers;

public class InstallationProperties {
	public WebDriver driver;

	public InstallationProperties(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[contains(text(), 'Editar')]")
	private WebElement editbtn;

	Helpers help = new Helpers();
	String label;

	public void createInstallationProperties(WebDriver driver) {
		driver.findElement(By.xpath("//div[contains(text(), 'Nuevo')]")).click();
		help.wait(4);
		driver.findElement(By.className("selectItemLiteText")).click();
		;

		List<WebElement> dropdowns = driver.findElements(By.className("selectItemLiteText"));
		for (WebElement dropdown : dropdowns) {
			System.out.println("MENSAJEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE");
			if (dropdown.getText().contains("Seguridad SCA")) {
				dropdown.click();
				break;
			}
		}

		driver.findElement(By.name("VALUE")).sendKeys("VALOR");
		help.wait(10);
	}

	public void fixInstallationProperties(WebDriver driver, String InstallationProperties) {
		Actions action = new Actions(driver);
		WebElement elementLocator = driver.findElement(By.xpath("//td[contains(., '" + InstallationProperties + "')]"));
		action.contextClick(elementLocator).perform();
		help.wait(3);
		driver.findElement(By.xpath("//div[contains(text(), 'Corregir')]")).click();
		help.wait(2);

	}

	public void editInstallationProperties(WebDriver driver, String InstallationProperties) {

		Actions action = new Actions(driver);
		WebElement elementLocator = driver.findElement(By.xpath("//td[contains(., '" + InstallationProperties + "')]"));
		action.contextClick(elementLocator).perform();
		help.wait(2);
		driver.findElement(By.xpath("//div[contains(text(), 'Editar')]")).click();
		driver.findElement(By.name("VALUE")).sendKeys(" edit");
		help.wait(2);
		driver.findElement(By.xpath("//div[contains(text(), 'Guardar')]")).click();
		help.wait(4);

	}

	public void deleteInstallationProperties(WebDriver driver, String desc) {
		Actions action = new Actions(driver);
		WebElement elementLocator = driver.findElement(By.xpath("//div[contains(., '" + desc + "')]"));
		action.contextClick(elementLocator).perform();
		driver.findElement(By.xpath("//td/div[contains(., 'Eliminar')]")).click();
		help.wait(2);
		driver.findElement(By.xpath("//td[contains(text(), 'Aceptar')]")).click();
		driver.findElement(By.xpath("//tbody/tr/td/table/tbody/tr/td[2]/img")).click();
		help.wait(4);

	}

}
