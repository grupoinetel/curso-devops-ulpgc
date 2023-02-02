#
# Build stage
#
ARG PROFILE_ACTIVE=dev
FROM maven:latest AS build
COPY ./ /home/app/
RUN mvn -f /home/app/pom.xml clean package -U 

#
# Package stage
#
FROM openjdk:19-ea-19-jdk 
COPY --from=build /home/app/target/book-review.jar /tmp/book-review.jar
EXPOSE 8080
VOLUME /tmp
ENTRYPOINT ["java","-jar","/tmp/book-review.jar"]