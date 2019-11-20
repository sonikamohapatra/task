package com.automation.steps;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.cme.automation.api.DocHome;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class DocStepDef {
	WebDriver driver;
	@Given("^the webpage is loaded$")
	public void the_webpage_is_loaded() throws Throwable {
		//dochomeservice.login();
		login();
	}

	private void login() {
		 driver = new ChromeDriver();
		//  Wait For Page To Load
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Navigate to URL
		driver.get("https://developer.here.com/documentation");
		// Maximize the window.
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	@Then("^validate all the links present in the webPage$")
	public void validate_all_the_links_present_in_the_webPage() throws Throwable {
		 java.util.List<WebElement> links = driver.findElements(By.tagName("a"));
		 System.out.println("Total links in the page : "+links.size());
		 
//		 for (int i = 1; i<=links.size()+1; i++)
//		 {
//		 System.out.println(links.get(i).getText());
//		 }
		 String homePage = "https://developer.here.com/documentation";
	        String url = "";
	        HttpURLConnection huc = null;
	        int respCode = 200;
		 Iterator<WebElement> it = links.iterator();
	        
	        while(it.hasNext()){
	            
	            url = it.next().getAttribute("href");
	            
	            if(url == null || url.isEmpty()){
	System.out.println("URL is either not configured for anchor tag or it is empty");
	                continue;
	            }
	            
	            if(!url.startsWith(homePage)){
	                System.out.println("URL belongs to another domain, skipping it.");
	                continue;
	            }
	            
	            try {
	                huc = (HttpURLConnection)(new URL(url).openConnection());
	                
	                huc.setRequestMethod("HEAD");
	                
	                huc.connect();
	                
	                respCode = huc.getResponseCode();
	                
	                if(respCode >= 400){
	                    System.out.println(url+" is a broken link");
	                }
	                else{
	                    System.out.println(url+" is a valid link");
	                }
	                    
	            } catch (MalformedURLException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            } catch (IOException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }
	        }
	}





}
