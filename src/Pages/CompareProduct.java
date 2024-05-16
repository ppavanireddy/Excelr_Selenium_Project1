package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CompareProduct {
	static WebDriver dr;
	public CompareProduct(WebDriver dr)
	{
		this.dr = dr;
		
	}
	public void women()
	{
		WebElement Women = dr.findElement(By.xpath("//*[@id=\"ui-id-4\"]/span[2]"));
		Women.click();
	}
	public void item()
	{
		WebElement Shorts = dr.findElement(By.xpath("//*[@id=\"maincontent\"]/div[4]/div[2]/div[2]/div/ul[2]/li[2]/a"));
		Shorts.click();
	}
	
	public void product()
	{
		WebElement Product = dr.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[1]/div"));
		Product.click();
	}
	public void AddtoCompare()
	{
		WebElement compare = dr.findElement(By.xpath("//*[@id=\"maincontent\"]/div[2]/div/div[1]/div[5]/div/a[2]"));
		compare.click();
	}
	public String Message()
	{
		WebElement message = dr.findElement(By.xpath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div"));
		return message.getText();
		//You added product Portia Capri to the comparison list..
	}

}
