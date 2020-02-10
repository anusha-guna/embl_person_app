
Persons application is a simple web and REST API based application to perform read and write operations of various details about a person like name, age, hobbies etc.

Persons App is a Maven’s project created using the Eclipse IDE. The application is developed using Spring framework with a H2 in-memory database at the backend. The Application uses Ajax/JQuery scripting front end to construct the client side JSON objects and uses the REST APIs built using the Spring framework model to perform CRUD operations.

The applications support add, edit, delete, get and get list options for the Persons details.

GitHub Project URL

https://github.com/anusha-guna/embl_user_app.git

Packages

1. Spring version 2.1.2

2. H2 In-Memory Database

3. Java 1.8.

4. Spring REST Shell version 1.2.0.

Rest Shell can be downloaded from https://github.com/spring-projects/rest-shell/downloads .

There are several ways to run the project. An ideal way would be clone the GIT repository to the Eclipse’s working folder and run the project from the App.java class. Additionally to validate the REST APIs, any REST API client like Chrome’s POSTMAN plugin can be used. Person application uses Spring security framework for securing the REST API calls. It implements Spring web security adapter class and uses the basic username and password based authentication. All Person CRUD operations require username/password. I have hard coded the username and password and associated roles in the application code.

There are 2 user roles available in the application.

Admin User: Admin user can perform all operations including write operation.

User: Users having User role can perform only GET/READ operation. Username/Password to perform the CRUD operation is embladmin/password. Username/Password to perform USER role operation us embluser/password. Importing in Eclipse IDE

The Persons application can be cloned from the GitHub repo and can be imported to Eclipse manually as well. Please follow the below method to manually import the porject. Please import the project in Eclipse using File->Open Projects from File System menu and use the eMaven project wizard to import the project. Once the project is imported to Eclipse, please run the App.java to start the project. API Documentation for REST API Client like Postman

1. Get All Person List from Database:

http://localhost:8080/persons/

Expected Result:

{ "persons": [ { "id": 7, "age": 23, "favColor": "Grey", "hobbyList": [ "shopping", "Golf" ], "fname": "Anusha", "lastName": "Guna" }, { "id": 8, "age": 34, "favColor": "Black", "hobbyList": [ "Cricket", "Joggin" ], "fname": "Peter", "lastName": "White" }, { "id": 9, "age": 34, "favColor": "Grey", "hobbyList": [ "Movies", "Running" ], "fname": "Raj", "lastName": "Kumar" } ] }

2. Get :

http://localhost:8080/persons/{user_id}

Example: http://localhost:8080/persons/7

Expected Result:

{ "persons": { "id": 7, "age": 23, "favColor": "Grey", "hobbyList": [ "shopping", "Golf" ], "fname": "Anusha", "lastName": "Guna" } } 3. POST : http://localhost:8080/persons Post supports Add operation or Add all operation Person details can be a sing person JSON or multiple persons JSON. Below is the supported format to input the details. Single Person input format { "persons": { "id": 7, "age": 23, "favColor": "Grey", "hobbyList": [ "shopping", "Golf" ], "fname": "Anusha", "lastName": "Guna" } } Multiple person input format. [Persons] title is not required. [ { "id": 10, "age": 23, "favColor": "Grey", "hobbyList": [ "shopping", "Golf" ], "fname": "Anusha", "lastName": "Guna" }, { "id": 11, "age": 34, "favColor": "Black", "hobbyList": [ "Cricket", "Joggin" ], "fname": "Peter", "lastName": "White" }, { "id": 12, "age": 34, "favColor": "Grey", "hobbyList": [ "Movies", "Running" ], "fname": "Raj", "lastName": "Kumar" } ]

4. Put : Put performs edit operation. The URL must include the id which needs to be updated in the record.

url : http://localhost:8080/persons/1

{ "fname":"anushaj1", "lName":"gunasekaran", "age":16, "favColor":"t", "hobbyList”:[“running”,”dancing”] }

5. DELETE: Delete performs record delete operation. The URL must include the id of the record which needs to be deleted.

url : http://localhost:8080/persons/1

Expected Result:

{ "message": "Deleted Successfully" }

API Documentation for Spring Shell

To connect to the rest shell, use the rest-shell command available inside the bin folder of the Rest Shell folder. Example CLI commands

Authentication command:

auth basic --username embladmin --password password

Get command example:

get http://localhost:8080/persons/3

Post Command Example:

post http://localhost:8080/persons --data [{"age":12,"fname":"raj","lastName":"kumar","hobbyList”:[“running”,”dancing”],”favColor”:”blue”}] Web UI: Persons Application supports a web UI to input and delete persons details. It can be connected using a browser to http://localhost:8080.

