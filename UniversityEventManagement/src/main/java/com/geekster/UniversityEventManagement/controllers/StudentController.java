package com.geekster.UniversityEventManagement.controllers;

import com.geekster.UniversityEventManagement.models.EnumDepartment;
import com.geekster.UniversityEventManagement.models.StudentModel;
import com.geekster.UniversityEventManagement.services.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping("add")
    public String addStudent(@Valid @RequestBody ArrayList<StudentModel> studentList ){
    return studentService.addStudent(studentList);
    }
    @GetMapping("getStudent")
   public Iterable<StudentModel>getStudent(){
        return studentService.getAllStudent();
    }

    @GetMapping("/{id}")
    public Optional<StudentModel>getStudentById(@PathVariable Integer id){
        return studentService.getStudentById(id);
    }
    @PutMapping("update/{id}/{department}")
    public void updateStudentDetails(@PathVariable Integer id, @PathVariable EnumDepartment department){
        studentService.updateDetails(id ,department);
    }
    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Integer id){
        studentService.deleteStudentById(id);
    }
}
