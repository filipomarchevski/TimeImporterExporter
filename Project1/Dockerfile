FROM openjdk:18.0.1.1-oracle

COPY /out/artifacts/Project1_jar /tmp/timeexporter
WORKDIR /tmp/timeexporter

RUN mkdir "output"

VOLUME /tmp/timeexporter/output

CMD java -jar Project1.jar