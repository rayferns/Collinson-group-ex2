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
    
    @Given("^a city bike exist within a company$")
    public void GetEndpoint(){
           request = given().header("Accept", "application/json");
    }

    @When("^a user retrieves the city by location$")
    public void a_user_retrieves_the_city_by_location(){
		response = request.when().get(ENDPOINT_GET_CITYBIKES_BY_COUNTRIES);
		System.out.println("response: " + response.prettyPrint());
    }

	@Then("^the status code is (\\d+)$")
	public void verify_status_code(int statusCode){
		json = response.then().statusCode(statusCode);
	}
	@And("^response includes the following$")
	public void response_equals(Map<String,String> responseFields){
		for (Map.Entry<String, String> field : responseFields.entrySet()) {
			if(StringUtils.isNumeric(field.getValue())){
				json.body(field.getKey(), equalTo(Integer.parseInt(field.getValue())));
			}
			else{
				json.body(field.getKey(), equalTo(field.getValue()));
			}
		}
    }
    
	@And("^response includes the following in any order$")
	public void response_contains_in_any_order(Map<String,String> responseFields){
		for (Map.Entry<String, String> field : responseFields.entrySet()) {
			if(StringUtils.isNumeric(field.getValue())){
				json.body(field.getKey(), containsInAnyOrder(Integer.parseInt(field.getValue())));
			}
			else{
				json.body(field.getKey(), containsInAnyOrder(field.getValue()));
			}
		}
	}
}