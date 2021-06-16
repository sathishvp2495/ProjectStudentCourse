package com.example.controller;

import com.example.entity.Student;
import com.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("allStudents")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("{studentId}")
    public Optional<Student> getStudent(@PathVariable Integer studentId){
        return studentService.getStudentById(studentId);
    }

    @PostMapping("addStudent")
    public Student saveStudent(@RequestBody Student student){
        return studentService.saveStudent(student);
    }

    @PutMapping("update/{studentId}")
    public Student updateStudent(@PathVariable Integer studentId,@RequestBody Student student){
        return studentService.updateStudent(studentId,student);
    }

    @DeleteMapping("delete/{studentId}")
    public void deleteStudent(@PathVariable Integer studentId){
        studentService.deleteStudent(studentId);
    }

}
