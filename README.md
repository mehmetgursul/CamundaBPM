# Unit Tests for the Camunda BPM REST API

Camunda BPM provides REST API (https://docs.camunda.org/manual/7.5/reference/rest/). After testing REST API by using **postman**(https://www.getpostman.com/), I wrote some unit tests for the Task and User topics of Camunda REST API.

I'll add another remaining unit tests later. Let's explain added unit tests.

## 1. **How to Run Project**
Before explaining the project, we can easily run the project with following:
* Download Camunda BPM Tomcat distribution from https://camunda.com/download/.
* Extract downloaded Camunda BPM Tomcat distribution and run "start-camunda.bat" for Windows and "start-camunda.sh" for Linux at the base folder.
* Download my project with command "git clone https://github.com/mehmetgursul/CamundaBPM.git ." in your current folder.
* Run "mvn test" command at the base folder of the downloaded project.

## 2. **Used Libraries**

* **junit **: Testing framework for java programming language (Version 4.12 used, Version 5 will also be used later)
* **rest-assure** : REST API testing library. Rest Assure works on top of junit. (http://rest-assured.io/)
* **org.json** : JSON in Java library for JSON encoding and decoding and decoding in Java. (https://mvnrepository.com/artifact/org.json/json)

All used libraries added into the pom.xml file.

## 3. **Test Classes**
* **ConfigureTest.java :** 
Parent class of each unit test class. Contains a setUp function to set baseURI and port to be used in the RestAssure. Default target will be "http://localhost:8080/". You can change the default target when running the "mvn test" command following:

`mvn test -Dserver.port=<installed Camunda BPM port>-Dserver.host=<installed Camunda BPM host address>` 

* **CamundaTaskRestServiceTest.java :** 
Contains unit tests for the Task topic of the Camunda BPM REST API.
* **CamundaUserRestServiceTest.java :** 
Contains unit tests for the User topic of the Camunda BPM REST API.

**Resources:**
1. https://semaphoreci.com/community/tutorials/testing-rest-endpoints-using-rest-assured
2. https://www.swtestacademy.com/api-testing-with-rest-assured/
 
