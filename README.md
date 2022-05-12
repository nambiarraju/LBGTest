# LBGTest

Technical Challenge solution.

This is the solution for the Technical Challenge requested by LBG.

To execute test just run `mvnw clean test` in the root folder.

Reports after execution will be located at : `Reports\Report.html`

**Pre-requisite :** The application should be running on localhost:8080


**Answers to the questions requested:**

**1. Identify any shortcomings in the code regarding its functionality and where it could be improved to increase quality.**

Below are some of the points that can be added or improved in the exisiting solution
- Can give name to query parameter such as ID instead of using variable name itself.
- Can provide additional filtering criteria by adding query parameters for values such as for PostCode, SupportedCurrencies, Location etc.
- Can provide additional functionality of pagination, sorting and filtering if above filters are implemented and response has more results.
- Can give response message in body when incorrect identification is sent instead of empty response.
- Can add versioning to endpoints to help switching between different versions when there are further requirements for api or when there is a failure.
- Can make query parameter values case insensitive
- Can add API documentation so it becomes easy to understand the features and consume.

**2. Demonstrate practically how you can test the code in different ways to show how you would test it in practice.**

  Below are some of the scenarios that can be considered for testing open-banking-app solution.
  - Positive scenarios
    - Test with correct identification where we are expecting response. 
    - Can test with multiple dataset if data are of different nature such as different currency, Country, Address missing etc

- Negative test with valid inputs
  - Can test for different http methods which are not allowed and check that we get correct status code and response message.
  - Can test for identification which are not present in Database.
  - Can test for mix letter case identification.
  - Can test for identification with whitespace.

- Negative test with invalid inputs
  - Test with identification empty
  - Test with numbers in identification
  - Test with wildcard in identification
  - Test short length and long length identifications

- Test for scenarios for 400 and 500 series of errors.
- Validate the response json schema.
- Test that api conforms to all of the points of API contract.
