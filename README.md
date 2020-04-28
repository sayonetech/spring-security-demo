# spring security demo

This is the boilerplate repo for spring security and session implementation.

This project is built using Spring-boot and Gradle.

### Build & Run

- *>gradlew bootRun* : to run the project 
- *>gradlew bootWar* : To package the project as a standalone war. The war file will be generated in /build/libs/* folder of the the selected service with file name *.war

### Generate Token

Note that you are prompted for basic authentication to get the Token. Provide the following information for the username and password:

```
$ curl -v http://localhost:8080/api/v1/user/login -u admin:123456
```

Output 

```
< HTTP/1.1 200 
< Vary: Origin
< Vary: Access-Control-Request-Method
< Vary: Access-Control-Request-Headers
< X-Content-Type-Options: nosniff
< X-XSS-Protection: 1; mode=block
< Cache-Control: no-cache, no-store, max-age=0, must-revalidate
< Pragma: no-cache
< Expires: 0
< X-Frame-Options: SAMEORIGIN
< X-Auth-Token: bbfc9c30-d078-4911-bc32-0bda4c9595b3
< Content-Type: application/json
< Transfer-Encoding: chunked
< Date: Tue, 28 Apr 2020 14:36:42 GMT
```

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

