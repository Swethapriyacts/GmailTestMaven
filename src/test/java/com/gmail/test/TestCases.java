package com.gmail.test;

import org.junit.Test;

import com.gmail.pages.Application;
import com.gmail.pages.GmailPage;
import com.gmail.pages.GooglePage;

public class TestCases {

	private GooglePage googlePage;
	private GmailPage gmailPage;
	
	
	@Test
	public void verifyCreatenewAccount(){
		Application application = new Application();
		googlePage = application.openGoogleApplication();
		gmailPage = googlePage.clickOnGmailLink();
		gmailPage.verifyCreateAccount();
		application.closeApplication();
		
	}
	
	
}
