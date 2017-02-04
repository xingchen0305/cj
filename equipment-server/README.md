## Equipment Server
- Build
`mvn clean package docker:build -Dmaven.test.skip=true`
- Run
`docker run --name equipment-server  -p 8080:8080 -d bupt626/equipment-server`