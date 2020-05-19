package com.selenium.entities;

import java.util.List;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.selenium.helpers.Helpers;

public class Emisor {
	public WebDriver driver;

	public Emisor(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[contains(text(), 'Editar')]")
	private WebElement editbtn;

	Helpers help = new Helpers();
	String label;

	public void createEmisor(WebDriver driver, String Bin, String desc, String BinLength, String PanLength,
			String PinLength, String PinLengthMin, String PinLengthMax) {

		driver.findElement(By.xpath("//div[contains(text(), 'Nuevo')]")).click();

		driver.findElement(By.name("BIN")).sendKeys(Bin);
		driver.findElement(By.name("DESCRIPTION")).sendKeys(desc);
		driver.findElement(By.name("BIN_LENGTH")).sendKeys(BinLength);
		driver.findElement(By.name("PAN_LENGTH")).sendKeys(PanLength);
		driver.findElement(By.name("PIN_LENGTH")).sendKeys(PinLength);
		driver.findElement(By.name("PIN_LENGTH_MIN")).sendKeys(PinLengthMin);
		driver.findElement(By.name("PIN_LENGTH_MAX")).sendKeys(PinLengthMax);

		Actions actions = new Actions(driver);

		List<WebElement> combox = driver.findElements(By.className("selectItemLiteText"));
		actions.moveToElement(combox.get(0)).click().sendKeys(Keys.ARROW_DOWN, Keys.ENTER).perform();
		help.wait(2);
		actions.moveToElement(combox.get(10)).click().sendKeys(Keys.ARROW_DOWN, Keys.ENTER).perform();
		help.wait(2);
		driver.findElement(By.xpath("//div[contains(text(), 'Guardar')]")).click();
		help.wait(4);

	}

	public void fixEmisor(WebDriver driver, String Emisor) {
		driver.findElement(By.xpath("//div[contains(text(), 'BIN')]")).click();
		help.wait(2);
		driver.findElement(By.className("headerButtonSelectedOver")).click();
		help.wait(2);
		Actions action = new Actions(driver);
		WebElement elementLocator = driver.findElement(By.xpath("//td/div[contains(text(), '" + Emisor + "')]"));
		action.contextClick(elementLocator).perform();
		help.wait(3);
		driver.findElement(By.xpath("//div[contains(text(), 'Corregir')]")).click();
		help.wait(2);

	}

	public void editEmisor(WebDriver driver, String Emisor) {
		driver.findElement(By.xpath("//div[contains(text(), 'BIN')]")).click();
		help.wait(2);
		driver.findElement(By.className("headerButtonSelectedOver")).click();
		help.wait(2);
		Actions action = new Actions(driver);
		WebElement elementLocator = driver.findElement(By.xpath("//td/div[contains(., '" + Emisor + "')]"));
		action.contextClick(elementLocator).perform();
		help.wait(2);
		driver.findElement(By.xpath("//div[contains(text(), 'Editar')]")).click();
		driver.findElement(By.name("DESCRIPTION")).sendKeys(" edit");
		Actions actions = new Actions(driver);
		List<WebElement> btn = driver.findElements(By.className("buttonRounded"));
		actions.moveToElement(btn.get(3)).click().perform();
		help.wait(20);

	}

	public void deleteEmisor(WebDriver driver, String desc) {
		driver.findElement(By.xpath("//div[contains(text(), 'BIN')]")).click();
		help.wait(2);
		driver.findElement(By.className("headerButtonSelectedOver")).click();
		help.wait(2);

		Actions action = new Actions(driver);
		WebElement elementLocator = driver.findElement(By.xpath("//div[contains(text(), '" + desc + "')]"));
		action.contextClick(elementLocator).perform();
		//driver.findElement(By.xpath("//td/div[contains(., 'Eliminar')]")).click();
		List<WebElement> btn = driver.findElements(By.className("menuTitleField"));
		action.moveToElement(btn.get(1)).click().perform();
		help.wait(20);
		help.wait(2);
		driver.findElement(By.xpath("//td[contains(text(), 'Aceptar')]")).click();
		driver.findElement(By.xpath("//tbody/tr/td/table/tbody/tr/td[2]/img")).click();
		help.wait(4);
		
		
	}

}
