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
