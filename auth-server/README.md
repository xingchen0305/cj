## AUTH Server
- Build
`mvn clean package docker:build -Dmaven.test.skip=true`
- Run
`docker run --name auth-server --link discovery-server:discovery --link ams-mysql:db -p 9999:9999 -d bupt626/auth-server`


