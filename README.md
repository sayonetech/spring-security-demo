# spring security demo

This is the boilerplate repo for spring security and session implementation.

This project is built using Spring-boot and Gradle.

### Build & Run

- *>gradlew bootRun* : to run the project 
- *>gradlew bootWar* : To package the project as a standalone war. The war file will be generated in /build/libs/* folder of the the selected service with file name *.war

### Features  

- This has a basic authentication service that authenticate any user with password "password"
- redis session 
- concurrency 

## TODO

- [] JPA based Authentication
- [] Flyway Migration
- [] Swagger Doc
- [] CORS 
- [] Base Controller 
- [] Gzip compression 

