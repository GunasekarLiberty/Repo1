import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/*
 * Copyright (C) 2017, Liberty Mutual Group
 *
 * Created on Jul 17, 2017
 */

/**
 * @author n0274028
 *
 */
public class propertfile {
	
	WebDriver driver;
	
	public propertfile(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
		
	
	
		

}
