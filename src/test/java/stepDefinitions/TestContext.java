package stepDefinitions;

import utils.RestUtil;

public class TestContext {
    //TestContext class to be used with Dependency injection and provide common instance of RestUtil and other required classes across all Step definitions.
    private RestUtil restUtil;

    public TestContext() {
        restUtil = new RestUtil();
    }

    public RestUtil getRestUtil() {
        return restUtil;
    }

}
