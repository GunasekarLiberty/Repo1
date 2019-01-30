/*
 * Copyright (C) 2017, Liberty Mutual Group
 *
 * Created on Jul 20, 2017
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
public class generalinfo_repository {

	WebDriver driver;
	public generalinfo_repository(WebDriver driver){
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
	
	@FindBy(id="cmbRiskState")
	WebElement txt_state;
	
	@FindBy(xpath="//*[(@id='txtAgencyNameAndCode' )or (@id='cmbAgencyNameAndCode')]")
	WebElement txt_agency;
	
	@FindBy(id="txtInsuredName")
	WebElement txt_txtInsuredName;
	
	@FindBy(id="txtMailingAddress")
	WebElement txt_txtMailingAddress;
	
	@FindBy(id="txtInsuredPhone")
	WebElement txt_txtInsuredPhone;
	
	public WebElement txt_state(){
		return txt_state;
	}
	
	public WebElement txt_agency(){
		return txt_agency;
	}
	
	public WebElement txt_txtInsuredName(){
		return txt_txtInsuredName;
	}
	
	public WebElement txt_txtMailingAddress(){
		return txt_txtMailingAddress;
	}
	
	public WebElement txt_txtInsuredPhone(){
		return txt_txtInsuredPhone;
	}
}
