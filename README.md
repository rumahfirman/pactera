USER GUIDE

To build and run the application: go to root directory of the project and run:
mvn clean package && java -jar target/pactera-test-1.0.0.war

To check for weather: localhost:8080
User will be presented with a drop down selection of cities. Whenever a selection changes, the weather information for
 that city will be presented.

APPLICATION DESIGN

The application is built using Spring Boot on the backend and React on the front end. When the application starts,
City table will be created on h2 database and populated with 3 Australian cities (Sydney, Melbourne and Wollongong).

API documentation built using Swagger is available at localhost:8080/swagger. Using the endpoints exposed there, user
can add city, list cities and get weather for a given city.

The url localhost:8080 is mapped to index.html which contains the React javascript client application. Each time user
 selects a city on the client application, a request is sent to localhost:8080/weather. This request will go through
 validation whether the city is listed in the database or not. If yes, the weather information is retrieved from
 openweathermap.org and returned to the client. If not, constraint violation exception will be thrown.

The application is also available at http://52.13.15.243:8090/
Every 6 hours, Jenkins in AWS EC2 instance will poll this github repo and trigger build if any new commits
are found. The build pipeline is specified by Jenkinsfile in the root of this repo. It first clones the source,
builds it then deploys it to Tomcat running on the same EC2 instance at the above url.