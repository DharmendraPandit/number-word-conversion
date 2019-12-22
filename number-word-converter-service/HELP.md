# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.2.2.RELEASE/maven-plugin/)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.2.2.RELEASE/reference/htmlsingle/#boot-features-developing-web-applications)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)

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
2. java -jar target/number-word-converter-service-0.0.1-SNAPSHOT.jar or mvn spring-boot:run
