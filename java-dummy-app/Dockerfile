FROM maven:3.9.0-amazoncorretto-19 as dependencies
WORKDIR /opt/app
COPY . .
RUN mvn dependency:resolve -Dmaven.wagon.http.ssl.insecure=true -Dmaven.wagon.http.ssl.allowall=true -Dmaven.wagon.http.ssl.ignore.validity.dates=true 

FROM dependencies as build
RUN mvn clean package -Dmaven.wagon.http.ssl.insecure=true -Dmaven.wagon.http.ssl.allowall=true -Dmaven.wagon.http.ssl.ignore.validity.dates=true 

FROM amazoncorretto:19-al2-jdk

EXPOSE 8080
COPY --from=build /opt/app/target/*.jar dummy.jar
ENTRYPOINT ["java", "-jar", "dummy.jar"]
