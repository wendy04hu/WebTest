package com.oracle.test.another;

import org.openqa.selenium.WebDriver;

import com.oracle.common.GlobalParams;

/**
 * Hello world!
 *
 */
public class App 
{
	void LoginAdminUI(WebDriver webDriver){
		webDriver.get("https://admin.c9qa132.oraclecorp.com/apex/f?p=5900:2");
		GlobalParams.loginSSO(webDriver);
	}
	
    public static void main( String[] args )
    {
        //System.out.println( "Hello World!" );
    	WebDriver webDriver =GlobalParams.getWebDriver("firefox");
		App testMainObj = new App();
		testMainObj.LoginAdminUI(webDriver);
		webDriver.close();
	
    }
}
