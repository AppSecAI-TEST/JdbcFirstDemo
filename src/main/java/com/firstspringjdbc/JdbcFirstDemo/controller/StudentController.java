package com.firstspringjdbc.JdbcFirstDemo.controller;

import com.firstspringjdbc.JdbcFirstDemo.dao.StudentDao;
import com.firstspringjdbc.JdbcFirstDemo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by abhi on 21/06/17.
 */

@RestController
public class StudentController {

    @Autowired
    private StudentDao studentDao;

    @GetMapping(value="/getdata")
    public ResponseEntity<?> getAllStudentData(){

        List<Student> stList=studentDao.getAllStudents();

        ResponseEntity<List<Student>> entity=ResponseEntity.ok(stList);

        return entity;

    }

    @GetMapping(value="/getdata1")
    public List<Student> getAllStudentData1(){

        List<Student> stList=studentDao.getAllStudents();

        return stList;

    }

    @GetMapping(value="/getdata/{id}")
    public ResponseEntity<?> getAllStudentData(@PathVariable Integer id){

        Student stList=studentDao.getStudent(id);

        ResponseEntity<Student> entity=ResponseEntity.ok(stList);

        return entity;

    }

    @GetMapping(value = "/getdata/{id}/{name}")
    public ResponseEntity<?> getname(@PathVariable Integer id, @PathVariable String name){

        Student stList = studentDao.getbyname(id, name);

        ResponseEntity<Student> entity=ResponseEntity.ok(stList);

        return entity;
    }

    @PostMapping(value = "/postdata")
    public void postdata (@RequestBody Student student){
        studentDao.postdata(student);
    }

    @DeleteMapping(value = "/deletedata/{id}")
    public void deletedata(@PathVariable Integer id){
        studentDao.deletedata(id);
    }


    @GetMapping(value = "/getcombineddata/{id}")
    public ResponseEntity<?> getcombineddata(@PathVariable Integer id){
        List<Map<String,Object>> stList = studentDao.getcombineddata(id);
        ResponseEntity<List<Map<String, Object>>> entity = ResponseEntity.ok(stList);
        return entity;
    }

}
