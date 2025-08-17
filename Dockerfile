# ✅ 1단계: Build stage
FROM amazoncorretto:17-alpine AS build

WORKDIR /app

# gradlew 및 소스 복사
COPY . .

# 실행 권한 부여
RUN chmod +x ./gradlew

# 빌드
RUN ./gradlew build -x test

# ✅ 2단계: Runtime stage
FROM amazoncorretto:17-alpine

WORKDIR /app

# 빌드된 jar 복사
COPY --from=build /app/build/libs/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]