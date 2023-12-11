Feature: validate playlist API
  Scenario: Verify if create playlist is working
    Given create playlist api payload
    When user calls with POST http request
    Then API call executed with status code 201

  Scenario: verify if fetch playlist functionality is working
    Given Get a playlist payload
    When user calls with GET http request
    Then API call executes with status code 201

  Scenario: verify if update playlist functionality is working
    Given Get update playlist payload
    When User calls with PUT http request
    Then API call should executes with status code 200