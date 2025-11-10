# rest-java17-wildfly
A minimalist setup to bootstrap Rest projects using Java 17, Maven, and Wildfly 30

## Instructions

Check the story on [Medium](https://medium.com/@doleron/51d1a465cae5).

## Run locally with

```
mvn clean package

java -jar payara-micro.jar --deploy target/modulename.backend.war

```

Then you can open the app in:

http://localhost:8080/modulename.backend/api/myservice/hello
