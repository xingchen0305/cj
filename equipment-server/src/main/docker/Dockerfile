FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD *.jar app.jar
RUN sh -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar", "-Xmx512M", "-Xms256M", "/app.jar"]