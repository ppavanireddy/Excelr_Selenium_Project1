package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Orders_Returns {
	static WebDriver dr;
	public Orders_Returns(WebDriver dr)
	{
		this.dr = dr;
		
	}
	public void orders()
	{
		WebElement Order = dr.findElement(By.xpath("//a[normalize-space()='Orders and Returns']"));
		Order.click();
	}
	public void orderid(String oi)
	{
		WebElement OrderID = dr.findElement(By.xpath("//input[@id='oar-order-id']"));
		OrderID.sendKeys(oi);
	}
	public void lastname(String ln)
	{
		WebElement LastName = dr.findElement(By.xpath("//input[@id='oar-billing-lastname']"));
		LastName.sendKeys(ln);
	}
	public void email(String e)
	{
		WebElement Email = dr.findElement(By.xpath("//*[@id=\"oar_email\"]"));
		Email.sendKeys(e);
	}
	public void Continue()
	{
		WebElement Continue = dr.findElement(By.xpath("//*[@id=\"oar-widget-orders-and-returns-form\"]/div/div/button"));
		Continue.click();
	}

}
