package com.hrudzinskyi.model;

import lombok.*;


@AllArgsConstructor
@Getter
@Setter
@ToString
public class Repair {
    private Integer id;
    private String time;
    private String start_data;
    private String end_data;
    private Integer repairs_worker_id;
    private Integer equipment_id;
    private Integer repairs_worker_id1;

    public Repair(String time, String start_data, String end_data, Integer repairs_worker_id, Integer equipment_id, Integer repairs_worker_id1) {
        this(null, time, start_data, end_data, repairs_worker_id, equipment_id, repairs_worker_id1);
    }
}