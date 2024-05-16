package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddNewAddress {
	static WebDriver dr;
	public AddNewAddress(WebDriver dr)
	{
		this.dr = dr;
	}
	public void sale()
	{
		WebElement Sale = dr.findElement(By.xpath("//*[@id=\"ui-id-8\"]"));
		Sale.click();
	}
	public void link()
	{
		WebElement Link = dr.findElement(By.xpath("//*[@id=\"maincontent\"]/div[4]/div[1]/div[1]/div/a"));
		Link.click();
	}
	public void product()
	{
		WebElement Product = dr.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[3]/div"));
		Product.click();
	}
	public void size()
	{
		WebElement Size = dr.findElement(By.xpath("//*[@id=\"option-label-size-143-item-168\"]"));
		Size.click();
	}
	public void color()
	{
		WebElement Color = dr.findElement(By.xpath("//*[@id=\"option-label-color-93-item-60\"]"));
		Color.click();
	}
	public void addtocart()
	{
		WebElement Addtocart = dr.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]"));
		Addtocart.click();
	}
	public void button()
	{
		WebElement Button = dr.findElement(By.xpath("/html/body/div[2]/header/div[2]/div[1]/a"));
		Button.click();
	}
	public void checkout()
	{
		WebElement Proceed = dr.findElement(By.xpath("//*[@id=\"top-cart-btn-checkout\"]"));
		Proceed.click();
	}
	public void email(String e)
	{
		WebElement Email= dr.findElement(By.xpath("//*[@id=\"customer-email\"]"));
		Email.sendKeys(e);
	}
	public void pass (String p)
	{
		WebElement password = dr.findElement(By.xpath("//*[@id=\"customer-password\"]"));
		password.sendKeys(p);
	}
	public void login()
	{
		WebElement Login = dr.findElement(By.xpath("//*[@id=\"customer-email-fieldset\"]/fieldset/div[2]/div[1]/button"));
		Login.click();
	}
	public void NewAddress()
	{
		WebElement address = dr.findElement(By.xpath("//*[@id=\"checkout-step-shipping\"]/div[2]/button"));
		address.click();
	}
	
	public void ship()
	{
		WebElement ShipHere = dr.findElement(By.xpath("/html/body/div[3]/aside[2]/div[2]/footer/button[1]"));
		ShipHere.click();
	}
	public void box()
	{
		WebElement Box = dr.findElement(By.xpath("//*[@id=\"billing-address-same-as-shipping-checkmo\"]"));
		Box.click();
	}
	

}
