package com.example.demo.controllers;

import com.example.demo.models.Student;
import com.example.demo.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping( path="api/v1/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudent() {
        return studentService.getAllStudent();
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student){
          studentService.addNewStudent(student);
    }

    @DeleteMapping(path="{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId){
        studentService.deleteStudent (studentId);
    }

    @PutMapping(path="{studentId}")
    public  void updateStudent(@PathVariable("studentId") Long studentId,
                               @RequestParam(required = false) String name,  // sent parameter via URL Parameters
                               @RequestParam(required = false) String email,
                               @RequestBody Student student  // or parse parameters from json of request body
                               ){
        studentService.updateStudent(studentId, name, email);
    }

}
