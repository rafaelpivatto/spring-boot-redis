#POC Spring boot + redis
A simple CRUD with spring boot using redis as repository.

#### Requirements:
- Java 8+
- Docker

#### Setup:

> mvn install

in docker-images:
> docker-compose up --build 

#### To run

> mvn spring-boot:run

#### Operations:
> - [POST] in "/" to create with body: 
~~~~
{
	"id",
	"document",
	"description"
}
~~~~
> - [GET] in "/{ID}" to get by id
> - [PUT] in "/" to update with body:
~~~~
{
	"id",
    	"document",
    	"description"
}
~~~~
> - [DELETE] in "/{ID}" to delete by id

#### Endpoint example to test
https://www.getpostman.com/collections/f33b2160ff362d15d1cd