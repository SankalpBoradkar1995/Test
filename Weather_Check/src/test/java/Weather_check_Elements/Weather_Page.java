package Weather_check_Elements;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Weather_Page 
{
	WebDriver driver;
	
	public String elements=null;
	
	String city=null;
	
	@FindBy(how=How.XPATH, using="//div[@id='messages']") private  WebElement DropDown;
	
	@FindBy(how=How.CLASS_NAME, using="searchBox") public WebElement CityInputBox;
	
	public Weather_Page(WebDriver driver)
	{
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}
	
	public void clickOperations(WebElement element )
	{
		WebDriverWait wait = new WebDriverWait(driver,20);
		
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
		element.click();
	}
	
	public void City_DD()
	{
		List<WebElement> options = driver.findElements(By.id("messages"));
		
		for(WebElement element : options)
		{
			//System.out.println(element.getText());
			
			elements = element.getText();
		}
		
		String[] arrSplit = elements.split("\\r?\\n");
		
		System.out.println("Index of split array is:"+" "+arrSplit.length);
		
		Random random = new Random();
		
		int randomIndex = random.nextInt(arrSplit.length);
		
		System.out.println("Random index from the split array is:"+" "+randomIndex);
		
		city = arrSplit[randomIndex];
		
		System.out.println("Random city for the curresponding index is:"+" "+city);
		
		/*for(int i=0; i<arrSplit.length;i++)
		{
			System.out.println(arrSplit[i]);
			
			System.out.println("break");
		}*/
	}
	
	public void cityDetails()
	{
		CityInputBox.sendKeys(city);
		
		String oldCity = city;
		
		String newCity = oldCity.substring(1);
		
		//label[contains(text(),'Pune')]
		
		String cityFirstHalf = "//label[contains(text(),'";
		
		String citySecondHalf = "')]";
		
		String CompletePinCityPath = cityFirstHalf+newCity+citySecondHalf;
		
		WebElement SearchedCity = driver.findElement(By.xpath(CompletePinCityPath));
		
		if(SearchedCity.isSelected())
		{
			System.out.println("Already selected");
			
			
		}
		else
		{
			System.out.println("Not selected");
			
			//SearchedCity.click();
		}
	}
	
	
}
