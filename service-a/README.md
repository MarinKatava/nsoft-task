# Service-a HTTP API

Service-a in this case is exposed to localhost port 8081 (it can be changed) and it is listening to it. Client's post request must have Json body and must be sent to http://localhost:8081/message. Json body must have parameters defined in HttpMessage model, in this case "amount" and "currency" parameters.

Example of valid Json body:
```
{
"amount":"2103",
"currency":"EUR"
}

```

When request is sent, message goes through JsonValidation class. If one of requested parameters is not defined or value of "currency" parameter is different than "EUR" or value of "amount" is not in range between -100000000 and 100000000, server will return **BAD REQUEST** (Http 400) response. If everything is well defined, server will return **OK** (Http 200) response. 

Value of "amount" will be rounded to 2 decimal places and multiplied by 100. Message that will be sent to RabbitMQ got random ID field (random String) and it is sent in that form.
