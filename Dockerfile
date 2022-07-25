FROM gradle:6.8-jdk11 as builder
USER root
WORKDIR /builder
ADD . /builder
RUN gradle build

FROM openjdk:11-jre-slim
WORKDIR /app
EXPOSE 8080
COPY --from=builder /builder/build/libs/mint-ecommerce.jar mint-ecommerce.jar
ENTRYPOINT ["java", "-jar", "mint-ecommerce.jar"]