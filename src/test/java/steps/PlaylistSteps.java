package steps;

import com.Spotify.pojo.Playlist;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.Specbuilder;

import java.io.IOException;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertEquals;

public class PlaylistSteps {

    RequestSpecification requestSpecification;
    Response response;
    static String playlistId;

    @Given("create playlist api payload")
    public void create_playlist_api_payload() throws IOException {
        Playlist reqPlaylist = new Playlist();
        reqPlaylist.setName("11 december playlist");
        reqPlaylist.setDescription("This is test playlist by code");
        reqPlaylist.setPublic(false);
        requestSpecification = given().spec(Specbuilder.reqspec()).body(reqPlaylist);
    }

    @When("user calls with POST http request")
    public void user_calls_with_post_http_request() {
        response = requestSpecification.when().post("/users/31ksa427zbqxse7boltpddy6va2q/playlists");
    }

    @Then("API call executed with status code {int}")
    public void api_call_executed_with_status_code(Integer expectedStatusCode) {
//        Playlist playlist = response.as(Playlist.class);
//        String playlistName = playlist.getName();
//        System.out.println(playlistName);
//        playlistId = playlist.getId();
//        assertEquals(response.statusCode(), expectedStatusCode);

        Playlist playlist = response.as(Playlist.class);

        String nameOfPlaylist = playlist.getName();

        System.out.println(nameOfPlaylist);

        playlistId = playlist.getId();

        assertEquals(response.statusCode(), expectedStatusCode);
    }

    @Given("Get a playlist payload")
    public void get_a_playlist_payload() throws IOException {
        requestSpecification = given()
                .spec(Specbuilder.reqspec())
                .pathParam("pId",playlistId);
    }

    @When("user calls with GET http request")
    public void user_calls_with_get_http_request() {
        response = requestSpecification.when().get("/playlists/{pId}");
    }

    @Then("API call executes with status code {int}")
    public void api_call_executes_with_status_code(Integer expectedStatusCode) {
        response.then()
                .spec(Specbuilder.resSpec());
        assertEquals(response.statusCode(),expectedStatusCode);
    }

    @Given("Get update playlist payload")
    public void get_update_playlist_payload() throws IOException {
        Playlist reqPlaylist = new Playlist();
        reqPlaylist.setName("Updated playlist new year mashup");
        reqPlaylist.setDescription("Updated playlist by RA");
        reqPlaylist.setPublic(false);
        requestSpecification = given().spec(Specbuilder.reqspec()).body(reqPlaylist);
    }

    @When("User calls with PUT http request")
    public void user_calls_with_put_http_request() {
        response=requestSpecification.when().put("/playlists/"+playlistId);
    }

    @Then("API call should executes with status code {int}")
    public void api_call_should_executes_with_status_code(Integer expectedStatusCode) {
        response.then().assertThat().statusCode(expectedStatusCode);
    }
}
