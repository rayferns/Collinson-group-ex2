package services;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;

//import java.util.Arrays;

import org.apache.http.HttpStatus;
import org.junit.Test;


public class CitybikesTests
{
	private static String ENDPOINT_GET_CITYBIKES_BY_COUNTRIES = "http://api.citybik.es/v2/networks";

	@Test
	public void testGetByCompanies(){
		//String Company = "Nextbike GmbH";

		given().
		when().
		get(ENDPOINT_GET_CITYBIKES_BY_COUNTRIES)
		.then().
		statusCode(HttpStatus.SC_OK).
		body(	"totalItems", equalTo(1),
				"location.city", containsInAnyOrder("Frankfurt"),
				"location.country", containsInAnyOrder("DE"),
				"location.latitude", containsInAnyOrder("50.0709"),
				"location.longitude", containsInAnyOrder("8.24322"));
	}
}
