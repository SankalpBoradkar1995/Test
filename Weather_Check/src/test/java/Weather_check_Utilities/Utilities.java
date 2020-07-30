package Weather_check_Utilities;

import Weather_check_Base.Base_Class;

public class Utilities extends Base_Class
{
	public static String PageTitle()
	{
		String title = driver.getTitle();
		
		return title;
	}
}
