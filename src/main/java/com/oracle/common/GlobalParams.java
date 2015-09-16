package com.oracle.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

public final class GlobalParams {
	public static String migDc1AdminUI = "https://admin.c9qa132.oraclecorp.com/apex/f?p=5900";
	public static String SSO = "";
	public static String userName = "wenwen.hu@oracle.com";
	public static String userPwd = "Zy1206203";
	public static WebDriver webDriver;
	public static String migPayLoadUrl = "https://tascentral.c9qa132.oraclecorp.com/soa-infra/services/default/MISIMDCloudTAS!1.1*soa_c3f2eb5a-850e-4f4f-96a9-869a5c6d2352/submittotas_client_ep";
	public static void loginSSO(WebDriver driver){
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	//	driver.get("https://login-stage.oracle.com/");
	    WebElement username = driver.findElement(By.xpath("//input[@id='sso_username']"));
	    username.sendKeys("wenwen.hu@oracle.com");
	    
	    WebElement password = driver.findElement(By.xpath("//input[@id='ssopassword']"));
	    password.sendKeys("Zy1206203");
	    
	    WebElement btnLogin = driver.findElement(By.className("submit_btn"));
	    btnLogin.click();
	}
	public static WebDriver getWebDriver(String type){
		if(webDriver == null){
			if(type.equals("chrome")){
				System.setProperty("webdriver.chrome.driver",
						"D:\\resource\\chromedriver_win32\\chromedriver.exe");
				webDriver = new ChromeDriver();
			}
			else if(type.equals("firefox")){
				System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
//				FirefoxProfile profile = new FirefoxProfile();
//				profile.setPreference(FirefoxProfile.PORT_PREFERENCE, 9876);
				webDriver = new FirefoxDriver();
			}
		}
		return webDriver;
	}
	
	public static void loginCentralAdmin(WebDriver webdriver){
		webdriver.get(migDc1AdminUI);
		loginSSO(webdriver);
		try {
			webdriver.wait(5*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("未加载central Admin 页面");
			e.printStackTrace();
		}
	}
	
}
