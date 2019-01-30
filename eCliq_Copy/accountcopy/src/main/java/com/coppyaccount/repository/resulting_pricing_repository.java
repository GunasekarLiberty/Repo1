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
public class resulting_pricing_repository {

	
	WebDriver driver;
	public resulting_pricing_repository(WebDriver driver){
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
	@FindBy(id="GeneralInfo")
	WebElement lnk_generalinfo;
	
	@FindBy(id="REVIEW")
	WebElement btn_RefertoUnderwritingforReview;
	
	@FindBy(name="chkEffectiveDate")
	WebElement chk_issue;
	
	@FindBy(id="ISSUE")
	WebElement btn_issue;
	
//	@FindBy(name="chkEffectiveDate")
//	WebElement chk_IssueEffective;
	
	@FindBy(name="inspectionSameAsPrimary")
	WebElement chk_InspectionSameAsPrimary;
	
	@FindBy(name="accountingSameAsPrimary")
	WebElement chk_AccountingSameAsPrimary;
	
	@FindBy(xpath="//*[(contains(@name,'chkEffectiveDate') or contains(@id,'lblEffectiveDate')) and contains(@name,'chkEffectiveDate')]")
	WebElement chk_chkEffectiveDate;
	
	@FindBy(xpath="//*[@id='automaticWithdrawalsFalsePaymentPlan']")
	WebElement ddl_paymentplan;
	
	@FindBy(xpath="//*[@id='paperlessBillingNo']")
	WebElement rdo_paperless;
	
	public WebElement chk_chkEffectiveDate(){
		return chk_chkEffectiveDate;
	}
		
	public WebElement lnk_generalinfo(){
		return lnk_generalinfo;
	}
	
	public WebElement btn_RefertoUnderwritingforReview(){
		return btn_RefertoUnderwritingforReview;
	}
	
	public WebElement chk_issue(){
		return chk_issue;
	}
	
	public WebElement btn_issue(){
		return btn_issue;
	}
	
//	public WebElement chk_IssueEffective(){
//		return chk_IssueEffective;
//	}
	
	public WebElement chk_InspectionSameAsPrimary(){
		return chk_InspectionSameAsPrimary;
	}

	public WebElement chk_AccountingSameAsPrimary(){
		return chk_AccountingSameAsPrimary;
	}
	
	public WebElement ddl_paymentplan(){
		return ddl_paymentplan;
	}
	public WebElement rdo_paperless(){
		return rdo_paperless;
	}

	
	
	
	
	
	
}
