FROM openjdk
EXPOSE 8080
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar
ENV h2_user: sa
#ENV h2_password:
ENTRYPOINT ["java","-jar","/spring-boot-docker.jar"]
