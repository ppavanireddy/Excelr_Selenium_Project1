package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Review_Payment {
	static WebDriver dr;
	public Review_Payment(WebDriver dr)
	{
		this.dr = dr;
	}
	public void PlaceOrder()
	{
		WebElement placeorder = dr.findElement(By.xpath("//button[@class='action primary checkout']"));
		placeorder.click();
	}
	public String message()
	{
		WebElement success = dr.findElement(By.xpath("//span[@class=\"base\" and @data-ui-id=\"page-title-wrapper\"]"));
		return success.getText();
	}
		

}
