package com.selenium.entities;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.PageFactory;

import com.selenium.helpers.Helpers;

public class Installation {
	public WebDriver driver;

	public Installation(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	Helpers help = new Helpers();

	public void createInstallation(WebDriver driver) {

	}

	public void fixInstallation(WebDriver driver, String Installation) {
		Actions action = new Actions(driver);
		WebElement elementLocator = driver.findElement(By.xpath("//td/div[contains(., '" + Installation + "')]"));
		action.contextClick(elementLocator).perform();
		help.wait(3);
		driver.findElement(By.xpath("//div[contains(text(), 'Corregir')]")).click();
		help.wait(2);

	}

	public void editInstallation(WebDriver driver, String Installation) {

		Actions action = new Actions(driver);
		WebElement elementLocator = driver.findElement(By.xpath("//td/div[contains(., '" + Installation + "')]"));
		action.contextClick(elementLocator).perform();
		help.wait(2);
		driver.findElement(By.xpath("//div[contains(text(), 'Editar')]")).click();
		driver.findElement(By.name("DESCRIPTION")).sendKeys(" edit");
		help.wait(2);
		driver.findElement(By.xpath("//div[contains(text(), 'Guardar')]")).click();
		help.wait(4);

	}

	public void deleteInstallation(WebDriver driver, String desc) {
	}

}
