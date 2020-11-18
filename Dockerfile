FROM openjdk:11
LABEL maintainer="Jens Wegar <jens.wegar@gmail.com>"

ENV TZ Europe/Helsinki

WORKDIR /usr/app

EXPOSE 8080

COPY ./target/testbed-api-*.jar /usr/app/testbed-api.jar

CMD ["java", "-jar", "/usr/app/testbed-api.jar", "$@"]