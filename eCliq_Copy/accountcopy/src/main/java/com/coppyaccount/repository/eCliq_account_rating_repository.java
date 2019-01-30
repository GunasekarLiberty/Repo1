/*
 * Copyright (C) 2017, Liberty Mutual Group
 *
 * Created on Sep 15, 2017
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
public class eCliq_account_rating_repository {
	WebDriver driver;
	public eCliq_account_rating_repository(WebDriver driver){
	this.driver=driver;
	PageFactory.initElements(driver, this);

}
	
	@FindBy(name="viewpremiumdiscount")
	WebElement btn_view_apply_premiummodification;
	
	@FindBy(name="SUBMITFORRATING")
	WebElement btn_rate;
	
	public WebElement btn_view_apply_premiummodification(){
		return btn_view_apply_premiummodification;
	}
	
	public WebElement btn_rate(){
		return btn_rate;
	}
	
	
	
	
}