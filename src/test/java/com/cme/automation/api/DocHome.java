package com.cme.automation.api;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DocHome {
	public void login() {
		
		WebDriver driver = new ChromeDriver();
	//  Wait For Page To Load
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	// Navigate to URL
	driver.get("https://developer.here.com/documentation");
	// Maximize the window.
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

}
