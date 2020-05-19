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

public class KeyType {
	public WebDriver driver;

	public KeyType(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[contains(text(), 'Editar')]")
	private WebElement editbtn;

	Helpers help = new Helpers();

	public void createKeyType(WebDriver driver, String KeyType, String KeyName, String desc, String Length) {
		driver.findElement(By.xpath("//div[contains(text(), 'Nuevo')]")).click();
		driver.findElement(By.name("KEYTYPE")).sendKeys(KeyType);
		driver.findElement(By.name("KEY_NAME")).sendKeys(KeyName);
		driver.findElement(By.name("DESCRIPTION")).sendKeys(KeyName);
		driver.findElement(By.name("PART_LENGTH")).sendKeys(Length);

		Actions actions = new Actions(driver);
		List<WebElement> combox = driver.findElements(By.className("selectItemLiteText"));
		actions.moveToElement(combox.get(0)).click().sendKeys(Keys.ARROW_DOWN, Keys.ENTER).perform();
		help.wait(2);
		actions.moveToElement(combox.get(1)).click().sendKeys(Keys.ARROW_DOWN, Keys.ENTER).perform();
		help.wait(2);
		actions.moveToElement(combox.get(2)).click().sendKeys(Keys.ARROW_DOWN, Keys.ENTER).perform();
		help.wait(2);

		driver.findElement(By.xpath("//div[contains(text(), 'Guardar')]")).click();
		if (driver.findElements(By.className("windowBackground")).size() > 0) {
			System.out.println("NO SE PUDO GUARDAR EL REGISTRO , VERIFICAR DATOS INGRESADOS");
			driver.findElement(By.xpath("//td[contains(text(), 'Aceptar')]")).click();
			help.wait(5);
		} else {
			System.out.println("REGISTRO CON EXITO");
		}
		help.wait(8);
	}

	public void fixKeyType(WebDriver driver, String KeyType) {
		Actions action = new Actions(driver);
		WebElement elementLocator = driver.findElement(By.xpath("//td[contains(., '" + KeyType + "')]"));
		action.contextClick(elementLocator).perform();
		help.wait(3);
		driver.findElement(By.xpath("//div[contains(text(), 'Corregir')]")).click();
		help.wait(2);

	}

	public void editKeyType(WebDriver driver, String KeyType) {

		driver.findElement(By.xpath("//div[contains(text(), 'Tipo llave')]")).click();
		help.wait(2);
		driver.findElement(By.className("headerButtonSelectedOver")).click();
		Actions action = new Actions(driver);
		WebElement elementLocator = driver.findElement(By.xpath("//td[contains(., '" + KeyType + "')]"));
		action.contextClick(elementLocator).perform();
		help.wait(2);
		driver.findElement(By.xpath("//div[contains(text(), 'Editar')]")).click();
		driver.findElement(By.name("DESCRIPTION")).sendKeys(" edit");
		help.wait(2);
		driver.findElement(By.xpath("//div[contains(text(), 'Guardar')]")).click();
		help.wait(4);

	}

	public void deleteKeyType(WebDriver driver, String desc) {
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
