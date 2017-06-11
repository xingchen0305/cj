## API Server
- Build
`mvn clean package docker:build -Dmaven.test.skip=true`
- Run
`docker run --name api-gateway -e CONFIG_ADDRESS=172.17.0.3 -p 80:80 -d bupt626/api-gateway`


