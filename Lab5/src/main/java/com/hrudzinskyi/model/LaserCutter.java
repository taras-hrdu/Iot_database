package com.hrudzinskyi.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "laser_cutter")
public class LaserCutter {
    private Integer id;
    private String time_using;
    private String start_data;
    private String end_data;
    private Integer equipment_id;

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
    @Column(name = "time_using")
    public String getTime_using() {
        return time_using;
    }

    public void setTime_using(String time_using) {
        this.time_using = time_using;
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

    @Basic
    @Column(name = "equipment_id")
    public Integer getEquipment_id() {
        return equipment_id;
    }

    public void setEquipment_id(Integer equipment_id) {
        this.equipment_id = equipment_id;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LaserCutter laserCutter = (LaserCutter) o;
        return Objects.equals(id, laserCutter.id) && Objects.equals(time_using, laserCutter.time_using)&& Objects.equals(start_data, laserCutter.start_data)&& Objects.equals(end_data, laserCutter.end_data)&& Objects.equals(equipment_id, laserCutter.equipment_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, time_using, start_data, end_data, equipment_id);
    }

    public LaserCutter() {}

    public LaserCutter(String time_using, String start_data, String end_data, Integer equipment_id ) {
        this.time_using = time_using;
        this.start_data = start_data;
        this.end_data = end_data;
        this.equipment_id = equipment_id;
    }

    @Override
    public String toString() {
        return "LaserCutter {" +
                "id=" + id +
                ", time_using='" + time_using + '\'' +
                ", start_data='" + start_data + '\'' +
                ", end_data='" + end_data + '\'' +
                ", equipment_id='" + equipment_id + '\'' +
                '}';
    }
}