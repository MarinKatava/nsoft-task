FROM java:8
EXPOSE 8080
ADD /target/service-a.jar service-a.jar
ENTRYPOINT ["java", "-jar", "service-a.jar"]