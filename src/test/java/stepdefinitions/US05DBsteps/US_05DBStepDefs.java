package stepdefinitions.US05DBsteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import utilities.DBUtils;

import java.util.ArrayList;
import java.util.List;

import static utilities.DBUtils.*;
import static utilities.ReadTxt.getSSNIDs;
import static utilities.WriteToTxt.saveRegistrantData;
import static utilities.WriteToTxt.save_Ids;

public class US_05DBStepDefs {

    List<Object> appointmentDB = new ArrayList<>();
    List<Object> allDBSSNs;

    @Given("user connects to database")
    public void user_connects_to_database() {
        createConnection("jdbc:postgresql://medunna.com:5432/medunna_db","medunnadb_user" , "Medunnadb_@129");

    }
    @Given("user selects all {string} column data")
    public void user_selects_all_column_data(String id) {
        appointmentDB = getColumnData("select * from appointment", id);
        System.out.println(appointmentDB);
    }
    @Given("user verifies {string} with the database")
    public void user_verifies_with_the_database(String id) {
        Assert.assertTrue(appointmentDB.toString().contains(id));
    }
    @Then("user saves the DB records to correspondent files")
    public void user_saves_the_db_records_to_correspondent_files() {
        save_Ids(appointmentDB);
    }
    @Then("close the database connection")
    public void close_the_database_connection() {
        closeConnection();
    }


    @Given("user connects to the database")
    public void user_connects_to_the_database() {
        createConnection("jdbc:postgresql://medunna.com:5432/medunna_db","medunnadb_user" , "Medunnadb_@129");

    }
    @Given("user sends the query to DB and gets the column data {string} and {string}")
    public void user_sends_the_query_to_db_and_gets_the_column_data_and(String query, String columnName) {
        allDBSSNs = getColumnData(query, columnName);
        System.out.println(allDBSSNs);
    }
    @Given("user verifies {string} number with the database")
    public void user_verifies_number_with_the_database(String ssn) {
        Assert.assertTrue(allDBSSNs.toString().contains(ssn));

    }
    @Given("user validates DB datas")
    public void user_validates_db_datas() {
        List<String> expectedSSNIds = new ArrayList<>();
        expectedSSNIds.add("856-45-6789");
        expectedSSNIds.add("856-45-6788");

        List<String> actualData = getSSNIDs();

        Assert.assertTrue(actualData.containsAll(expectedSSNIds));

    }
    @Then("user saves the DB records to the correspondent files")
    public void user_saves_the_db_records_to_the_correspondent_files() {
        saveRegistrantData(allDBSSNs);
    }

    @Then("close database connection")
    public void close_database_connection() {
        DBUtils.closeConnection();
    }


}
