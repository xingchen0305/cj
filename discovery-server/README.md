## Config Server
- Build
`mvn clean package docker:build -Dmaven.test.skip=true`
- Run
`docker run --name discovery-server  -p 8761:8761 -d bupt626/discovery-server`


