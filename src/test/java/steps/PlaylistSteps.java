package steps;

import com.Spotify.pojo.Playlist;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utils.Specbuilder;

import static io.restassured.RestAssured.*;

public class PlaylistSteps {

    RequestSpecification reqs;

    @Given("create playlist api payload")
    public void create_playlist_api_payload() {
        Playlist reqPlaylist = new Playlist();
        reqPlaylist.setName("2nd december playlist");
        reqPlaylist.setDescription("This is test playlist by code");
        reqPlaylist.setPublic(false);

        reqs = given().spec(Specbuilder.reqspec()).body(reqPlaylist);
    }

    @When("user calls with POST http request")
    public void user_calls_with_post_http_request() {
        reqs.post()
    }

    @Then("API call executed with status code {int}")
    public void api_call_executed_with_status_code(Integer int1) {
    }

    @Given("Get a playlist payload")
    public void get_a_playlist_payload() {

    }

    @When("user calls with GET http request")
    public void user_calls_with_get_http_request() {

    }

    @Then("API call executes with status code {int}")
    public void api_call_executes_with_status_code(Integer int1) {

    }

    @Given("Get update playlist payload")
    public void get_update_playlist_payload() {

    }

    @When("User calls with PUT http request")
    public void user_calls_with_put_http_request() {

    }

    @Then("API call should executes with status code {int}")
    public void api_call_should_executes_with_status_code(Integer int1) {

    }
}
