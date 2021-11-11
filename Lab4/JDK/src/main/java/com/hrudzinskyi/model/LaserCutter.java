package com.hrudzinskyi.model;

import lombok.*;


@AllArgsConstructor
@Getter
@Setter
@ToString
public class LaserCutter {
    private Integer id;
    private String time_using;
    private String start_data;
    private String end_data;
    private Integer equipment_id;

    public LaserCutter(String time_using, String start_data, String end_data, Integer equipment_id) {
        this(null, time_using, start_data, end_data, equipment_id);
    }
}