# Usar una imagen base de Java
FROM eclipse-temurin:17-jdk

# Crear directorio de la app
WORKDIR /app

# Copiar el jar generado por Maven/Gradle
COPY target/facturas-service-sp-0.0.1.jar app.jar

# Exponer el puerto del Eureka Server
EXPOSE 8090

# Esperar a que el config-server esté disponible antes de arrancar el gateway
CMD bash -c "echo 'Esperando que config-server esté listo...'; \
until curl -sf http://config-server:8888/actuator/health > /dev/null; do \
  echo 'config-server no disponible aún...'; \
  sleep 5; \
done; \
echo 'Config-server disponible ✅'; \
java -jar app.jar"