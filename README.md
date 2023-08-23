Project build as semester project for CTU subject Software architectures by Martin Mašata, Martin Turyna, Jaroslav Erben

# Project structure

- `/hotel` - Main microservice which manages the hotel, bookings and rooms. 
- `customerProfile` - Service that manages customers and their profiles. It also arranges customer orders.
- `roomReviews` - Hotel Reviews are managed by this service. You can create / or retrieve reviews by parameters. 

# Run

1. First of whole it is necessary to run 

```
mvn clean install
```

in directories of every microservice seperately. Once you done this .jar files are going to be generated.


2. To run the microservices on Docker you need to go to root directory and run the following command

```
docker-compose up --build
```

This command will not only build every Docker image from Dockerfiles but also run all microservices together. 

# Programming principles

- KISS
- DRY
- Dependency injection
- Inversion of control
- Encapsulation
- Lombok library
- Templates

Every microservice is divided into sub modules (api, service, database, runnable app). It makes the code cleaner and reusable.  

# App specifications

- Java 11 (Open JDK)
- Spring Boot 2.7.3
- Lombok 1.18.0
- Apache Commons 4.4.0
- Jackson 2.13.0
- H2 (in memory database)
- Circuit Breaker 1.7.1
- Docker image / Docker compose



