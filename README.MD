# Pharmacy

Pharmacy is an application to show information based on authorized user among pharmacist, patien, physician and admin who monitors everything.
# Node server
[excel to json libray](https://www.npmjs.com/package/convert-excel-to-json) to read excel files and middleware to check who were auntenticated.

## Installation guide
```
 cd node-server && npm install
 npm start
```
## Endpoints

| Method|API | Description |
| ---|--- | ------ |
|POST|http://192.168.1.64:8080/servlet/Authenticate| Login user|
|POST| http://192.168.1.64:8080/servlet/Signup | Register new user |
|POST|http://192.168.1.64:9000/api/v1/getinfo| get pharmacy info based on signed in user

# REACT JS

 It has webpages to show off pages related to logged in user.

 ## Installation guide
 ```
 cd client && npm install
 npm start
 ```
# Servlet
 1. Open netbeans
 2. Click file > open > servlet> download and import `gson-2-8-2.jar and java.json.jar` libraries there you can read JSON key:value pair from __reactjs__ or __postman__
 3. Add tomcat server as well to serve APIs

# Tools

 - Netbeans
 - Vscode
 - Figma [figma](https://www.figma.com/proto/PmvZ7l9zFT59oObzXEWEtC/Untitled?node-id=1%3A3)
 ### docker
 - Hopefully you have installed docker other wise get it from [here](docker.com) and run the following commands in terminal 
 - cd client 
    ``` 
    docker build -t container_name . 
    docker run -d -p 3000:3000 container_name
    ```
    Later on open browser and type localhost:3000 ` signup page is expected to be loaded`
- cd node-server
 ``` 
    docker build -t container_name . 
    docker run -d -p 9000:9000 container_name
    ```
 Later on open browser and type localhost:9000/testDocker ` Docker is working... is expected to be opened in webpage`
 