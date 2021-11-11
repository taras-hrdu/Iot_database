package com.hrudzinskyi.model;

import lombok.*;


@AllArgsConstructor
@Getter
@Setter
@ToString
public class RepairsWorker {
    private Integer id;
    private String name;
    private String surname;

    public RepairsWorker(String name, String surname) {
        this(null, name, surname);
    }
}