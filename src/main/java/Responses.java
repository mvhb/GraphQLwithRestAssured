import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Responses {

    public Response getResponse(String body, String url){
        Response response = given().
                header(Constants.CONTENTTYPE, Constants.CONTENTTYPEVALUE).
                and().
                body(body).
                when().
                post(url);
        return response;
    }
}
