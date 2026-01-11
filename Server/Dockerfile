FROM maven:3.9.6-eclipse-temurin-11 AS build

WORKDIR /app


COPY pom.xml .
                                 # dependency caching
RUN mvn -B dependency:go-offline


COPY src ./src
                                 # run full build (including tests)
RUN mvn -B clean package


                              
FROM eclipse-temurin:11-jre-alpine

WORKDIR /app


                                 # jar from build stage
COPY --from=build /app/target/*.jar app.jar


EXPOSE 8080

                               
ENTRYPOINT ["java", "-jar", "app.jar"]
