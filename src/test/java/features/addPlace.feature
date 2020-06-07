Feature: Verify addPlace API functionality

@addplace @regression
Scenario Outline: Verify AddPlace functionality
Given pass the addPlace payload with "<name>" "<address>" "<language>"
When call the "AddPlaceAPI" by using "POST" method
Then Verify the status code 200
And Verify the "status" in the response is "OK"
And Verify the "scope" in the response is "APP"
And verify place_id created maps to "<name>" using "GetPlaceAPI"

Examples:
|name|address|language|
|AAHouse|World trade center|English|
#|MYHouse|Sea trade center|Spanish|

@deleteplace @regression
Scenario: Verify DeletePlace functionality
Given pass the DeletePlace payload
When call the "DeletePlaceAPI" by using "POST" method
Then Verify the status code 200
And Verify the "status" in the response is "OK"

