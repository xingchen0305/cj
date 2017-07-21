

机器：

| 地址            | 作用                  |
| ------------- | ------------------- |
| 10.105.242.65 | 存储服务器               |
| 10.105.242.66 | 8G + 60G + 4cpu（未用） |
| 10.105.242.74 | 微服务项目服务器            |

服务：

| 地址                 | 服务   |
| ------------------ | ---- |
| 10.105.242.74:3306 | 数据库  |
| 10.105.242.74:4999 | showDoc |
| 10.105.242.66:27017 | mongoDB |

mongodb ： admin:<password>



注：密码群里问，或者私信我

ssh 登录：
ssh root@10.105.242.65

校园网登录： 
1. python /data/bupt/login.py
2. 用户名/密码
3. python /data/bupt/logout.py

mongodb : `docker run -d -p 27017:27017 -p 28017:28017 -e MONGODB_PASS="xxx" tutum/mongodb`
