#Start with a base image containing Java runtime
FROM openjdk:17-jdk-slim
#information who is mantaining the image
MAINTAINER eazybytes.com
#Adding the application to jar to the image
COPY target/accounts-0.0.1-SNAPSHOT.jar accounts.jar
#execute the application
ENTRYPOINT ["java","-jar","accounts-0.0.1-SNAPSHOT.jar"]