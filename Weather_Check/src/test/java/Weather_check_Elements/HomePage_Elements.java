package Weather_check_Elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage_Elements 
{
	WebDriver driver;
	
	static WebDriverWait wait;
	
	@FindBy(how=How.ID, using="h_sub_menu") public  WebElement SubMenu;
	
	@FindBy(how=How.CLASS_NAME, using="allow") private static WebElement Permission;
	
	@FindBy(how=How.XPATH, using="//*[contains(text(),'WEATHER')]") public  WebElement Weather;
	
	public HomePage_Elements(WebDriver driver)
	{
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	public void Permission()
	{
		wait = new WebDriverWait(driver,20);
		
		wait.until(ExpectedConditions.elementToBeClickable(Permission));
		
		Permission.click();
	}
	
	public static void clickOperations(WebElement element)
	{
		element.click();
	}
}


