package com.example.demo.demo.service;

import com.example.demo.demo.dto.StudentDto;

import java.util.List;

public interface DemoService {

    List<StudentDto> getStudents();
    StudentDto saveStudent(StudentDto studentDto);

}
