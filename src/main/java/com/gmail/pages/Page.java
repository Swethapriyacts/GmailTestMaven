package com.gmail.pages;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {
	
	protected WebDriver driver;	
	protected abstract boolean isValidPage();

	
	protected Page(WebDriver driver) {
		this.driver=driver;
		verifyApplicationInCorrectPage();
	}
	
	private void verifyApplicationInCorrectPage() {
		if (!isValidPage()) {
			Assert.fail("Not in expected Page");					
		}
	}
	
	
	protected Boolean waitForElement(By by) {
		try {
			new WebDriverWait(driver,50).
			until(ExpectedConditions.presenceOfElementLocated(by));
		} catch (Exception ex) {
			return false;
		}
		return true;
	}
}
