package hello;

import hello.CountryClient;
import hello.wsdl.GetCountryResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class CountryClientTest {

    @Autowired
    CountryClient countryClient;

    @Test
    void getCountry2() {
        GetCountryResponse spain = countryClient.getCountry2("Spain");

        assertNotNull(spain);
        System.out.println(spain);

    }
}