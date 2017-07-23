## Equipment Server
- Build
`mvn clean package docker:build -Dmaven.test.skip=true`
- Run
`docker run --name equipment-server -p 8755:8755 --link auth-server:auth --link discovery-server:discovery --link ams-mysql:db  -d bupt626/equipment-server`


### Get Token 
curl http://10.105.242.74:9999/uaa/oauth/token -d "grant_type=password&scope=read&username=hexiuyu&password=123456" -u bupt-client:bupt626