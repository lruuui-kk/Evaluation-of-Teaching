package com.evaluation_of_teaching.utils;

import com.evaluation_of_teaching.model.StudentEntity;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import static java.lang.Math.random;

public class RandomStudent {

    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 30; i++) {
            int a = random.nextInt(100) + 100;


            System.out.println(getName());
        }
    }

    /**
     * @return 生成的学生对象
     * @description 随机生成学生数据，由这些数据创建学生对象并返回。
     */
    public static StudentEntity getStudent() {
        StudentEntity stu = new StudentEntity();
        stu.setPassword("123456");
        stu.setName(getName());
        stu.setSno(getSno());
        stu.setDept(getDept());
        stu.setStu_class(getStu_class());





        return stu;
    }

    /**
     * @return 生成的学生姓名。
     * @description 随机生成学生姓名。有20种姓氏；名字长度可能有1-2位，共有6480中组合。共有129600种可能的姓名组合。
     */
    public static String getName() {
        String[] firstNameArray = {"李", "王", "张", "刘", "陈", "杨", "赵", "黄", "周", "吴", "徐", "孙", "胡", "朱", "高", "余", "欧阳",
                "太史", "端木", "上官", "司马"};
        String[] lastNameArray = {"伟", "勇", "军", "磊", "涛", "斌", "强", "鹏", "杰", "峰", "超", "波", "辉", "刚", "健", "明", "亮",
                "俊", "飞", "凯", "浩", "华", "平", "鑫", "毅", "林", "洋", "宇", "敏", "宁", "建", "兵", "旭", "雷", "锋", "彬", "龙", "翔",
                "阳", "剑", "静", "敏", "燕", "艳", "丽", "娟", "莉", "芳", "萍", "玲", "娜", "丹", "洁", "红", "颖", "琳", "霞", "婷", "慧",
                "莹", "晶", "华", "倩", "英", "佳", "梅", "雪", "蕾", "琴", "璐", "伟", "云", "雨", "蓉", "青", "薇", "欣", "琼", "宁", "平",
                "媛", "欣"};// 常用于名字的单字
        int firstPos = (int) (20 * random());
        StringBuilder name = new StringBuilder(firstNameArray[firstPos]);
        int lastLen = (int) (2 * random()) + 1;
        /*
         * 为了各函数的统一性，此处也用for循环实现 int lastPos1 = (int) (80 * random()); String lastName =
         * lastNameArray[lastPos1]; if (lastLen == 2) { int lastPos2 = (int) (80 *
         * random()); lastName = lastName + lastNameArray[lastPos2]; }
         */
        for (int i = 0; i < lastLen; i++) {
            int lastPos = (int) (80 * random());
            name.append(lastNameArray[lastPos]);
        }
        return name.toString();
    }

    /**
     * @return 生成的学号。
     * @description 随机生成指定规则的学号。
     */
    public static String getSno() {
        String[] yearArray = {"2017","2018","2019","2020"};
        String[] majorArray = {"1107","1302","1405","0509","0803","1202","1005","0707"};

        StringBuilder sno = new StringBuilder();
        Random random = new Random();
        int x = random.nextInt(100)+100;
        int a = (int) (4 * random());
        int b = (int) (8 * random());
        sno.append(yearArray[a]).append(majorArray[b]).append(x);

        return sno.toString();
    }

    /**
     * @return 生成性别。
     * @description 随机生成性别。
     */
    public static String getSex() {
        String[] sexArray = {"男","女"};
        StringBuilder sex = new StringBuilder();
        int a = (int) (2 * random());
        sex.append(sexArray[a]);
        return sex.toString();
    }

    /**
     * @return 生成学院。
     * @description 随机选择9种学院。
     */
    public static String getDept() {
        String[] deptArray = {"信科", "经管", "机电", "艺设", "外院", "城建", "新法", "数学", "国学"};// 共有9种学院
        int a = (int) (9 * random());
        return deptArray[a];
    }

    /**
     * @return 生成班级。
     * @description 随机生成班级。
     */
    public static String getStu_class() {
        String[] classArray = {"软工", "中软", "计科", "物联网", "光电" ,"智能", "机器人", "土木", "工造", "生物",
                               "新媒体", "财务", "金融", "国学", "英语" ,"市营", "外贸", "数学", "新闻", "广告"};
        String[] numArray = {"170", "180", "190", "200"};
        String[] num2Array = {"1", "2", "3", "4", "5"};
        StringBuilder stuClass = new StringBuilder();
        int a = (int) (20 * random());
        int b = (int) (4 * random());
        int c = (int) (5 * random());
        stuClass.append(classArray[a]).append(numArray[b]).append(num2Array[c]);
        return stuClass.toString();
    }

    /**
     * @return 生成的入学时间。
     * @description 随机生成的入学时间，时间范围在2016.1.1~2017.12.31。
     */
    public static String getEntryTime() {
        // 先确定2016.1.1和2017.12.31对应的毫秒数，在此范围内生成long随机数，然后根据该随机数生成java.sql.Date，再toString。
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(2016, 0, 1);
        long minMillis = calendar.getTimeInMillis();
        calendar.set(2018, 0, 1);
        long maxMillis = calendar.getTimeInMillis();
        long millis = (long) ((maxMillis - minMillis) * random()) + minMillis;
        return (new Date(millis)).toString();
    }


    /**
     * @return 生成的学号。
     * @description 随机生成的学号，取值范围在1~2147483647 （int最大正值）。
     */
    public static int getJnshuId() {
        return (int) (Integer.MAX_VALUE * random()) + 1;
    }

    /**
     * @return 生成的日报链接。
     * @description 随机生成的日报链接：http://www.jnshu.com/daily/xxxx（int型数字，取值范围：1~2147483647
     * （int最大正值））。
     */
    public static String getDailyUrl() {
        return "http://www.jnshu.com/daily/" + getJnshuId();
    }

}
