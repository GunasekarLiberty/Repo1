/*
 * Copyright (C) 2017, Liberty Mutual Group
 *
 * Created on Jul 11, 2017
 */

package com.copyaccount.page;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Set;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.coppyaccount.repository.accountcreation;
import com.coppyaccount.repository.copyaccount_repository;
import com.coppyaccount.repository.eCliq_ReferralDesktop;
import com.coppyaccount.repository.eCliq_account_rating_repository;
import com.coppyaccount.repository.ecliq_accountdetails_repository;
import com.coppyaccount.repository.ecliq_login_repository;
import com.coppyaccount.repository.generalinfo_repository;
import com.coppyaccount.repository.globalnavigation_repository;
import com.coppyaccount.repository.resulting_pricing_repository;
import BasePackage.BaseFramework;


public class ecliq_login extends BaseFramework{
	
	public static int row;
	public static int rownum;
	public static int cellnum;
	public static String newaccountnum;
	public static int newaccountcount=-1;
	public static String status;
	public static String DataSheetPath;
	public static Logger log=LogManager.getLogger(ecliq_login.class.getName());
	
		public ecliq_login(String excelpath) throws Exception {
		super(excelpath);	
	}

	@Test(dataProvider="SourceAccount")
	public void login(String sourceaccount) throws IOException, InterruptedException, Exception{
	log.info("1234");
	log.error("abcd");
	log.fatal("qwert");
			
		
		
//Data sheet file location		
		FileInputStream fis=new FileInputStream("src/main/resources/input.properties");
		Properties prop=new Properties();
		prop.load(fis);
		DataSheetPath=prop.getProperty("Source_sheet_Path");
		System.out.println("Data sheetpath"+DataSheetPath);
		
		BaseFramework read=new BaseFramework(DataSheetPath);

//Accessing driver from Base class
		driver=InitializeDriver();
		ecliq_login_repository loginpage=new ecliq_login_repository(driver);
		driver.manage().window().maximize();
		
//Login	
		
		String username=read.DatafromExcel("eCliq",1,1);
		String password=read.DatafromExcel("eCliq",2,1);
		String url=read.DatafromExcel("eCliq",0,1);
		driver.get(url);
		WaitForEnter(driver,loginpage.email(),username);
		WaitForEnter(driver,loginpage.password(),password);
		WaitForClick(driver,loginpage.btn_login());
		WaitForClick(driver,loginpage.lnk_disablevalidation());
	
	
		
		if(url.contains("https://test-b-eclps")){
			System.out.println("Selected Region : Test B");
	log.info("Select Region: B");
	log.error("B Region");
	
			loginpage.chk_validationratedatedisable().click();
			loginpage.chk_allowRateDateOverride().click();
			loginpage.chk_overrideAQSValidation().click();
			loginpage.chk_overrideLossesDateValidation().click();
			//loginpage.chk_disableclearance().click();
		}else if (url.contains("https://stage-eclps")){
			System.out.println("Selected Region : Stage");
			loginpage.chk_validationratedatedisable().click();
			loginpage.chk_allowRateDateOverride().click();
			loginpage.chk_overrideAQSValidation().click();
			loginpage.chk_disableclearance().click();
			loginpage.chk_overrideLossesDateValidation().click();
			
		}else if (url.contains("https://test-eclps")){
			System.out.println("Selected Region : Test A");
			loginpage.chk_validationratedatedisable().click();
			loginpage.chk_allowRateDateOverride().click();
			loginpage.chk_overrideAQSValidation().click();
			loginpage.chk_disableclearance().click();
			loginpage.chk_overrideLossesDateValidation().click();
		}

		WaitForClick(driver,loginpage.lnk_ReturntoMainMenu());
			
		ecliq_accountdetails_repository ac=new ecliq_accountdetails_repository(driver);
		resulting_pricing_repository pricing=new resulting_pricing_repository(driver);
		
	/*
	 * Searching an given account and getting account details
	 * 	
	 */
		
		String existingaccount1=sourceaccount;
		String policynum = null;
		String quotenum = null;
		System.out.println("Source Account#:"+existingaccount1);
		
			WaitForAccountEnter(driver,ac.txt_txtaccountnumber(),existingaccount1);
			WaitForClick(driver,ac.btn_accountSearch());
			Thread.sleep(10000);
//			WebElement status1=driver.findElement(By.xpath("//*[@id='policyDataTable']/tbody/tr/td[4]"));
//			String one=status1.getText();
			//System.out.println(one);
			policynum=ac.lbl_policycount().getText();
			quotenum=ac.lbl_quoteapplication_count().getText();
			
			
		
//			String alerttext=driver.switchTo().alert().getText();
//			
//			if (alerttext.contains("The account could not be opened")){
//				System.out.println("Please Make sure source account is created in respective region");
//				System.exit(0);
//			
//		}

		
//		String policynum=ac.lbl_policycount().getText();
//		String quotenum=ac.lbl_quoteapplication_count().getText();
		
		if(!policynum.equals("(0)")) {
			WaitForClick(driver,ac.lnk_lobname());
			WaitForClick(driver,ac.lnk_viewhistory());
			WaitForClick(driver,ac.lnk_transaction());
		}
		else if(!quotenum.equals("(0)")){
			
			System.out.println("Account was rated but not issued");
			WaitForClick(driver,ac.lnk_quotenumber());
			WaitForClick(driver,ac.lnk_quoteidversion());
						
		}else{
			System.out.println(" Account is not Rated or Issued. Please Rate and try again...");
			return;
		}
	    
	    WaitForClick(driver,ac.lnk_readonly());
		WaitForClick(driver,pricing.lnk_generalinfo());       		 
		generalinfo_repository geneinfo=new generalinfo_repository(driver);

//Getting existing account details and stored into string	
		
		String fullagency=geneinfo.txt_agency().getAttribute("value");
		
		System.out.println("Existing Agent:"+fullagency);
		String insuredname=geneinfo.txt_txtInsuredName().getAttribute("value");
		System.out.println("InsuredName:"+insuredname);
		String addressdetails=geneinfo.txt_txtMailingAddress().getAttribute("value");
		System.out.println("Address:"+addressdetails);
		String phonenum=geneinfo.txt_txtInsuredPhone().getAttribute("value");

//Split Agency, zip code,state and address	
		String s=addressdetails.replace(","," ");
		String citysplit[]=addressdetails.split(",");
		String s2=s.replace("  "," ");
		String a[]=s2.split(" ");
		
		String agencysplit[]=fullagency.split(" ");
		String agency=agencysplit[0];
		
		String zip = null;
		String state=null;
		String city=null;
		String address=null;
		
//ZIP Code	
			for(int i=0;i<1;i++){
				zip=(a[a.length-1]+"");
				System.out.println("ZIP: "+zip);
			}
//State
			for(int i=0;i<1;i++){
				state=(a[a.length-2]+"");
				System.out.println("State: "+ state);
			}
		
		globalnavigation_repository global=new globalnavigation_repository(driver);
		WaitForClick(driver,global.lnk_mainmenu());
		
	/*
	 * Creating new account with existing account's details	
	 * 
	 */
		
		accountcreation newaccount=new accountcreation(driver);
		WaitForClick(driver,newaccount.btn_createaccount());
		WaitForEnter(driver,newaccount.txt_agencySearchValue(),agency);
		WaitForClick(driver,newaccount.rdo_aia());
		WaitForClick(driver,newaccount.btn_search());
		Select agencylist=new Select(newaccount.ddl_agency());
		agencylist.selectByValue(agency);
		WaitForEnter(driver,newaccount.txt_insuredname(),insuredname);
				
		WaitForEnter(driver,newaccount.txt_zip(),zip);
		WaitForEnter(driver,newaccount.txt_state(),state);
		
		for(int i=0;i<1;i++){
			newaccount.txt_txtMailingCity().sendKeys(citysplit[1]);	
		}
			
		for(int i=0;i<a.length-3;i++){
				 newaccount.txt_address().sendKeys(a[i]+" ");	
			}
		
		WaitForClick(driver,newaccount.btn_cityzip());
		WaitForEnter(driver,newaccount.txt_PhoneNumber(),phonenum);
		
		WaitForClick(driver,newaccount.btn_btnCreateAccount());
				
//		try {
//			driver.switchTo().alert().accept();
//			System.out.println("Warning: Invalid Address");
//		}catch (Exception e){
//			
//		}

		WaitForClick(driver,newaccount.btn_btnCreateAnotherAccount());
		
		try {
			driver.switchTo().alert().accept();
		}catch (Exception e){
			System.out.println("Create another -Alert not opened");
		}
		
		WebElement table = driver.findElement(By.xpath("//*[@id='acctResult']/div[1]/table"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        int rowcount = rows.size(); 
        int rdobtn=rowcount-1;
           
       driver.findElement(By.xpath("//*[@class='summaryTable']/tbody/tr["+rdobtn+"]/td//*[@id='rdbOpenAccount']")).click();
       WaitForClick(driver,newaccount.btn_continue());  
       WaitForClick(driver,newaccount.btn_accountoptions());
     
//Start New copy       
      
       
       WaitForClick(driver,newaccount.lnk_StartNewCopy());
       Set<String> windows=driver.getWindowHandles();
       Iterator<String> child=windows.iterator();
       String parent=child.next();
       String subwindow=child.next();
       driver.switchTo().window(subwindow);
       System.out.println(driver.getTitle());
       WaitForClick(driver,newaccount.btn_ok());
       driver.switchTo().window(parent);
        
       copyaccount_repository copyacc=new copyaccount_repository(driver);
       WaitForEnter(driver,copyacc.txt_accountnum(),existingaccount1);
    	Select copyreason=new Select(copyacc.ddl_reason());
    	copyreason.selectByValue("Agent");
       	WaitForClick(driver,copyacc.btn_search());
        WaitForClick(driver,copyacc.btn_startcopy());
        newaccountcount=newaccountcount+1;
        Thread.sleep(5000);
        
        String a1=ac.lbl_Newaccountnum().getText();
        
        String[] accountsplit=a1.split("-");
		newaccountnum=accountsplit[0];
		System.out.println("***New Account#: "+newaccountnum);
        
 //Page Navigation
        boolean nextbtn=copyacc.btn_next().isDisplayed();
        String pagename = null;
        boolean foundflag=false;
        int i;
        
        do{
        	try{
        		 if(nextbtn) {
        			WebElement page=copyacc.lbl_screentitle();
		       		pagename=page.getText();	
		       		System.out.println(pagename+" screen loading...");
		       		if(pagename.equalsIgnoreCase("Driver Information")){
		       			Set<String> eCliqmainWin=driver.getWindowHandles();
		       	        Iterator<String> driverwin=eCliqmainWin.iterator();
		       	        String ecliqDriver=driverwin.next();
		       	        String referralwin=driverwin.next();
		       	        driver.switchTo().window(referralwin);
		       	        WaitForClick(driver,copyacc.btn_driverscreenContinue());
		       	     driver.switchTo().window(ecliqDriver);
	       				}
		       		
		       		if(pagename.equals("Summary")){
		       				boolean nextbtn2=copyacc.btn_next2().isDisplayed();
		       				if(nextbtn2) {
		       					WaitForClick(driver,copyacc.btn_next2());
		       				}
		       			foundflag=true;	
		       			break;
		       		}
		       		WaitForClick(driver,copyacc.btn_next());
        		}
        	}catch (Exception e){
        		WaitForClick(driver,copyacc.btn_next());
        		foundflag=false;
        		
        	      	}
        	
        }while(!foundflag);
        
  		eCliq_account_rating_repository rating=new eCliq_account_rating_repository(driver);
  		
  		try{
  			WaitForClick(driver,rating.btn_view_apply_premiummodification());
  	  		WaitForClick(driver,rating.btn_rate());
  			driver.switchTo().alert().accept();
  		}catch(Exception e){
			}
 
  //Rating
 		
  		String issuetype=read.DatafromExcel("eCliq",4,1).toLowerCase();
  		System.out.println("Selected Issue Type:"+issuetype);
  		BaseFramework b=new BaseFramework(DataSheetPath);
  		switch (issuetype){
  		
  		case "refer to underwriting for review":
  			
  			WaitForClick(driver,pricing.btn_RefertoUnderwritingforReview());
  			WaitForClick(driver,pricing.btn_RefertoUnderwritingforReview());
  			//driver.switchTo().alert().accept();
  	  		WaitForClick(driver,ac.lnk_PendingPolicynum());
  	  		ReferralDesktopclear(newaccountnum);
  	  		
  	  		WaitForClick(driver,ac.lnk_PendingPolicynum());
  	  		WaitForClick(driver,ac.lnk_quoteidversion());
  	  		WaitForClick(driver,ac.lnk_UpdateorIssue());
  	  		WaitForClick(driver,pricing.chk_chkEffectiveDate());
  	  		WaitForClick(driver,pricing.btn_issue());
  	  		
  	  	boolean Issue_foundflag=false;
	  		
	  		do{
	  		
	  			try{
	  				String PageTitle=driver.getTitle();
	  				if (PageTitle.contains("Policy Delivery Preference")){
	  					Issue_foundflag=true;
	  					break;
	  				}
	  				
	  				if (PageTitle.contains("Contact Information")){
	  					WaitForClick(driver,pricing.chk_AccountingSameAsPrimary());
	  					WaitForClick(driver,pricing.chk_InspectionSameAsPrimary());
	  					WaitForClick(driver,copyacc.btn_ContactInfoNEXT());
	  				}
	  			
	  				}catch (Exception e){
	  				
					Issue_foundflag=true;
				 }
	  		}while(!Issue_foundflag);
  	  		IssuePolicy(newaccountnum);
  	  		
  	  		
  	  		read.SetAccountnumber("Accounts", newaccountcount, 4, status);
  	  		b.SetAccountnumber("Accounts", newaccountcount, 2, "NewAccount");
  	  		b.SetAccountnumber("Accounts", newaccountcount, 3, newaccountnum);
  	  		b.SetAccountnumber("Accounts", newaccountcount, 4, "Issued");
  	  	
  	  		//driver.close();
  	  		break;
  			
  		case "no":
  			System.out.println("Account is not issued");
  			b.SetAccountnumber("Accounts", newaccountcount, 2, "NewAccount");
  	  		b.SetAccountnumber("Accounts", newaccountcount, 3, newaccountnum);
  	  		b.SetAccountnumber("Accounts", newaccountcount, 4, "Saved");
  			driver.close();
  			break;
  			
  		case "submit to issue - subject to underwriting review":
  			WaitForClick(driver,pricing.chk_chkEffectiveDate());
  	  		WaitForClick(driver,pricing.btn_issue());
  	  		
  	  	boolean Issue_foundflag1=false;
  	  		
  	  		do{

  	  				try{
  	  					WaitForClick(driver,pricing.chk_AccountingSameAsPrimary());
  	  					WaitForClick(driver,pricing.chk_InspectionSameAsPrimary());
  	  					WaitForClick(driver,copyacc.btn_ContactInfoNEXT());
  	  					
  	  					Issue_foundflag1=true;	
  	  				}catch(Exception e){
  	  					Issue_foundflag1=true;
  	  					
  	  					break;
  	  				}
  	  				

  	  		}while(!Issue_foundflag1);
  	  		
  	  		IssuePolicy(newaccountnum);
  	  		ReferralDesktopclear(newaccountnum);
  	  		b.SetAccountnumber("Accounts", newaccountcount, 2, "NewAccount");
	  		b.SetAccountnumber("Accounts", newaccountcount, 3, newaccountnum);
	  		b.SetAccountnumber("Accounts", newaccountcount, 4, "Issued");
  	  		driver.close();
  		default :
  			//System.out.println(issuetype+ " Please enter valid Issue Type");
  		}
  } 
	
 /*
  * Capturing policy number in data sheet   
  */
//	@AfterMethod
//	public void setaccount() throws Exception{
//		System.out.println("After done "+newaccountcount);
//		BaseFramework b=new BaseFramework(DataSheetPath);
//		b.SetAccountnumber("Accounts", newaccountcount, 2, "NewAccount");
//		b.SetAccountnumber("Accounts", newaccountcount, 3, newaccountnum);
//		System.out.println("After"+newaccountnum);
//	}

	private void WaitForClick(WebDriver driver,WebElement Str) throws Exception 
	{
		WebDriverWait wait=new WebDriverWait(driver, 60);
			try{
				wait.until(ExpectedConditions.visibilityOf(Str)).click();
					}catch (Exception e){
						
						if(driver.findElement(By.xpath("//*[@id='unexpected-system-error-section']/header")).isDisplayed()){
							System.out.println("Error Screen");
						}else{
						//System.out.println("Button or Link not visible for click");	
						String popup=driver.switchTo().alert().getText();
						//System.out.println(popup);
						if((popup.contains("Click 'OK'"))|| (popup.contains("One or more"))){
								Thread.sleep(1000);
								if(popup.contains("One or more")){
									driver.switchTo().alert().accept();
									errorfield(driver,Str);
								}else{
									driver.switchTo().alert().accept();
								}
						}else{
							driver.switchTo().alert().accept();
							wait.until(ExpectedConditions.visibilityOf(Str)).click();
						}
				}}
	}
	
	private void WaitForEnter(WebDriver driver,WebElement Str,String input) {
		WebDriverWait wait=new WebDriverWait(driver, 60);
		try{
			
				wait.until(ExpectedConditions.visibilityOf(Str)).sendKeys(input);
			}catch (Exception e){
				wait.until(ExpectedConditions.visibilityOf(Str)).sendKeys(input);
						System.out.println("Unable to enter text " );
			}
		}
	
	private void WaitForAccountEnter(WebDriver driver,WebElement Str,String existingaccount1) throws InterruptedException {
		try{
			WebDriverWait wait=new WebDriverWait(driver, 60);
				wait.until(ExpectedConditions.visibilityOf(Str)).sendKeys(existingaccount1);
					}catch (Exception e){
//						System.out.println("Unable to enter text "+ existingaccount1 );
//						System.out.println("Button or Link not visible for click");
						String popup=driver.switchTo().alert().getText();
						System.out.println(popup);
						if((popup.contains("Click 'OK'"))|| (popup.contains("One or more"))){
							for(int k=0;k<2;k++){
								Thread.sleep(2000);
								String expectedpop=driver.switchTo().alert().getText();
								Thread.sleep(2000);
								if(expectedpop.contains("One or more")){
									driver.switchTo().alert().accept();
									
									errorfield(driver,Str);
									break;
								}else{
									driver.switchTo().alert().accept();
								}
							}
							
						}
					}
		}

	/*
	 * Handling unfilled/unselected radio button,drop down and Test boxes while page navigating
	 * 
	 */
	private void errorfield(WebDriver driver,WebElement str){
		String radioErrorTag = null ;
		String radioErrorVal=null;
		String ErrorTag=null;
		 
		try{
			
			ErrorTag=driver.findElement(By.xpath("//*[contains(@class,'Required  error') or contains(@class,'required error') or contains(@class,'REQUIRED error') and contains(@value,'No')]")).getTagName();
			String ErrorId=driver.findElement(By.xpath("//*[contains(@class,'Required  error') or contains(@class,'required error') or contains(@class,'REQUIRED error') and contains(@value,'No')]")).getAttribute("id");
			//radioErrorTag=driver.findElement(By.xpath("//*[contains(@class,'REQUIRED error') and contains(@value,'No')]")).getTagName();
			//radioErrorVal=driver.findElement(By.xpath("//*[contains(@class,'REQUIRED error') and contains(@value,'No')]")).getAttribute("value");
			//*[contains(@class,'REQUIRED error') and contains(@value,'No')]
			if((ErrorTag.equalsIgnoreCase("input"))&&(!ErrorId.contains("txt"))){
				radioErrorVal=driver.findElement(By.xpath("//*[(contains(@class,'REQUIRED error') or contains(@class,'error') )and contains(@value,'No')]")).getAttribute("value");
			}
			
//			System.out.println("Error Radio Tag:@@"+radioErrorTag);
//			System.out.println("Error Radio ID:@@"+radioErrorVal);
//			System.out.println("Error Tag:@@"+ErrorTag);
//			System.out.println("Error ID:@@"+ErrorId);
			
			if(ErrorTag.equalsIgnoreCase("input")&&(ErrorId.contains("txtGeo"))){
				driver.findElement(By.xpath("//*[@id='lookupGeocode1']")).click();
				Set<String> windows=driver.getWindowHandles();
			    Iterator<String> child=windows.iterator();
			    String parent=child.next();
			    String subwindow=child.next();
			    driver.switchTo().window(subwindow);
			    driver.findElement(By.xpath("//input[@name='geoHazardCode']")).click();
			    driver.findElement(By.xpath("//button[@id='btnSubmit']")).click();
			    driver.switchTo().window(parent);
				
			}else if ((ErrorTag.equalsIgnoreCase("input"))&&(ErrorId.contains("txt"))){
				driver.findElement(By.xpath("//*[contains(@class,'Required  error') or contains(@class,'required error')]")).sendKeys("Test");
				
			}else if (ErrorTag.equalsIgnoreCase("select")){
				Select errorcmb=new Select(driver.findElement(By.id(ErrorId)));
				errorcmb.selectByIndex(1);
			} else if ((ErrorTag.equalsIgnoreCase("input"))&&(radioErrorVal.equalsIgnoreCase("no"))){
				//System.out.println("Radio Button Handled");
				 driver.findElement(By.xpath("//*[(contains(@class,'REQUIRED error') or contains(@class,'error') )and contains(@value,'No')]")).click();
			}
			
		}catch(Exception e){
			if ((ErrorTag.equalsIgnoreCase("input"))&&(radioErrorVal.contains("No"))){
				
				 driver.findElement(By.xpath("//*[contains(@class,'REQUIRED error') and contains(@value,'No')]")).click();
			}
		}
	} 
/*
 * Referral clearence  
 * 	
 */
	private void ReferralDesktopclear(String sr) throws Exception{
		eCliq_ReferralDesktop referral=new eCliq_ReferralDesktop(driver);
		
  		WaitForClick(driver,referral.lnk_EnhancedReferralDesktop());
  		//System.out.println("Window Title: "+driver.getTitle());
  		
  		Set<String> eCliqmainWin=driver.getWindowHandles();
        Iterator<String> referralwindow=eCliqmainWin.iterator();
        String ecliq=referralwindow.next();
        String referralwin=referralwindow.next();
        driver.switchTo().window(referralwin);
         
        System.out.println(driver.getTitle());
  		System.out.println("Window Title:"+driver.getTitle());
  		driver.findElement(By.partialLinkText(newaccountnum)).click();
  		WaitForClick(driver,referral.btn_ManageReferrals());
  		
		boolean referralflag=false;
  		do{
  			try{
  				
  				 boolean completeprocessing=referral.btn_completeProcessing().isDisplayed();
  				 if(completeprocessing){
  					referral.btn_completeProcessing().click();
  					try{
  						driver.switchTo().alert().accept();
  					}catch(Exception e){
  						
  					}
  					
  					Thread.sleep(10000);
  					String referrastatus=driver.findElement(By.xpath("//*[@id='UW_DISPOSITION']")).getText();
  					System.out.println("Referral status: "+referrastatus);
  					driver.close();
  					driver.switchTo().window(ecliq);
  					driver.navigate().refresh();
  					referralflag=true;
  				 }
  			}catch (Exception e){
  				WebElement Referraltable = driver.findElement(By.xpath("//*[@id='manage_referrals']"));
  				List<WebElement> Referralrows = Referraltable.findElements(By.xpath("//a[contains(@id,'check')]"));
  				List<WebElement> comment=Referraltable.findElements(By.xpath("//*[contains(@id,'lobReferralItemComment')]"));
  				List<WebElement> override=Referraltable.findElements(By.xpath("//*[contains(@id,'OverrideButton')]"));
  				 
  				int check=Referralrows.size();
  				int commentbox=comment.size();
  				int overridebtn=override.size();
  				
//  				System.out.println("Totalcheck:"+check);
//  				System.out.println("Totalcomment:"+commentbox);
//  				System.out.println("Totalcomment:"+overridebtn);
  			if(overridebtn!=0){
  					for(int k=1;k<=overridebtn;k++){
  					driver.findElement(By.xpath("//*[@id='checkAll"+k+"']")).click();
  					driver.findElement(By.xpath("//*[@id='lobReferralItemComment"+k+"']")).sendKeys("Test");
  					driver.findElement(By.xpath("//*[@id='OverrideButton"+k+"']")).click();
  					Thread.sleep(5000);
  					}
  				referralflag=false;
  			}else{
  				referralflag=false;
  				break;
  			}
  			}
  			
  		}while(!referralflag);
	}
	
	/*
	 * Issuing policy
	 */
	private void IssuePolicy(String sr) throws Exception{
		
		ecliq_accountdetails_repository ac=new ecliq_accountdetails_repository(driver);
		resulting_pricing_repository pricing=new resulting_pricing_repository(driver);
		copyaccount_repository copyacc=new copyaccount_repository(driver);
		
		try{
			
		}catch(Exception e){
			
		}
		
		WaitForClick(driver,copyacc.btn_PolicyDeliveryPrefNEXT());
  		WaitForClick(driver,copyacc.btn_CreateNewBilling());
  	
  		WaitForClick(driver,copyacc.btn_Continue());
  		WaitForClick(driver,copyacc.rdo_accountNumber());
	  	WaitForClick(driver,copyacc.btn_SubmitUsingExisting());
	  	WaitForClick(driver,copyacc.btn_IssueWithoutDownPayment());
  			
	}
	
	@DataProvider(name="SourceAccount")
	public Object[][] getacc() throws Exception{
		FileInputStream fis=new FileInputStream("src/main/resources/input.properties");
		Properties prop=new Properties();
		prop.load(fis);
		DataSheetPath=prop.getProperty("Source_sheet_Path");
		
		BaseFramework b=new BaseFramework(DataSheetPath);
		row=b.getAccountCount("Accounts",1);
		System.out.println("Total account: "+row);
		Object[][] data=new Object[row][1];
		for(rownum=0;rownum<row;rownum++){
				data[rownum][0]=b.AccountfromExcel("Accounts",rownum,1);
							}
			return data;
		}
	 
	}

