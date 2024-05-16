package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchTerms {
	static WebDriver dr;
	public SearchTerms (WebDriver dr)
	{
		this.dr = dr;
		
	}
	public void Search()
	{
		WebElement search = dr.findElement(By.xpath("/html/body/div[2]/footer/div/ul/li[1]/a"));
		search.click();
	}
	public void ajax()
	{
		WebElement AJAX = dr.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/ul/li[4]/a"));
		AJAX.click();
	}
	

}
