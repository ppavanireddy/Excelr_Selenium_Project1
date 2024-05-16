package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Checkout {
	static WebDriver dr;
	public Checkout(WebDriver dr)
	{
		this.dr = dr;
		
	}
	public void url()
	{
		dr.get("https://magento.softwaretestingboard.com/checkout/#shipping");
	}
	public void streetAddress(String Address)
	{
		WebElement streetaddress = dr.findElement(By.xpath("//input[@name='street[0]']"));
		streetaddress.sendKeys(Address);
	}
	public void city(String City)
	{
		WebElement city = dr.findElement(By.xpath("//input[@name='city']"));
		city.sendKeys(City);
	}
	public void state()
	{
	WebElement State = dr.findElement(By.xpath("//select[@name='region_id']"));
	Select sel2 = new Select(State);
	
	
	sel2.selectByVisibleText("Alaska"); 
	}
	public void code(String Postalcode)
	{
		WebElement Code = dr.findElement(By.xpath("//input[@name='postcode']"));
		Code.sendKeys(Postalcode);
	}
	public void country()
	{
	WebElement Country = dr.findElement(By.xpath("//select[@name='country_id']"));
	Select sel2 = new Select(Country);
	
	
	sel2.selectByVisibleText("Togo"); 
	}
	public void phone(String phnno)
	{
		WebElement Phone = dr.findElement(By.xpath("//input[@name='telephone']"));
		Phone.sendKeys(phnno);
	}
	public void shippingmethod()
	{
		WebElement method = dr.findElement(By.xpath("//*[@id=\"checkout-shipping-method-load\"]/table/tbody/tr[2]/td[1]/input"));
		method.click();
	}
	public void Next()
	{
		WebElement next = dr.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/div/button"));
		next.click();
	}
	
	

}
