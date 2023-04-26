FROM openjdk:19-oracle
COPY target/*.jar bankapp.jar
EXPOSE 8083
ENTRYPOINT ["java" , "-jar" , "bankapp.jar"]
