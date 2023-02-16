package com.opencart.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencart.pageObjects.AccountRegistrationPage;
import com.opencart.pageObjects.HomePage;
import com.opencart.testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {

	@Test(description = "Esta prueba verifica que una cuenta haya sido creada exitosamente ")
	void test_account_Registration() {

		logger.debug("<Registros");
		logger.info("****Iniciando TC_001_AccountRegistrationTest*****");

		HomePage hp = new HomePage(driver);
		AccountRegistrationPage regPage = new AccountRegistrationPage(driver);
		hp.clickMyAccount();

		logger.info("Click en Mi cuenta");
		hp.clickRegistro();
		logger.info("Click en Registro");

		regPage.setFirstName(randomString(8).toUpperCase());
		regPage.setLastName(randomString(8).toUpperCase());
		regPage.setEmail(randomString(5) + "@correo.com");// Generado de forma aleatoria
		regPage.setUserName(randomString(10));

		String password = randomAlphaNumeric(6);
		regPage.setPassword(password);
		regPage.setConfirmPassword(password);
		regPage.setPrivacyPolicy();
		regPage.clickCountinue();
		logger.info("Click en continuar");
		String confMsg = regPage.getConfirmationMsg();

		logger.info("Validando mensaje");
		Assert.assertEquals(confMsg, "Congratulations! Your new account has been successfully created!");

		logger.info("****Iniciando TC_001_AccountRegistrationTest*****");

	}

}
