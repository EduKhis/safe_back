# Используем официальный образ OpenJDK
FROM openjdk:17-jdk-slim

# Устанавливаем рабочую директорию
WORKDIR /app

# Копируем jar файл в контейнер
COPY target/myapp.jar app.jar

# Запускаем приложение
ENTRYPOINT ["java", "-jar", "app.jar"]
