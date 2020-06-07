package pojo;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import java.util.ArrayList;
public class AddPlace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		AddPlacePojoClass addplace=new AddPlacePojoClass();
		addplace.setAccuracy(50);
		addplace.setAddress("29, side layout, cohen 09");
		addplace.setLanguage("English");
		addplace.setName("Frontline house");
		addplace.setPhone_number("8124982298");
		addplace.setWebsite("http://google.com");
		LocationPojo l=new LocationPojo();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		addplace.setLocation(l);
		ArrayList<String> types=new ArrayList<String>();
		types.add("shoe park");
		types.add("shop");
		addplace.setTypes(types);
		
		
		AddPlaceDeserialize response=given().queryParam("key","qaclick123").body(addplace)
		.when().post("/maps/api/place/add/json")
		.then().extract().as(AddPlaceDeserialize.class);
		//System.out.println("ID :"+response.getId());
		//System.out.println("Place_ID:"+response.getPlace_id());
		//System.out.println("Reference :"+response.getReference());
		//System.out.println("Scope :"+response.getScope());
		//System.out.println("Status :"+response.getStatus());
		
		
		String response1=given().log().all().queryParam("key","qaclick123").queryParam("place_id",response.getPlace_id())
		.when().get("/maps/api/place/get/json").then().extract().asString();
		
		System.out.println(response1);
	}

}
