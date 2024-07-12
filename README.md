## Lab work

#### Lab one

- [x] Spring framework and Dependency Injection

#### Lab two

- [x] Spring boot and AOP

#### Lab three

- [x] Spring boot and JPA and JD

#### Lab four

#### Lab five

- embedded puts properties into the same class e.g appointment and payment but class must be formed first but not saved
- secondarytables puts properties into a different class e.g patient and address but the secondary class is imaginary and not formed but produced as a table

#### Kubernetes service
- set up the blacklabelops/hsqldb image and deployment, then spin up the service
- run the following commands: this will enable access on localhost:9003
```
kubectl port-forward service/SERVICE_NAME MY_DESIRED_PORT_NUMBER:EXPOSED_SERVICE_PORT_NUMBER
e.g kubectl port-forward service/hsqldb-service 9003:9001
```
- make sure to set the environment variables in the deployment file
- for database name, alias and passwords under containers
```
          env:
            - name: HSQLDB_DATABASE_NAME
              value: "trainingdb"
            - name: HSQLDB_DATABASE_ALIAS
              value: "trainingdb"
            - name: HSQLDB_USER
              value: "SA"
            - name: HSQLDB_PASSWORD
              value: ""
```


#### Lab six
- [x] Spring Queries

#### Lab seven
- [x] Spring transactions and concurrency and optimization

#### Lab eight

- [x] Spring MongoDB

#### Lab nine
- [x] Spring REST Services

      Best practices for RESTful services
        - Put only one or two path variables on the URL
        - A method should hav 3 or less parameters
        - Always return objects to the front End not strings or numbers
        - Always give default constructor , getters and setters to classes
        - In Spring Boot, always return RESPONSE ENTITY. Helps to set headers and status codes
        - Always return the same object on sucess POST anc PUT
        - For Lists, always return RESPONSE ENTITY with only one converted object to avoid front end massage
        - Never return a list of objects
        - Nevere return an exception to the front end
        - Use @RestControllerAdvice to handle exceptions
        - Use @Valid to validate objects
        - Use @RequestBody to get objects from the front end
        - Use @PathVariable to get path variables
        - Use @RequestParam to get query parameters
        - Use @RequestHeader to get headers
        - Use @ResponseStatus to set status codes
        - Use @GetMapping, @PostMapping, @PutMapping, @DeleteMapping
        - Use @CrossOrigin to allow front end to access the back end
        - Use @Transactional to handle transactions
        - Use @Async to handle concurrency
        - Use verbs and plurals in the URL
        - Use underscores in the URL e.g ?results_per_page=20
        - Use camel case in the URL e.g ?resultsPerPage=20
        - Though not sure about the last two points

## NOTE:
    - POST is not idempotent i.e it changes the state of the server whenever it is called
    - WAR files are not used in Spring Boot anymore but JAR files, the latter is more efficient and creates a container with Tomcat embedded


#### Lab thirteen
- Testing with JUnit and monitoring
[Test Coverage Tools](https://www.unlogged.io/post/code-coverage-tools-in-java-spring-boot-a-comprehensive-guide)

