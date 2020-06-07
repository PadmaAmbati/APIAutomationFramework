package StepDefinitions;

import Javapages.myFirst_Javacode;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class myfirstSteps extends myFirst_Javacode{

	@Given("^launch google page$")
    public void launch_google_page() throws Throwable {
       launchGoogle();
    }

    @When("^enter search string in search box$")
    public void enter_search_string_in_search_box() throws Throwable {
        searchString();
    }

    @Then("^verify search result present$")
    public void verify_search_result_present() throws Throwable {
        verifySearchresult();
    }

    @And("^click on search button$")
    public void click_on_seearch_button() throws Throwable {
        clickSearchButton();
    }

    @And("^click on first link from the search result$")
    public void click_on_first_link_from_the_search_result() throws Throwable {
        clickOnFirstLink();
    }

	
}
