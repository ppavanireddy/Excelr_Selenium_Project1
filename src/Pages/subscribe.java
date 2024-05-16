package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class subscribe {
	static WebDriver dr;
	public subscribe(WebDriver dr)
	{
		this.dr = dr;
	}
	public void link()
	{
		WebElement Link = dr.findElement(By.xpath("/html/body/div[2]/footer/div/div/div/ul/li[4]/a"));
		Link.click();
	}
	public void email()
	{
		WebElement Email = dr.findElement(By.xpath("//*[@id=\"mce-EMAIL\"]"));
		Email.click();
	}
	public void button()
	{
		WebElement Button = dr.findElement(By.xpath("//*[@id=\"mc-embedded-subscribe\"]"));
		Button.click();
	}

}
