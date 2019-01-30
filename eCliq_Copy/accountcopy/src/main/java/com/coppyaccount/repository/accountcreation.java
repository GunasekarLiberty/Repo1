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
import org.openqa.selenium.support.ui.Select;


public class accountcreation {
	WebDriver driver;
	public accountcreation(WebDriver driver){
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
	@FindBy(name="createNew")
	WebElement btn_createaccount;
	
	@FindBy(id="agencySearchValue")
	WebElement txt_agencySearchValue;
	
	@FindBy(id="agencySearchValue_aia")
	WebElement rdo_aia;

	@FindBy(id="AgencyCodeSearch")
	WebElement btn_search;
	
	@FindBy(id="cmbAgencyCode")
	WebElement ddl_agencys;
	
	@FindBy(id="txtFirstNameInsured1")
	WebElement txt_insuredname;
	
	@FindBy(id="txtMailingAddress1")
	WebElement txt_address;
	
	@FindBy(id="txtMailingZip")
	WebElement txt_zip;

	@FindBy(id="txtMailingState")
	WebElement txt_state;
	
	@FindBy(id="txtMailingCity")
	WebElement txt_txtMailingCity;
	
	@FindBy(name="btnLookupCountyCityZip")
	WebElement btn_cityzip;
	
	@FindBy(id="txtPhoneNumber")
	WebElement txt_PhoneNumber;
	
	@FindBy(id="btnCreateAccount")
	WebElement btn_btnCreateAccount;
	
	@FindBy(id="btnCreateAnotherAccount")
	WebElement btn_btnCreateAnotherAccount;
	
	@FindBy(id="NoMatch")
	WebElement rdo_nomatch;

	@FindBy(id="btnContinue")
	WebElement btn_continue;

	@FindBy(id="accountActionsButton")
	WebElement btn_accountoptions;
	
	@FindBy(linkText="Start New Copy")
	WebElement lnk_StartNewCopy;
	 
	@FindBy(name="buttonOK")
	WebElement btn_ok; 
	
	public WebElement btn_createaccount(){
		return btn_createaccount;
	}
	
	public WebElement txt_agencySearchValue(){
		return txt_agencySearchValue;
	}
	public WebElement rdo_aia(){
		return rdo_aia;
	}
	public WebElement btn_search(){
		return btn_search;
	}
	
	public WebElement ddl_agency(){
		return  ddl_agencys;
	}
	public WebElement txt_insuredname(){
		return  txt_insuredname;
	}
	public WebElement txt_address(){
		return  txt_address;
	}
	
	public WebElement txt_zip(){
		return  txt_zip;
	}
	public WebElement txt_state(){
		return  txt_state;
	}
	public WebElement txt_txtMailingCity(){
		return  txt_txtMailingCity;
	}
	
	public WebElement btn_cityzip(){
		return  btn_cityzip;
	}
	public WebElement txt_PhoneNumber(){
		return  txt_PhoneNumber;
	}
	public WebElement btn_btnCreateAccount(){
		return  btn_btnCreateAccount;
	}
	public WebElement btn_btnCreateAnotherAccount(){
		return  btn_btnCreateAnotherAccount;
	}
	
	public WebElement rdo_nomatch(){
		return  rdo_nomatch;
	}
	public WebElement btn_continue(){
		return  btn_continue;
	}
	public WebElement btn_accountoptions(){
		return  btn_accountoptions;
	}
	public WebElement lnk_StartNewCopy(){
		return  lnk_StartNewCopy;
	}
	
	public WebElement btn_ok(){
		return  btn_ok;
	}
	
}
