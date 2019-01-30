/*
 * Copyright (C) 2017, Liberty Mutual Group
 *
 * Created on Jul 17, 2017
 */

package com.coppyaccount.repository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author n0274028
 *
 */
public class ecliq_accountdetails_repository {
	
	
	WebDriver driver;
	public ecliq_accountdetails_repository(WebDriver driver){
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
	
	@FindBy(id="txtAccountNumber")
	WebElement txt_txtaccountnumber;
		
	@FindBy(xpath="//*[@id='account_number_search_container']/section/div/div/input")
	WebElement btn_accountSearch;
	
	@FindBy(xpath="//*[@id='policyDataTable']/tbody/tr/td[1]/div[1]/div/span")
	//*[@id="76683333MLN1Q11Row"]/td[1]
	WebElement lnk_lobname;
	
	@FindBy(xpath="//*[@id='ui-id-1']/strong")
	WebElement policycount;
	
	@FindBy(xpath="//*[@id='quoteCount']")
	WebElement quoteapplication_count;
	
	@FindBy(xpath="//*[@id='quoteDataTable']/tbody/tr/td")
	WebElement lnk_quotenumber;
	
	@FindBy(linkText="View History")
	WebElement lnk_viewhistory;
	    		 
	@FindBy(xpath="//*[@id='quoteparisTransactionNum0']/div[1]/div/span")
	WebElement lnk_transaction;
	
	@FindBy(xpath="//*[@id='quoteiqVersionNum0']/div[1]/div/span")
	WebElement lnk_quoteidversion;
		
	//*[@id="quoteDataTable"]/tbody/tr/td[1]
	
	@FindBy(linkText="Read Only")
	WebElement lnk_readonly;
	
	@FindBy(linkText="Update or Issue Selected Item")
	WebElement lnk_UpdateorIssue;
	
	@FindBy(xpath="//*[@id='policyDataTable']/tbody/tr/td[4]")
	WebElement lbl_Status;
	
	@FindBy(xpath="//*[@id='quoteDataTable']/tbody/tr/td[1]")
	WebElement lnk_PendingPolicynum;
	
	@FindBy(xpath="//*[contains(@class,'span3 headerValue headerCol2') and contains(@style,'word-break: break-all;')]")
			//*[@id='header']/div[2]/div/div[2]/div/div[2]/div[2]")
	//*[@id="header"]/div[3]/div/div[2]/div/div[2]/div[2]
	WebElement lbl_Newaccountnum;
	
		public WebElement txt_txtaccountnumber(){
		return txt_txtaccountnumber;
		}
		public WebElement btn_accountSearch(){
		return btn_accountSearch;
		}
	
		public WebElement lnk_lobname(){
		return lnk_lobname;
		}
		
		public WebElement lbl_policycount(){
			return policycount;
		}
		public WebElement lbl_quoteapplication_count(){
			return quoteapplication_count;
		}
		
		public WebElement lnk_viewhistory(){
			return lnk_viewhistory;
		}
		public WebElement lnk_transaction(){
			return lnk_transaction;
		}
		public WebElement lnk_readonly(){
			return lnk_readonly;
		}
		public WebElement lnk_quotenumber(){
			return lnk_quotenumber;
		}
		
		public WebElement lnk_quoteidversion(){
			return lnk_quoteidversion;
		}
		public WebElement lbl_Newaccountnum(){
			return lbl_Newaccountnum;
		}
		public WebElement lnk_UpdateorIssue(){
			return lnk_UpdateorIssue;
		}
		public WebElement lbl_Status(){
			return lbl_Status;
		}
		public WebElement lnk_PendingPolicynum(){
			return lnk_PendingPolicynum;
		}
		
		//*[@id="quoteDataTable"]/tbody/tr/td
		
		/*
		WebElement table = driver.findElement(By.xpath("//*[@id='historyTable']/tbody"));
	    List<WebElement> rows = table.findElements(By.tagName("tr"));
	     int rowcount = rows.size();
	     
	     public int rowcount(){
	 		return rowcount;
	 	} 
	    /*
	     * 
	     */

}
