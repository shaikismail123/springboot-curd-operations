package com.example.service;

import com.example.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

    public boolean saveStudent(Student student);

    public List<Student> getAllStudents();

    public Student getStudentById(Long studentId);

    public Student updateStudent(Student student);

    public String deleteStudentById(Long id);
}
