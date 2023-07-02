package com.geekster.UniversityEventManagement.services;

import com.geekster.UniversityEventManagement.models.EnumDepartment;
import com.geekster.UniversityEventManagement.models.StudentModel;
import com.geekster.UniversityEventManagement.repository.IStudentRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    IStudentRepo iStudentRepo;

    public String addStudent(ArrayList<StudentModel> studentList) {
        Iterable<StudentModel>status=iStudentRepo.saveAll(studentList);
        if(status!=null){
            return "YES";
        }
        else{
            return "NO";
        }
    }

    public Iterable<StudentModel> getAllStudent() {
   return iStudentRepo.findAll();
    }

    public Optional<StudentModel> getStudentById(Integer id) {
        return iStudentRepo.findById(id);
    }

    @Transactional
    public void updateDetails(Integer id, EnumDepartment department) {
       String stringDepartment= department.name();
        iStudentRepo.updateStudentDepartment(id,stringDepartment);
    }

    public void deleteStudentById(Integer id) {
        iStudentRepo.deleteById(id);
    }
}
