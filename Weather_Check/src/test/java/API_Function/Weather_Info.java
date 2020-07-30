package API_Function;

import static io.restassured.RestAssured.given;

import org.testng.annotations.*;

import io.restassured.RestAssured;

public class Weather_Info 
{
	@Test
	public void cityTemp()
	{
		RestAssured.baseURI = "http://api.openweathermap.org";
		
		String GETResponse = given().log().all().queryParam("appid", "7fe67bf08c80ded756e598d6f8fedaea")
				.queryParam("q", "pune")
				.when().get("/data/2.5/weather")
				.then().log().all().extract().response().asString();
		
		
	}
}
