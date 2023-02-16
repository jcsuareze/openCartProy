package com.opencart.testBase;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public WebDriver driver;
	public Logger logger; //for logging

	@BeforeClass
	public void setup() {
		
		logger = LogManager.getLogger(this.getClass()); //logging

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		//driver.manage().deleteAllCookies();
		driver.get("http://localhost/opencart/upload/index.php");

		driver.manage().window().maximize();
	}

	@AfterClass
	public void teardDown() {

		driver.quit();
	}

	// Generado por dependencias
	public String randomString(int numberOfDigits) {

		String generatedString = RandomStringUtils.randomAlphabetic(numberOfDigits);

		return generatedString;
	}

	public String randomNumber(int numberOfDigits) {
		String generatedString = RandomStringUtils.randomNumeric(numberOfDigits);

		return generatedString;
	}

	public String randomAlphaNumeric(int numberOfDigits) {
		String generatedString = RandomStringUtils.randomAlphanumeric(numberOfDigits);

		return generatedString;
	}

}
