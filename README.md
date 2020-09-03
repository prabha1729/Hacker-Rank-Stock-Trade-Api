# Stock-Trade-Api
This is a prototype for building a brokerage company's account and trades management platform. One Requirement is for a REST API service to manage trades using Spring Boot framework. Add functionality to add or delete transations as well as to perform some queries.

Each trade is a JSON entry with the following keys:

_id_: This is the trade unique ID.

_type_: This is the trade type, buy or sell.

_user_: The user responsible for the trade. The user itself is a JSON entry consisting of following fields:

_id_: This is the user unique ID.

_name_: This is the user name.

_stock_symbol_: This is the stock symbol.

_stock_quantity_: This is the total number of stocks traded. The traded stock quantity is between 10 and 30 inclusive.

_stock_price_: This is the stock price for one stock (upto two places of decimal) at the time of the trade. The stock price is between 130.42 and 195.65inclusive.

_trade_timestamp_: This is the timestamp for the trade creation given in the format yyyy-MM-dd HH:mm:ss. The timezone is EST (UTC -4).

For example, consider the following event JSON:

```
Trade JSON
{
  "id":1000344,
  "type":"buy",
  "user":{
    "id":1619820,
    "name":"David"
  },
  "stock_symbol":"AC",
  "stock_quantity":28,
  "stock_price":162.17,
  "trade_timestamp":"2014-06-14 13:13:13"
}
```
The REST service should implement the following functionalities:

**Erasing all the trades**: The service should be able to erase all the trades by the DELETE request at `/erase`. The HTTP response code should be 200.

**Adding new trades**: The service should be able to add a new trade by the POST request at `/trades`. The event JSON is sent in the request body. If a trade with the same id already exists then the HTTP response code should be 400, otherwise, the response code should be 201.

**Returning all the trades**: The service should be able to return the JSON array of all the trades by the `GET` request at `/trades`. The HTTP response code should be 200. The JSON array should be sorted in ascending order by trade ID.

**Returning the trade records filtered by the trade ID**: The service should be able to return the JSON array of all the trades which are performed by the trade ID by the `GET` request at `/trades/{id}`. If the trade with given ID does not exist then the HTTP response code should be 404, otherwise, the response code should be 200. The JSON array should be sorted in ascending order by trade ID.

**Returning the trade records filtered by the user ID**: The service should be able to return the JSON array of all the trades which are performed by the user ID by the `GET` request at `/trades/users/{userID}`. If the requested user does not exist then the HTTP response code should be 404, otherwise, the response code should be 200. The JSON array should be sorted in ascending order by trade ID.

**Returning the trade records filtered by the stock Symbol**: The service should be able to return the JSON array of all the trades which are associated with stock symbol by the `GET` request at `/trades/stocks/{stockSymbol}`. If the requested stock does not exist then the HTTP response code should be 404, otherwise, the response code should be 200. The JSON array should be sorted in ascending order by trade ID.


**Returning the trade records filtered by user ID && stock Symbol**: The service should be able to return the JSON array of all the trades which are performed by user ID and associated with stock symbol by the `GET` request at `/trades/users/{userID}/stocks/{stockSymbol}`. If the requested user or stock symbol does not exist then the HTTP response code should be 404, otherwise, the response code should be 200. The JSON array should be sorted in ascending order by trade ID.


# Reach out to me
[<img align="left" alt="LinkedIn" width="22px" src="https://cdn.jsdelivr.net/npm/simple-icons@v3/icons/linkedin.svg" />](https://www.linkedin.com/in/prabhakargaddam/)
[<img align="left" alt="Gmail" width="22px" src="https://cdn.jsdelivr.net/npm/simple-icons@v3/icons/gmail.svg" />](<mailto:prabhakargaddam1729@gmail.com>)

<br/>



# Execution
```
# To build the project standard maven build is sufficient
mvn clean install

# To start/run the project spring boot maven plugin is included just run
mvn spring-boot:run

# The integration test may be executed using
mvn test
```
 # Usage 
Once the application is started,

1. Erase all the trades, run below command in [cURL](https://en.wikipedia.org/wiki/CURL)
```
$curl -i -X DELETE http://localhost:8080/erase
````
2. Add a new trade,
```
$curl -X POST http://localhost:8080/trades/  -H "content-type: application/json"
-d "
    {
        "id": 1,
        "type": "buy",
        "user": {
            "id": 2,
            "name": "Amy Palmer"
        },
        "symbol": "AA",
        "shares": 11,
        "price": 174.82,
        "timestamp": "2018-12-28 13:18:48"
    }"
```
3. Return a trade filtered by ID, http://localhost:8080/trades/1 (1 -> id of trade).
4. http://localhost:8080/trades/ , return all trades the response should be sorted in ascending order by trade ID.
5.  Get all the trades filtered by USER ID,goto http://localhost:8080/trades/users/1 the response should be sorted in ascending order by trade ID.(1 -> id of user)
6. http://localhost:8080/trades/stocks/AA, return all the trades filtered by STOCK SYMBOL the response should be sorted in ascending order by trade ID. (AA -> stock symbol)
7. Return all the trades filtered by USER ID & STOCK SYMBOL the response should be sorted in ascending order by trade ID, http://localhost:8080/trades/users/2/stocks/AA (2 -> id of user, AA-> stock symbol).


## You may also like...

- [Contact System](https://github.com/prabha1729/Spring-Boot-RESTful-Api) - A Spring Boot RESTful service for Contact Entry System.
- [Airport Info](https://github.com/prabha1729/Airport-Info) - A Spring Boot Service for airport information.
