package com.opencart.testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

	public WebDriver driver;
	public Logger logger; // for logging

	public ResourceBundle rb;

	@BeforeClass
	@Parameters("browser")
	public void setup(String br) {

		rb = ResourceBundle.getBundle("config");

		logger = LogManager.getLogger(this.getClass()); // logging

		// WebDriverManager.chromedriver().setup(); //No necesario desde la version
		// 4.6.0. de Selenium

		if (br.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (br.equals("edge")) {
			driver = new EdgeDriver();
		} else {

			driver = new FirefoxDriver();
		}

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get(rb.getString("appURL"));

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

	public String captureScreen(String tname) throws IOException{
		
		

		String timeStamp = new SimpleDateFormat("yyMMddhhmmss").format(new Date());
		
		
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return destination;
	}

}
