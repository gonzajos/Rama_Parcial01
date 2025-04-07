FROM eclipse-temurin:17-jdk

# Instalar Node.js y npm
RUN apt-get update && \
    apt-get install -y curl && \
    curl -fsSL https://deb.nodesource.com/setup_18.x | bash - && \
    apt-get install -y nodejs

# Directorio de la aplicación
WORKDIR /app

# Copiar el wrapper y dependencias
COPY .mvn .mvn
COPY mvnw .
COPY pom.xml .

# Descargar dependencias
RUN ./mvnw dependency:go-offline

# Copiar el resto del proyecto
COPY . .

# Construir el proyecto (genera el frontend también)
RUN ./mvnw clean install

# Exponer el puerto
EXPOSE 8080

# Ejecutar la app
CMD ["./mvnw", "spring-boot:run"]

