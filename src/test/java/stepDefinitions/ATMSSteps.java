package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import utils.AssertJsonUtil;

import java.io.IOException;
import static net.javacrumbs.jsonunit.assertj.JsonAssertions.assertThatJson;



public class ATMSSteps extends BaseSteps {

    //Step definition file for steps related ATMS api steps.

    public ATMSSteps(TestContext testContext) {
        super(testContext);
    }


    @Given("User has ATMS endpoint {string}")
    public void user_has_atms_endpoint_atms(String basePath) throws IOException {

        testContext.getRestUtil().requestSpecification.basePath(basePath);

    }

    @And("User should get the valid atms response for identification as per file {string}")
    public void user_should_get_the_valid_response_for_identification(String filanme) {

        String responseBody = testContext.getRestUtil().response.getBody().asString();
        AssertJsonUtil.compareJsonResponseToFile(responseBody,filanme);

    }


    @Then("User should get the empty response")
    public void user_should_get_the_empty_response() {

        String responseBody = testContext.getRestUtil().response.getBody().asString();
        assertThatJson(responseBody).inPath("$").isEqualTo("[]");
    }


}
