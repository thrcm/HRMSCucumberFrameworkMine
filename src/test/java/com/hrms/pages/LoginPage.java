package com.hrms.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.hrms.testBase.BaseClass;

public class LoginPage extends BaseClass {

	public WebElement username=driver.findElement(By.xpath("//input[@id='txtUsername']"));
	public WebElement password=driver.findElement(By.id("txtPassword"));
	public WebElement loginBtn=driver.findElement(By.xpath("//input[@id='btnLogin']"));
//	public WebElement errMsg = driver.findElement(By.xpath("//span[@id='spanMessage']"));
			
}
