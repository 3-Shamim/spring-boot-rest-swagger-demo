package com.learningstuff.springbootrestswaggerdemo.model;


import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Student {

    @Id
    @ApiModelProperty(notes = "Id is required!")
    private String studentId;
    private String studentName;
    private String gender;
    private double cgpa;

}
