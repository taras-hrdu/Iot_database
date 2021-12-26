package com.hrudzinskyi.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "type_of_equipment")
public class TypeOfEquipment {
    private Integer id;
    private String type;

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
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TypeOfEquipment typeOfEquipment = (TypeOfEquipment) o;
        return Objects.equals(id, typeOfEquipment.id) && Objects.equals(type, typeOfEquipment.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type);
    }

    public TypeOfEquipment() {}

    public TypeOfEquipment(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "TypeOfEquipment {" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }
}