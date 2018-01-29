# Spring-Boot-Generic-Mock
It's a Spring Boot Server to call and Json Mock file from local system


For start the project we need the next files:

#Package
mvn clean package
#Running
java -jar xxxx.jar --local.path={your-file-path}

#properties
server.port={the port server you want}
local.path={the path for your json files}
ext.file={if you want other files extension}

