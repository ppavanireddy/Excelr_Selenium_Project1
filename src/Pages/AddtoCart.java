package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddtoCart {
	static WebDriver dr;
	
	public AddtoCart(WebDriver dr)
	{
		this.dr = dr;
	}
	public void Women()
	{
		WebElement womenProducts = dr.findElement(By.xpath("//*[@id=\"ui-id-4\"]/span[2]"));
		womenProducts.click();
	}
	public void clickProduct(String productName) 
	{
        WebElement product = dr.findElement(By.xpath("//*[@id=\"maincontent\"]/div[4]/div[1]/div[1]/div[3]/div/div/ol/li[1]/div"));
        product.click();
	}
	public void SelectSize(String Size) 
	{
        WebElement size = dr.findElement(By.xpath("//div[@class='swatch-attribute size']//div[3]"));
        size.click();
	}
	public void SelectColor(String Color) {
        WebElement color = dr.findElement(By.xpath("//div[@class='swatch-attribute color']//div[3]"));
        color.click();
	}
	public void ClickAddtoCart() 
	{
        WebElement AddtoCartButton = dr.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]"));
        AddtoCartButton.click();
	}
	public String actualMessage()
	{
		WebElement acutalmessage = dr.findElement(By.xpath("//div[@class='message-success success message']"));
		return acutalmessage.getText();
	}

}
