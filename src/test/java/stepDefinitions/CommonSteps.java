package stepDefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;
import java.util.Locale;

import static net.javacrumbs.jsonunit.assertj.JsonAssertions.assertThatJson;

public class CommonSteps extends BaseSteps {

    //Step definition file for steps which will be common across api's.

    public CommonSteps(TestContext testContext) {
        super(testContext);
    }


    @Then("User should get response status code as {int}")
    public void user_should_get_response_status_code_as(int statusCode) {
        Assert.assertEquals(statusCode, testContext.getRestUtil().response.statusCode());
    }

    @Given("User has a QueryParameters {string} with value {string}")
    public void user_has_a_query_parameters_query_params_with_values_query_param_values(String queryParam, String queryParamValue) {
        testContext.getRestUtil().requestSpecification.queryParam(queryParam, queryParamValue);
    }

    @When("User calls api with {string} Method")
    public void user_calls_get_method(String httpMethod) {

        httpMethod = httpMethod.toLowerCase();

        if (httpMethod.equals("get"))
            testContext.getRestUtil().response = testContext.getRestUtil().requestSpecification.get();
        else if (httpMethod.equals("post"))
            testContext.getRestUtil().response = testContext.getRestUtil().requestSpecification.post();
        else if (httpMethod.equals("put"))
            testContext.getRestUtil().response = testContext.getRestUtil().requestSpecification.put();
        else if (httpMethod.equals("delete"))
            testContext.getRestUtil().response = testContext.getRestUtil().requestSpecification.delete();

    }

    @Then("User should get the error as {string}")
    public void user_should_get_the_error_as_method_not_allowed(String errorMessage) {

        String responseBody = testContext.getRestUtil().response.getBody().asString();
        assertThatJson(responseBody).inPath("$.error").isEqualTo(errorMessage);
    }
}
