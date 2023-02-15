package com.opencart.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{

	public AccountRegistrationPage(WebDriver driver) {

		super(driver);
	}

	// Elementos
	@FindBy(name = "firstname")
	WebElement txtFirstName;

	@FindBy(name = "lastname")
	WebElement txtLastName;

	@FindBy(name = "email")
	WebElement txtEmail;

	@FindBy(name = "telephone")
	WebElement txtTelephone;

	@FindBy(name = "password")
	WebElement txtPassword;

	@FindBy(name = "confirm")
	WebElement txtConfirmPassword;

	@FindBy(name = "agree")
	WebElement chkPolicy;

	@FindBy(xpath = "//input[@value='Continue']")
	WebElement btnCointinue;

	@FindBy(xpath = "//div[@id='content']/child::p[1]")
	WebElement msgConfirmation;

	public void setFirstName(String fname) {
		txtFirstName.sendKeys(fname);
	}

	public void setLastName(String lname) {
		txtLastName.sendKeys(lname);
	}

	public void setEmail(String emal) {
		txtEmail.sendKeys(emal);
	}

	public void setUserName(String tel) {
		txtTelephone.sendKeys(tel);

	}

	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}

	public void setConfirmPassword(String pwd) {
		txtConfirmPassword.sendKeys(pwd);
	}

	public void setPrivacyPolicy() {
		chkPolicy.click();
	}

	public void clickCountinue() {
		btnCointinue.click();
	}

	public String getConfirmationMsg() {

		try {
			return (msgConfirmation.getText());
		} catch (Exception e) {

			return e.getMessage();
		}

	}
}
