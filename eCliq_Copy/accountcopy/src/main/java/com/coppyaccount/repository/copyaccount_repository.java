/*
 * Copyright (C) 2017, Liberty Mutual Group
 *
 * Created on Aug 25, 2017
 */

package com.coppyaccount.repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author n0274028
 *
 */
public class copyaccount_repository {

	WebDriver driver;
	public copyaccount_repository(WebDriver driver){
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="screen-name")
	WebElement lbl_screentitle;
	
	@FindBy(id="txtAccountNumber")
	WebElement txt_accountnum;
	
	@FindBy(id="cmbReasonsForCopy")
	WebElement ddl_reason;
	
	@FindBy(id="searchButton")
	WebElement btn_search;
	
	@FindBy(name="btnContinue")
	WebElement btn_startcopy;
	
	@FindBy(id="txtComment")
	WebElement txt_versiondes;
	
	
	
	@FindBy(name="NEXTPAGE")
	
	WebElement btn_next;
	
	@FindBy(id="wcIndividuals_opt_no")
	WebElement rdo_individualno;
	
	@FindBy(name="RATE_NEXT_PAGE")
	WebElement btn_next2;
	
	@FindBy(css="#CONTACT_INFORMATION_CONTINUE_WITH_SUBMISSION")
			//"#CONTACT_INFORMATION_CONTINUE_WITH_SUBMISSION")
	WebElement btn_ContactInfoNEXT;
	
	@FindBy(css="#BILL_PLAN_CONTINUE_WITH_SUBMISSION")
	WebElement btn_PolicyDeliveryPrefNEXT;
	
	@FindBy(xpath="//*[contains(@id,'newDirectBillAccountButton') and contains(@name,'optionType')]")
	WebElement btn_CreateNewBilling;
	
	@FindBy(name="primaryButton")
	WebElement btn_Continue;
	
	@FindBy(name="accountNumber")
	WebElement rdo_accountNumber;
	
	@FindBy(name="primaryButton")
	WebElement btn_SubmitUsingExisting;
	
	@FindBy(id="notRequiredPrimaryButton")
	WebElement btn_IssueWithoutDownPayment;
	
	@FindBy(xpath="//*[@id='btnContinue']")
	WebElement btn_driverscreenContinue;
	
	
	public WebElement lbl_screentitle(){
		return lbl_screentitle;
	}
	public WebElement txt_accountnum(){
		return txt_accountnum;
	}
	public WebElement ddl_reason(){
		return ddl_reason;
	}
	public WebElement btn_search(){
		return btn_search;
	}
	public WebElement btn_startcopy(){
		return btn_startcopy;
	}
	public WebElement txt_versiondes(){
		return txt_versiondes;
	}
	public WebElement btn_next(){
		return btn_next;
	}
	public WebElement rdo_individualno(){
		return rdo_individualno;
	}
	public WebElement btn_next2(){
		return btn_next2;
	}
	public WebElement btn_PolicyDeliveryPrefNEXT(){
		return btn_PolicyDeliveryPrefNEXT;
	}
	public WebElement btn_CreateNewBilling(){
		return btn_CreateNewBilling;
	}
	public WebElement btn_Continue(){
		return btn_Continue;
	}
	public WebElement rdo_accountNumber(){
		return rdo_accountNumber;
	}
	public WebElement btn_SubmitUsingExisting(){
		return btn_SubmitUsingExisting;
	}
	public WebElement btn_IssueWithoutDownPayment(){
		return btn_IssueWithoutDownPayment;
	}
	public WebElement btn_ContactInfoNEXT(){
		return btn_ContactInfoNEXT;
	}

	public WebElement btn_driverscreenContinue(){
		return btn_driverscreenContinue;
	}
	
	//*[@id="tablet-navigation-arrows"]/div[2]/a
	//*[@id="tablet-navigation-arrows"]/div[2]/a
	
	
	
	
	
}