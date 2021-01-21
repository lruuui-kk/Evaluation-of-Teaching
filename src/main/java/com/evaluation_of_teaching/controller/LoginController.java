package com.evaluation_of_teaching.controller;

import com.evaluation_of_teaching.dao.AdminMapper;
import com.evaluation_of_teaching.dao.CourseMapper;
import com.evaluation_of_teaching.dao.StudentMapper;
import com.evaluation_of_teaching.dao.TeacherMapper;
import com.evaluation_of_teaching.model.AdminEntity;
import com.evaluation_of_teaching.model.CourseEntity;
import com.evaluation_of_teaching.model.StudentEntity;
import com.evaluation_of_teaching.model.TeacherEntity;
import com.evaluation_of_teaching.service.CourseService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.util.StringUtil;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class LoginController {

    @Autowired
    StudentMapper studentMapper;
    @Autowired
    TeacherMapper teacherMapper;
    @Autowired
    AdminMapper adminMapper;

    @RequestMapping(path = "/login")
    public Object login(String username, String password, String flag, HttpSession session){
        if(flag.equals("stu")){
            StudentEntity student = studentMapper.getStudentByUsername(username);
            if(student!=null){
                if(student.getPassword().equals(password)){
                    session.setAttribute("loginUser",student);
                    return student;
                }else return "密码错误！";
            }else return "用户名错误！";

        }else if(flag.equals("teacher")){
            TeacherEntity teacher = teacherMapper.getTeacherByUsername(username);
            if(teacher!=null){
                if(teacher.getPassword().equals(password)){
                    session.setAttribute("loginUser",teacher);
                    return teacher;
                }else return "密码错误！";
            }else return "用户名错误！";


        }else if(flag.equals("admin")){
            AdminEntity admin = adminMapper.getAdminByUsername(username);
            if(admin!=null){
                if(admin.getPassword().equals(password)){
                    session.setAttribute("loginUser",admin);
                    return admin;
                }else return "密码错误！";
            }else return "用户名错误！";

        }
        return "";
    }

    @RequestMapping(path = "/logout")
    public void logout(HttpSession session){
        session.setAttribute("loginUser",null);
    }

}
