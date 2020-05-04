package ready;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.Rule;
import org.junit.Test;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;
import static io.restassured.RestAssured.given;

public class ReadyTest {

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(options().port(9876));


    @Test
    public void everythingWorks() {

        given().
        when().
            get("http://localhost:9876/us/12345").
        then().
            assertThat().
            statusCode(200);
    }
}
