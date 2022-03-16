package stepdefinitions.apisteps;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.it.Ma;
import io.restassured.response.Response;
import pojos.Registrant;
import utilities.ConfigurationReader;
import java.util.HashMap;
import java.util.Map;
import static Hooks.Hooks.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static utilities.ApiUtils.getRequest;
import static utilities.ApiUtils.getRequest;
import static utilities.Authentication.generateToken;

public class US02_ApiValidationSteps {

    Response response;

    @Given("user sends get request to {string}")
    public void user_sends_get_request_to(String string) {
        spec.pathParams("first","api","second","user");
    }

    @Given("user sends the GET request and gets the response")
    public void user_sends_the_get_request_and_gets_the_response() {
        response = getRequest(generateToken(), ConfigurationReader.getProperty("api_user_by_ssn"));
        response.prettyPrint();
    }

    @Then("verify expected data equals to actual data")
    public void verify_expected_data_equals_to_actual_data() {
        Map<String,Object> expectedData = new HashMap<>();
        expectedData.put("ssn",222-03-7732);
        expectedData.put("email","hasan.husen@gmail.com");
        expectedData.put("login","hasan.husen");

        Map<String,Object> actualData = response.as(HashMap.class);
        assertEquals(expectedData.get("email"),actualData.get("email"));
        assertEquals(expectedData.get("login"),actualData.get("login"));

    }
}
