#
# Build stage
#
FROM maven:3.8-amazoncorretto-19 AS build
COPY ./ /home/app/
RUN mvn -f /home/app/pom.xml clean package -U 

#
# Package stage
#
FROM openjdk:19-jdk
COPY --from=build /home/app/bookreview-api-rest/target/book-review.jar /tmp/book-review.jar
EXPOSE 8080
VOLUME /tmp
ENTRYPOINT ["java","-jar","/tmp/book-review.jar"]