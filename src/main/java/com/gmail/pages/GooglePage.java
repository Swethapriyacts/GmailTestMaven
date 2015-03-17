package com.gmail.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class GooglePage extends Page{

	public GooglePage(WebDriver driver) {
		super(driver);		
	}
	
	
	@Override
	protected boolean isValidPage() {
		if(driver.getTitle().contains("Google")){
			return true;
		}else{
			return false;
		}
	}
	
	public GmailPage clickOnGmailLink(){
		driver.findElement(By.xpath("//a[text()='Gmail']")).click();
		return new GmailPage(driver);
	}
	

}
