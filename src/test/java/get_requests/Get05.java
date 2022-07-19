package get_requests;

import base_urls.HerokuappBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertTrue;

public class Get05 extends HerokuappBaseUrl {
    /*
        Given
            https://restful-booker.herokuapp.com/booking
        When
            User send a request to the URL
        Then
            Status code is 200
	  	And
	  		Among the data there should be someone whose firstname is "Aaron" and last name is "Chen"
     */

    @Test
    public void get05(){

        //1. Step: Set the Url

        //https://restful-booker.herokuapp.com/booking/?firstname=Adamz&lastname=Dear
        spec.pathParam("first","booking").
                queryParams("firstname","Aaron", "lastname","Chen");

        //2. Step: Set the expected data

        //3. Step: Set the request and get response

        Response response=given().spec(spec).when().get("/{first}");
        response.prettyPrint();

        //4. Step: Do Assertion

       response.then().assertThat().statusCode(200);
      // assertTrue(response.asString().contains("1649"));
        assert response.asString().contains("1649");

    }
}
