# service-a
>This is a simple spring boot application which consists of two services. "RabbitSender" sends messages to "RabbitReceiver" over the RabbitMQ. 
RabbitReceiver service tracks a balance containing money in some storage. 
It receives messages from "RabbitSender" service and adds to the balance accordingly.
----
## Getting started
- Before we start, you need to install these programs on your PC:
1. [IntelliJ IDEA](https://www.jetbrains.com/idea/download/) or [Eclipse IDEA](https://www.eclipse.org/downloads/)
2. [MySQL Workbench](https://dev.mysql.com/downloads/workbench/) (remember your username and password)
3. [Postman](https://www.getpostman.com/downloads/)
4. [RabbitMQ Server](https://www.rabbitmq.com/download.html)
- Follow given instructions to set up every program.
- Clone this project to your PC and open it in an IDEA.
>Go to *...\service-a\src\main\resources\application.properties* file and write down your own username and password in fields
*spring.datasource.username* and 
*spring.datasource.password* and create your own *spring.datasource.url*