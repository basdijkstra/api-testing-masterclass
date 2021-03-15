package exercises;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import com.tngtech.java.junit.dataprovider.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.*;
import org.junit.runner.RunWith;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@RunWith(DataProviderRunner.class)
public class RestAssuredExercises2Test {

	private static RequestSpecification requestSpec;

	@Rule
	public WireMockRule wireMockRule = new WireMockRule(options().port(9876));

	@BeforeClass
	public static void createRequestSpecification() {

		requestSpec = new RequestSpecBuilder().
			setBaseUri("http://localhost").
			setPort(9876).
			build();
	}

	/*******************************************************
	 * Create a DataProvider with three test data rows:
	 * ------------------------------------
	 * country code | zip code | state
	 * ------------------------------------
	 * us           | 90210    | California
	 * us           | 12345    | New York
	 * ca           | Y1A      | Yukon
	 *
	 * Use that DataProvider to turn the three tests below
	 * into a single, data-driven test
	 ******************************************************/

	@Test
	public void checkStateForUsZipCode90210() {

		given().
			spec(requestSpec).
		when().
			get("/us/90210").
		then().
			assertThat().
			body("places[0].state", equalTo("California"));
	}

	@Test
	public void checkStateForUsZipCode12345() {

		given().
			spec(requestSpec).
		when().
			get("/us/12345").
		then().
			assertThat().
			body("places[0].state", equalTo("New York"));
	}

	@Test
	public void checkStateForCaZipCodeY1A() {

		given().
			spec(requestSpec).
		when().
			get("/ca/Y1A").
		then().
			assertThat().
			body("places[0].state", equalTo("Yukon"));
	}
}