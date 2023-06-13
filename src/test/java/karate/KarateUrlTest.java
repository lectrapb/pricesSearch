package karate;


import com.app.PricesAppApplication;
import com.intuit.karate.junit5.Karate;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT, classes = {PricesAppApplication.class})
public class KarateUrlTest {

    @Karate.Test
    Karate pricesTest() {
        return Karate.run("classpath:karate/prices/prices.feature");
    }
}
