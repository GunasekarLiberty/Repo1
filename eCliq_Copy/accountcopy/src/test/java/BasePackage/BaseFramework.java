/*
 * Copyright (C) 2017, Liberty Mutual Group
 *
 * Created on Oct 16, 2017
 */

package BasePackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.gargoylesoftware.htmlunit.javascript.host.Iterator;

/**
 * @author n0274028
 *
 */
public class BaseFramework {

	public WebDriver driver;
	XSSFWorkbook book;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	public static int totalaccount;
	public static int celltype;
	public static String DataSheetPath;

	public WebDriver InitializeDriver() throws Exception {

		FileInputStream fis = new FileInputStream("src/main/resources/input.properties");
		Properties prop = new Properties();
		prop.load(fis);
		DataSheetPath = prop.getProperty("Source_sheet_Path");

		BaseFramework read = new BaseFramework(DataSheetPath);
		String BrowserType = read.DatafromExcel("eCliq", 3, 1);

		System.out.println("Selected Browser: " + BrowserType);
		if (BrowserType.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver-2.41.exe");

			Thread.sleep(3000);
			// Actions act=new Actions(driver);

			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");
			DesiredCapabilities c = DesiredCapabilities.chrome();
			c.setCapability(ChromeOptions.CAPABILITY, options);
			driver = new ChromeDriver(c);
			System.out.println("Scripts uses INCOGNITO mode to avoid failures");

		} else if (BrowserType.equals("IE")) {
			DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			System.setProperty("webdriver.ie.driver", "src/main/resources/IEDriverServer.exe");
			driver = new InternetExplorerDriver(capabilities);
		} else {
			System.out.println("Please select a browser");
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}

	public BaseFramework(String excelpath) throws Exception {

		try {
			File path = new File(excelpath);
			FileInputStream fis = new FileInputStream(path);
			book = new XSSFWorkbook(fis);
			FileOutputStream fos = new FileOutputStream(path);
			book.write(fos);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public String DatafromExcel(String sheetname, int row, int cell) {
		sheet = book.getSheet(sheetname);
		String data = sheet.getRow(row).getCell(cell).getStringCellValue();
		return data;

	}

	public String AccountfromExcel(String sheetname, int row, int cell) {
		sheet = book.getSheet(sheetname);
		System.out.println("******" + book.isWindowsLocked());
		int account1 = 0;
		int AccountNotBlank = sheet.getRow(row).getPhysicalNumberOfCells();
		if (AccountNotBlank == 2) {
			celltype = sheet.getRow(row).getCell(cell).getCellType();

			if (sheet.getRow(row).getCell(cell).getCellType() == XSSFCell.CELL_TYPE_NUMERIC) {
				account1 = (int) sheet.getRow(row).getCell(cell).getNumericCellValue();
				System.out.println("Account#:" + account1);
				String existingaccount = Integer.toString(account1);
				int validAccount1 = existingaccount.length();
				if (validAccount1 == 8) {
					return existingaccount;
				} else {
					System.out.println("Script stops. Entered Invalid Account. An 8 digit number is required");
					System.exit(0);
				}
			} else if (sheet.getRow(row).getCell(cell).getCellType() == XSSFCell.CELL_TYPE_STRING) {
				String account = sheet.getRow(row).getCell(cell).getStringCellValue();
				System.out.println("Account#:" + account);
				int validAccount = account.length();
				if (validAccount == 8) {
					return account;
				} else {
					System.out.println("Entered Invalid Account. An 8 digit number is required");
					System.exit(0);
				}
			}
		} else if (AccountNotBlank > 2) {
			System.out.println("Script stops.Delete invalid columns in data sheet");
			System.out.println(
					"Delete invalid column(s) in **(DataSheet->Accounts(SheetName)->Delete other than columns A & B)**");
			System.exit(0);
		}
		return null;
	}

	public int getAccountCount(String sheetname, int row) {

		totalaccount = book.getSheet(sheetname).getLastRowNum();
		// System.out.println("Last cell:"+totalaccount);
		totalaccount = totalaccount + 1;
		return totalaccount;
	}

	public void SetAccountnumber(String sheetname, int row, int cell, String newaccount) throws IOException {
		File f = new File(DataSheetPath);
		FileInputStream fis = new FileInputStream(f);
		book = new XSSFWorkbook(fis);
		sheet = book.getSheet(sheetname);
		sheet.getRow(row).createCell(cell).setCellValue(newaccount);
		FileOutputStream fus = new FileOutputStream(f);
		book.write(fus);
	}
}
