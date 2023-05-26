package common.util;

import common.api_setup.util.Endpoints;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;

public class Extract {

    /***
     * This method extract bearer token from the Json response
     * @param refreshToken Refresh token that can be either Admins or Mentors, stored in common -> util -> SetupConstants
     * @return Returns Bearer token as a String
     */
    public static String extractBearerToken(String refreshToken) {
        Response response = RestAssured.given().when().patch(Endpoints.JWT + refreshToken);
        return JsonPath.from(response.asString()).get("response.accessToken");
    }

    /***
     * This method extracts variable from second layer in the JSON object. This method can only be used if the response consists of two layers in json.
     * For example first layer is "response" and second layer is "objects".
     * @param jsonResponse This is json response in form of pretty print or string.
     * @param firstLayer This is "response" in most cases
     * @param secondLayer This is "objects" in most cases
     * @param index This number represents what object are we targeting
     * @param variableName This parameter is variable name that we want to extract from the given object
     * @return Variable value from the given object
     */
    public static String extractVariableFromSecondLayerJsonObject(String jsonResponse, String firstLayer, String secondLayer, int index, String variableName) {
        JSONObject object = new JSONObject(jsonResponse);
        JSONArray objectsArray = object.getJSONObject(firstLayer).getJSONArray(secondLayer);
        JSONObject firstObject = objectsArray.getJSONObject(index);
        return firstObject.getString(variableName);
    }

    /***
     * This method returns size of the JSON response objects.
     * @param jsonResponse This is json response in form of pretty print or string
     * @return Size of the json objects
     */
    public static int lengthOfResponseObjects(String jsonResponse) {
        JSONObject object = new JSONObject(jsonResponse);
        JSONArray objectsArray = object.getJSONObject("response").getJSONArray("objects");
        return objectsArray.length();
    }

    public static JSONArray extractArrayFromJsonResponse(String jsonResponse, String key) {
        JSONObject object = new JSONObject(jsonResponse);
        return object.getJSONArray(key);
    }

    public static boolean ifJSONArrayHasObject(JSONArray array, JSONObject objectToFind) {
        for (int i = 0; i < array.length(); i++) {
            JSONObject objectInArray = array.getJSONObject(i);
            if (objectInArray.toString().equals(objectToFind.toString())) {
                return true;
            }
        }
        return false;
    }
}
