# spring-boot-xml-json-response

Spring Boot XML and JSON response example - 
This will return XML or JSON response as per request sent from client with given **Accept** header or **mediaType** parameter. 

## Prerequisites 
- Java (Java 8)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Maven](https://maven.apache.org/guides/index.html)

### Tools
- Eclipse or IntelliJ IDEA (or any preferred IDE) with embedded Gradle
- Maven (version >= 3.6.0)
- Postman (or any RESTful API testing tool)

###  Build and Run application
_GOTO >_ **~/absolute-path-to-directory/spring-boot-xml-json-response/**  
and try below command in terminal
> **```mvn clean install```** it will build application  

Run jar file from below path with given command
_GOTO >_ **~/absolute-path-to-directory/spring-boot-xml-json-response/target/**  
> **```java -jar ~/path-to-project-directory/target/spring-boot-xml-json-response-0.0.1-SNAPSHOT.jar```

Or run main method from `SpringBootXMLApplication.java` as spring boot application.


## API End Points
1. Sending ***Accept*** in request header
    - http://localhost:8080/super-hero/tony
        - _Accept_  -  **application/json**
            ```
          {  
                "name": "Tony",  
                "superName": "Iron Man",  
                "profession": "Business man",  
                "age": 45,  
                "canFly": true  
            }
        
        - _Accept_  -  **application/xml**    
            ```
          <SuperHero>
                <name>Tony</name>
                <superName>Iron Man</superName>
                <profession>Business man</profession>
                <age>45</age>
                <canFly>true</canFly>
            </SuperHero>      
    
2. Sending ***mediaType*** as request param in url

    - http://localhost:8080/super-heroes?mediaType=xml  
    as per **_mediaType_** request param, response will get in XML format
    - http://localhost:8080/super-heroes?mediaType=json  
    as per **_mediaTpe_** request param, response will get in JSON format
