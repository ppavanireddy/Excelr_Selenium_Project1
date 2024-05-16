package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchforInvalidProduct {
	static WebDriver dr;
	public SearchforInvalidProduct(WebDriver dr)
	{
		this.dr = dr;
		
	}
	public String msg()
	{
		WebElement Message = dr.findElement(By.xpath("//div[contains(text(),'Your search returned no results.')]"));
		return Message.getText();
		//Your search returned no results.
	}

}
