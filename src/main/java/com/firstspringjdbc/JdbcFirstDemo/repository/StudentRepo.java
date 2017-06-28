package com.firstspringjdbc.JdbcFirstDemo.repository;

import com.firstspringjdbc.JdbcFirstDemo.model.Student;

import java.util.List;
import java.util.Map;

/**
 * Created by abhi on 21/06/17.
 */
public interface StudentRepo {

    List<Student> getAllStudents();

    Student getStudent(Integer id);

    Student getbyname(Integer id, String name);


    void postdata (Student student);

    void deletedata(Integer id);

    List<Map<String,Object>> getcombineddata( Integer id);

}
