package com.hrudzinskyi.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "repair")
public class Repair {
    private Integer id;
    private String time;
    private String start_data;
    private String end_data;
    private Integer repairs_worker_id;
    private Integer equipment_id;
    private Integer repairs_worker_id1;

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

    @Basic
    @Column(name = "repairs_worker_id")
    public Integer getRepairs_worker_id() {
        return repairs_worker_id;
    }

    public void setRepairs_worker_id(Integer repairs_worker_id) {
        this.repairs_worker_id = repairs_worker_id;
    }

    @Basic
    @Column(name = "equipment_id")
    public Integer getEquipment_id() {
        return equipment_id;
    }

    public void setEquipment_id(Integer equipment_id) {
        this.equipment_id = equipment_id;
    }

    @Basic
    @Column(name = "repairs_worker_id1")
    public Integer getRepairs_worker_id1() {
        return repairs_worker_id1;
    }

    public void setRepairs_worker_id1(Integer repairs_worker_id1) {
        this.repairs_worker_id1 = repairs_worker_id1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Repair repair = (Repair) o;
        return Objects.equals(id, repair.id) && Objects.equals(time, repair.time)&& Objects.equals(start_data, repair.start_data)&& Objects.equals(end_data, repair.end_data)&& Objects.equals(repairs_worker_id, repair.repairs_worker_id)&& Objects.equals(equipment_id, repair.equipment_id)&& Objects.equals(repairs_worker_id1, repair.repairs_worker_id1);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, time, start_data, end_data,repairs_worker_id, equipment_id,repairs_worker_id1);
    }

    public Repair() {}

    public Repair(String time, String start_data, String end_data, Integer repairs_worker_id,Integer equipment_id,Integer repairs_worker_id1) {
        this.time = time;
        this.start_data = start_data;
        this.end_data = end_data;
        this.repairs_worker_id = repairs_worker_id;
        this.equipment_id = equipment_id;
        this.repairs_worker_id1 = repairs_worker_id1;
    }

    @Override
    public String toString() {
        return "Repair {" +
                "id=" + id +
                ", time='" + time + '\'' +
                ", start_data='" + start_data + '\'' +
                ", end_data='" + end_data + '\'' +
                ", repairs_worker_id='" + repairs_worker_id + '\'' +
                ", equipment_id='" + equipment_id + '\'' +
                ", repairs_worker_id1='" + repairs_worker_id1 + '\'' +
                '}';
    }
}