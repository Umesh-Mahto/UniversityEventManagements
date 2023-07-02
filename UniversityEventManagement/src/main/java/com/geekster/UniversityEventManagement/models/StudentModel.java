package com.geekster.UniversityEventManagement.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
@Entity
public class StudentModel {
    @Column(name = "student_id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer studentId;
    private String firstName;
    private String lastName;
    @Column(name = "student_age")
    @Min(value = 18,message = "Age value should be Minimum 18 and Maximum 24")
    @Max(value = 25,message = "Age value should be Minimum 18 and Maximum 24")

    private Integer age;
    @Column(name = "student_department")
    @Enumerated(EnumType.STRING)
    private EnumDepartment department;

}
