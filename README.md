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
- Follow given instructions to set up every program. I recommend using default settings.
- Clone this project to your PC and open it in an IDEA.
>Go to *...\service-a\src\main\resources\application.properties* file and write down your own username and password in fields
*spring.datasource.username* and 
*spring.datasource.password* and create your own *spring.datasource.url*
