package com.opencart.testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public WebDriver driver;

	@BeforeClass
	void setup() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("http://localhost/opencart/upload/index.php");

		driver.manage().window().maximize();
	}

	@AfterClass
	void teardDown() {

		driver.quit();
	}

	// Generado por dependencias Juan Carlos
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
