package stepdefs;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class CitybikesStepDefinitions{
    private Response response;
    private ValidatableResponse json;
    private RequestSpecification request;

    private String ENDPOINT_GET_CITYBIKES_BY_COUNTRIES = "http://api.citybik.es/v2/networks";
    
    @Given("^I Set GET posts api endpoint$")
    public void setGetEndpoint(){
        response = request.when().get(ENDPOINT_GET_CITYBIKES_BY_COUNTRIES);
        System.out.println("response: " + response.prettyPrint());
    }

    @Given("^a city bike exist within a company$") {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    });
    
    When("^a user retrieves the city by location$", () -> {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    });
    
    Then("^the status code is (\\d+)$", (Integer arg1) -> {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    });
    
    Then("^Response includes the following$", (DataTable arg1) -> {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
        // E,K,V must be a scalar (String, Integer, Date, enum etc)
        throw new PendingException();
    });
    
    Then("^response includes the following in order$", (DataTable arg1) -> {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
        // E,K,V must be a scalar (String, Integer, Date, enum etc)
        throw new PendingException();
    });
    

    

}