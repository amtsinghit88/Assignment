Feature: register user

Scenario Outline:  registration <TEST-INFO>
  Given setup BaseUrl and headers
  When send a HTTP post request with set username "<username>" and password "password`"
  Then return a success status and verify register response

  Examples:
    |  TEST-INFO  |    username   | password
    |  register   | abc@gmail.com | abc123