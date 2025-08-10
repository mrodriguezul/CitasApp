LABEL authors="mrodriguezul"
# ---- Build Stage ----
FROM maven:3.8.5-openjdk-17 AS build
# Set the working directory inside the container
WORKDIR /app
# Copy project files
COPY .mvn/ .mvn/
COPY mvnw pom.xml ./
COPY src ./src

# Build the executable Jar (skip tests to speed up)
RUN chmod +x mvnw
RUN ./mvnw clean package -DskipTests

# ---- Run Stage ----
FROM openjdk:17.0.1-jdk-slim
# Set the working directory
WORKDIR /app
# Copy the JAR file from the 'build' stage to the final image
COPY --from=build /app/target/citasapp-1.0.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]