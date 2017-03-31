FROM java:8
VOLUME /tmp
ADD eureka-service-1.0-SNAPSHOT.jar eureka.jar
RUN bash -c 'touch /eureka.jar'
EXPOSE 7000
ENTRYPOINT ["java", "-jar", "eureka.jar"]