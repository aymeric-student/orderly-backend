# Stage 1 : Build de l'application avec Maven
FROM eclipse-temurin:21-jdk as build

WORKDIR /app

COPY . .

RUN ./mvnw clean package -DskipTests

# Stage 2 : Image légère pour exécuter le JAR
FROM eclipse-temurin:21-jre

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
