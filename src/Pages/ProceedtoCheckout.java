package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProceedtoCheckout {
static WebDriver dr;
	
	public ProceedtoCheckout(WebDriver dr)
	{
		this.dr = dr;
		
	}
	public void Product()
	{
		WebElement Gear = dr.findElement(By.xpath("//*[@id=\"ui-id-6\"]/span[2]"));
		Gear.click();
	}
	public void Backpack()
	{
		WebElement backpack = dr.findElement(By.xpath("//*[@id=\"maincontent\"]/div[4]/div[1]/div[1]/div[3]/div/div/ol/li[1]"));
		backpack.click();
	}
	public void addtocart()
	{
		WebElement cart = dr.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]"));
		cart.click();
	}
	public void Checkout()
	{
		WebElement checkout = dr.findElement(By.xpath("//*[@id=\"top-cart-btn-checkout\"]"));
		checkout.click();
	}

}
