package com.test.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage {
	// ==============LoginElements=================
	@FindBy(id="username")
       WebElement userNamElement ;
    	   
   @FindBy(id="password")
	WebElement userPasswordElement;
	
	@FindBy(name="login")
	WebElement loginElement;
	
	@FindBy(xpath = "/*[@id=\"page-36\"]/div/div[1]/nav/ul/li[6]/a")
	  WebElement  logout;
	//==============RegisterElements==================
	@FindBy(name="email" )
	      WebElement email;
	@FindBy(name="password")
	    WebElement passwordElement;
	@FindBy(name="register")
	   WebElement registerElement;
}
