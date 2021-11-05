FROM java:8

MAINTAINER BeamStark

COPY *.jar /app.jar

CMD ["--server.port= 8848"]

EXPOSE 8848

RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-jar","/app.jar"]