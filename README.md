# Hacker-Rank-Stock-Trade-Api
This is a prototype for building a brokerage company's account and trades management platform. One Requirement is for a REST API service to manage trades using Spring Boot framework. Add functionality to add or delete transations as well as to perform some queries.
 
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

- Erase all the trades, run below command in [cURL](https://en.wikipedia.org/wiki/CURL)
```
$curl -i -X DELETE http://localhost:8080/erase
````
- Add a new trade,
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
- Return a trade filtered by ID, http://localhost:8080/trades/1 (1 -> id of trade).
- http://localhost:8080/trades/ , return all trades the response should be sorted in ascending order by trade ID.
-  Get all the trades filtered by USER ID,goto http://localhost:8080/trades/users/1 the response should be sorted in ascending order by trade ID.(1 -> id of user)
- http://localhost:8080/trades/stocks/AA, return all the trades filtered by STOCK SYMBOL the response should be sorted in ascending order by trade ID. (AA -> stock symbol)
- Return all the trades filtered by USER ID & STOCK SYMBOL the response should be sorted in ascending order by trade ID, http://localhost:8080/trades/users/2/stocks/AA (2 -> id of user, AA-> stock symbol).


