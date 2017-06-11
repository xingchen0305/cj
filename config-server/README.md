## Config Server
- 本地运行
cp config-repo/* $HOME/work/config-repo/

- Build
`mvn clean package docker:build -Dmaven.test.skip=true`
- Run
`docker run --name config-server -e "DISCOVERY_ADDRESS=169.254.227.249:8761/eureka"  -p 8888:8888 -d bupt626/config-server`
- 打包
`docker save -o discovry.tar bupt626/discovery-server:latest`
- 解包
`docker load -i discovry.tar`

##这里因为校园网不太好访问外网，所以使用本地仓库没有使用git

## 注意，如何将配置文件copy到容器里
    maven的 docker build 的根目录是打包好的文件件下面的docker目录
    如何将 配置文件 build的时候 放入docker目录呢，使用了maven一个插件
    ```
    <plugin>
        <artifactId>maven-resources-plugin</artifactId>
        <version>3.0.2</version>
        <executions>
            <execution>
                <id>copy-resources</id>
                <!-- here the phase you need -->
                <phase>validate</phase>
                <goals>
                    <goal>copy-resources</goal>
                </goals>
                <configuration>
                    <outputDirectory>${basedir}/target/docker/config-repo</outputDirectory>
                    <resources>
                        <resource>
                            <directory>config-repo</directory>
                            <filtering>true</filtering>
                        </resource>
                    </resources>
                </configuration>
            </execution>
        </executions>
    </plugin>
    ```
    
    这里使用了maven一个插件
    
    更改后的配置文件如何放置在容器里
   `scp config-repo/*  config-repo root@10.105.242.74:/data/images/config-repo/` 
   `tar -cv config-repo/* | docker exec -i config-server  tar x -C/root/work`