package com.sms.demo.service;

import org.springframework.stereotype.Service;

@Service
public interface StudentService {

    public void addAStudent(String firstName, String lastName, String middleName, String username, String password,String emailId);
    public void login(String username,String password);

}
