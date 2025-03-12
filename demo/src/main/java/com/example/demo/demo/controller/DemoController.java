package com.example.demo.demo.controller;

import com.example.demo.demo.dto.StudentDto;
import com.example.demo.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v2")
public class DemoController {

    @Autowired
    private DemoService demoService;

    @GetMapping
    public ResponseEntity<List<StudentDto>> getAllStudents(){
        List<StudentDto> listOfStudentDto = demoService.getStudents();
        return new ResponseEntity<>(listOfStudentDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<StudentDto> saveStudent(@RequestBody StudentDto studentDto){
        StudentDto savedStudentDto = demoService.saveStudent(studentDto);
        return new ResponseEntity<StudentDto>(savedStudentDto,HttpStatus.OK);
    }

}
