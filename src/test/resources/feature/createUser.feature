Feature: create user

Scenario Outline:  create <TEST-INFO>
Given setup BaseUrl and headers
When send a HTTP post request with set name "<name>" and job "job"
Then return a success status and verify create response

  Examples:
    |  TEST-INFO  |    name   | job
    |  create   | ram | computer
    |  create   | shyam | IT
    |  create   | ramesh | marketing
    |  create   | vinay | sales
    |  create   | vivek | machineLearning