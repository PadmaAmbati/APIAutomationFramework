package stepDefinitions;

import static io.restassured.RestAssured.given;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import static org.junit.Assert.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.AddPlaceDeserialize;
import pojo.AddPlacePojoClass;
import pojo.LocationPojo;
import resources.APIResources;
import resources.TestDataBuilder;
import resources.Utils;

public class AddPlaceSteps extends Utils{
	
	TestDataBuilder data=new TestDataBuilder();
	RequestSpecification req;
	ResponseSpecification resspec;
	Response response;
	String response_str;
	static String place_id;

	 @Given("^pass the addPlace payload with \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	    public void pass_the_addplace_payload_with_something_something_something(String name, String address, String language) throws IOException
	     {		 	  	 
		 	 
		 req=given().spec(sepcBuilders()).body(data.appplacePayload(name,address,language));
	        
	    }

	 @When("^call the \"([^\"]*)\" by using \"([^\"]*)\" method$")
	    public void call_the_something_by_using_something_method(String resource, String method) throws Throwable {
		 
		 APIResources resource_API=APIResources.valueOf(resource);
	    	System.out.println(resource_API.GetResource()); 
		 resspec=new ResponseSpecBuilder()
					.expectContentType(ContentType.JSON).build();
	    	
	    	
	    	if(method.equalsIgnoreCase("POST"))
	        response=req.when().post(resource_API.GetResource());
	    	else if(method.equalsIgnoreCase("GET"))
	    	response=req.when().get(resource_API.GetResource());
	    	
	    	System.out.println(response);
	   
	    }

	    @Then("^Verify the status code 200$")
	    public void verify_the_status_code_200() throws Throwable {
	    	assertEquals(response.getStatusCode(),200);
	        
	    }

	    @And("^Verify the \"([^\"]*)\" in the response is \"([^\"]*)\"$")
	    public void verify_the_something_in_the_response_is_something(String keyValue, String Expectedvalue) throws Throwable {
	    	 response_str=response.asString();	    	
	        assertEquals(getkeyvalue(response_str,keyValue),Expectedvalue);

	    }
	    @Then("verify place_id created maps to {string} using {string}")
	    public void verify_place_id_created_maps_to_using(String expectedname, String resource) throws Throwable {
	        // Write code here that turns the phrase above into concrete actions
	    	
	    	place_id=getkeyvalue(response.asString(),"place_id");
	    	req=given().spec(sepcBuilders()).queryParam("place_id", place_id);
	    	call_the_something_by_using_something_method(resource,"GET");
	       	assertEquals(getkeyvalue(response.asString(),"name"),expectedname);
	    	
	    }
	    @Given("^pass the DeletePlace payload$")
	    public void pass_the_deleteplace_payload() throws Throwable {
	    	
	    	req=given().spec(sepcBuilders()).body(data.deletePayload(place_id));
	    	
	    }
	    
	  
}
