# Java Sample Accessing other APIs

## Introduction

This project is used to introduce how to access other APIs from within Java Spring REST API CRUD applications. As such it is a small application showing just the code that is needed to explain the topic.

## Database layout

The table layouts are as follows:

- Employee is the driving table
- Email has a Many-To-One relationship with Employee. Each employee has many emails. Each email has only one employee
- Jobtitles has a Many-To-Many relationship with Employee
- EmployeeTitles is the join table to represent the Many-To_Many relationship between Employee and JobTitles

![Image of Database Layout](sampleemps-db.png)

When you first run the application, something similar to the following will appear from accessing the API [http://numbersapi.com/random/year?json](http://numbersapi.com/random/year?json)

```TEXT
13:31:52.023 [main] DEBUG org.springframework.web.client.RestTemplate - HTTP GET http://numbersapi.com/random/year?json
13:31:52.060 [main] DEBUG org.springframework.web.client.RestTemplate - Accept=[application/json, application/*+json, */*]
13:32:03.247 [main] DEBUG org.springframework.web.client.RestTemplate - Response 200 OK
13:32:03.251 [main] DEBUG org.springframework.web.client.RestTemplate - Reading to [com.lambdaschool.sampleemps.models.YearFact]
YearFact{text='1857 is the year that the Spirits' Book (Le Livre des Esprits), one of the Five Fundamental Works of Spiritism, is published by French educator Allan Kardec on April 18th.', number=1857}
13:32:03.373 [restartedMain] DEBUG org.springframework.web.client.RestTemplate - HTTP GET http://numbersapi.com/random/year?json
13:32:03.375 [restartedMain] DEBUG org.springframework.web.client.RestTemplate - Accept=[application/json, application/*+json, */*]
13:32:03.454 [restartedMain] DEBUG org.springframework.web.client.RestTemplate - Response 200 OK
13:32:03.455 [restartedMain] DEBUG org.springframework.web.client.RestTemplate - Reading to [com.lambdaschool.sampleemps.models.YearFact]
YearFact{text='893 is the year that the name yakuza (ya-ku-za, or 8-9-3, is a losing hand in Oicho-Kabu, a form of blackjack).', number=893}
```

Below are the endpoints that are affected by data from other apis

Accessing [http://localhost:2019/otherapis/isspositions](http://localhost:2019/otherapis/isspositions) from API [http://api.open-notify.org/iss-now.json](http://api.open-notify.org/iss-now.json)

```JSON
{
    "latitude": "-28.2833",
    "longitude": "-113.3399"
}
```

Accessing [http://localhost:2019/otherapis/klingon/"Success"](http://localhost:2019/otherapis/klingon/"Success") from API [https://api.funtranslations.com/translate/klingon.json?text="Success"](https://api.funtranslations.com/translate/klingon.json?text=%22Success%22)

```JSON
{
    "translated": "\"qapla'\""
}
```
