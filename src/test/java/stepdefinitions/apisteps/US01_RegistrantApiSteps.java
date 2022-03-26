package stepdefinitions.apisteps;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojos.Registrant;
import utilities.ConfigurationReader;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static utilities.ApiUtils.getRequest;
import static utilities.Authentication.generateToken;
import static utilities.WriteToTxt.saveRegistrantData;
import static Hooks.Hooks.spec;

public class US01_RegistrantApiSteps {
    Registrant registrant = new Registrant();
    Faker faker = new Faker();
    Response response;
    Registrant []registrants;

    @Given("user sets the necessary path params")
    public void user_sets_the_necessary_path_params() {

        spec.pathParams("first", "api", "second", "register");
//        RequestSpecification spec = new RequestSpecBuilder().setBaseUri("https://medunna.com").build();
//        spec.pathParams("first", "api", "second", "register");

    }

    @Given("user sets the expected data {string}, {string} {string} {string} {string} {string} and {string}")
    public void user_sets_the_expected_data_and(String firstname, String lastname, String ssn, String email, String username, String password, String lan) {
        firstname = faker.name().firstName();
        lastname = faker.name().lastName();
        ssn = faker.idNumber().ssnValid();
        email = faker.internet().emailAddress();
        username = faker.name().username();
        password = faker.internet().password(8, 15, true, true);
        registrant.setFirstName(firstname);
        registrant.setLastName(lastname);
        registrant.setSsn(ssn);
        registrant.setEmail(email);
        registrant.setLogin(username);
        registrant.setPassword(password);
        registrant.setLangKey(lan);
    }

    @Given("user sends the POST request and gets the response")
    public void user_sends_the_post_request_and_gets_the_response() {
//        RequestSpecification spec = new RequestSpecBuilder().setBaseUri("https://medunna.com").build();
//        spec.pathParams("first", "api", "second", "register");
        response = given().spec(spec).contentType(ContentType.JSON).body(registrant).when().post("/{first}/{second}");
    }

    @When("user saves the api records to correspondent files")
    public void user_saves_the_api_records_to_correspondent_files() {
        saveRegistrantData(registrant);
    }

    @Then("user validates api records")
    public void user_validates_api_records() throws Exception {
        response.then().statusCode(201);
        response.prettyPrint();

        ObjectMapper obj = new ObjectMapper();
        Registrant actualRegistrant = obj.readValue(response.asString(),Registrant.class);
        System.out.println(actualRegistrant);
        assertEquals(registrant.getFirstName(),actualRegistrant.getFirstName());
        assertEquals(registrant.getLastName(),actualRegistrant.getLastName());
        assertEquals(registrant.getSsn(),actualRegistrant.getSsn());

    }

    @Given("user send the get request for users data")
    public void user_send_the_get_request_for_users_data() {
//      Response response = given().headers("Authorization","Bearer"+generateToken(),
//                "Content-type",ContentType.JSON,"Accept",ContentType.JSON).when().
//                get(ConfigurationReader.getProperty("registrant_endpoint"));
//
//      response.prettyPrint();

        response = getRequest(generateToken(ConfigurationReader.getProperty("admin_username"), ConfigurationReader.getProperty("admin_password")),ConfigurationReader.getProperty("registrant_endpoint"));
        response.prettyPrint();
    }
    @Given("user deserialized data to Java")
    public void user_deserialized_data_to_java() throws Exception {
        ObjectMapper obj = new ObjectMapper();
        registrants = obj.readValue(response.asString(), Registrant[].class);
        System.out.println(registrants.length);


//        for (int i=0; i< registrants.length; i++){
//            System.out.println("name"+registrants[i].getFirstName());
//        }

    }
    @Given("user saves the users data to corespondent files")
    public void user_saves_the_users_data_to_corespondent_files() {
        for (Registrant allRegistrants : registrants) {
            saveRegistrantData(allRegistrants);
            // System.out.println(allRegistrants);
        }
    }
    @Then("user validates get request records")
    public void user_validates_get_api_records() {
        assertTrue(registrants.length==2000);



    }
}
