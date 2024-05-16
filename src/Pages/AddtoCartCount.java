package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddtoCartCount {
		static WebDriver dr;
		
		public AddtoCartCount(WebDriver dr)
		{
			this.dr = dr;
			
		}
		public void ProductName() 
		{
	        WebElement productname = dr.findElement(By.xpath("//*[@id=\"mini-cart\"]/li/div/div/strong/a"));
	        productname.getText();
		}
		public void ClickAddtoCart() 
		{
	        WebElement AddtoCartButton = dr.findElement(By.xpath("//a[@class='action showcart']"));
	        AddtoCartButton.click();
		}
		public String getCartItemCount()
		{
			String count = dr.findElement(By.xpath("//span[@class='count']")).getText();
			return count;
		}

}
