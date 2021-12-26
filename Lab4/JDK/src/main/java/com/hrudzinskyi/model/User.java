package com.hrudzinskyi.model;

import lombok.*;


@AllArgsConstructor
@Getter
@Setter
@ToString
public class User {
    private Integer id;
    private String surname;
    private String name;
    private String student_number;
    private Integer zip;

    public User(String surname, String name, String student_number, Integer zip) {
        this(null, surname, name, student_number, zip);
    }
}