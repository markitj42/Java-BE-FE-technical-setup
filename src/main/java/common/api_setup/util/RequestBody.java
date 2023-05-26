package common.api_setup.util;

import static io.restassured.RestAssured.given;

public class RequestBody {

    /***
     * This method sends GET API request.
     * @param bearerToken Bearer token can be found in every Test Class where we call this method.
     * @param endpoint Endpoint for the GET Request, can be found in Endpoints Util class.
     * @param statusCode This method assert and check status code
     * @return String from JSON response
     */
    public static String getApiRequest(String bearerToken, String endpoint, int statusCode) {
        return given()
                    .header("Authorization", bearerToken)
                    .header("Content-Type", "application/json").
                when()
                    .get(endpoint).
                then()
                    .statusCode(statusCode).extract().asPrettyString();
    }

    /***
     * This method sends GET API request with variable extraction from the response.
     * @param bearerToken Bearer token can be found in every Test Class
     * @param endpoint Endpoint for the GET request
     * @param statusCode This method assert and check status code
     * @param variableName Extracted variable name
     * @return Extracted variable name as a string from the JSON response
     */
    public static String getApiRequestWithVariableExtraction(String bearerToken, String endpoint, int statusCode, String variableName) {
        return given()
                    .header("Authorization", bearerToken)
                    .header("Content-Type", "application/json").
                when()
                    .get(endpoint).
                then()
                    .statusCode(statusCode)
                    .extract().response().path(variableName);
    }

    /***
     * This method create a POST API request.
     * @param bearerToken Takes bearer token as a parameter and can be found in test class
     * @param requestBody Takes string as a parameter that will contain body for post method
     * @param endpoint Endpoint of a request that can be found in Endpoints util class
     * @param statusCode This method check and assert status code as well
     */
    public static void postApiRequest(String bearerToken, String requestBody, String endpoint, int statusCode) {
        given()
                .header("Authorization", bearerToken)
                .header("Content-Type", "application/json")
                .body(requestBody)
        .when()
                .post(endpoint)
        .then()
                .statusCode(statusCode);
    }

    public static void patchApiRequest(String bearerToken, String requestBody, String endpoint, int statusCode) {
        given()
                .header("Authorization", bearerToken)
                .header("Content-Type", "application/json")
                .body(requestBody)
        .when()
                .patch(endpoint)
        .then()
                .statusCode(statusCode);
    }
}