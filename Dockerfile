FROM openjdk:8-jre-alpine
VOLUME /tmp
ADD target/MidWestTenBank-0.0.1-SNAPSHOT.jar MidWestTenBank-0.0.1-SNAPSHOT.jar
EXPOSE 80
ENTRYPOINT ["java", "-jar" , "MidWestTenBank-0.0.1-SNAPSHOT.jar"]