hello

接口1：查询所有学生 

参数：currentPage（int）、name（String）、dept(String)

路径：/Student/getStudents

currentPage参数必须传递，否则报错500。name和dept选传，有模糊查询功能。

接口2：添加学生

接口3：修改学生

接口4：删除学生

接口5：查询所有老师

参数：currentPage（int）、name（String）、dept(String)

currentPage参数必须传递，否则报错500。name和dept选传，有模糊查询功能。

接口6：添加老师

接口7：更新老师

接口8：删除老师

接口9：查询所有课程

参数：currentPage（int）、name（String）、dept(String)

currentPage参数必须传递，否则报错500。name和dept选传，有模糊查询功能。

接口10：按学院查询课程

更新过接口9的模糊查询，此接口可以被废弃。

接口11：增加课程

接口12：修改课程

接口13：删除课程

接口14：查询某学生所有已经评过的评价

接口15：查询学生评价（传入老师id 课程id 查到了就返回空，说明该课程已经被评价过。没查到就返回老师对象和课程对象（一个dto里存的老师对象和课程对象））

接口16：添加学生评价

接口17：查询某老师所有已经评过的评价

接口18：查询老师评价（传入当前登录老师id1 被评老师id2 查到了就返回空，说明老师2已经被老师1评价过。没查到就返回被评老师）

接口19：添加老师评价

接口20：查询所有学生对某老师的评价

接口21：查询所有老师对某老师的评价

接口22：查询当前学生选课信息 返回当前学生信息和已选课程信息，没有选课就只返回学生信息

接口23：添加选课

接口24：删除选课

接口25：统计评分

不传参查出所有课

接口26：统计结果按学生评价平均分排序

必填参数：currentPage

选填参数：teaName(老师名字)  dept(学院名)  courseName(课程名)  dir(排序方式)

dir等于desc时是降序排序，等于其他值为升序

路径：/statisticalStuSort

接口27：统计结果按老师评价平均分排序

必填参数：currentPage

选填参数：teaName(老师名字)  dept(学院名)  courseName(课程名)  dir(排序方式)

dir等于desc时是降序排序，等于其他值为升序

路径：/statisticalTeaSort

接口28：登录

接口29：注销