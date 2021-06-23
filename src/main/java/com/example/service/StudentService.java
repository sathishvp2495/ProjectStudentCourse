package com.example.service;

import com.example.entity.Student;
import com.example.repository.StudentRepository;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    SessionFactory sessionFactory;

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(Integer studentId){
        return studentRepository.findById(studentId);
    }

    public Student saveStudent(Student student){
        return studentRepository.save(student);
    }

   public Student updateStudent(Integer studentId,Student student){
        if(studentRepository.existsById(studentId)){
            student.setId(studentId);
            return studentRepository.save(student);
        }else{
            return null;
        }
    }



   public void deleteStudent(Integer studentId){
        if(studentRepository.existsById(studentId)){
            studentRepository.deleteById(studentId);
        }
    }


}
