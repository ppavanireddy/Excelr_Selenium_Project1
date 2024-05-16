package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UpdateCart {
static WebDriver dr;
	
	public UpdateCart(WebDriver dr)
	{
		this.dr = dr;
	}
	public void edit()
	{
		WebElement Edit = dr.findElement(By.xpath("//a[@class='action edit']"));
		Edit.click();
	}
	public void Quantity(String qty)
	{
		WebElement quantity = dr.findElement(By.xpath("//*[@id=\"qty\"]"));
		quantity.sendKeys(qty);
	}
	public void updatecart()
	{
		WebElement Update = dr.findElement(By.xpath("//button[@id='product-updatecart-button']"));
		Update.click();
	}
	public String message()
	{
		WebElement Message = dr.findElement(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']"));
		return Message.getText();
	}

}
