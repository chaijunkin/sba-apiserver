# docker build -f Dockerfile -t smartbank-api-module .
# docker tag smartbank-api-module jkplayground/smartbank-api-module:v1.0.0
# docker push jkplayground/smartbank-api-module:v1.0.0
# DOCKER LOCAL DB AND API
# docker run --name smartbankdb --env POSTGRES_USER=postgres --env POSTGRES_PASSWORD=admin --env POSTGRES_DB=postgres -p 5432:5432 postgres
# docker run --link smartbankdb:dbserver -p 80:8080 --env spring.datasource.url=jdbc:postgresql://dbserver:5432/postgres -d jkplayground/smartbank-api-module:v1.0.0
# DOCKER AWS API
# docker run -d -p 80:8080 --log-driver=awslogs --log-opt awslogs-region=us-west-1 --log-opt awslogs-group=omega-docker --log-opt awslogs-create-group=true --env spring.datasource.username=postgres --env spring.datasource.password=postgres --env spring.datasource.url=jdbc:postgresql://omega-postgresdb.cz6pjwcofgn8.us-west-1.rds.amazonaws.com:5432/smartbankdb jkplayground/smartbank-api-module:v1.0.0
FROM openjdk:8-jre-alpine

COPY target/smart-bank-api.jar smart-bank-api.jar
#RUN java -jar app.jar  #build time
ENTRYPOINT ["java", "-jar","smart-bank-api.jar"]
