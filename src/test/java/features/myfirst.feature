Feature: verify google search

Scenario: Enter search string in Google search box and click on Enter
Given launch google page
When enter search string in search box
And click on search button
Then verify search result present 
And click on first link from the search result

