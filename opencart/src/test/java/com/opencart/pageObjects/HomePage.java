package com.opencart.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	
	public HomePage(WebDriver driver) {
		super(driver);// invoca a la clase padre
	}

	// Elements
	@FindBy(xpath = "//span[text()='My Account']")
	WebElement lnkMyaccount;

	@FindBy(linkText = "Register")
	WebElement lnkRegister;

	// Metodos de Acción
	public void clickMyAccount() {
		lnkMyaccount.click();
	}

	public void clickRegistro() {

		lnkRegister.click();
	}

}
