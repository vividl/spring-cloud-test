FROM java:8
VOLUME /tmp
ADD discovery-service-1.0-SNAPSHOT.jar app.jar
RUN bash -c 'touch /app.jar'
EXPOSE 7001
ENTRYPOINT ["java", "-jar", "/app.jar"]
