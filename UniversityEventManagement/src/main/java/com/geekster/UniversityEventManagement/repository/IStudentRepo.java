package com.geekster.UniversityEventManagement.repository;

import com.geekster.UniversityEventManagement.models.StudentModel;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepo extends CrudRepository<StudentModel,Integer> {
  @Modifying
  @Query(value = "update STUDENT_MODEL set STUDENT_DEPARTMENT =:stringDepartment where STUDENT_ID = :id",nativeQuery = true)
    public void updateStudentDepartment(Integer id, String stringDepartment);
}
