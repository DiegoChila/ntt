# Ntt demo service

This service register devices and calculate their depreciation using a cron job.

To execute this service in your machine, you must have to install Java 19 in your pc.

### Docker
* Go to the project root
* open your cmd 
* In your cmd: .\mvnw clean install
* In your cmd: docker build -t demo-ntt:v1 .
* In your cmd: docker run -p 8080:8080 demo-ntt:v1
* You can see the Swagger documentation in the next link: http://localhost:8080/swagger-ui/index.html#/


### Local
* Go to the project root
* open your cmd
* In your cmd: .\mvnw spring-boot:run
* You can see the Swagger documentation in the next link: http://localhost:8080/swagger-ui/index.html#/