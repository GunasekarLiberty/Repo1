/*
 * Copyright (C) 2017, Liberty Mutual Group
 *
 * Created on Oct 16, 2017
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
public class eCliq_ReferralDesktop {

	
	WebDriver driver;
	public eCliq_ReferralDesktop(WebDriver driver){
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
	
	
	@FindBy(linkText="Enhanced Referral Desktop")
	WebElement lnk_EnhancedReferralDesktop;
	
	@FindBy(partialLinkText="")
	WebElement lnk_accountnumber;
	
	@FindBy(id="ManageReferralsButton")
	WebElement btn_ManageReferrals;
	
	@FindBy(name="completeProcessing")
	WebElement btn_completeProcessing;
	
	
	
	
	public WebElement lnk_EnhancedReferralDesktop(){
		return lnk_EnhancedReferralDesktop;
	}
	
	public WebElement lnk_accountnumber(String s) {
		return lnk_accountnumber(s);
	}
	
	public WebElement btn_ManageReferrals(){
		return btn_ManageReferrals;
	}
	
	public WebElement btn_completeProcessing(){
		return btn_completeProcessing;
	}
	
	
	
}
