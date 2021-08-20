#getting base image
FROM openjdk:11
EXPOSE 1001
VOLUME /temp
ADD /target/TrackMe_backend-0.0.1-SNAPSHOT.jar TrackMe_backend-0.0.1-SNAPSHOT.jar
ENTRYPOINT [ "java","-jar", "TrackMe_backend-0.0.1-SNAPSHOT.jar"]