FROM openjdk:19
VOLUME /tmp
EXPOSE 8080
ADD ./target/demo-1.jar demo.jar
ENTRYPOINT ["java","-jar","/demo.jar"]