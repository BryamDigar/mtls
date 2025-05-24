# Fase de construcción (Build stage)
FROM eclipse-temurin:17-jdk AS build

# Instalar dependencias necesarias para la compilación
RUN apt-get update && apt-get install -y \
    git \
    wget

WORKDIR /app
COPY . .

RUN ls -la /app

# Convertir gradlew a formato Unix, asignarle permisos y ejecutar el build
RUN sed -i 's/\r$//' gradlew && chmod +x gradlew && ./gradlew bootJar --no-daemon

# Fase de ejecución (Run stage)
FROM eclipse-temurin:21-jdk

EXPOSE 8075

# Correct the path to match the output directory of the bootJar task
COPY --from=build /app/build/libs/seguridad-0.0.1-SNAPSHOT.jar seguridad.jar

ENTRYPOINT ["java", "-jar", "seguridad.jar"]
