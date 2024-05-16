package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyOrders {
	static WebDriver dr;
	public MyOrders(WebDriver dr)
	{
		this.dr = dr;
		
	}

	
	public void url()
	{
		dr.get("https://magento.softwaretestingboard.com/customer/account/index/");
		
	}
	public void button()
	{
		WebElement Button = dr.findElement(By.xpath("//div[@class='panel header']//button[@type='button']"));
		Button.click();
	}
	public void MyAccount()
	{
		WebElement myaccount = dr.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/div/ul/li[1]/a"));
		myaccount.click();
	}
	public void MyOrders()
	{
		WebElement myorders = dr.findElement(By.xpath("//*[@id=\"block-collapsible-nav\"]/ul/li[2]/a"));
		myorders.click();
	}

}
