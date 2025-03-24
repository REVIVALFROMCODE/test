FROM openjdk:17-alpine
ARG JAR_FILE=target/api-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
# Create the /var/logs directory and the unmatched_requests.log file with appropriate permissions
RUN mkdir -p /var/logs && \
    touch /var/logs/unmatched_requests.log && \
    chmod -R 777 /var/logs

ENTRYPOINT ["java","-jar","/app.jar"]
