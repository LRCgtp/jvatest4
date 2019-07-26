# jvatest4
# jvatest4
汉得作业27日

#####运行本地java项目

1.向film插入一条数据(POST)
localhost:18080/film/insert

2.用户登录（POST）
localhost:18080/login/select?name=BARBARA&password=JONES

3.编写HandlerMethodArgumentResolver（GET请求）
localhost:18080/film/getpage?page=1&pageSize=3

4.查询film 列表(GET)
localhost:18080/film/getpage?page=1&pageSize=3

5.新增用户(PUT)
localhost:18080/login/insert
--参数
{"firstName":"lk","lastName":"xxp","email":"32145","address":"大理"}

6.跟新用户（POST）
localhost:18080/login/update

7.删除用户(DELETE)
localhost:18080/login/delete

8.Mybatis分页插件（GET）
localhost:18080/film/list/2/1



####运行docker-compose运行jar包
将仓库中得docker文件上传到服务器(我已经把docker-compose.yml文件和jar包放入docker目录中了)根目录(/),
cd /docker
docker-compose.yml
具体访问方式跟本地访问一样。



