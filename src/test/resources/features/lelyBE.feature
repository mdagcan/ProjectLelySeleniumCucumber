Feature: Lely BE-API Services control scenarios

  Scenario: Check that all of the data.id values are 4 digit integers and none of them are null
    Given User list all user with GET request
    And User check all user ids

  Scenario: Create a new user and checked created one
    Given User create a new user with status code 201
    And User check newly created user

  Scenario: Try to create a created user
    Given User try to create same user with status code 422
    And User see the response message has already been taken