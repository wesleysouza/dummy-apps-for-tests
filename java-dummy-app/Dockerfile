FROM maven:3.8-amazoncorreto-11 as dependencies
WORKDIR /opt/app
COPY ..
COPY settings.xml /root/.m2/settings.xml
RUN mvn dependency:resolve -Dmaven.wagon.http.ssl.insecure=true -Dmaven.wagon.http.ssl.allowall=true -Dmaven.wagon.http.ssl.ignore.validity.dates=true 

FROM dependencies as build
RUN mvn clean package -Dmaven.wagon.http.ssl.insecure=true -Dmaven.wagon.http.ssl.allowall=true -Dmaven.wagon.http.ssl.ignore.validity.dates=true 

FROM amazoncorreto:11-alpine-jdk

EXPOSE 8080
COPY --from=build /opt/app/target*.jar DummySpringBootAppApplicatin.jar
ENTRYPOINT ["java", "-jar", "./DummySpringBootAppApplicatin.jar"]
