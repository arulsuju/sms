package com.sms.demo.controller;

import com.sms.demo.repo.StudentRepository;
import com.sms.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path = "/")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private StudentService studentService;

    @RequestMapping(path="/register",method = {RequestMethod.GET,RequestMethod.POST})
    public String addAStudent(@RequestParam("firstName") String firstName,
                              @RequestParam("lastName") String lastName,
                              @RequestParam("middleName") String middleName,
                              @RequestParam("username") String username,
                              @RequestParam("password") String password,
                              @RequestParam("emailid") String emailId)
    {
        studentService.addAStudent(firstName, lastName, middleName, username, password, emailId);
        return "/";

    }

}
