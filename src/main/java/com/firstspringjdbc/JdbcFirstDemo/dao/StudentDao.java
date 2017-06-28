package com.firstspringjdbc.JdbcFirstDemo.dao;

import com.firstspringjdbc.JdbcFirstDemo.model.Student;
import com.firstspringjdbc.JdbcFirstDemo.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by abhi on 21/06/17.
 */
 @Repository
public class StudentDao implements StudentRepo {

   @Autowired
   JdbcTemplate jdbcTemplate;

    @Override
    public List<Student> getAllStudents() {

        String sql="select * from student";

        List<Student> list=jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Student.class));

        return list;
    }

    @Override
    public Student getStudent(Integer id) {

        String sql="select name from student where id=?";

        Student s=jdbcTemplate.queryForObject(sql,new Object[]{id},new BeanPropertyRowMapper<>(Student.class));
        return s;
    }

    @Override
    public Student getbyname(Integer id, String name){
        String sql = "select * from student where id=? and name=? ";

        Student sn=jdbcTemplate.queryForObject(sql,new Object[]{id,name}, new BeanPropertyRowMapper<>(Student.class));
        return sn;
    }

    @Override
    public void postdata(Student student){
        String sql = "insert into student (name, city) values (?,?)";

        jdbcTemplate.update(sql, new Object[]{student.getName(), student.getCity()});
    }

    @Override
    public void deletedata(Integer id){
        String sql = "delete from student where id = ?";

        jdbcTemplate.update(sql, id);
    }

    @Override
    public List<Map<String, Object>> getcombineddata(Integer id) {
        String sql = "select a.id,a.name,b.dep_name from student a, department b where a.dept_id = b.dept_id and b.dept_id =?";
        List<Map<String, Object>> List = jdbcTemplate.queryForList(sql, new Object[]{id});
        return List;
    }

}
