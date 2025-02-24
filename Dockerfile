# Используем официальный образ OpenJDK 17
FROM openjdk:17-jdk-slim
WORKDIR /app
# Копируем JAR-файл приложения
COPY target/demo-0.0.1-SNAPSHOT.jar app.jar
# Запускаем приложение
ENTRYPOINT ["java", "-jar", "app.jar"]
EXPOSE 8088
