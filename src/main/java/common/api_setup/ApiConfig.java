package common.api_setup;

import common.api_setup.util.Endpoints;
import common.util.TestData;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeSuite;

public class ApiConfig {
    protected ApiConfig() {
    }

    public static RequestSpecification api_requestSpec;
    public static ResponseSpecification api_responseSpec;

    public static TestData testData;

    @BeforeSuite
    public static void beforeSuiteSetup() {
        api_requestSpec = new RequestSpecBuilder()
                .setBaseUri(Endpoints.BASE_URI)
                .setBasePath(Endpoints.BASE_PATH)
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .build();

        api_responseSpec = new ResponseSpecBuilder()
                .build();

        RestAssured.requestSpecification = api_requestSpec;
        RestAssured.responseSpecification = api_responseSpec;

        try {
            testData = TestData.getInstance();
        } catch (Exception e) {
            throw new RuntimeException("Error loading test data: " + e);
        }
    }
}
