package com.hrudzinskyi.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "equipment_transfer")
public class EquipmentTransfer {
    private Integer id;
    private String time;
    private String start_data;
    private String end_data;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "time")
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Basic
    @Column(name = "start_data")
    public String getStart_data() {
        return start_data;
    }

    public void setStart_data(String start_data) {
        this.start_data = start_data;
    }

    @Basic
    @Column(name = "end_data")
    public String getEnd_data() {
        return end_data;
    }

    public void setEnd_data(String end_data) {
        this.end_data = end_data;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EquipmentTransfer equipmentTransfer = (EquipmentTransfer) o;
        return Objects.equals(id, equipmentTransfer.id) && Objects.equals(time, equipmentTransfer.time)&& Objects.equals(start_data, equipmentTransfer.start_data)&& Objects.equals(end_data, equipmentTransfer.end_data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, time, start_data, end_data);
    }

    public EquipmentTransfer() {}

    public EquipmentTransfer(String time, String start_data, String end_data ) {
        this.time = time;
        this.start_data = start_data;
        this.end_data = end_data;
    }

    @Override
    public String toString() {
        return "EquipmentTransfer {" +
                "id=" + id +
                ", time_using='" + time + '\'' +
                ", start_data='" + start_data + '\'' +
                ", end_data='" + end_data + '\'' +
                '}';
    }
}