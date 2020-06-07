package StepDefinitions;

import Javapages.addPlace_Javacode;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddingPlaceSteps extends addPlace_Javacode{


    @Given("^add the place by passing request URL and call the Post method$")
    public void add_the_place_by_passing_request_url_and_call_the_post_method() throws Throwable {
       addplace();
    }

    @Then("^Verify the response code and plece_id generated$")
    public void verify_the_response_code_and_pleceid_generated() throws Throwable {
       validateResponse();
    }
}
