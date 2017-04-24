# 实验室管理系统接口文档
---
#目录

 + [缩写单词说明](#description)
 + [管理员相关接口](#admin)
    + [学生管理模块](#studentManage)
        + [增添新学生](#addStudent)
        + [删除学生](#deleteStudent)
        + [修改学生信息](#updateStudent)
        + [获取全部学生信息](#getAllStudent)
        + [获取预约项目学生](#getBatchStudent)
        + [获取学生通过年级](#getStudentByGrade)
        + [获取学生通过专业](#getStudentBySpecial)
    + [教师管理模块](#teacherManage)
        + [增添新教师](#addTeacher)
        + [删除教师](#deleteTeacher)
        + [修改教师信息](#updateTeacher)
        + [获取全部教师信息](#getAllTeacher)
        + [获取教师通过姓名](#getTeacherByName)
    + [项目管理模块](#itemManage)
        + [增添新项目](#addItem)
        + [删除项目](#deleteItem)
        + [修改项目信息](#updateItem)
        + [通过ID获取项目](#getItemById)
        + [获取全部项目信息](#getAllItem)
    + [项目批次管理模块](#batchManage)
        + [增添新项目批次](#addBatch)
        + [删除项目批次](#deleteBatch)
        + [修改项目信息批次](#updateBatch)
        + [通过ID获取项目批次信息](#getBatchById)
        + [获取全部项目信息批次](#getAllBatch)
    + [管理员管理模块](#adminManage)
        + [增添管理员](#addAdmin)
        + [删除管理员](#deleteAdmin)
        + [修改管理员信息](#updateAdmin)
        + [获取全部管理员信息](#getAllAdmin)
        + [获取相关管理员信息](#getAdminById)
        + [修改相关管理员密码](#updateAdminById)
    + [公告栏管理模块](#noticeManage)
        + [增添新的公告](#addNotice)
        + [删除公告信息](#deleteNotice)
        + [修改公告信息](#updateNotice)
        + [获取全部公告信息](#getAllNotice)
 + [通过项目批次获取成绩信息](#getTestByBatId)
 + [学生相关接口](#student)
    + [获取已经预约项目](#getHasOrderBatch)
    + [预约项目](#orderBatch)
    + [获取实验成绩](#getTest)
    + [获取相关学生信息](#getStudentById)
    + [修改相关学生密码](#updateStudentById)
 + [教师相关接口](#teacher)
    + [获取安排的项目](#getArrangeBatch)
    + [写入学生成绩信息](#updateTest)
    + [获取相关教师信息](#getTeacherById)
    + [修改相关教师密码](#updateTeacherById)
 + [登录接口](#login) 
    + [登录系统](#loginSystem) 
    + [获取登录信息](#getUserInfo)
 + [错误状态码说明](#error)

---
#<span id="description">缩写单词说明</span>

| 缩写 | 说明 |
|:-------------:|:-------------|
| lbms | [laboratory manage system]实验室管理系统 |
| admin| [administrator]管理员     |
| tea|[teacher]老师|
|num|[number]学生ID|


---
# <span id="admin">管理员相关接口</span>
##<span id="studentManage">学生模块</span>
###<span id="addStudent">增添学生</span>
 - 描述
    增加新的学生用户
 - 请求地址
    
    |操作|path|
    |:----:|:------:|
    |  协议 | HTTP   |
    |数据格式|application/json|
    |方法|POST|
    |ULR全径|http://$variable/lbms/student|


 - 请求参数
    |序号|参数名|必选|数据类型|长度|备注|
    |:--:|:----:|:--:|:------:|:--:|:--:|
    |1|name|Y|String|10byte||
    |2|sex|N|String|1byte|性别'0'代表男'1'代表女|
    |3|specialization|Y|String|10byte|专业|
    |4|grade|Y|String|10byte|年级|
    |5|contact|Y|String|2byte|联系方式|
 - 返回数据
    
    |序号|返回值|中文名称|备注|
    |:--:|:----:|:------:|:--:|
    |1|code|请求状态码|200请求成功,400请求失败|
    |2|data|返回数据|json格式数据，字符串|

 - 请求URL实例
 
```
 POST /lbms/student HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Cache-Control: no-cache
Postman-Token: 17a970cf-7e0d-cfc3-8e1e-b3d73e833569

{
	"name":"李璠涛",
	"sex":"0",
	"specialization":"软件",
	"grade":"2014",
	"contact":"15667027637"
}
```
 - 返回数据实例

```
{
  "code": 200,
  "object": "Zf7WV7XH"//登录账户名(很重要)
}

```

###<span id="deleteStudent">删除学生</span>
 - 描述
    删除学生用户
 - 请求地址
    
    |操作|path|
    |:----:|:------:|
    |  协议 | HTTP   |
    |数据格式|Integer|
    |方法|DELETE|
    |ULR全径|http://$variable/lbms/student/{numId}|


 - 请求参数
    |序号|参数名|必选|数据类型|长度|备注|
    |:--:|:----:|:--:|:------:|:--:|:--:|
    |1|numId|Y|Integer|1byte|学生信息Id|
 - 返回数据
    
    |序号|返回值|中文名称|备注|
    |:--:|:----:|:------:|:--:|
    |1|code|请求状态码|200请求成功,400请求失败|
    |2|data|返回数据|json格式数据，字符串|

 - 请求URL实例
  ```
  DELETE /lbms/student/5 HTTP/1.1
Host: localhost:8080
Cache-Control: no-cache
Postman-Token: a81ffcab-974d-d4f2-d5fc-21ab5965a610
Content-Type: multipart/form-data; boundary=----WebKitFormBoundary7MA4YWxkTrZu0gW
  ```
 


- 返回数据实例


```
{
  "code": 200,
  "data": "删除成功"
}

```

###<span id="updateStudent">修改学生</span>
 - 描述
    修改学生相关信息
 - 请求地址
    
    |操作|path|
    |:----:|:------:|
    |  协议 | HTTP   |
    |数据格式|application/json|
    |方法|PUT|
    |ULR全径|http://$variable/lbms/student|


 - 请求参数
    详情见请求实例
 - 返回数据
    
    |序号|返回值|中文名称|备注|
    |:--:|:----:|:------:|:--:|
    |1|code|请求状态码|200请求成功,400请求失败|
    |2|data|返回数据|json格式数据，字符串|

 - 请求URL实例
 ```
    PUT /lbms/student HTTP/1.1
    Host: localhost:8080
    Content-Type: application/json
    Cache-Control: no-cache
    Postman-Token: e189fe86-04b9-c3c8-e1d9-3883e221d727

    {
	    "numid":4,
	    "name":"喵帕斯",
	    "sex":"1",
	    "specialization":"软件",
	    "grade":"2014",
	    "contact":"15667027637"
    }
 ```
 

 - 返回数据实例

```
{
  "code": 200,
  "data": "更新成功"
}

```
###<span id="getAllStudent">获取全部学生信息</span>
 - 描述
    获取全部学生用户
 - 请求地址
    
    |操作|path|
    |:----:|:------:|
    |  协议 | HTTP   |
    |数据格式|Integer|
    |方法|GET|
    |ULR全径|http://$variable/lbms/student/page/{currentPage}|


 - 请求参数
    |序号|参数名|必选|数据类型|长度|备注|
    |:--:|:----:|:--:|:------:|:--:|:--:|
    |1|currentPage|Y|Integer|1byte|当前页码|
 - 返回数据
    
    |序号|返回值|中文名称|备注|
    |:--:|:----:|:------:|:--:|
    |1|code|请求状态码|200请求成功,400请求失败|
    |2|data|返回数据|json格式数据，字符串|

 - 请求URL实例
 ```
 GET /lbms/student/page/1 HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Cache-Control: no-cache
Postman-Token: 8476daf0-1596-586c-8506-d456c8e8c192

 
 ```


 
- 返回数据实例

```
{
  "code": 200,
  "data": {
    "currentPage": 1,
    "pageSize": 8,
    "recordCount": 1,
    "recordList": [
      {
        "numid": 4,
        "name": "喵帕斯",
        "sex": "1",
        "specialization": "软件",
        "grade": "2014",
        "date": null,
        "contact": "15667027637"
      }
    ],
    "pageCount": 1,
    "beginPageIndex": 1,
    "endPageIndex": 1
  }
}

```
###<span id="getBatchStudent">获取预约项目的学生</span>
 - 描述
    获取预约了相关项目的学生
 - 请求地址
    
    |操作|path|
    |:----:|:------:|
    |  协议 | HTTP   |
    |数据格式|Integer|
    |方法|GET|
    |ULR全径|http://$variable/lbms/student/{batchId}/{currentPage}|


 - 请求参数
    |序号|参数名|必选|数据类型|长度|备注|
    |:--:|:----:|:--:|:------:|:--:|:--:|
    |1|batchId|Y|Integer|1byte|项目批次ID|
    |2|currentPage|N|Integer|1byte|当前页码|
 - 返回数据
    
    |序号|返回值|中文名称|备注|
    |:--:|:----:|:------:|:--:|
    |1|code|请求状态码|200请求成功,400请求失败|
    |2|data|返回数据|json格式数据，字符串|

 - 请求URL实例
```
GET /lbms/student/1/1 HTTP/1.1
Host: localhost:8080
Cache-Control: no-cache
Postman-Token: f0805281-947b-517d-644d-f1a794d5f5f7
```
 
- 返回数据实例

```
{
  "code": 200,
  "data": {
    "currentPage": 1,
    "pageSize": 8,
    "recordCount": 10,
    "recordList": [
      {
        "numid": 4,
        "name": "喵帕斯",
        "sex": "1",
        "specialization": "软件1405",
        "grade": "2014",
        "date": "2017-02-12 11:16:59.0",
        "contact": "15667027637"
      }
    ],
    "pageCount": 2,
    "beginPageIndex": 1,
    "endPageIndex": 2
  }
}

```
###<span id="getStudentByGrade">通过年级查找学生</span>
 - 描述
    获取相关年级的学生
 - 请求地址
    
    |操作|path|
    |:----:|:------:|
    |  协议 | HTTP   |
    |数据格式|Integer|
    |方法|GET|
    |ULR全径|http://$variable/lbms/student/page/grade/{grade}&{currentPage}|


 - 请求参数
    |序号|参数名|必选|数据类型|长度|备注|
    |:--:|:----:|:--:|:------:|:--:|:--:|
    |1|grade|Y|Integer|1byte|年级|
    |2|currentPage|N|Integer|1byte|当前页码|
 - 返回数据
    
    |序号|返回值|中文名称|备注|
    |:--:|:----:|:------:|:--:|
    |1|code|请求状态码|200请求成功,400请求失败|
    |2|data|返回数据|json格式数据，字符串|

 - 请求URL实例
```
GET /lbms/student/page/grade/2014&amp;1 HTTP/1.1
Host: localhost:8080
Cache-Control: no-cache
Postman-Token: 6da8369c-bd5a-4d05-9ec9-c8a5388affa0

```
 
- 返回数据实例

```
{
  "code": 200,
  "data": {
    "currentPage": 1,
    "pageSize": 8,
    "recordCount": 10,
    "recordList": [
      {
        "numid": 4,
        "name": "喵帕斯",
        "sex": "1",
        "specialization": "软件1405",
        "grade": "2014",
        "date": "2017-02-12 11:16:59.0",
        "contact": "15667027637"
      },
      {
        "numid": 5,
        "name": "李璠涛",
        "sex": "1",
        "specialization": "软件1405",
        "grade": "2014",
        "date": "2017-02-14 16:46:01.0",
        "contact": "15667027637"
      },
      {
        "numid": 6,
        "name": "李璠涛",
        "sex": "1",
        "specialization": "软件1405",
        "grade": "2014",
        "date": "2017-02-14 16:46:06.0",
        "contact": "15667027637"
      },
      {
        "numid": 7,
        "name": "李璠涛",
        "sex": "1",
        "specialization": "软件1405",
        "grade": "2014",
        "date": "2017-02-14 16:46:08.0",
        "contact": "15667027637"
      },
      {
        "numid": 8,
        "name": "李璠涛",
        "sex": "1",
        "specialization": "软件1405",
        "grade": "2014",
        "date": "2017-02-14 16:46:09.0",
        "contact": "15667027637"
      },
      {
        "numid": 9,
        "name": "李璠涛",
        "sex": "1",
        "specialization": "软件1405",
        "grade": "2014",
        "date": "2017-02-14 16:46:10.0",
        "contact": "15667027637"
      },
      {
        "numid": 10,
        "name": "李璠涛",
        "sex": "1",
        "specialization": "软件1405",
        "grade": "2014",
        "date": "2017-02-14 16:46:11.0",
        "contact": "15667027637"
      },
      {
        "numid": 11,
        "name": "李璠涛",
        "sex": "1",
        "specialization": "软件1405",
        "grade": "2014",
        "date": "2017-02-14 16:46:11.0",
        "contact": "15667027637"
      }
    ],
    "pageCount": 2,
    "beginPageIndex": 1,
    "endPageIndex": 2
  }
}

```
###<span id="getStudentBySpecial">通过专业查找学生</span>
 - 描述
    获取相关年级的学生
 - 请求地址
    
    |操作|path|
    |:----:|:------:|
    |  协议 | HTTP   |
    |数据格式|Integer|
    |方法|GET|
    |ULR全径|http://$variable/lbms/student/page/special/{special}&{currentPage}|


 - 请求参数
    |序号|参数名|必选|数据类型|长度|备注|
    |:--:|:----:|:--:|:------:|:--:|:--:|
    |1|special|Y|Integer|1byte|专业|
    |2|currentPage|Y|Integer|1byte|当前页码|
 - 返回数据
    
    |序号|返回值|中文名称|备注|
    |:--:|:----:|:------:|:--:|
    |1|code|请求状态码|200请求成功,400请求失败|
    |2|data|返回数据|json格式数据，字符串|

 - 请求URL实例
```
GET /lbms/student/page/special/软件1405&amp;1 HTTP/1.1
Host: localhost:8080
Cache-Control: no-cache
Postman-Token: 7544bb08-1ed6-49d2-ce91-ade69d1004d6

```
 
- 返回数据实例

```
{
  "code": 200,
  "data": {
    "currentPage": 1,
    "pageSize": 8,
    "recordCount": 10,
    "recordList": [
      {
        "numid": 4,
        "name": "喵帕斯",
        "sex": "1",
        "specialization": "软件1405",
        "grade": "2014",
        "date": "2017-02-12 11:16:59.0",
        "contact": "15667027637"
      },
      {
        "numid": 5,
        "name": "李璠涛",
        "sex": "1",
        "specialization": "软件1405",
        "grade": "2014",
        "date": "2017-02-14 16:46:01.0",
        "contact": "15667027637"
      },
      {
        "numid": 6,
        "name": "李璠涛",
        "sex": "1",
        "specialization": "软件1405",
        "grade": "2014",
        "date": "2017-02-14 16:46:06.0",
        "contact": "15667027637"
      },
      {
        "numid": 7,
        "name": "李璠涛",
        "sex": "1",
        "specialization": "软件1405",
        "grade": "2014",
        "date": "2017-02-14 16:46:08.0",
        "contact": "15667027637"
      },
      {
        "numid": 8,
        "name": "李璠涛",
        "sex": "1",
        "specialization": "软件1405",
        "grade": "2014",
        "date": "2017-02-14 16:46:09.0",
        "contact": "15667027637"
      },
      {
        "numid": 9,
        "name": "李璠涛",
        "sex": "1",
        "specialization": "软件1405",
        "grade": "2014",
        "date": "2017-02-14 16:46:10.0",
        "contact": "15667027637"
      },
      {
        "numid": 10,
        "name": "李璠涛",
        "sex": "1",
        "specialization": "软件1405",
        "grade": "2014",
        "date": "2017-02-14 16:46:11.0",
        "contact": "15667027637"
      },
      {
        "numid": 11,
        "name": "李璠涛",
        "sex": "1",
        "specialization": "软件1405",
        "grade": "2014",
        "date": "2017-02-14 16:46:11.0",
        "contact": "15667027637"
      }
    ],
    "pageCount": 2,
    "beginPageIndex": 1,
    "endPageIndex": 2
  }
}

```
##教师模块
###<span id="addTeacher">增加教师</span>
 - 描述
    增加新教师用户
 - 请求地址
    
    |操作|path|
    |:----:|:------:|
    |  协议 | HTTP   |
    |数据格式|Integer|
    |方法|GET|
    |ULR全径|http://$variable/lbms/teacher|


 - 请求参数
    详情参见请求实例
 - 返回数据
    
    |序号|返回值|中文名称|备注|
    |:--:|:----:|:------:|:--:|
    |1|code|请求状态码|200请求成功,400请求失败|
    |2|data|返回数据|json格式数据，字符串|

 - 请求URL实例
 ```
 POST /lbms/teacher HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Cache-Control: no-cache
Postman-Token: 8328f889-3582-81f1-f92f-de553b43d933
{
	"name":"喵帕斯",
	"sex":"1",
	"title":"软件",
	"education":"硕士",
	"contact":"15667027637"
}
 ```


 
- 返回数据实例

```
{
  "code": 200,
  "data": "MTIc1pFF"//登录名很重要
}

```
###<span id="updateTeacher">更新教师</span>
 - 描述
    更新教师用户信息
 - 请求地址
    
    |操作|path|
    |:----:|:------:|
    |  协议 | HTTP   |
    |数据格式|application/json|
    |方法|GET|
    |ULR全径|http://$variable/lbms/teacher|


 - 请求参数
    详情见请求实例
 - 返回数据
    
    |序号|返回值|中文名称|备注|
    |:--:|:----:|:------:|:--:|
    |1|code|请求状态码|200请求成功,400请求失败|
    |2|data|返回数据|json格式数据，字符串|

 - 请求URL实例
```
PUT /lbms/teacher HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Cache-Control: no-cache
Postman-Token: 49f0b3af-83d6-66f3-0f5f-45f460027f00

{
	"teaid":1,
	"name":"喵帕斯",
	"sex":"0",
	"title":"软件",
	"education":"硕士",
	"contact":"15667027637"
}
```
 
- 返回数据实例

```
{
  "code": 200,
  "data": "更新成功"
}

```
###<span id="deleteTeacher">删除教师</span>
 - 描述
    删除教师用户
 - 请求地址
    
    |操作|path|
    |:----:|:------:|
    |  协议 | HTTP   |
    |数据格式|Integer|
    |方法|DELETE|
    |ULR全径|http://$variable/lbms/teacher/{teaId}|


 - 请求参数
    |序号|参数名|必选|数据类型|长度|备注|
    |:--:|:----:|:--:|:------:|:--:|:--:|
    |1|teaId|Y|String|1byte|教师ID|
 - 返回数据
    
    |序号|返回值|中文名称|备注|
    |:--:|:----:|:------:|:--:|
    |1|code|请求状态码|200请求成功,400请求失败|
    |2|data|返回数据|json格式数据，字符串|

 - 请求URL实例
```
DELETE /lbms/teacher/2 HTTP/1.1
Host: localhost:8080
Cache-Control: no-cache
Postman-Token: ede04d9a-f955-b7a8-420e-500c0c365a0f
Content-Type: multipart/form-data; boundary=----WebKitFormBoundary7MA4YWxkTrZu0gW

------WebKitFormBoundary7MA4YWxkTrZu0gW--
```
 
- 返回数据实例

```
{
  "code": 200,
  "data": "删除成功"
}

```

###<span id="getAllTeacher">获取教师信息</span>
 - 描述
    获取所有教师用户
 - 请求地址
    
    |操作|path|
    |:----:|:------:|
    |  协议 | HTTP   |
    |数据格式|Integer|
    |方法|GET|
    |ULR全径|http://$variable/lbms/teacher/page/{currentPage}|


 - 请求参数
    |序号|参数名|必选|数据类型|长度|备注|
    |:--:|:----:|:--:|:------:|:--:|:--:|
    |1|currentPage|Y|String|1byte|当前页码|
 - 返回数据
    
    |序号|返回值|中文名称|备注|
    |:--:|:----:|:------:|:--:|
    |1|code|请求状态码|200请求成功,400请求失败|
    |2|data|返回数据|json格式数据，字符串|

 - 请求URL实例
 ```
 DELETE /lbms/teacher/2 HTTP/1.1
Host: localhost:8080
Cache-Control: no-cache
Postman-Token: d189718e-41e9-1f5c-5abf-aaed24ff01f2
Content-Type: multipart/form-data; boundary=----WebKitFormBoundary7MA4YWxkTrZu0gW
------WebKitFormBoundary7MA4YWxkTrZu0gW--
 ```


 
- 返回数据实例

```
{
  "code": 200,
  "data": "删除成功"
}

```
###<span id="getTeacherByName">获取教师信息</span>
 - 描述
    获取所有教师用户
 - 请求地址
    
    |操作|path|
    |:----:|:------:|
    |  协议 | HTTP   |
    |数据格式|Integer|
    |方法|GET|
    |ULR全径|http://$variable/lbms/teacher/name/{name}|


 - 请求参数
    |序号|参数名|必选|数据类型|长度|备注|
    |:--:|:----:|:--:|:------:|:--:|:--:|
    |1|name|Y|String|1byte|教师姓名|
 - 返回数据
    
    |序号|返回值|中文名称|备注|
    |:--:|:----:|:------:|:--:|
    |1|code|请求状态码|200请求成功,400请求失败|
    |2|data|返回数据|json格式数据，字符串|

 - 请求URL实例
 ```
GET /lbms/teacher/name/喵帕斯 HTTP/1.1
Host: localhost:8080
Cache-Control: no-cache
Postman-Token: e245b483-c22b-5d8b-8e94-121e9a08cf43
 ```


 
- 返回数据实例

```
    {
  "code": 200,
  "data": {
    "teaid": 1,
    "name": "喵帕斯",
    "sex": "0",
    "title": "软件",
    "education": "硕士",
    "date": null,
    "contact": "15667027637"
  }
}

```

##项目模块
###<span id="addItem">增加项目</span>
 - 描述
    增加新项目
 - 请求地址
    
    |操作|path|
    |:----:|:------:|
    |  协议 | HTTP   |
    |数据格式|application/json|
    |方法|POST|
    |ULR全径|http://$variable/lbms/item|


 - 请求参数
    |序号|参数名|必选|数据类型|长度|备注|
    |:--:|:----:|:--:|:------:|:--:|:--:|
    |1|itemname|Y|String|15byte|项目名称|
    |2|term|Y|String|5byte|学期|
    |3|coursename|Y|15byte|课程名称|
 - 返回数据
    
    |序号|返回值|中文名称|备注|
    |:--:|:----:|:------:|:--:|
    |1|code|请求状态码|200请求成功,400请求失败|
    |2|data|返回数据|json格式数据，字符串|

 - 请求URL实例
 ```
 POST /lbms/item HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Cache-Control: no-cache
Postman-Token: e46f2df7-811f-ef3b-dd1f-14f764130338
{
	"itemname":"C语言字符串课程设计",
	"term":"第一学期",
	"coursename":"C语言"
}
 ```
 
- 返回数据实例

```
{
  "code": 200,
  "data": "创建成功"
}

```
###<span id="updateItem">更新项目</span>
 - 描述
    更新项目信息
 - 请求地址
    
    |操作|path|
    |:----:|:------:|
    |  协议 | HTTP   |
    |数据格式|Integer|
    |方法|PUT|
    |ULR全径|http://$variable/lbms/item|


 - 请求参数
    详情见请求实例
 - 返回数据
    
    |序号|返回值|中文名称|备注|
    |:--:|:----:|:------:|:--:|
    |1|code|请求状态码|200请求成功,400请求失败|
    |2|data|返回数据|json格式数据，字符串|

 - 请求URL实例
 ```
 PUT /lbms/item HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Cache-Control: no-cache
Postman-Token: c878a7bc-da3d-3943-229e-259d8e1dce77
{
	"itemid":1,
	"itemname":"排序算法练习",
	"term":"第二学期",
	"coursename":"数据结构与算法"
}
 ```
 
- 返回数据实例

```
{
  "code": 200,
  "data": "更新成功"
}

```
###<span id="deleteItem">删除项目信息</span>
 - 描述
    删除项目信息
 - 请求地址
    
    |操作|path|
    |:----:|:------:|
    |  协议 | HTTP   |
    |数据格式|Integer|
    |方法|DELETE|
    |ULR全径|http://$variable/lbms/item/{itemId}|


 - 请求参数
    |序号|参数名|必选|数据类型|长度|备注|
    |:--:|:----:|:--:|:------:|:--:|:--:|
    |1|itemId|Y|Integer|1byte|项目ID|
 - 返回数据
    
    |序号|返回值|中文名称|备注|
    |:--:|:----:|:------:|:--:|
    |1|code|请求状态码|200请求成功,400请求失败|
    |2|data|返回数据|json格式数据，字符串|

 - 请求URL实例
 ```
 DELETE /lbms/item/2 HTTP/1.1
Host: localhost:8080
Cache-Control: no-cache
Postman-Token: 1e7a1670-307a-e2c8-872d-4ea9e55fd03c
Content-Type: multipart/form-data; boundary=----WebKitFormBoundary7MA4YWxkTrZu0gW
------WebKitFormBoundary7MA4YWxkTrZu0gW--
 ```
 
- 返回数据实例

```
{
  "code": 200,
  "data": "删除成功"
}

```
###<span id="getItemById">通过ID获取项目</span>
 - 描述
    通过ID获取项目
 - 请求地址
    
    |操作|path|
    |:----:|:------:|
    |  协议 | HTTP   |
    |数据格式|Integer|
    |方法|GET|
    |ULR全径|http://$variable/lbms/item/{itemId}|


 - 请求参数
    |序号|参数名|必选|数据类型|长度|备注|
    |:--:|:----:|:--:|:------:|:--:|:--:|
    |1|itemId|Y|Integer|1byte|项目ID|
 - 返回数据
    
    |序号|返回值|中文名称|备注|
    |:--:|:----:|:------:|:--:|
    |1|code|请求状态码|200请求成功,400请求失败|
    |2|data|返回数据|json格式数据，字符串|

 - 请求URL实例
 ```
 GET /lbms/item/1 HTTP/1.1
Host: localhost:8080
Cache-Control: no-cache
Postman-Token: d54b4070-ef2f-f05f-d9e1-1b5c8bdba4a9

 ```
 
- 返回数据实例

```
{
  "code": 200,
  "data": {
    "itemid": 1,
    "itemname": "排序算法练习",
    "term": "第二学期",
    "coursename": "数据结构与算法"
  }
}
```

###<span id="getAllItem">获取项目信息</span>
 - 描述
    获取所有项目信息
 - 请求地址
    
    |操作|path|
    |:----:|:------:|
    |  协议 | HTTP   |
    |数据格式|Integer|
    |方法|GET|
    |ULR全径|http://$variable/lbms/item/page/{currentPage}|


 - 请求参数
    |序号|参数名|必选|数据类型|长度|备注|
    |:--:|:----:|:--:|:------:|:--:|:--:|
    |1|currentPage|Y|Integer|1byte|当前页码|
 - 返回数据
    
    |序号|返回值|中文名称|备注|
    |:--:|:----:|:------:|:--:|
    |1|code|请求状态码|200请求成功,400请求失败|
    |2|data|返回数据|json格式数据，字符串|

 - 请求URL实例
 ```
 GET /lbms/item/page/1 HTTP/1.1
Host: localhost:8080
Cache-Control: no-cache
Postman-Token: d54b4070-ef2f-f05f-d9e1-1b5c8bdba4a9

 ```
 
- 返回数据实例

```
{
  "code": 200,
  "data": {
    "currentPage": 1,
    "pageSize": 8,
    "recordCount": 1,
    "recordList": [
      {
        "itemid": 1,
        "itemname": "排序算法练习",
        "term": "第二学期",
        "coursename": "数据结构与算法"
      }
    ],
    "pageCount": 1,
    "beginPageIndex": 1,
    "endPageIndex": 1
  }
}
```
##<span id="batchManage">项目批次模块</span>
###<span id="addBatch">增加项目批次</span>
 - 描述
    增加新的项目批次
 - 请求地址
    
    |操作|path|
    |:----:|:------:|
    |  协议 | HTTP   |
    |数据格式|application/json|
    |方法|POST|
    |ULR全径|http://$variable/lbms/batch|


 - 请求参数
    |序号|参数名|必选|数据类型|长度|备注|
    |:--:|:----:|:--:|:------:|:--:|:--:|
    |1|itemid|Y|Integer|1byte|项目ID|
    |2|teaid|Y|Integer|1byte|分配教师ID|
    |3|laboratory|Y|String|1byte|实验室地址|
    |4|date|Y|String|1byte|实验日期|
    |5|segmentation|Y|String|1byte|节次|
 - 返回数据
    
    |序号|返回值|中文名称|备注|
    |:--:|:----:|:------:|:--:|
    |1|code|请求状态码|200请求成功,400请求失败|
    |2|data|返回数据|json格式数据，字符串|

 - 请求URL实例
```
POST /lbms/batch HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Cache-Control: no-cache
Postman-Token: fdc34ca7-ec3d-1207-a966-c51976f04bfa

{
	"itemid":1,
	"teaid":1,
	"laboratory":"FF104",
	"date":"2017-02-12",
	"segmentation":"3,4节"
}
```
 
- 返回数据实例

```
{
  "code": 200,
  "data": "创建成功"
}

```
###<span id="updateBatch">更新项目批次</span>
 - 描述
    更新项目批次安排
 - 请求地址
    
    |操作|path|
    |:----:|:------:|
    |  协议 | HTTP   |
    |数据格式|application/json|
    |方法|POST|
    |ULR全径|http://$variable/lbms/batch|


 - 请求参数
    详情见请求实例
 - 返回数据
    
    |序号|返回值|中文名称|备注|
    |:--:|:----:|:------:|:--:|
    |1|code|请求状态码|200请求成功,400请求失败|
    |2|data|返回数据|json格式数据，字符串|

 - 请求URL实例
```
PUT /lbms/batch HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Cache-Control: no-cache
Postman-Token: 8b3fd6b1-54c3-785a-1ac7-5d7d95b815d7

{
	"batid":1,
	"itemid":1,
	"teaid":1,
	"laboratory":"FF104",
	"date":"2017-02-12",
	"segmentation":"5,6节"
}
```
 
- 返回数据实例

```
{
  "code": 200,
  "data": "更新成功"
}

```
###<span id="deleteBatch">删除项目批次</span>
 - 描述
    删除项目批次安排
 - 请求地址
    
    |操作|path|
    |:----:|:------:|
    |  协议 | HTTP   |
    |数据格式|Integer|
    |方法|DELETE|
    |ULR全径|http://$variable/lbms/batch/{batchId}|


 - 请求参数
    |序号|参数名|必选|数据类型|长度|备注|
    |:--:|:----:|:--:|:------:|:--:|:--:|
    |1|batchId|Y|Integer|1byte|项目批次ID|
 - 返回数据
    
    |序号|返回值|中文名称|备注|
    |:--:|:----:|:------:|:--:|
    |1|code|请求状态码|200请求成功,400请求失败|
    |2|data|返回数据|json格式数据，字符串|

 - 请求URL实例
 ```
 DELETE /lbms/batch/2 HTTP/1.1
Host: localhost:8080
Cache-Control: no-cache
Postman-Token: 86e31b39-43f7-fac1-b865-f8c61bb62917
Content-Type: multipart/form-data; boundary=----WebKitFormBoundary7MA4YWxkTrZu0gW
------WebKitFormBoundary7MA4YWxkTrZu0gW--
 ```


 - 返回数据实例

```
{
  "code": 200,
  "data": "删除成功"
}

```
###<span id="getBatchById">获取项目批次通过ID</span>
 - 描述
    获取项目批次通过ID
 - 请求地址
    
    |操作|path|
    |:----:|:------:|
    |  协议 | HTTP   |
    |数据格式|Integer|
    |方法|GET|
    |ULR全径|http://$variable/lbms/batch/{batId}|


 - 请求参数
    |序号|参数名|必选|数据类型|长度|备注|
    |:--:|:----:|:--:|:------:|:--:|:--:|
    |1|batId|Y|String|1byte|项目批次ID|
 - 返回数据
    
    |序号|返回值|中文名称|备注|
    |:--:|:----:|:------:|:--:|
    |1|code|请求状态码|200请求成功,400请求失败|
    |2|data|返回数据|json格式数据，字符串|

 - 请求URL实例
 ```
 GET /lbms/batch/1 HTTP/1.1
Host: localhost:8080
Cache-Control: no-cache
Postman-Token: c808ef0a-73e6-4463-7865-e5ed99df1f89
 ```
 
- 返回数据实例

```
{
  "code": 200,
  "data": {
    "batid": 1,
    "itemid": 1,
    "teaid": 1,
    "laboratory": "FF104",
    "date": "2017-02-12",
    "segmentation": "5,6节",
    "sure": null
  }
}
```

###<span id="getAllBatch">获取项目批次信息</span>
 - 描述
    获取所有项目批次信息
 - 请求地址
    
    |操作|path|
    |:----:|:------:|
    |  协议 | HTTP   |
    |数据格式|Integer|
    |方法|GET|
    |ULR全径|http://$variable/lbms/batch/page/{currentPage}|


 - 请求参数
    |序号|参数名|必选|数据类型|长度|备注|
    |:--:|:----:|:--:|:------:|:--:|:--:|
    |1|currentPage|Y|String|1byte|当前页码|
 - 返回数据
    
    |序号|返回值|中文名称|备注|
    |:--:|:----:|:------:|:--:|
    |1|code|请求状态码|200请求成功,400请求失败|
    |2|data|返回数据|json格式数据，字符串|

 - 请求URL实例
 ```
 GET /lbms/batch/page/1 HTTP/1.1
Host: localhost:8080
Cache-Control: no-cache
Postman-Token: c808ef0a-73e6-4463-7865-e5ed99df1f89
 ```
 
- 返回数据实例

```
{
  "code": 200,
  "data": {
    "currentPage": 1,
    "pageSize": 8,
    "recordCount": 1,
    "recordList": [
      {
        "batid": 1,
        "itemid": 1,
        "teaid": 1,
        "laboratory": "FF104",
        "date": "2017-02-12",
        "segmentation": "5,6节",
        "sure": null
      }
    ],
    "pageCount": 1,
    "beginPageIndex": 1,
    "endPageIndex": 1
  }
}
```

##<span id="adminManage">管理员账户模块</span>
###<span id="addAdmin">增加管理员</span>
 - 描述
    增加管理员
 - 请求地址
    
    |操作|path|
    |:----:|:------:|
    |  协议 | HTTP   |
    |数据格式|application/json|
    |方法|POST|
    |ULR全径|http://$variable/lbms/administrator|


 - 请求参数
    |序号|参数名|必选|数据类型|长度|备注|
    |:--:|:----:|:--:|:------:|:--:|:--:|
    |1|name|Y|String|20byte|姓名|
    |2|sex|Y|String|1byte|0男,1女|
    |3|contact|Y|String|20byte|联系方式|
 - 返回数据
    
    |序号|返回值|中文名称|备注|
    |:--:|:----:|:------:|:--:|
    |1|code|请求状态码|200请求成功,400请求失败|
    |2|data|返回数据|json格式数据，字符串|

 - 请求URL实例
 ```
 POST /lbms/administrator HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Cache-Control: no-cache
Postman-Token: 36a269f4-bef0-4d39-9cfe-0575a0d4c03f
{
	"name":"李璠涛",
	"sex":"0",
	"contact":"15667027637"
}
 ```
 
- 返回数据实例

```
{
  "code": 200,
  "data": "WID0JGxL"//登录账号 很重要
}

```
###<span id="updateAdmin">更新管理员</span>
 - 描述
    更新管理员信息
 - 请求地址
    
    |操作|path|
    |:----:|:------:|
    |  协议 | HTTP   |
    |数据格式|application/json|
    |方法|PUT|
    |ULR全径|http://$variable/lbms/administrator|


 - 请求参数
    详情见请求实例
 - 返回数据
    
    |序号|返回值|中文名称|备注|
    |:--:|:----:|:------:|:--:|
    |1|code|请求状态码|200请求成功,400请求失败|
    |2|data|返回数据|json格式数据，字符串|

 - 请求URL实例
 ```
 PUT /lbms/administrator HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Cache-Control: no-cache
Postman-Token: 5a2a2665-93a1-6980-bcac-d8a97886b69e

{
	"admid":"1",
	"name":"喵帕斯",
	"sex":"1",
	"contact":"15667027637"
}
 ```
 
- 返回数据实例

```
{
  "code": 200,
  "data": "更新成功"
}

```
###<span id="deleteAdmin">删除管理员</span>
 - 描述
    删除管理员(只有超级管理员有此权限)
 - 请求地址
    
    |操作|path|
    |:----:|:------:|
    |  协议 | HTTP   |
    |数据格式|Integer|
    |方法|GET|
    |ULR全径|http://$variable/lbms/administrator/{adId}|


 - 请求参数
    |序号|参数名|必选|数据类型|长度|备注|
    |:--:|:----:|:--:|:------:|:--:|:--:|
    |1|adId|Y|String|1byte|管理员ID|
 - 返回数据
    
    |序号|返回值|中文名称|备注|
    |:--:|:----:|:------:|:--:|
    |1|code|请求状态码|200请求成功,400请求失败|
    |2|data|返回数据|json格式数据，字符串|

 - 请求URL实例
 ```
 DELETE /lbms/administrator/2 HTTP/1.1
Host: localhost:8080
Content-Type: multipart/form-data; boundary=----WebKitFormBoundary7MA4YWxkTrZu0gW
Cache-Control: no-cache
Postman-Token: e5755ef2-b3ef-e9b9-a13e-130adb33f978
------WebKitFormBoundary7MA4YWxkTrZu0gW--
 ```
 
- 返回数据实例

```
{
  "code": 200,
  "data": "删除成功"
}

```

###<span id="getAllAdmin">获取所有管理员</span>
 - 描述
    获取所有管理员用户信息
 - 请求地址
    
    |操作|path|
    |:----:|:------:|
    |  协议 | HTTP   |
    |数据格式|Integer|
    |方法|GET|
    |ULR全径|http://$variable/lbms/administrator/page/{currentPage}|


 - 请求参数
    |序号|参数名|必选|数据类型|长度|备注|
    |:--:|:----:|:--:|:------:|:--:|:--:|
    |1|currentPage|Y|String|1byte|当前页码|
 - 返回数据
    
    |序号|返回值|中文名称|备注|
    |:--:|:----:|:------:|:--:|
    |1|code|请求状态码|200请求成功,400请求失败|
    |2|data|返回数据|json格式数据，字符串|

 - 请求URL实例
```
GET /lbms/administrator/page/1 HTTP/1.1
Host: localhost:8080
Content-Type: application/x-www-form-urlencoded
Cache-Control: no-cache
Postman-Token: 5b553074-7ba0-3743-ff4e-6dc96902958b

```
 
- 返回数据实例

```
{
  "code": 200,
  "data": {
    "currentPage": 1,
    "pageSize": 8,
    "recordCount": 1,
    "recordList": [
      {
        "admid": 1,
        "itemid": null,
        "name": "喵帕斯",
        "sex": "1",
        "contact": "15667027637"
      }
    ],
    "pageCount": 1,
    "beginPageIndex": 1,
    "endPageIndex": 1
  }
}
```
###<span id="getAdminById">获取相关管理员</span>
 - 描述
    获取登录管理员个人信息
 - 请求地址
    
    |操作|path|
    |:----:|:------:|
    |  协议 | HTTP   |
    |数据格式|Integer|
    |方法|GET|
    |ULR全径|http://$variable/lbms/administrator/{adId}|


 - 请求参数
    |序号|参数名|必选|数据类型|长度|备注|
    |:--:|:----:|:--:|:------:|:--:|:--:|
    |1|adId|Y|Integer|1byte|管理员账户ID|
 - 返回数据
    
    |序号|返回值|中文名称|备注|
    |:--:|:----:|:------:|:--:|
    |1|code|请求状态码|200请求成功,400请求失败|
    |2|data|返回数据|json格式数据，字符串|

 - 请求URL实例
```
GET /lbms/administrator/1 HTTP/1.1
Host: localhost:8080
Content-Type: application/x-www-form-urlencoded
Cache-Control: no-cache
Postman-Token: db4811d3-6c1c-7d25-a942-86a5e7402054

```
 
- 返回数据实例

```
{
  "code": 200,
  "data": {
    "admid": 1,
    "itemid": null,
    "name": "喵帕斯",
    "sex": "1",
    "contact": "15667027637"
  }
}
```

###<span id="updateAdminById">修改相关管理员密码</span>
 - 描述
    修改登录管理员密码
 - 请求地址
    
    |操作|path|
    |:----:|:------:|
    |  协议 | HTTP   |
    |数据格式|String|
    |方法|POST|
    |ULR全径|http://$variable/lbms/cipher/administrator|


 - 请求参数
    |序号|参数名|必选|数据类型|长度|备注|
    |:--:|:----:|:--:|:------:|:--:|:--:|
    |1|password|Y|String|8byte|必须为A-Z或a-z ASCLL字符|
    |2|adId|Y|Integer|1byte|管理员ID|
 - 返回数据
    
    |序号|返回值|中文名称|备注|
    |:--:|:----:|:------:|:--:|
    |1|code|请求状态码|200请求成功,400请求失败|
    |2|data|返回数据|json格式数据，字符串|

 - 请求URL实例
 ```
 POST /lbms/cipher/administrator HTTP/1.1
Host: localhost:8080
Cache-Control: no-cache
Postman-Token: 2d3ddbf6-2396-6495-f773-c320b7f8b05a
Content-Type: application/x-www-form-urlencoded
password=yiranblade&adId=1
 
 ```
 
- 返回数据实例

```
{
  "code": 500,
  "data": "更新失败"
}
```
##<span id="noticeManage">公告栏模块</span>
###<span id="addNotice">增加公告栏</span>
 - 描述
    增加新公告
 - 请求地址
    
    |操作|path|
    |:----:|:------:|
    |  协议 | HTTP   |
    |数据格式|application/json|
    |方法|POST|
    |ULR全径|http://$variable/lbms/notice|


 - 请求参数
    |序号|参数名|必选|数据类型|长度|备注|
    |:--:|:----:|:--:|:------:|:--:|:--:|
    |1|noticetile|Y|String|20byte|公告标题|
    |2|noticecontent|Y|String|50byte|公告内容|
 - 返回数据
    
    |序号|返回值|中文名称|备注|
    |:--:|:----:|:------:|:--:|
    |1|code|请求状态码|200请求成功,400请求失败|
    |2|data|返回数据|json格式数据，字符串|

 - 请求URL实例
```
POST /lbms/notice HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Cache-Control: no-cache
Postman-Token: b8f7617d-81ba-34c1-5e2b-291a6b2df1b2

{
	"noticetile":"先关于实验取消",
	"noticecontent":"今天下午所有实验课取消"
}
```
 
- 返回数据实例

```
{
  "code": 200,
  "data": "添加成功"
}

```
###<span id="updateNotice">更新公告栏</span>
 - 描述
    更新公告信息
 - 请求地址
    
    |操作|path|
    |:----:|:------:|
    |  协议 | HTTP   |
    |数据格式|application/json|
    |方法|PUT|
    |ULR全径|http://$variable/lbms/notice|


 - 请求参数
    |序号|参数名|必选|数据类型|长度|备注|
    |:--:|:----:|:--:|:------:|:--:|:--:|
    |1|noticeid|Y|Integer|1byte|公告ID|
    |2|noticetile|Y|String|1byte|公告标题|
    |3|noticecontent|Y|String|1byte|公告内容|
 - 返回数据
    
    |序号|返回值|中文名称|备注|
    |:--:|:----:|:------:|:--:|
    |1|code|请求状态码|200请求成功,400请求失败|
    |2|data|返回数据|json格式数据，字符串|

 - 请求URL实例
```
PUT /lbms/notice HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Cache-Control: no-cache
Postman-Token: 99c86328-c50d-3a42-0cad-5c780e839b8c

{
	"noticeid":"1",
	"noticetile":"通知",
	"noticecontent":"今天下午所有实验课取消"
}
```

start=A&end=B
 
- 返回数据实例

```
{
  "code": 200,
  "data": "更新成功"
}
```
###<span id="deleteNotice">删除公告信息</span>
 - 描述
    删除公告信息
 - 请求地址
    
    |操作|path|
    |:----:|:------:|
    |  协议 | HTTP   |
    |数据格式|Integer|
    |方法|DELETE|
    |ULR全径|http://$variable/lbms/notice/{noticeId}|


 - 请求参数
    |序号|参数名|必选|数据类型|长度|备注|
    |:--:|:----:|:--:|:------:|:--:|:--:|
    |1|noticeId|Y|Integer|1byte|公告ID|
 - 返回数据
    
    |序号|返回值|中文名称|备注|
    |:--:|:----:|:------:|:--:|
    |1|code|请求状态码|200请求成功,400请求失败|
    |2|data|返回数据|json格式数据，字符串|

 - 请求URL实例
 ```
 DELETE /lbms/notice/2 HTTP/1.1
Host: localhost:8080
Cache-Control: no-cache
Postman-Token: b4c208ec-876b-4750-4dac-bf3a3c1361c5
Content-Type: multipart/form-data; boundary=----WebKitFormBoundary7MA4YWxkTrZu0gW
------WebKitFormBoundary7MA4YWxkTrZu0gW--
 ```
 
- 返回数据实例

```
{
  "code": 200,
  "data": "删除成功"
}

```

###<span id="getAllNotice">获取所有公告信息</span>
 - 描述
    获取所有公告信息
 - 请求地址
    
    |操作|path|
    |:----:|:------:|
    |  协议 | HTTP   |
    |数据格式|String|
    |方法|GET|
    |ULR全径|http://$variable/lbms/notice/page/{currentPage}|


 - 请求参数
    |序号|参数名|必选|数据类型|长度|备注|
    |:--:|:----:|:--:|:------:|:--:|:--:|
    |1|currentPage|Y|Integer|1byte|当前页码|
 - 返回数据
    
    |序号|返回值|中文名称|备注|
    |:--:|:----:|:------:|:--:|
    |1|code|请求状态码|200请求成功,400请求失败|
    |2|data|返回数据|json格式数据，字符串|

 - 请求URL实例
```
GET /lbms/notice/page/1 HTTP/1.1
Host: localhost:8080
Cache-Control: no-cache
Postman-Token: 2fe777b8-ea00-e5e5-2ea2-016b77557e18

```
 
- 返回数据实例

```
{
  "code": 200,
  "data": {
    "currentPage": 1,
    "pageSize": 8,
    "recordCount": 1,
    "recordList": [
      {
        "noticeid": 1,
        "noticetile": "通知",
        "noticecontent": "今天下午所有实验课取消",
        "date": null
      }
    ],
    "pageCount": 1,
    "beginPageIndex": 1,
    "endPageIndex": 1
  }
}
```
###<span id="getTestByBatchId">获取项目批次下所有成绩</span>
 - 描述
    获取项目批次下所有成绩
 - 请求地址
    
    |操作|path|
    |:----:|:------:|
    |  协议 | HTTP   |
    |数据格式|Integer|
    |方法|GET|
    |ULR全径|http://$variable/lbms/test/batch/{batchId}|


 - 请求参数
    |序号|参数名|必选|数据类型|长度|备注|
    |:--:|:----:|:--:|:------:|:--:|:--:|
    |1|batchId|Y|Integer|1byte|项目批次ID|
 - 返回数据
    
    |序号|返回值|中文名称|备注|
    |:--:|:----:|:------:|:--:|
    |1|code|请求状态码|200请求成功,400请求失败|
    |2|data|返回数据|json格式数据，字符串|

 - 请求URL实例
```
GET /lbms/test/batch/1 HTTP/1.1
Host: localhost:8080
Cache-Control: no-cache
Postman-Token: 2fe777b8-ea00-e5e5-2ea2-016b77557e18

```
 
- 返回数据实例

```
{
  "code": 200,
  "data": [
    {
      "testid": 2,
      "batid": 1,
      "numid": 4,
      "grade": "2014",
      "results": 98,
      "date": null
    }
  ]
}
```
##<span id="student">学生相关接口</span>
###<span id="getHasOrderBatch">获取已经预约项目</span>
 - 描述
    获取学生已经预约的项目批次
 - 请求地址
    
    |操作|path|
    |:----:|:------:|
    |  协议 | HTTP   |
    |数据格式|Integer|
    |方法|GET|
    |ULR全径|http://$variable/lbms/batch/student/{numId}|


 - 请求参数
    |序号|参数名|必选|数据类型|长度|备注|
    |:--:|:----:|:--:|:------:|:--:|:--:|
    |1|numId|Y|String|1byte|学生ID|
 - 返回数据
    
    |序号|返回值|中文名称|备注|
    |:--:|:----:|:------:|:--:|
    |1|code|请求状态码|200请求成功,500请求失败|
    |2|data|返回数据|json格式数据，字符串|

 - 请求URL实例
 ```
 GET /lbms/batch/student/4 HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Cache-Control: no-cache
Postman-Token: f25aeb12-4483-1b11-63a0-b8c19fa43237

 ```
 
- 返回数据实例

```
{
  "code": 200,
  "data": [
    {
      "batid": 1,
      "itemid": 1,
      "teaid": 1,
      "laboratory": "FF104",
      "date": "2017-02-12",
      "segmentation": "5,6节",
      "sure": null
    }
  ]
}
```

###<span id="orderBatch">预约项目</span>
 - 描述
    学生用户预约实验项目批次
 - 请求地址
    
    |操作|path|
    |:----:|:------:|
    |  协议 | HTTP   |
    |数据格式|String|
    |方法|PUT|
    |ULR全径|http://$variable/lbms/batch/student/{batchId}&{numId}|


 - 请求参数
    |序号|参数名|必选|数据类型|长度|备注|
    |:--:|:----:|:--:|:------:|:--:|:--:|
    |1|batchId|Y|Integer|1byte|预约的实验批次ID|
    |2|numId|Y|Integer|1byte|预约学生的ID|
 - 返回数据
    
    |序号|返回值|中文名称|备注|
    |:--:|:----:|:------:|:--:|
    |1|code|请求状态码|200请求成功,400请求失败|
    |2|data|返回数据|json格式数据，字符串|

 - 请求URL实例
```
PUT /lbms/batch/student/1&amp;4 HTTP/1.1
Host: localhost:8080
Cache-Control: no-cache
Postman-Token: e97e2df2-0eca-d037-2dda-25af7578c1a0
Content-Type: multipart/form-data; boundary=----WebKitFormBoundary7MA4YWxkTrZu0gW

------WebKitFormBoundary7MA4YWxkTrZu0gW--
```
 
- 返回数据实例

```
{
  "code": 200,
  "data": "创建成功"
}
```
###<span id="getTest">获取学生成绩</span>
 - 描述
    获取学生成绩
 - 请求地址
    
    |操作|path|
    |:----:|:------:|
    |  协议 | HTTP   |
    |数据格式|Integer|
    |方法|GET|
    |ULR全径|http://$variable/lbms/test/{batchId}&{numId}|


 - 请求参数
    |序号|参数名|必选|数据类型|长度|备注|
    |:--:|:----:|:--:|:------:|:--:|:--:|
    |1|batchId|Y|Integer|1byte|实验批次ID|
    |2|numId|Y|Integer|1byte|学生的ID|
 - 返回数据
    
    |序号|返回值|中文名称|备注|
    |:--:|:----:|:------:|:--:|
    |1|code|请求状态码|200请求成功,400请求失败|
    |2|data|返回数据|json格式数据，字符串|

 - 请求URL实例
```
GET /lbms/test/1&amp;4 HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Cache-Control: no-cache
Postman-Token: 72cb8d72-bb7d-4fcb-9733-7c96464d1114

```
 
- 返回数据实例

```
{
  "code": 200,
  "data": {
    "testid": 2,
    "batid": 1,
    "numid": 4,
    "grade": "2014",
    "results": 98,
    "date": null
  }
}
```
###<span id="getStudentById">获取相关学生信息</span>
 - 描述
    获取登录学生信息
 - 请求地址
    
    |操作|path|
    |:----:|:------:|
    |  协议 | HTTP   |
    |数据格式|Integer|
    |方法|GET|
    |ULR全径|http://$variable/lbms/student/{numId}|


 - 请求参数
    |序号|参数名|必选|数据类型|长度|备注|
    |:--:|:----:|:--:|:------:|:--:|:--:|
    |1|numId|Y|Integer|1byte|学生ID|
 - 返回数据
    
    |序号|返回值|中文名称|备注|
    |:--:|:----:|:------:|:--:|
    |1|code|请求状态码|200请求成功,400请求失败|
    |2|data|返回数据|json格式数据，字符串|

 - 请求URL实例
```
GET /lbms/student/4 HTTP/1.1
Host: localhost:8080
Cache-Control: no-cache
Postman-Token: b24a47c2-9b85-7efc-e412-0a54ed45ae2a

```
 
- 返回数据实例

```
{
  "code": 200,
  "data": {
    "numid": 4,
    "name": "喵帕斯",
    "sex": "1",
    "specialization": "软件",
    "grade": "2014",
    "date": "2017-02-12 11:16:59.0",
    "contact": "15667027637"
  }
}
```

###<span id="updateStudentById">更新相关学生密码信息</span>
 - 描述
    更新登录学生密码信息
 - 请求地址
    
    |操作|path|
    |:----:|:------:|
    |  协议 | HTTP   |
    |数据格式|String|
    |方法|POST|
    |ULR全径|http://$variable/lbms/cipher/student|


 - 请求参数
    |序号|参数名|必选|数据类型|长度|备注|
    |:--:|:----:|:--:|:------:|:--:|:--:|
    |1|password|Y|String|1byte|修改后的密码|
    |2|numId|N|String|1byte|学生ID|
 - 返回数据
    
    |序号|返回值|中文名称|备注|
    |:--:|:----:|:------:|:--:|
    |1|code|请求状态码|200请求成功,400请求失败|
    |2|data|返回数据|json格式数据，字符串|

 - 请求URL实例
```
POST /lbms/cipher/student HTTP/1.1
Host: localhost:8080
Content-Type: application/x-www-form-urlencoded
Cache-Control: no-cache
Postman-Token: d1498dd1-3662-b012-b08f-4efe02ad4f0e

password=yiranblade&numId=4
```
 
- 返回数据实例

```
{
  "code": 200,
  "data": "更新成功"
}
```
##<span id="teacher">教师相关接口</span>
###<span id="getArrangeBatch">获取安排项目</span>
 - 描述
    获取所有安排给当前教师的项目
 - 请求地址
    
    |操作|path|
    |:----:|:------:|
    |  协议 | HTTP   |
    |数据格式|String|
    |方法|GET|
    |ULR全径|http://$variable/lbms/batch/teacher/{teaId}&{currentPage}|


 - 请求参数
    |序号|参数名|必选|数据类型|长度|备注|
    |:--:|:----:|:--:|:------:|:--:|:--:|
    |1|teaId|Y|Integer|1byte|教师ID|
    |2|currentPage|Y|Integer|1byte|当前页码|
 - 返回数据
    
    |序号|返回值|中文名称|备注|
    |:--:|:----:|:------:|:--:|
    |1|code|请求状态码|200请求成功,400请求失败|
    |2|data|返回数据|json格式数据，字符串|

 - 请求URL实例
```
GET /lbms/batch/teacher/1&amp;1 HTTP/1.1
Host: localhost:8080
Content-Type: application/x-www-form-urlencoded
Cache-Control: no-cache
Postman-Token: 3746fb4a-53bf-de6c-ae85-a9dcddede472

```
 
- 返回数据实例

```
{
  "code": 200,
  "data": {
    "currentPage": 1,
    "pageSize": 8,
    "recordCount": 1,
    "recordList": [
      {
        "batid": 1,
        "itemid": 1,
        "teaid": 1,
        "laboratory": "FF104",
        "date": "2017-02-12",
        "segmentation": "5,6节",
        "sure": null
      }
    ],
    "pageCount": 1,
    "beginPageIndex": 1,
    "endPageIndex": 1
  }
}
```

###<span id="updateTest">写入学生实验成绩</span>
 - 描述
    写学生成绩
 - 请求地址
    
    |操作|path|
    |:----:|:------:|
    |  协议 | HTTP   |
    |数据格式|application/json|
    |方法|PUT|
    |ULR全径|http://$variable/lbms/test|


 - 请求参数
    |序号|参数名|必选|数据类型|长度|备注|
    |:--:|:----:|:--:|:------:|:--:|:--:|
    |1|testid|Y|String|1byte|成绩ID|
    |2|batid|Y|String|1byte|实验项目批次ID|
    |3|numid|Y|String|1byte|学生ID|
    |4|grade|Y|String|10byte|年级|
    |5|results|Y|Integer|1byte|分数|
 - 返回数据
    
    |序号|返回值|中文名称|备注|
    |:--:|:----:|:------:|:--:|
    |1|code|请求状态码|200请求成功,400请求失败|
    |2|data|返回数据|json格式数据，字符串|

 - 请求URL实例
```
PUT /lbms/test HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Cache-Control: no-cache
Postman-Token: 14a16e11-c75a-a5b6-ca40-a0e94017e139

{
	"testid":"2",
	"batid":"1",
	"numid":"4",
	"grade":"2014",
	"results":"98"
}
```
 
- 返回数据实例

```
{
  "code": 200,
  "data": "更新成功"
}
```

###<span id="getTeacherById">获取相关教师信息</span>
 - 描述
    获取登录教师相关信息
 - 请求地址
    
    |操作|path|
    |:----:|:------:|
    |  协议 | HTTP   |
    |数据格式|Integer|
    |方法|GET|
    |ULR全径|http://$variable/lbms/teacher/{teaId}|


 - 请求参数
    |序号|参数名|必选|数据类型|长度|备注|
    |:--:|:----:|:--:|:------:|:--:|:--:|
    |1|teaId|Y|String|1byte|教师ID|
 - 返回数据
    
    |序号|返回值|中文名称|备注|
    |:--:|:----:|:------:|:--:|
    |1|code|请求状态码|200请求成功,400请求失败|
    |2|data|返回数据|json格式数据，字符串|

 - 请求URL实例
 ```
 GET /lbms/teacher/1 HTTP/1.1
Host: localhost:8080
Content-Type: application/json
Cache-Control: no-cache
Postman-Token: ade05a28-b755-6f36-3e4b-7ac29a48a13d

 ```
 
- 返回数据实例

```
{
  "code": 200,
  "data": {
    "teaid": 1,
    "name": "喵帕斯",
    "sex": "0",
    "title": "软件",
    "education": "硕士",
    "date": null,
    "contact": "15667027637"
  }
}
```

###<span id="updateTeacherById">修改相关教师密码</span>
 - 描述
    登录教师修改密码
 - 请求地址
    
    |操作|path|
    |:----:|:------:|
    |  协议 | HTTP   |
    |数据格式|Integer|
    |方法|POST|
    |ULR全径|http://$variable/lbms/cipher/teacher|


 - 请求参数
    |序号|参数名|必选|数据类型|长度|备注|
    |:--:|:----:|:--:|:------:|:--:|:--:|
    |1|password|Y|String|20byte|修改后的密码|
    |2|teaId|N|String|1byte|教师ID|
 - 返回数据
    
    |序号|返回值|中文名称|备注|
    |:--:|:----:|:------:|:--:|
    |1|code|请求状态码|200请求成功,400请求失败|
    |2|data|返回数据|json格式数据，字符串|

 - 请求URL实例
```
POST /lbms/cipher/teacher HTTP/1.1
Host: localhost:8080
Content-Type: application/x-www-form-urlencoded
Cache-Control: no-cache
Postman-Token: 36c26b44-b81f-c098-0e9a-f580890943cc

password=yiranblade&teaId=1
```
 
- 返回数据实例

```
{
  "code": 200,
  "data": "更新成功"
}
```
##<span id="login">登录相关接口</span>
###<span id="loginSystem">登录系统</span>
 - 描述
    登录系统
 - 请求地址
    
    |操作|path|
    |:----:|:------:|
    |  协议 | HTTP   |
    |数据格式|application/x-www-form-urlencoded|
    |方法|POST|
    |ULR全径|http://$variable/lbms/login|


 - 请求参数
    |序号|参数名|必选|数据类型|长度|备注|
    |:--:|:----:|:--:|:------:|:--:|:--:|
    |1|userName|Y|String|1byte|必须为A-Z或a-z ASCLL字符|
    |2|password|Y|String|1byte|必须为A-Z或a-z ASCLL字符|
 - 返回数据
    
    |序号|返回值|中文名称|备注|
    |:--:|:----:|:------:|:--:|
    |1|code|请求状态码|200请求成功,500请求失败|
    |2|data|返回数据|json格式数据，字符串|

 - 请求URL实例
 ```
POST /lbms/login HTTP/1.1
Host: localhost:8080
Content-Type: application/x-www-form-urlencoded
Cache-Control: no-cache
Postman-Token: 93266c51-f4c3-2b3a-ca20-82d7566172d0
userName=Zf7WV7XH&password=yiranblade
 ```
 
- 返回数据实例

```
{
  "code": 200,
  "data": "登录成功"
}
```



###<span id=“getUserInfo">获取登录信息</span>
 - 描述
    通过用户名获取用户登录的身份信息
 - 请求地址
    
    |操作|path|
    |:----:|:------:|
    |  协议 | HTTP   |
    |数据格式|String|
    |方法|GET|
    |ULR全径|http://$variable/lbms/login/{userName}|


 - 请求参数
    |序号|参数名|必选|数据类型|长度|备注|
    |:--:|:----:|:--:|:------:|:--:|:--:|
    |1|userName|Y|String|8byte|必须为A-Z或a-z ASCLL字符|
 - 返回数据
    
    |序号|返回值|中文名称|备注|
    |:--:|:----:|:------:|:--:|
    |1|code|请求状态码|200请求成功,500请求失败|
    |2|data|返回数据|json格式数据，字符串|

 - 请求URL实例
 ```
GET /lbms/login/Zf7WV7XH HTTP/1.1
Host: localhost:8080
Cache-Control: no-cache
Postman-Token: 3a267299-50b8-89a6-9578-0a5b3cb0ce44

 ```
 
- 返回数据实例

```
{
  "code": 200,
  "data": {
    "userName": "Zf7WV7XH",
    "userId": 4,
    "power": "student"
  }
}
```
#<span id="error">错误状态码说明</span>
|序号|状态码|说明|
|:--:|:----:|:--:|
|1|200|请求发送成功|
|2|400|数据格式错误|
|4|500|服务器发生未知错误|
|5|501|请求过于频繁|
 



