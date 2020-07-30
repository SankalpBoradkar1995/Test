package Weather_check_Test_Cases;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import Weather_check_Base.Base_Class;
import Weather_check_Elements.HomePage_Elements;
import Weather_check_Elements.Weather_Page;
import Weather_check_Utilities.Utilities;

public class StartUpCheck extends Base_Class 
{
	@Test(priority=1)
	public void WeatherPageNavigation() throws Exception 
	{
		System.out.println("Browser initilized");

		// Initializing home page elements from HomePage_Elements class

		HomePage_Elements HomePage_Elements_Elements = new HomePage_Elements(driver);

		// Accessing the initialized element from HomePage_Elements class

		WebElement NextPane = HomePage_Elements_Elements.SubMenu;

		WebElement Weather = HomePage_Elements_Elements.Weather;

		/* Allowing the update permission on home page using Permission() method of
		 HomePage_Elements class*/

		HomePage_Elements_Elements.Permission();

		// Clicking button to expand the pane

		HomePage_Elements.clickOperations(NextPane);

		// Clicking weather option from next pane

		HomePage_Elements.clickOperations(Weather);

		// Fetching the expected page's title using custom PageTitle() method

		String title = Utilities.PageTitle();

		System.out.println(title);
	}
	
	@Test(dependsOnMethods={"WeatherPageNavigation"},priority=2)
	
	public void WeatherCheck()
	{
		// Initializing elements of Weather_Page class
		
		Weather_Page Weather_PageObj = new Weather_Page(driver);
		
		// Fetching all the available cities from the Pin Your city option on the Weather page
		
		Weather_PageObj.City_DD();
		
		// Adding randomly picked city to search box and checking the weather details
		
		WebElement cityField = Weather_PageObj.CityInputBox;
		
		Weather_PageObj.clickOperations(cityField);
		
		// Selecting city and checking its details on map
		
		Weather_PageObj.cityDetails();
	}
}
