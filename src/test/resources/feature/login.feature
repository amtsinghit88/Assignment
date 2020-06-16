Feature: login user

Scenario Outline:  login <TEST-INFO>

Given setup BaseUrl and headers
When send a HTTP post request with set email "<emailId>" and password "password`"
Then return a success status and verify login response


  Examples:
    |  TEST-INFO  |    emailId   | password
    |  login   | abc@gmail.com | abc123