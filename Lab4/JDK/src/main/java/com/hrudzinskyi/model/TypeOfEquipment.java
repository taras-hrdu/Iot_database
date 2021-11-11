package com.hrudzinskyi.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class TypeOfEquipment {
    private Integer id;
    private String type;

    public TypeOfEquipment(String type) {
        this(null, type);
    }
}