FROM amazoncorretto:17-alpine-jdk
MAINTAINER Hiren Patel (userhiren@gmail.com)
COPY target/stock-api.jar stock-api.jar
ENTRYPOINT ["java","-jar","/stock-api.jar"]
EXPOSE 8080