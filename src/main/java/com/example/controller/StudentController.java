package com.example.controller;

import com.example.entity.Student;
import com.example.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    private final static Logger logger = LoggerFactory.getLogger(StudentController.class);

    @PostMapping(value = "/saveStudent")
    public ResponseEntity<String> saveStudent(@RequestBody Student student) {
        logger.info(" Cursor enter into controller method inside ");
        if (studentService.saveStudent(student)) {
            return ResponseEntity.status(HttpStatus.CREATED).body("Successfully Student Saved..!");
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong..!");
    }

    @PutMapping(value="/updateStudent")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.updateStudent(student));
    }

    @GetMapping(value="/getAllStudents")
    public ResponseEntity<List<Student>> getAllStudents(){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getAllStudents());
    }

    @GetMapping(value="studentById/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getStudentById(id));
    }

    @DeleteMapping(value="/deleteById/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.deleteStudentById(id));
    }

}
