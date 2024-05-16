package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RemoveProduct {
	static WebDriver dr;
	
	public RemoveProduct(WebDriver dr)
	{
		this.dr = dr;
		
	}
	public void ViewCart()
	{
		WebElement viewcart = dr.findElement(By.xpath("//*[@id='minicart-content-wrapper']/div[2]/div[5]/div/a/span"));
		viewcart.click();
	}
	public void remove() 
	{
        WebElement Remove = dr.findElement(By.xpath("//*[@id=\"mini-cart\"]/li/div/div/div[3]/div[2]/a"));
        Remove.click();
	}
	public String message()
	{
		WebElement message = dr.findElement(By.xpath("//*[@id=\"minicart-content-wrapper\"]/div[2]/strong"));
		return message.getText();
	}
	public void alert()
	{
		WebElement Alert = dr.findElement(By.xpath("/html/body/div[4]/aside[2]/div[2]/footer/button[2]"));
		Alert.click();
	}
	

}
