package Javapages;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
public class addPlace_Javacode extends API_payload{
		String response;
		SessionFilter session=new SessionFilter();
	public void addplace(){
		RestAssured.baseURI="https://rahulshettyacademy.com";
		//SessionFilter session=new SessionFilter();
		 response=given().queryParam("key","qaclick123").body(postpayload())
		.when().filter(session).post("/maps/api/place/add/json")
		.then().assertThat().statusCode(200).extract().asString();
		System.out.println(session);
	}
	public void validateResponse(){
		JsonPath js=new JsonPath(response);
		System.out.println(response);
		System.out.println(js.getString("place_id"));
		System.out.println("Session id is :"+session);
	}
}
