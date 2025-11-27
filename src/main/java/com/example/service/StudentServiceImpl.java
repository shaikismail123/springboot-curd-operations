package com.example.service;

import com.example.entity.Student;
import com.example.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService{

    private final StudentRepository studentRepository;

    @Override
    public boolean saveStudent(Student student) {
        Student save = studentRepository.save(student);
        return true;
    }

    @Override
    public List<Student> getAllStudents() {
       return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long studentId) {
        return studentRepository.findById(studentId).orElseThrow(() -> new RuntimeException("Student Id is not valid..!"));
    }

    @Override
    public Student updateStudent(Student student) {
        Optional<Student> stu =  studentRepository.findById(student.getStudentId());
        if(stu.isPresent()){
            var st = stu.get();
            st.setStudentId(student.getStudentId());
            st.setStudentName(student.getStudentName());
            st.setStudentAge(student.getStudentAge());
            st.setCollegeName(student.getCollegeName());
            st.setAddress(student.getAddress());
            st.setEmail(student.getEmail());
            st.setMobileNo(student.getMobileNo());
           return studentRepository.save(st);
        }
        return null;
    }

    @Override
    public String deleteStudentById(Long id) {
        studentRepository.deleteById(id);
        return " Student Successfully Deleted..!";
    }
}
