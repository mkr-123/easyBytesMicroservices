# Start with a base image containing Java runtime
FROM openjdk:17-jdk-slim

# Information about who is maintaining the image
MAINTAINER eazybytes.com

# Adding the application JAR to the image
COPY target/accounts-0.0.1-SNAPSHOT.jar accounts.jar

# Execute the application
ENTRYPOINT ["java","-jar","accounts.jar"]
