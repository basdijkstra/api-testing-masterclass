package wiremockanswers;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.*;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static io.restassured.RestAssured.given;

public class WireMockAnswers1 {

    private RequestSpecification requestSpec;

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(9876);

    @Before
    public void createRequestSpec() {

        requestSpec = new RequestSpecBuilder().
            setBaseUri("http://localhost").
            setPort(9876).
            build();
    }

    public void setupStubExercise101() {

        /************************************************
         * Create a stub that will respond to a POST
         * to /pl/80-862 with an HTTP status code 200
         ************************************************/

        stubFor(post(urlEqualTo("/pl/80-862"))
            .willReturn(aResponse()
                .withStatus(200)
            ));
    }

    public void setupStubExercise102() {

        /************************************************
         * Create a stub that will respond to a POST
         * to /pl/80-862 with a header 'Content-Type' with
         * value 'text/plain' and a response body 'Posted!'
         ************************************************/

        stubFor(post(urlEqualTo("/pl/80-862"))
            .willReturn(aResponse()
                .withHeader("Content-Type", "text/plain")
                .withBody("Posted!")
            ));
    }

    @Test
    public void testExercise101Java() {

        /***
         * Use this test to test the Java implementation of exercise 101
         */

        setupStubExercise101();

        given().
            spec(requestSpec).
        when().
            post("/pl/80-862").
        then().
            assertThat().
            statusCode(200);
    }

    @Test
    public void testExercise101Json() {

        /***
         * Use this test to test the JSON implementation of exercise 101
         */

        given().
            spec(requestSpec).
        when().
            post("/pl/80-862").
        then().
            assertThat().
            statusCode(200);
    }

    @Test
    public void testExercise102Java() {

        /***
         * Use this test to test the Java implementation of exercise 102
         */

        setupStubExercise102();

        given().
            spec(requestSpec).
        when().
            post("/pl/80-862").
        then().
            assertThat().
            contentType(ContentType.TEXT).
        and().
            body(org.hamcrest.Matchers.equalTo("Posted!"));
    }

    @Test
    public void testExercise102Json() {

        /***
         * Use this test to test the JSON implementation of exercise 102
         */

        given().
            spec(requestSpec).
        when().
            post("/pl/80-862").
        then().
            assertThat().
            contentType(ContentType.TEXT).
        and().
            body(org.hamcrest.Matchers.equalTo("Posted!"));
    }
}
