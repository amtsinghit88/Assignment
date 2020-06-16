Feature: update user

Scenario Outline:  update <TEST-INFO>
  Given setup BaseUrl and headers
  When send a HTTP put request with set name "<name>" and job "job"
  Then return a success status and verify update response
  Examples:
    |  TEST-INFO  |    name   | job
    |  create   | ram1 | computer
    |  create   | shyam2 | IT
    |  create   | ramesh3 | marketing
    |  create   | vinay4 | sales