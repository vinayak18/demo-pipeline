# Use a base image
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy jar from target folder
COPY target/*.jar app.jar

# Run the app
ENTRYPOINT ["java", "-jar", "app.jar"]
