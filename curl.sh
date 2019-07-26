echo "第一题-----------"
echo "使用Spring 技术实现往film 表中插入一条数据"
curl -v -X POST localhost:18080/film/insert



echo "第二题-------------"
echo "登录接口，POST 请求，通过curl 传入name 和password"
curl -v -X POST localhost:18080/login/select -d 'name=BARBARA&password=JONES'



echo "第三题--------------"
echo "声明一个Page 对象，包含pageSize 、page和 sort 属性，分别表示要查询分页的大小、页数以及是正 序还是倒叙"
curl -v localhost:18080/film/getpage?page=1&pageSize=2



echo "第四题---------------"
echo "查询film 列表，GET 请求，通过curl 传入pageSize 和page。方法上使用Page对象接收"
curl -v localhost:18080/film/getpage?page=1&pageSize=2



echo "第五题---------"
echo "新增用户，PUT 请求"
curl -H "Content-Type: application/json" -X PUT  --data '{"firstName":"lk","lastName":"xxp","email":"32145","address":"大理"}' http://localhost:18080/login/insert



echo "第六题-------------------"
echo "更新刚才的用户"
curl -v -X POST localhost:18080/login/update


echo "第七题-------------"
echo "删除新增的用户"
curl -v -X DELETE localhost:18080/login/delte


echo "第八题-------------"
echo "使用mybatis 的PageHelper 插件来执行分页查询"
curl -v localhost:18080/film/list/2/1
