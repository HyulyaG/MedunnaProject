package stepdefinitions.apisteps;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojos.AppointmentApi;
import pojos.AppointmentOut;
import utilities.ConfigurationReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import static Hooks.Hooks.spec;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertEquals;
import static utilities.ApiUtils.getRequest;
import static utilities.Authentication.generateToken;
import static utilities.WriteToTxt.saveAppointmentCreation;
public class US05_ApiSteps {
    Response response;
    Faker faker = new Faker();
    AppointmentApi newAppo = new AppointmentApi();
    AppointmentOut [] appointmentArrayList;
    @Given("user sets the necessary path params for appointment creation")
    public void user_sets_the_necessary_path_params_for_appointment_creation() {
        spec.pathParams("first","api","second","appointments","third","request");
    }
    @Given("user sets the expected data {string}, {string} {string} {string} {string}  and {string}")
    public void user_sets_the_expected_data_and(String firstname, String lastname, String SSN, String email, String phone, String date) {
        firstname = faker.name().firstName();
        lastname = faker.name().lastName();
        SSN = faker.idNumber().ssnValid();
        email = faker.internet().emailAddress();
        newAppo.setFirstName(firstname);
        newAppo.setLastName(lastname);
        newAppo.setSsn(SSN);
        newAppo.setEmail(email);
        newAppo.setPhone(phone);
        newAppo.setStartDate(date);
    }
    @Given("user sends the POST request and gets the response for appointment creation")
    public void user_sends_the_post_request_and_gets_the_response_for_appointment_creation() {
        response = given().spec(spec).contentType(ContentType.JSON).body(newAppo).when().post("/{first}/{second}/{third}");
    }
    @When("user saves the appointment records to correspondent files")
    public void user_saves_the_appointment_records_to_correspondent_files() {
        saveAppointmentCreation(newAppo);
    }
    @Then("user validates appointment records")
    public void user_validates_appointment_records() {
        response.then().statusCode(201);
        response.prettyPrint();
        Map<String,Object> actualData = response.as(HashMap.class);
        assertEquals(newAppo.getFirstName(),((Map)actualData.get("patient")).get("firstName"));
        assertEquals(newAppo.getSsn(),((Map)((Map)actualData.get("patient")).get("user")).get("ssn"));
    }
    @Given("user sends get request for appointment registration data")
    public void user_sends_get_request_for_appointment_registration_data() {
        response = getRequest(generateToken(ConfigurationReader.getProperty("admin_username"), ConfigurationReader.getProperty("admin_password")),ConfigurationReader.getProperty("appointments_endpoint"));
    }
    @Given("user deserializes data to Java")
    public void user_deserializes_data_to_java() throws IOException {
        ObjectMapper obj = new ObjectMapper();
        appointmentArrayList = obj.readValue(response.asString(),AppointmentOut[].class);
        System.out.println(appointmentArrayList.length);
        for(int i = 0; i<appointmentArrayList.length; i++){
            if(appointmentArrayList[i].getId() != null){
                System.out.println("id: " + appointmentArrayList[i].getId());
            }
        }
    }
    @Given("user validates records")
    public void user_validates_records() {
        response.then().body("id",hasItem(3403));
        response.then().assertThat().body("id",hasItem(3404));
    }
}
