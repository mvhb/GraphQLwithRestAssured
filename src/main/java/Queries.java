public class Queries {

    public String getQueryCountries(){
        String queryCountries = "{\"query\":\"query {\\n  countries\\n  \\n  {\\n    code\\n    name\\n    native\\n    phone\\n    continent {\\n      name\\n    }\\n    capital\\n    emoji\\n  }\\n}\",\"variables\":{}}";
        return queryCountries;
    }

    public String getQueryCountriesFilterByBR(){
        String queryCountriesFilterByBR = "{\"query\":\"query {\\n  countries (filter:\\n  {\\n    code:\\n    {\\n      eq: \\\"BR\\\"\\n      }\\n    })\\n  {\\n    name\\n    capital\\n  }\\n}\",\"variables\":{}}";
        return queryCountriesFilterByBR;
    }
}
