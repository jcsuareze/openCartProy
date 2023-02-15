package com.opencart.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencart.pageObjects.AccountRegistrationPage;
import com.opencart.pageObjects.HomePage;

public class TC_001_AccountRegistrationTest extends BaseClass {
	
	@Test
	void test_account_Registration() {

	
			HomePage hp = new HomePage(driver);
			AccountRegistrationPage regPage = new AccountRegistrationPage(driver);
			hp.clickMyAccount();
			hp.clickRegistro();

			regPage.setFirstName(randomString(8).toUpperCase());
			regPage.setLastName(randomString(8).toUpperCase());
			regPage.setEmail(randomString(5) + "@correo.com");// Generado de forma aleatoria
			regPage.setUserName(randomString(10));

			String password = randomAlphaNumeric(6);
			regPage.setPassword(password);
			regPage.setConfirmPassword(password);
			regPage.setPrivacyPolicy();
			regPage.clickCountinue();
			String confMsg = regPage.getConfirmationMsg();

			Assert.assertEquals(confMsg, "Congratulations! Your new account has been successfully created!");
		

	}

}
