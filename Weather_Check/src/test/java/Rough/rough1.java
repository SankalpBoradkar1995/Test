package Rough;

import java.util.Random;

import Weather_check_Base.Base_Class;
import Weather_check_Elements.Weather_Page;

public class rough1 extends Base_Class
{
	public static void main(String a[])
	{
		String one="I have keyword";
		
		String two = "keyword";
		
		if(one.toLowerCase().contains(two.toLowerCase()))
		{
			System.out.println("Keyword matches");
		}
		else
		{
			System.out.println("Keyword doesnt match");
		}
		
		Weather_Page Weather_Page_Obj = new Weather_Page(driver);
		
		String newData = Weather_Page_Obj.elements;
		
		String[] arrSplit = newData.split("\\r?\\n");
		
		System.out.println(arrSplit.length);
		
		Random random = new Random(arrSplit.length);
		
		int randomDDValue = random.nextInt();
		
		String RandomCity = arrSplit[randomDDValue];
		
		System.out.println(RandomCity);
	}
}
