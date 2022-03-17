package utilities;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static Hooks.Hooks.spec;
import static io.restassured.RestAssured.given;

public class Authentication {

    public static String generateToken(String admin_username, String admin_password){

        spec.pathParams("first","api","second","authenticate");

        Map<String, String> expectedData = new HashMap<>();
        expectedData.put("username","admin79");
        expectedData.put("password","admin");
        expectedData.put("rememberMe","true");

        Response response = given().spec(spec).contentType(ContentType.JSON)
                .body(expectedData).when().post("/{first}/{second}");

        response.prettyPrint();
        JsonPath json = response.jsonPath();

        return json.getString("id_token");
    }

}
