package com.gmail.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class Application {
	private WebDriver driver;
	
	
	
	public Application(){
		this.driver = new FirefoxDriver();		
	}
	
	
	
	public GooglePage openGoogleApplication(){
		driver.get("https://www.google.co.uk/");
		driver.manage().window().maximize();
		return new GooglePage(driver);
	}



	public void closeApplication() {
		driver.quit();
		
	}
	
}
