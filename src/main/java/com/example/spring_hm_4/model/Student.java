package com.example.spring_hm_4.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    //region Variables
    private long id;
    private String lastName;
    private String firstName;
    private String surName;
    private int age;
    private int course;
    //endregion

}
