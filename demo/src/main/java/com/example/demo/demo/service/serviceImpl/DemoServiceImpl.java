package com.example.demo.demo.service.serviceImpl;

import com.example.demo.demo.dto.StudentDto;
import com.example.demo.demo.entity.Student;
import com.example.demo.demo.repository.DemoRepository;
import com.example.demo.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    private DemoRepository demoRepository;

    @Override
    public List<StudentDto> getStudents() {
        List<Student> listOfStudents = demoRepository.findAll();
        List<StudentDto> listOfStudentsDto = new ArrayList<>();
        for(Student student : listOfStudents){
            StudentDto studentDto = new StudentDto();
            studentDto.setName(student.getName());
            studentDto.setAge(student.getAge());
            listOfStudentsDto.add(studentDto);
        }
        return listOfStudentsDto;
    }

    @Override
    public StudentDto saveStudent(StudentDto studentDto) {
        Student student = new Student();
        student.setName(studentDto.getName());
        student.setAge(studentDto.getAge());
        demoRepository.save(student);
        return studentDto;
    }
}
