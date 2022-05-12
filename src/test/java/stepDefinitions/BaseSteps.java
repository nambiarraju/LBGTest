package stepDefinitions;

import io.cucumber.java.ParameterType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.cucumber.java.en.Given;
import utils.RestUtil;

import java.util.Arrays;
import java.util.List;


public class BaseSteps {


    TestContext testContext;
    BaseSteps(TestContext testContext){
        this.testContext = testContext;

    }
}
