# Spring Boot Swagger 2 with Swagger-UI Demo

### Application config
* Application name = spring-boot-rest-swagger-demo
* Port = 8080 (can be changed.)

### DB config (MySQL)

* Config your DB (username, password from application.properties)
* DB-name = swagger_demo (not need to create first, can be changed.)


## RESTful API (rest endpoint)

```http request
GET http://localhost:8080/student
Accept: */*
Cache-Control: no-cache

###

GET http://localhost:8080/student/1
Accept: */*
Cache-Control: no-cache

###

GET http://localhost:8080/student/all
Accept: */*
Cache-Control: no-cache

###

GET http://localhost:8080/student?name=student1
Accept: */*
Cache-Control: no-cache

###

POST http://localhost:8080/student
Accept: */*
Cache-Control: no-cache
Content-Type: application/json

{ "studentId": "22", "studentName": "Student22", "gender": "Female", "cgpa": 3.7 }

###

PUT http://localhost:8080/student/22?name=student22
Accept: */*
Cache-Control: no-cache
Content-Type: application/json

{ "studentId": "22", "studentName": "Student22-updated", "gender": "Female", "cgpa": 3.7 }

###

DELETE http://localhost:8080/student/22?name=student22
Accept: */*
Cache-Control: no-cache
Content-Type: application/json

###

```

## Swagger UI-URL

[Swagger-UI](http://localhost:8080/swagger-ui.html)

Need to config swagger-security config properly.
Any one can config as they require.
