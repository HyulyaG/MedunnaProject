package stepdefinitions.apisteps;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.junit.Assert;
import pojos.CTestItem;
import utilities.ConfigurationReader;

import java.io.IOException;
import java.util.*;

import static Hooks.Hooks.spec;
import static org.junit.Assert.assertEquals;
import static utilities.ApiUtils.getRequest;
import static utilities.ApiUtils.postRequestTestItem;
import static utilities.Authentication.generateToken;
import static utilities.ReadTxt.getApiTestItemNames;
import static utilities.ReadTxt.getTestItemNames;
import static utilities.WriteToTxt.saveAllTestItems;
import static utilities.WriteToTxt.saveTestItemInfo;

public class US17_ApiStepDefs {

    CTestItem cTestItem=new CTestItem();
    Faker faker=new Faker();
    Response response;
    CTestItem [] cTestItems;

//=================================Test Items Post Request================================================================================


    @Given("user sets the path params to create test item")
    public void user_sets_the_path_params_to_create_test_item() {
        spec.pathParams("first","api","second","c-test-items");
    }
    @Given("user sets expected data")
    public void user_sets_expected_data() {
        cTestItem.setName(faker.name().firstName()+" test");
        cTestItem.setDescription("mg/dL");
        cTestItem.setPrice(faker.number().numberBetween(50,150)+"");
        cTestItem.setDefaultValMin("50");
        cTestItem.setDefaultValMax("120");
    }
    @Given("user send Post request for test item and gets response")
    public void user_send_post_request_for_test_item_and_gets_response() {
        response=postRequestTestItem(generateToken(), ConfigurationReader.getProperty("testItem_endpoint"),cTestItem);
        response.prettyPrint();
    }
    @Given("user saves the test item records")
    public void user_saves_the_test_item_records() {
        saveTestItemInfo(cTestItem);
    }

    @Then("user validates test item record with Api")
    public void user_validates_test_item_record_with_api() throws IOException {
        response.then().statusCode(201);

        ObjectMapper obj=new ObjectMapper();
        CTestItem actualCTestItem=obj.readValue(response.asString(),CTestItem.class);

        assertEquals(cTestItem.getName(),actualCTestItem.getName());
        assertEquals(cTestItem.getDescription(),actualCTestItem.getDescription());
        assertEquals(cTestItem.getPrice(),actualCTestItem.getPrice());
        assertEquals(cTestItem.getDefaultValMin(),actualCTestItem.getDefaultValMin());
        assertEquals(cTestItem.getDefaultValMax(),actualCTestItem.getDefaultValMax());
    }

//=================================Test Items Get Request================================================================================


    @Given("user sends the get request for test items data")
    public void user_sends_the_get_request_for_test_items_data() {
        response=getRequest(generateToken(),ConfigurationReader.getProperty("testItem_endpoint"));
        //response.prettyPrint();
    }

    @Given("user deserializes test items data to Java")
    public void user_deserializes_test_items_data_to_java() throws IOException {
        ObjectMapper obj = new ObjectMapper();
        cTestItems = obj.readValue(response.asString(), CTestItem[].class);
    }

    @Given("user saves the test items data to correspondent file")
    public void user_saves_the_test_items_data_to_correspondent_file() {
        saveAllTestItems(cTestItems);
    }

    @Then("user validates expected test item records with Api")
    public void userValidatesExpectedTestItemRecordsWithApi() {
        List<String> expectedData=getTestItemNames();
        //System.out.println("expected:"+ expectedData);
        List<String> actualTestItems=getApiTestItemNames();
        //System.out.println("actual: "+actualTestItems);
        Assert.assertTrue(actualTestItems.containsAll(expectedData));
    }

//=================================Test Items Put Request================================================================================


    @Given("user sets the expected test item data")
    public void user_sets_the_expected_test_item_data() {
        cTestItem.setName(faker.name().firstName()+"xtest");
        cTestItem.setDescription("mg/cL");
        cTestItem.setPrice(faker.number().numberBetween(30,60)+"");
        cTestItem.setDefaultValMin("60");
        cTestItem.setDefaultValMax("180");
        cTestItem.setCreatedBy("Bulent");
        cTestItem.setCreatedDate("17-03-2022");
    }
    @Given("user makes a put request for test item")
    public void user_makes_a_put_request_for_test_item() {

    }
    @Given("user validates the changes")
    public void user_validates_the_changes() {

    }


}