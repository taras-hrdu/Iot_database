package com.hrudzinskyi.model;

import lombok.*;


@AllArgsConstructor
@Getter
@Setter
@ToString
public class EquipmentTransfer {
    private Integer id;
    private String time;
    private String start_data;
    private String end_data;

    public EquipmentTransfer(String time, String start_data, String end_data) {
        this(null, time, start_data, end_data);
    }
}