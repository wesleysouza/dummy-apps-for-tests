FROM maven:3.9.0-amazoncorretto-19 as dependencies
WORKDIR /opt/app
COPY . .
RUN mvn dependency:resolve -Dmaven.wagon.http.ssl.insecure=true -Dmaven.wagon.http.ssl.allowall=true -Dmaven.wagon.http.ssl.ignore.validity.dates=true 

FROM dependencies as build
RUN mvn clean package -Dmaven.wagon.http.ssl.insecure=true -Dmaven.wagon.http.ssl.allowall=true -Dmaven.wagon.http.ssl.ignore.validity.dates=true 

FROM openjdk:19-jdk-alpine

ARG DT_API_URL="https://qet61000.live.dynatrace.com/api"
ARG DT_API_TOKEN="dt0c01.NEERRVSS36C2EOQFC6SKMFI4.HCL74GMIWH7ED64US5NWKUTFJCOI62NBJYTZ3HJZI3M75GA47PC7SMRT5P4YETTP"
ARG DT_ONEAGENT_OPTIONS="flavor=musl&include=java"
ENV DT_HOME="/opt/dynatrace/oneagent"
ADD "$DT_API_URL/v1/deployment/installer/agent/unix/paas/latest?Api-Token=$DT_API_TOKEN&$DT_ONEAGENT_OPTIONS" "$DT_HOME/oneagent.zip"
RUN mkdir -p "$DT_HOME" 
RUN unzip -d "$DT_HOME" "$DT_HOME/oneagent.zip"
RUN rm "$DT_HOME/oneagent.zip"



EXPOSE 8080
COPY --from=build /opt/app/target/*.jar dummy.jar
#ENTRYPOINT [ "/opt/dynatrace/oneagent/dynatrace-agent64.sh" ]
#CMD ["java", "-jar", "dummy.jar"]
ENTRYPOINT ["java", "-jar", "dummy.jar", "sh", "/opt/dynatrace/oneagent/dynatrace-agent64.sh"]
