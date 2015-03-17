package com.gmail.pages;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GmailPage extends Page{
	
	
	
	
	public GmailPage(WebDriver driver) {
		super(driver);		
	}
	

	@Override
	protected boolean isValidPage() {
		if((driver.getTitle().contains("Gmail"))||(driver.getTitle().contains("Create your Google Account"))){
			return true;
		}else{
			return false;
		}
	}
	
	

	public GmailPage verifyCreateAccount() {
		driver.findElement(By.id("link-signup")).click();
		waitForElement(By.id("FirstName"));
		driver.findElement(By.id("FirstName")).sendKeys("Swetha");
		driver.findElement(By.id("LastName")).sendKeys("Priya");
		
		driver.findElement(By.id("Passwd")).sendKeys("p@ssword12");
		driver.findElement(By.id("PasswdAgain")).sendKeys("p@ssword12");
		driver.findElement(By.xpath("//*[@id='BirthMonth']/div")).click();
		
		driver.findElement(By.xpath("//*[@id='BirthMonth']/div[2]/div[2]")).click();
		
		driver.findElement(By.id("BirthDay")).sendKeys("2");
		driver.findElement(By.id("BirthYear")).sendKeys("1990");
		driver.findElement(By.xpath("//*[@id='Gender']/div[1]")).click();
		driver.findElement(By.xpath("//*[@id='Gender']/div[2]/div[1]")).click();
		
		driver.findElement(By.id("RecoveryPhoneNumber")).sendKeys("9876543210");
		
		driver.findElement(By.id("RecoveryEmailAddress")).sendKeys("recovery@gmail.com");
		
		driver.findElement(By.id("SkipCaptcha")).click();
		
		driver.findElement(By.id("TermsOfService")).click();
		
		driver.findElement(By.id("submitbutton")).click();
		
		waitForElement(By.id("errormsg_0_GmailAddress"));
		
		if(driver.findElement(By.id("errormsg_0_GmailAddress")).isDisplayed()){
			String strMessage = driver.findElement(By.id("errormsg_0_GmailAddress")).getText();
			Assert.assertEquals("You can't leave this empty.", strMessage);
		}
		return this;		
	}

	
}
