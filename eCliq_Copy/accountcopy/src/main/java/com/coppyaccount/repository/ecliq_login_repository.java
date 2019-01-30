package com.coppyaccount.repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ecliq_login_repository {
	
	WebDriver driver;
	public ecliq_login_repository(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
}
		
	@FindBy(name="USER")
	WebElement username;
	
	@FindBy(xpath="//input[@name='PASSWORD']")
	WebElement password;
	
	@FindBy(id="btnLogin")
	WebElement btn_login;
	
	@FindBy(linkText="Disable Validation")
	WebElement lnk_disablevalidation;
	
	@FindBy(id="validationRateDateDisable")
	WebElement chk_validationratedatedisable;
	
	@FindBy(id="allowRateDateOverride")
	WebElement chk_allowRateDateOverride;
	
	@FindBy(id="overrideAQSValidation")
	WebElement chk_overrideAQSValidation;
	
	@FindBy(id="disableClearance")
	WebElement chk_disableclearance;
	
	@FindBy(id="overrideLossesDateValidation")
	WebElement chk_overrideLossesDateValidation;	
	
	@FindBy(linkText="Return to Main Menu")
	WebElement lnk_ReturntoMainMenu;
	
	
	public WebElement email(){
		return username;
	}
	public WebElement password(){
		return password;
	}
	public WebElement btn_login(){
		return btn_login;
	}
	public WebElement lnk_disablevalidation(){
		return lnk_disablevalidation;
	}
	public WebElement chk_validationratedatedisable(){
		return chk_validationratedatedisable;
	}
	public WebElement chk_allowRateDateOverride(){
		return chk_allowRateDateOverride;
	}
	public WebElement chk_overrideAQSValidation(){
		return chk_overrideAQSValidation;
	}
	public WebElement chk_disableclearance(){
		return chk_disableclearance;
	}
	public WebElement chk_overrideLossesDateValidation(){
		return chk_overrideLossesDateValidation;
	}
	public WebElement lnk_ReturntoMainMenu(){
		return lnk_ReturntoMainMenu;
	}
	
	
}
