package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WriteReview {
	static WebDriver dr;
	public WriteReview(WebDriver dr)
	{
		this.dr = dr;
		
	}
	public void product()
	{
		WebElement Product = dr.findElement(By.xpath("//*[@id=\"maincontent\"]/div[4]/div[1]/div[1]/div[3]/div/div/ol/li[3]/div"));
		Product.click();
	}
	public void review()
	{
		WebElement Reviews = dr.findElement(By.xpath("//*[@id=\"tab-label-reviews-title\"]"));
		Reviews.click();
	}
	public void star()
	{
		WebElement rating = dr.findElement(By.xpath("//label[@id='Rating_4_label']"));
		rating.click();
	}
	public void nickname(String n)
	{
		WebElement Nickname = dr.findElement(By.xpath("//*[@id=\"nickname_field\"]"));
		Nickname.sendKeys(n);
	}
	public void summary(String s)
	{
		WebElement Summary = dr.findElement(By.xpath("//*[@id=\"summary_field\"]"));
		Summary.sendKeys(s);
	}
	public void review(String r)
	{
		WebElement Review = dr.findElement(By.xpath("//*[@id=\"review_field\"]"));
		Review.sendKeys(r);
	}
	public void submit()
	{
		WebElement Submit= dr.findElement(By.xpath("//*[@id=\"review-form\"]/div/div/button"));
		Submit.click();
	}

}
