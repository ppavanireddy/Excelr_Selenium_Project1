package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {
static WebDriver dr;
	
	public SearchPage(WebDriver dr)
	{
		this.dr = dr;
	}
	
	public void searchFor(String searchTerm) 
	{
		WebElement searchInput = dr.findElement(By.xpath("//*[@id=\"search\"]"));
		searchInput.sendKeys(searchTerm);
	}
	public void searchButton() 
	{
		WebElement searchButton= dr.findElement(By.xpath("//*[@id=\"search_mini_form\"]/div[2]/button"));
		searchButton.click();
	}
	public String[] getSearchResults() {
        List<WebElement> searchResultElements = dr.findElements(By.xpath("//div[@class='search-results']/div[contains(@class, 'product')]"));
        String[] searchResults = new String[searchResultElements.size()];

        for (int i = 0; i < searchResultElements.size(); i++) {
            searchResults[i] = searchResultElements.get(i).getText();
        }

        return searchResults;
    }

}
