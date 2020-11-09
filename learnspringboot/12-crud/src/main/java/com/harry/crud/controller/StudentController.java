package com.harry.crud.controller;


import com.harry.crud.bean.Student;
import com.harry.crud.service.Imlp.StudentServiceImpl;
import com.harry.crud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/studentList")
    public String getStudentList(Model model){
        List<Student> students = studentService.selectAllStudent();
        model.addAttribute("students", students);
        return "student_list";
    }


}
