Feature: delete user

Scenario Outline:  delete <TEST-INFO>

Given setup BaseUrl and headers
When send a HTTP delete request with set userid
Then return a success status and verify response


  Examples:

