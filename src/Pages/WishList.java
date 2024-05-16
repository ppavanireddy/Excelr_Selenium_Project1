package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WishList {
	static WebDriver dr;
	public WishList(WebDriver dr)
	{
		this.dr = dr;
		
	}
	public void wishlist()
	{
		WebElement list= dr.findElement(By.xpath("//*[@id=\"ui-id-4\"]"));
		list.click();
	}
	public void item()
	{
		WebElement Item = dr.findElement(By.xpath("//*[@id=\"maincontent\"]/div[4]/div[2]/div/div/ul[1]/li[1]/a"));
		Item.click();
	}
	public void Hoodies()
	{
		WebElement hoody = dr.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[1]/div"));
		hoody.click();
	}
	public void addtowishlist()
	{
		WebElement addtolist = dr.findElement(By.xpath("//a[@class='action towishlist']"));
		addtolist.click();
	}
	public String Message()
	{
		WebElement msg = dr.findElement(By.xpath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div"));
		return msg.getText();
		//Circe Hooded Ice Fleece has been added to your Wish List. Click here to continue shopping.
	}

}
