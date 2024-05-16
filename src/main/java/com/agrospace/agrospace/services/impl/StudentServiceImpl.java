package com.agrospace.agrospace.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.agrospace.agrospace.Models.Role;
import com.agrospace.agrospace.Models.Student;
import com.agrospace.agrospace.repository.StudentRepository;
import com.agrospace.agrospace.services.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Student createStudent(Student studentR){

        Student student = new Student();
        student.setEmail(studentR.getEmail());
        student.setFirstName(studentR.getFirstName());
        student.setLastName(studentR.getLastName());
        student.setRole(Role.USER);
        student.setPassword(passwordEncoder.encode(studentR.getPassword()));
        student.setClasse(studentR.getClasse());
        student.setAge(studentR.getAge());
        student.setPhone(studentR.getPhone());

        return studentRepository.save(student);
    }

}
