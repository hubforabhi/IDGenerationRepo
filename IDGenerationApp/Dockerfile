FROM openjdk:17

VOLUME /tmp
ADD target/IDGenerationApp.jar /opt/app/
EXPOSE 8081
WORKDIR /opt/app/
CMD ["java", "-Djava.security.egd=file:/dev/./urandom", "-Xms512m", "-Xmx1g", "-jar", "IDGenerationApp.jar"]