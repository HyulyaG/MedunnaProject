package stepdefinitions.uisteps;

import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;
import pages.US015_Create_Edit_Patient;
import pojos.US015_Create_Edit_Patient_Pojo;
import pojos.US015_InnerCStatePojo;
import pojos.US015_InnerCountryPojo;
import pojos.US015_InnerUserPojo;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class US015_Create_Edit_Patient_Steps {

    US015_Create_Edit_Patient pageObject = new US015_Create_Edit_Patient();
    Response response;
    US015_Create_Edit_Patient_Pojo pojoObject = new US015_Create_Edit_Patient_Pojo();
    US015_InnerUserPojo pojoInnerUser = new US015_InnerUserPojo();
    US015_InnerCountryPojo pojoInnerCountry = new US015_InnerCountryPojo();
    US015_InnerCStatePojo pojoInnerCState = new US015_InnerCStatePojo();
    String id_token;
    US015_Create_Edit_Patient_Pojo []patientArray;

    @When("user launches the browser")
    public void user_launches_the_browser() {
        Driver.getDriver();
    }
    @When("user navigates to home page")
    public void user_navigates_to_home_page() {
        Driver.getDriver().navigate().to(ConfigurationReader.getProperty("medunna_login_url"));
    }
    @When("user clicks account_menu")
    public void user_clicks_account_menu() {
        pageObject.accountMenuButton.click();
    }
    @When("user clicks sign_in_menu")
    public void user_clicks_sign_in_menu() {
        pageObject.signInMenuButton.click();
    }
    @When("user enter username as {string}")
    public void user_enter_username_as(String username) {
        pageObject.usernameBox.sendKeys(username);

    }
    @When("user enter password as {string}")
    public void user_enter_password_as(String password) {
        pageObject.passwordBox.sendKeys(password);
    }
    @When("user clicks sign_in_button")
    public void user_clicks_sign_in_button() {
        pageObject.signInSubmitButton.click();

    }
    @When("user clicks ItemsTitles menu")
    public void user_clicks_items_titles_menu() {
        Driver.waitAndClick(pageObject.itemsTitlesMenu,2);
    }
    @When("user clicks Patient menu")
    public void user_clicks_patient_menu() {
        Driver.waitAndClick(pageObject.patientMenuInItems,2);
    }
    @When("user verifies create_a_new_patient button")
    public void user_verifies_create_a_new_patient_button() {
        Driver.waitForVisibility(pageObject.createANewPatientVerify,4);
        Assert.assertTrue(pageObject.createANewPatientVerify.isDisplayed());
    }
    @When("user clicks view information of first patient")
    public void user_clicks_view_information_of_first_patient() {
        Driver.waitAndClick(pageObject.viewButtonOfFirstPatient,2);
    }
    @When("user verifies all patient information title")
    public void user_verifies_all_patient_information_title() {
        Assert.assertTrue(pageObject.ssnTitleVerify.isDisplayed());
        Assert.assertTrue(pageObject.firstNameTitleVerify.isDisplayed());
        Assert.assertTrue(pageObject.lastNameTitleVerify.isDisplayed());
        Assert.assertTrue(pageObject.birthDateTitleVerify.isDisplayed());
        Assert.assertTrue(pageObject.phoneTitleVerify.isDisplayed());
        Assert.assertTrue(pageObject.genderTitleVerify.isDisplayed());
        Assert.assertTrue(pageObject.bloodGroupTitleVerify.isDisplayed());
        Assert.assertTrue(pageObject.addressTitleVerify.isDisplayed());
        Assert.assertTrue(pageObject.descriptionTitleVerify.isDisplayed());
        Assert.assertTrue(pageObject.createdDateTitleVerify.isDisplayed());
        Assert.assertTrue(pageObject.userTitleVerify.isDisplayed());
        Assert.assertTrue(pageObject.countryTitleVerify.isDisplayed());
        Assert.assertTrue(pageObject.stateCityTitleVerify.isDisplayed());
    }
    @When("user verifies id item added for edit patient")
    public void user_verifies_id_item_added_for_edit_patient() {
        List<String> viewElements = new ArrayList<>();
        List<String> editElements = new ArrayList<>();

        for (int i =0; i<pageObject.patientInformationInView.size();i++){
            viewElements.add(pageObject.patientInformationInView.get(i).getText());
        }

        Driver.waitAndClickElement(pageObject.editButtonOfFirstPatient,2);
        Driver.wait(2);

        for (int i =0; i<pageObject.patientInformationInEdit.size();i++){
            editElements.add(pageObject.patientInformationInEdit.get(i).getText());
        }

        Assert.assertFalse(viewElements.contains("ID"));
        Assert.assertTrue(editElements.contains("ID"));
    }
    @When("user enter patient values with Pojo {string}, {string}, {string}, {string}, {string}")
    public void user_enter_patient_values_with_pojo(String firstName, String lastName, String phone, String email, String userId) {
        pojoObject.setFirstName(firstName);
        pojoObject.setLastName(lastName);
        pojoObject.setPhone(phone);
        pojoObject.setEmail(email);
        pojoInnerUser.setId(Integer.parseInt(userId));
        pojoInnerCountry.setId(1201);
        pojoInnerCountry.setName("US");
        pojoInnerCState.setId(1255);
        pojoInnerCState.setName("California");

        pojoInnerCState.setCountry(pojoInnerCountry);
        pojoObject.setUser(pojoInnerUser);
        pojoObject.setCountry(pojoInnerCountry);
        pojoObject.setCstate(pojoInnerCState);
    }
   /* @When("user create a new patient with POST and API and Pojo")
    public void user_create_a_new_patient_with_post_and_api_and_pojo() {
        id_token = generateToken();
        spec.pathParams("first", "api", "second", "patients");
        response = given().headers(
                        "Authorization",
                        "Bearer " + id_token,
                        "Content-Type",
                        ContentType.JSON,
                        "Accept",
                        ContentType.JSON).
                spec(spec).body(pojoObject).when().post("/{first}/{second}");
        response.then().statusCode(201);
    }

    @When("user validate patient info with DB")
    public void user_validate_patient_info_with_db() {
        DatabaseUtility.createConnection("jdbc:postgresql://medunna.com:5432/medunna_db","medunnadb_user" , "Medunnadb_@129");
        String query = "SELECT * FROM patient where email ='"+pojoObject.getEmail()+"'";
        //DatabaseUtility.executeQuery(query);

        List<Map<String, Object>> patientInformation = DatabaseUtility.getQueryResultMap(query);

        Assert.assertEquals(pojoObject.getPhone(),patientInformation.get(0).get("phone"));
        Assert.assertEquals(pojoObject.getFirstName(),patientInformation.get(0).get("first_name"));
        Assert.assertEquals(pojoObject.getLastName(),patientInformation.get(0).get("last_name"));
    }
    @When("user validate patient info with API")
    public void user_validate_patient_info_with_api() throws IOException {
        response = getRequest(generateToken(),"https://medunna.com/api/patients/search?ssn=545-85-5485");

        ObjectMapper obj = new ObjectMapper();
        patientArray = obj.readValue(response.asString(), US015_Create_Edit_Patient_Pojo[].class);

        Assert.assertEquals(pojoObject.getPhone(),patientArray[0].getPhone());
        Assert.assertEquals(pojoObject.getFirstName(),patientArray[0].getFirstName());
        Assert.assertEquals(pojoObject.getLastName(),patientArray[0].getLastName());
        Assert.assertEquals(pojoObject.getEmail(),patientArray[0].getEmail());
    }
    @When("admin can delete any patient")
    public void admin_can_delete_any_patient() {
        Driver.waitAndClick(pageObject.itemsTitlesMenu,2);
        Driver.waitAndClick(pageObject.patientMenuInItems,2);
        Driver.wait(3);
        Driver.waitAndClick(pageObject.createdDateTitleVerify,2);
        Driver.wait(3);

        for(int i =0; i<pageObject.userInformationInTable.size();i++){
            if(pageObject.userInformationInTable.get(i).getText().equals("adminrecep")){
                Driver.wait(4);
                pageObject.deleteButtonInTable.get(i).click();
                Driver.wait(4);
                Driver.waitAndClick(pageObject.deleteButtonForAPatient,3);
                break;
            }else{
                Driver.wait(3);
                Driver.clickWithJS(pageObject.pageNumberGoNext);
            }
        }
        Driver.wait(2);
        Assert.assertTrue(pageObject.deleteVerifyMessage.isDisplayed());
    }*/

}