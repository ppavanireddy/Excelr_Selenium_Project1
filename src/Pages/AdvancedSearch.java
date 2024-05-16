package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdvancedSearch {
	static WebDriver dr;
	public AdvancedSearch(WebDriver dr)
	{
		this.dr = dr;
		
	}
	public void Advancedsearch()
	{
		WebElement advanced = dr.findElement(By.xpath("/html/body/div[2]/footer/div/ul/li[3]/a"));
		advanced.click();
	}
	public void product(String p)
	{
		WebElement Product = dr.findElement(By.xpath("//*[@id=\"name\"]"));
		Product.sendKeys(p);
	}
	public void search()
	{
		WebElement Search = dr.findElement(By.xpath("//*[@id=\"form-validate\"]/div/div/button"));
		Search.click();
	}

}
