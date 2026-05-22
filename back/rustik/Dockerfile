# Paso 1: Construir la aplicación usando Maven y Java 17
FROM maven:3.8.4-openjdk-17-slim AS build
WORKDIR /app
# Copiamos el pom.xml y el código fuente
COPY pom.xml .
COPY src ./src
# Compilamos el proyecto saltando los tests
RUN mvn clean package -DskipTests

# Paso 2: Crear la imagen de ejecución
FROM openjdk:17-jdk-slim
WORKDIR /app
# Copiamos el .jar generado desde la etapa de construcción
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
# Comando para iniciar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]