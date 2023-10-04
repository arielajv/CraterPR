package api_tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.RestApiUtils;

public class PetStoreAPI_Tests {
    String baseurl = "https://petstore.swagger.io/v2";

    Response response;
    RestApiUtils apiutils;
    int petid;


    // create a pet with dynamic id, and store the id as a global variable
    // so that we can use that pet id in later test cases


        @Test
        public void create_a_pet() {
        apiutils = new RestApiUtils();
        // request url
        String endpoint = "/pet";
        // request header
        // request method
        // request body

        //petid = apiutils.randomNumber();
           petid = 22112;

        String payload = "{\n"
                + "  \"id\": " + petid + ",\n"
                + "  \"category\": {\n"
                + "    \"id\": 232,\n"
                + "    \"name\": \"dog\"\n"
                + "  },\n"
                + "  \"name\": \"BooBoo\",\n"
                + "  \"photoUrls\": [\n"
                + "    \"string\"\n"
                + "  ],\n"
                + "  \"tags\": [\n"
                + "    {\n"
                + "      \"id\": 323,\n"
                + "      \"name\": \"oc223\"\n"
                + "    }\n"
                + "  ],\n"
                + "  \"status\": \"available\"\n"
                + "}";

        response = RestAssured
                .given()
                .contentType("application/json")
                .accept("application/json")
                .body(payload)
                .when()
                .post(baseurl + endpoint);


        response.then().statusCode(200).contentType("application/json");
        response.prettyPrint();

        // assert the id is same as the request id
        Assert.assertEquals(Integer.parseInt(response.path("id").toString()), petid);

        // assert the name is same as the request name
        Assert.assertEquals(response.path("name").toString(), "BooBoo");

        // assert the status is also same as the request status.
        Assert.assertEquals(response.path("status").toString(), "available");
    }


    // if this test is run separately alone,  it will not work.
    // why?   -- because at this point the petid is null.
    // solution - to make a test dependent on another test.
    //in testNG, there is a way to make a test dependent on another test.
    //the dependent test only runs when the other test is successful.

    @Test(dependsOnMethods = "create_a_pet")
    public void getApetByID() {
        String endpoint = "/pet/";

        response = RestAssured.given().accept(ContentType.JSON).when().get(baseurl + endpoint + petid);

        response.then().statusCode(200).contentType("application/json");
        response.prettyPrint();

        response
                .then().assertThat().statusCode(200)
                .and().assertThat().contentType("application/json");

        // validate the id
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.getContentType(), "application/json");
        System.out.println(response.path("name").toString());
        System.out.println(response.jsonPath().get("id").toString());
        Assert.assertEquals(Integer.parseInt(response.jsonPath().get("id").toString()), petid);
        Assert.assertEquals(response.path("name").toString(), "BooBoo");
        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Content Type: " + response.getContentType());


        // if I want to get the name of category, how do I define the json path?
        //System.out.println(response.path("category.name").toString());

        // if I want to get the id of category, how do I define the json path?
        //System.out.println(response.path("category.id").toString());

        // if I want to get the id of the first object of the tags, how do I define the
        // path?
        //System.out.println(response.path("tags[0].id").toString());

        // if I want to get the name of the second object of the tags, how do I define
        // the path?
        //System.out.println(response.path("tags[0].name").toString());

    }

    // when we update things, generally the update happens with the id of an object,
    // if the given id doens't exist in the data base,  put also creates new object as given request body.


    //Perform a GET request to find a pet with id 22112
    //Verify the status code is 200
    //Verify the content type is application.json
    //Verify the pet name is booboo status is available

    @Test(dependsOnMethods = "getApetByID")
    public void update_a_pet() {
        String endpoint = "/pet";

        String payload = "{\n"
                + "  \"id\": "+petid+",\n"
                + "  \"category\": {\n"
                + "    \"id\": 223,\n"
                + "    \"name\": \"dog\"\n"
                + "  },\n"
                + "  \"name\": \"Husky\",\n"
                + "  \"photoUrls\": [\n"
                + "    \"string\"\n"
                + "  ],\n"
                + "  \"tags\": [\n"
                + "    {\n"
                + "      \"id\": 2230,\n"
                + "      \"name\": \"hk223\"\n"
                + "    }\n"
                + "  ],\n"
                + "  \"status\": \"available\"\n"
                + "}";

        response = RestAssured
                .given()
                .accept("application/json")
                .contentType("application/json")
                .body(payload)
                .when()
                .put(baseurl + endpoint);

        response.then().statusCode(200).contentType("application/json");
        response.prettyPrint();

        // assert the id is same as the request id
        Assert.assertEquals(Integer.parseInt(response.path("id").toString()), petid);

        // assert the name is same as the request name
        Assert.assertEquals(response.path("name").toString(), "Husky");

        Assert.assertEquals(response.path("tags[0].name").toString(), "hk223");

        // assert the status is also same as the request status.
        Assert.assertEquals(response.path("status").toString(), "available");

    }


    @Test(dependsOnMethods = "update_a_pet")
    public void delete_the_pet() {
        String endpoint = "/pet/";

        response = RestAssured
                .given().accept("application/json")
                .when()
                .delete(baseurl + endpoint + petid);

        response.then().statusCode(200).contentType("application/json");
        response.prettyPrint();
        Assert.assertEquals(Integer.parseInt(response.path("message").toString()), petid);
    }


    @Test
    public void getPetsByStatus() {
        String endpoint = "/pet/findByStatus";

        response = RestAssured.given().accept(ContentType.JSON).param("status", "sold").when().get(baseurl + endpoint);

        response.then().statusCode(200).contentType("application/json");

        response.prettyPrint();
    }

    @Test
    public void invalidGetPetByID() {
        String endpoint = "/pet/";

        response = RestAssured.given().accept(ContentType.JSON)
                .when().get(baseurl + endpoint + 201029);

        response.then().statusCode(404).contentType("application/json");
        response.prettyPrint();
        Assert.assertEquals(response.path("message").toString(), "Pet not found");
    }

    @Test
    public void invalidCreatePetById() {

    }

}