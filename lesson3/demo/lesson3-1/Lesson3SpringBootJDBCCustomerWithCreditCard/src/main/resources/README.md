First you need to create the tables in the database:

CREATE TABLE customer (
  customerNumber  INTEGER PRIMARY KEY,
  name VARCHAR(50),
  email VARCHAR(50),
   phone VARCHAR(50)
);

CREATE TABLE creditcard (
  cardNumber  VARCHAR(50) PRIMARY KEY,
  type VARCHAR(50),
  validationDate VARCHAR(50),
  customernumber INTEGER
);


#### To build own database with HSQLDB
- [READ](https://www.baeldung.com/spring-boot-hsqldb)

Here are the steps that we should follow:

First, we’ll download HSQLDB and unzip it to a folder
Since HSQLDB doesn’t provide a default database out of the box, we’ll create one called “trainingdb” for example purposes
We’ll launch a command prompt and navigate to the HSQLDB data folder
Within the data folder, we’ll run the following command:
```
java -cp ../lib/hsqldb.jar org.hsqldb.server.Server --database.0 file:trainingdb --dbname.0 trainingdb
```
- must create tables first before running the application


