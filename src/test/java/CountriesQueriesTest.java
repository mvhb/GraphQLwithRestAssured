import io.restassured.response.Response;
import org.testng.annotations.Test;
import java.util.ArrayList;

import static org.hamcrest.Matchers.*;

public class CountriesQueriesTest {

    Queries queries = new Queries();
    Responses responses = new Responses();

    String firstCapitalOfTheList = "data.countries.capital[0]";
    String countriesCode = "data.countries.code";
    String capitalOfBrazil = "Brasília";

    @Test
    public void shouldReturnStatusCode200(){
        Response response = responses.getResponse(queries.getQueryCountries(), Constants.URL);
        response.then().statusCode(Constants.STATUSCODE200);
    }

    @Test
    public void shouldReturnTotalCountOfCountries(){
        Response response = responses.getResponse(queries.getQueryCountries(), Constants.URL);
        ArrayList countriesCount = response.jsonPath().get(countriesCode);
        int count = countriesCount.size();
        assert count == Constants.TOTALCOUNTOFCOUNTRIES;
    }

    @Test
    public void shouldReturnCorrectCapital(){
        Response response = responses.getResponse(queries.getQueryCountriesFilterByBR(), Constants.URL);
        response.then().body(firstCapitalOfTheList, equalTo(capitalOfBrazil));
        response.then().body(firstCapitalOfTheList, instanceOf(String.class));
    }
}
