# nsoft-task
>This is simple spring boot project which consists of two services. **Service-a** sends messages to **Service-b** over the RabbitMQ. 
**Service-b** consumes messages from RabbitMQ and tracks a balance containing money in MySQL database. 
It receives messages from **Service-a** and adds amount to the balance accordingly.
----
## Getting started
- Before we start, you need to install these programs on your PC:
1. [IntelliJ IDEA](https://www.jetbrains.com/idea/download/) or [Eclipse IDEA](https://www.eclipse.org/downloads/)
2. [MySQL Workbench](https://dev.mysql.com/downloads/workbench/) (remember your username and password)
3. [Postman](https://www.getpostman.com/downloads/)
4. [RabbitMQ Server](https://www.rabbitmq.com/download.html)
5. [Docker](https://www.docker.com/get-started) for your system.
- Follow given instructions to set up every program. I recommend using default settings.
----
- Open terminal and pull Docker images for RabbitMQ and MySQL using commands:
    `docker pull rabbitmq` and `docker pull mysql`. 
- Run Docker containers from those images by using commands:
```
docker run -p 5671:5671 --hostname rabbitmq --name rabbitmq rabbitmq:latest

docker run -p 3307:3306 --name mysql_container -e MYSQL_ROOT_HOST=% -e MYSQL_ROOT_PASSWORD=Jh72071G -e MYSQL_DATABASE=account -d mysql:latest
```

- By doing this, you have run a RabbitMQ container named "rabbitmq" and MySQL container named "msql_container". You can choose your own names and ports for these containers as well as password and database name for MySQL container.
- Run command `docker inspect rabbitmq`, find the IP address of the host and write it down somewhere.
----
- Clone this project to your PC and open it in an IDEA. I recommmend opening both services separately.
- Let's edit `application.properties` file in both services.

**Service-a:** go to `*...\service-a\src\main\resources\application.properties*` file and choose your own server port. In the field `spring.rabbitmq.host` write the IP address of the rabbitmq host. I have used default values for other properties.

Go to the terminal inside your IDEA and do `mvn clean install`. By doing this you will get *.jar* file that is neccessary for creating docker image.

Run commands:
```
docker build . -t service-a

docker run -p 8081:8081 --name service-a --link rabbitmq -d service-a
```
Docker image and container for service-a are done. Container is linked to rabbitmq container.

**Service-b:** go to `*...\service-b\src\main\resources\application.properties*` file and copy the basic rabbitmq properties from service-a. Define your url, username and password in MySQL properties.

Run commands:
```
docker build . -t service-b

docker run --name service-b --link mysql_container -d service-b
```
Docker image and container for service-a are done. Service-b container is linked to mysql_container.
