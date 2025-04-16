# Используем образ с Java и Maven для сборки
FROM maven:3.9-eclipse-temurin-17 AS build

# Устанавливаем рабочую директорию
WORKDIR /app

# Копируем pom.xml и загружаем зависимости
COPY pom.xml ./
RUN mvn dependency:go-offline

# Копируем весь код проекта
COPY . .

# Собираем приложение
RUN mvn package -DskipTests

# Используем легкий образ с Java для запуска
# FROM maven:3.9-eclipse-temurin-17-alpine
FROM maven:3.9-eclipse-temurin-17

# Устанавливаем рабочую директорию
WORKDIR /app

# Копируем собранный JAR-файл из предыдущего этапа
COPY --from=build /app/target/*.jar app.jar

# Открываем порт 8080 (стандартный для Spring Boot)
EXPOSE 8080

# Команда для запуска приложения
CMD ["java", "-jar", "app.jar"]
