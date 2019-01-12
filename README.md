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
- Open terminal and pull Docker images for RabbitMQ and MySQL using commands:
    `docker pull rabbitmq` and `docker pull mysql`. 
- Run Docker containers from those images by using commands:
```
docker run -p 5671:5671 --hostname rabbitmq --name rabbitmq rabbitmq:latest

docker run -p 3307:3306 --name mysql_container -e MYSQL_ROOT_HOST=% -e MYSQL_ROOT_PASSWORD=Jh72071G -e MYSQL_DATABASE=account -d mysql:latest
```
- Clone this project to your PC and open it in an IDEA. I recommmend opening both services separately.
- 
>Go to *...\service-a\src\main\resources\application.properties* file and write down your own username and password in fields
*spring.datasource.username* and 
*spring.datasource.password* and create your own *spring.datasource.url*
