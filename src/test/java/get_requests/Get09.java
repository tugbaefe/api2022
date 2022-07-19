package get_requests;

import base_urls.HerokuappBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

public class Get09 extends HerokuappBaseUrl {
    /*
      Given
          https://restful-booker.herokuapp.com/booking/91
      When
          User send a GET request to the URL
      Then
          HTTP Status Code should be 200
      And
          Response content type is “application/json”
      And
          Response body should be like;
        {
          "firstname": "GGS",
          "lastname": "FINCH",
          "totalprice": 111,
          "depositpaid": true,
          "bookingdates": {
              "checkin": "2018-01-01",
              "checkout": "2019-01-01"
          }
      }
   */
    @Test
    public void get01() {
        //1.Step : Set the Url
        spec.pathParams("first", "booking", "second", 91);

        //2. Step: Set the expected data

        Map<String, String> bookingdatesMap = new HashMap<>();
        bookingdatesMap.put("checkin", "2018-01-01");
        bookingdatesMap.put("checkout", "2019-01-01");
        Map<String, Object> expectedData = new HashMap<>();
        expectedData.put("firstname", "James");
        expectedData.put("lastname", "Brown");
        expectedData.put("totalprice", 111);
        expectedData.put("depositpaid", true);
        expectedData.put("bookingdates", bookingdatesMap);
        expectedData.put("additionalneeds", "Breakfast");
        System.out.println(expectedData);

        //3. Step: Send the request and get the Response

        Response response = given().spec(spec).when().get("/{first}/{second}");

        Map<String, Object> actualDataMap = response.as(HashMap.class);
        System.out.println(actualDataMap);

        //4.Step: Do Assertion

        assertEquals(expectedData.get("firstname"), actualDataMap.get("firstname"));
        assertEquals(expectedData.get("lastname"), actualDataMap.get("lastname"));
        assertEquals(expectedData.get("totalprice"), actualDataMap.get("totalprice"));
        assertEquals(expectedData.get("depositpaid"), actualDataMap.get("depositpaid"));
        assertEquals(expectedData.get("additionalneeds"), actualDataMap.get("additionalneeds"));

        assertEquals(bookingdatesMap.get("checkin"), ((Map) actualDataMap.get("bookingdates")).get("checkin"));
        assertEquals(bookingdatesMap.get("checkout"), ((Map) actualDataMap.get("bookingdates")).get("checkout"));
    }
}
