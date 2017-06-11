FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp

RUN mkdir -p $HOME/work/config-repo
COPY config-repo/* $HOME/work/config-repo/
ADD *.jar app.jar
RUN sh -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]