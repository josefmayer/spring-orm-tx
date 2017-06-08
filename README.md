## Spring ORM
Persist, query data in database with Spring, ORM Hibernate <br />


### Technologies
Spring, JPA, Hibernate, Transaction <br /> 


### Project Structure
Model: <br />
Entity Product <br />

Dao: <br />
ProductDao <br />
Implements CRUD methods <br />
Implemented with JPA EntityManager <br />

Service: <br />
Implemented with Dao <br />
Adds Transactions: @Transaction <br />


### Context configuraton xml-based: Spring.xml:  <br />
ClassPathXmlApplicationContext: <br />
dataSource <br /> 
entitymanagerfactory <br />
transactionmanager <br />



### Steps
##### Compile, package jar 
*mvn clean compile package*  <br />

##### Run Application
*java -jar target/jar-name.jar* <br />


