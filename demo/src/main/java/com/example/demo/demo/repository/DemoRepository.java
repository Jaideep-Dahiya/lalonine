package com.example.demo.demo.repository;

import com.example.demo.demo.dto.StudentDto;
import com.example.demo.demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DemoRepository extends JpaRepository<Student,Long> {

}
