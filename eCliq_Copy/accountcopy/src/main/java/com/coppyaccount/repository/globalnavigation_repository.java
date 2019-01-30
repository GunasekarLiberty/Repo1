/*
 * Copyright (C) 2017, Liberty Mutual Group
 *
 * Created on Aug 9, 2017
 */

package com.coppyaccount.repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author n0274028
 *
 */
public class globalnavigation_repository {
	
	WebDriver driver;
	public globalnavigation_repository(WebDriver driver){
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

	
	@FindBy(linkText="Main Menu")
	WebElement lnk_mainmenu;
	
	@FindBy(linkText="Account Details")
	WebElement lnk_acdetails;
	
	
	public WebElement lnk_mainmenu(){
		return lnk_mainmenu;
	}
	
}
