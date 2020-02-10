<h1>Person Application</h1>
<p>Person application is a web and REST API based application to perform read,write and delete operations of various details about a person such as first name,last name,favourite color, age, hobbies.</p>

<p>Persons App is a Maven’s project created using the Eclipse IDE. The application is developed using Spring framework with a H2 in-memory database at the backend with authentication. The Application uses Ajax/JQuery scripting front end  to perform CRUD operations. It supports REST Shell interface to perform CLI operations. 
</p>
<p>The applications support GET,POST,PUT and DELETE options for the Persons details.</p>

<b>GitHub Project URL</b>

https://github.com/anusha-guna/embl_person_app.git

<b>Docker Container</b><br>
<p>Persons Application is available as a Docker container as well. Please login into your Docker account and follow the below steps to run the Docker container.</p>

```bash
docker pull anushagunasekaran/embl_person_app
docker run -p 8080:8080 anushagunasekaran/embl_person_app
```

<b>Packages</b>
1. Spring version 2.1.2

2. H2 In-Memory Database

3. Java 1.8.



<b>Authentication</b>

<p>Person application uses Spring security framework for securing the REST API calls. It implements Spring web security adapter class and uses the basic username and password based authentication.</p><p>CRUD operations require username/password. I have hard coded the username and password and associated roles in the application code.</p>

There are 2 user roles available in the application.

<b>Admin User:</b> Admin user can perform all operations including write operation.

<b>User:</b> Users having User role can perform only GET/READ operation. Username/Password to perform the CRUD operation is embladmin/password. Username/Password to perform USER role operation us embluser/password.

<p>There are several ways to run the project. An ideal way would be clone the GIT repository to the Eclipse’s working folder and run the project from the App.java class. Additionally, to validate the REST APIs, any REST API client like Chrome’s POSTMAN plugin can be used.
</p>

<b>Command Line Client</b>
<p>Spring REST Shell version 1.2.0.</p>

Rest Shell can be downloaded from https://github.com/spring-projects/rest-shell/downloads .

<b>Deploying in Eclipse IDE</b>

The Persons application can be cloned from the GitHub repo and can be imported to Eclipse manually as well. Please follow the below method to manually import the project.

Please import the project in Eclipse using File->Open Projects from File System menu and use the Maven project wizard to import the project. Once the project is imported to Eclipse, please run the App.java to start the project.

<b>API Documentation </b>

<p>1.GET:Get All Person List API</p>

<p>URL : http://localhost:8080/persons/</p>

Output:

```bash
{ 
   "persons":[ 
      { 
         "id":1,
         "age":29,
         "favColor":"Red",
         "hobbyList":[ 
            "Cricket",
            "Chess"
         ],
         "fname":"Raj",
         "lastName":"Kumar"
      },
      { 
         "id":2,
         "age":29,
         "favColor":"Red",
         "hobbyList":[ 
            "Cricket",
            "Chess"
         ],
         "fname":"Raj",
         "lastName":"Kumar"
      },
      { 
         "id":3,
         "age":29,
         "favColor":"Black",
         "hobbyList":[ 
            "Chess"
         ],
         "fname":"Anusha",
         "lastName":"Guna"
      }
   ]
}

```


<p>2. GET : Single person get details API</p>
<p>URL : http://localhost:8080/persons/{user_id}</p>

Example: http://localhost:8080/persons/7

Output:

```bash

{ 
   "persons":{ 
      "id":7,
      "age":29,
      "favColor":"Red",
      "hobbyList":[ 
         "Cricket",
         "Chess"
      ],
      "fname":"Raj",
      "lastName":"Kumar"
   }
}
```

<p>3. POST :Post supports Add operation or Add all operation. Person(s) details can be a single person or multiple persons.</p>

<p>URL : http://localhost:8080/persons/</p>

Input:

```bash
[
   {
      "fname":"Raj",
      "lastName":"Kumar",
      "age":"29",
      "favColor":"Red",
      "hobbyList":[
         "Cricket",
         "Chess"
      ]
   },
   {
      "fname":"Anusha",
      "lastName":"Guna",
      "age":"29",
      "favColor":"Black",
      "hobbyList":[
         "Chess"
      ]
   }
]
```
Output:
```bash
{
    "persons": [
        {
            "id": 4,
            "age": 29,
            "favColor": "Red",
            "hobbyList": [
                "Cricket",
                "Chess"
            ],
            "fname": "Raj",
            "lastName": "Kumar"
        },
        {
            "id": 5,
            "age": 29,
            "favColor": "Black",
            "hobbyList": [
                "Chess"
            ],
            "fname": "Anusha",
            "lastName": "Guna"
        }
    ]
}
```

<p>4. PUT : Single person edit API. The URL must include the id which needs to be updated in the record.</p>

<p>URL : http://localhost:8080/persons/1</p>

Input:

```bash
{
   "age":29,
   "favColor":"grey",
   "hobbyList":[
      "Cricket",
      "Chess"
   ],
   "fname":"Raj",
   "lastName":"Kumar"
}
 ```
 Output:
 
 ```bash
 {
    "persons": {
        "id": 2,
        "age": 29,
        "favColor": "grey",
        "hobbyList": [
            "Cricket",
            "Chess"
        ],
        "fname": "Raj",
        "lastName": "Kumar"
    }
}
 ```
 
<p>5. DELETE: Delete performs record delete operation. The URL must include the id of the record which needs to be deleted.</p>

<p>URL : http://localhost:8080/persons/1</p>

Output:

```bash
{ 
   "message":"Deleted Successfully"
}
```
<b>API Documentation for Spring Rest Shell</b>

To connect to the rest shell, use the rest-shell command available inside the bin folder of the Rest Shell folder. 
Example CLI commands

Authentication command:

auth basic --username embladmin --password password

Get command example:
```bash
get http://localhost:8080/persons/3
```
Post Command Example:
```bash
post http://localhost:8080/persons --data [{"age":12,"fname":"raj","lastName":"kumar","hobbyList”:[“running”,”dancing”],”favColor”:”blue”}] 
```
<b>Web UI</b> 
<p>
Persons Application supports a web UI to input and delete persons details. It can be connected using a browser to http://localhost:8080.</p>
