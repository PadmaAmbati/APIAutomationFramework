package stepDefinitions;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {
	
	AddPlaceSteps addplace=new AddPlaceSteps();
	@Before("@deleteplace")
	public void beforeScenario() throws Throwable{
		if(AddPlaceSteps.place_id==null){
		addplace.pass_the_addplace_payload_with_something_something_something("Padma","Chennai","Telugu");
		addplace.call_the_something_by_using_something_method("AddPlaceAPI", "POST");
		addplace.verify_place_id_created_maps_to_using("Padma", "GetPlaceAPI");
		}
	}
}
