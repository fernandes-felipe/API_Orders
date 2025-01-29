# API_Orders
Study Java Spring Boot With RabbitMQ and MongoDB

## :rocket: Technologies 

* Java 21
* Spring Boot
* Spring Data MongoDB
* RabbitMQ
* Docker

## Message Example
````
   {
       "codigoPedido": 1001,
       "codigoCliente":1,
       "itens": [
           {
               "produto": "lápis",
               "quantidade": 100,
               "preco": 1.10
           },
           {
               "produto": "caderno",
               "quantidade": 10,
               "preco": 1.00
           }
       ]
   }