# SAM

School Asset Management

-------



+ #### 配置中心 config-server

> 1. 统一配置中心，每个项目的类路径下如果存在`spring-cloud-config-client` 包，会自动去找配置中心，配置中心地址默认是localhost:8888, 可配置属性`spring.cloud.cinfig.uri`
> 2. 配置中心由git管理，可配置 `spring.cloud.config.server.git.uri`属性。本项目配置为`file://${HOME}/work/config-repo` （暂时），配置文件存放在本地目录，并且由git管理，本项目配置文件的github地址为[https://github.com/xiuyuhe/config-repo.git](https://github.com/xiuyuhe/config-repo.git)，clone到本地上述位置，每次变化commit后方能生效

- #### 服务发现 discovery-server

> 1. 使用NetFlix Eureka（暂时），使用`@EnableEurekaServer`开启
> 2. 其他服务，开启服务发现客户端，`@EnableDiscoveryClient`
> 3. 详细配置请查看spring cloud eureka 文档

