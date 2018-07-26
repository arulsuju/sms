package com.sms.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public StudentServiceImpl(DataSource dataSource, JdbcTemplate jdbcTemplate) {
        this.dataSource = dataSource;
        this.jdbcTemplate = jdbcTemplate;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate=new JdbcTemplate(dataSource);
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void addAStudent(String firstName, String lastName, String middleName, String username, String password, String emailId)
    {
       JdbcTemplate jdbcTemplate=new JdbcTemplate(dataSource);
       jdbcTemplate.update("insert into Student(email_id,first_name,last_name,middle_name,password,username) values(?,?,?,?,?,?)",emailId,firstName,lastName,middleName,password,username);
    }
    @Override
    public void login(String username,String password) {
/*
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.query("select * from student where username=? and password=?", username, password);
   */
    }

}
