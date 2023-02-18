package stepDefinations.BeSteps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import lelyBE.methods.RestMethod;
import lelyBE.ReadData;
public class BeStepManager {
    RestMethod restMethod = new RestMethod();
    ReadData readData = new ReadData();

    @Given("^User list all user with GET request$")
    public void userListAllUserWithGETRequest() {
        restMethod.listUserId();
    }
    @And("^User check all user ids$")
    public void userCheckAllUserIds() {
        restMethod.checkUserDigit();
    }

    @Given("^User create a new user with status code (.*)$")
    public void userCreateANewUserWithStatusCode(int statusCode) {
        restMethod.postUser(readData.getTestData("test-user"), statusCode);
    }

    @And("^User check newly created user$")
    public void userCheckNewlyCreatedUser() {
        restMethod.checkUserDigit();
    }

    @Given("^User try to create same user with status code (.*)$")
    public void userTryToCreateSameUserWithStatusCode(int statusCode) {
        restMethod.postUser(readData.getTestData("test-user"), statusCode);
    }

    @And("^User see the response message (.*)$")
    public void userSeeTheResponseMessage(String message) {
        restMethod.checkResponseBody(message);
    }
}
