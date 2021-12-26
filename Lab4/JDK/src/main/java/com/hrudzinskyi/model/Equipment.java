package com.hrudzinskyi.model;

import lombok.*;


@AllArgsConstructor
@Getter
@Setter
@ToString
public class Equipment {
    private Integer id;
    private Integer inventory_numbers;
    private String color;
    private String body_material;
    private String condition_of_equipment;

    public Equipment(Integer inventory_numbers, String color, String body_material, String condition_of_equipment) {
        this(null, inventory_numbers, color, body_material, condition_of_equipment);
    }
}