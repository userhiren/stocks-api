
![Stocks](./images/stocks.png)

# Stocks API

Building a stocks API to load and provide market index data.

## Technologies Used
* [Amazon Corretto](https://aws.amazon.com/corretto) (Java SDK 17) for compiling locally
* [Spring Boot 2.6.4](https://spring.io/projects/spring-boot) framework was used to build out the REST API layer
* [Postman](https://www.postman.com) was used to manually test API (collection is available with project)
* [Maven 3.8.4](https://maven.apache.org/download.cgi) used for building, testing and packaging
* [Docker](https://www.docker.com) used for containerizing the solution
* [Postgres](https://www.postgres.com) used for storing and retrieving the stock data

## Prerequisites
* [Amazon Corretto](https://aws.amazon.com/corretto) (Java SDK 17) for compiling locally or any other JDK
* [Postman](https://www.postman.com) was used to manually test API (collection is available with project)
* [Docker](https://www.docker.com) used for containerizing the solution

## How to run API locally
In order to run this API locally, please run the following command. Note, you must be in the same directory as this 
README.md or the project root when executing the commands. Note that the API and corresponding database is setup to 
run locally using Docker and docker compose.

The following command will run the build for the API
```shell
./mvnw clean install
```

Once the packaged API jar is completed building run the following command to spin up the API and corresponding database.
```shell
docker-compose up -d
```

Once the build and Docker execution is completed you can access the swagger spec for the API by accessing the following
URL: [http://localhost:8080/swagger-ui/index.html#/](http://localhost:8080/swagger-ui/index.html#/). From the Swagger
page you should be able test the API by executing it against some test data in the `testdata` folder.

Alternatively if you choose you can use the postman collection: `stocks-api.postman_collection.json` and load it into
Postman to execute.