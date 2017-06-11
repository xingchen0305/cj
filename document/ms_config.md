## 部署在容器中的时候

### 如何解决容器ip对外不可见的问题

- Build
`mvn clean package docker:build -Dmaven.test.skip=true`
- Run
`docker run --name config-server -e "DISCOVERY_ADDRESS=169.254.227.249:8761/eureka"  -p 8888:8888 -d bupt626/config-server`
- 打包
`docker save -o discovry.tar bupt626/discovery-server:latest`
- 解包
`docker load -i discovry.tar`

##### 以config-server 为例：
`docker run --name config-server -e "DISCOVERY_ADDRESS=172.17.0.4:8761/eureka"  -p 8888:8888 -d bupt626/config-server`
这里的ip需要先通过网页查看注册中心的内部ip（172）,不然无法注册

另外，如果直接注册，会只显示容器名，不能显示ip
需要在配置上改为(每个注册的微服务都要改，未来使用K8s管理可以解决)：
`eureka.instance.prefer-ip-address = true`  这个是以ip显示，但还是不能显示外部ip
`eureka.instance.ip-address=10.105.242.74`  这个是手动配置的外部ip

（这个尽量卸载bootstrap里面，不然去服务中心改太麻烦）