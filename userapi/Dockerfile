FROM openjdk:11-jdk
ADD target/userapi-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-Dspring.data.mongodb.uri=mongodb://mymongo:27017/mymongo","-Djava.security.egd=file:/dev/./urandom","-jar","app.jar"]
