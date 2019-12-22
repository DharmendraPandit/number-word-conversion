# number-word-conversion
Microservice for number to word conversion

Api Details:

Following api with different input numbers
1. GET: http://localhost:8081/virtusa/converter/word?number=0
1. GET: http://localhost:8081/virtusa/converter/word?number=1
1. GET: http://localhost:8081/virtusa/converter/word?number=21
1. GET: http://localhost:8081/virtusa/converter/word?number=105
1. GET: http://localhost:8081/virtusa/converter/word?number=56945781
1. GET: http://localhost:8081/virtusa/converter/word?number=999,999,999


Steps to run the maven base spring boot application:
1. mvn install
2. java -jar target/number-word-converter-service-0.0.1-SNAPSHOT.jar 
    or 
   mvn spring-boot:run


Microservice details:
  1. Port: 8081
  2. Context path: /virtusa/converter
  3. Service url: GET: http://localhost:8081/virtusa/converter/word?number=21
