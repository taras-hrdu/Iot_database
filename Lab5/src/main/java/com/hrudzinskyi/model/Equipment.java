package com.hrudzinskyi.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "equipment")
public class Equipment {
    private Integer id;
    private Integer inventory_numbers;
    private String color;
    private String body_material;
    private String condition_of_equipment;

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
    @Column(name = "inventory_numbers")
    public Integer getInventory_numbers() {
        return inventory_numbers;
    }

    public void setInventory_numbers(Integer inventory_numbers) {
        this.inventory_numbers = inventory_numbers;
    }

    @Basic
    @Column(name = "color")
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Basic
    @Column(name = "body_material")
    public String getBody_material() {
        return body_material;
    }

    public void setBody_material(String body_material) {
        this.body_material = body_material;
    }

    @Basic
    @Column(name = "condition_of_equipment")
    public String getCondition_of_equipment() {
        return condition_of_equipment;
    }

    public void setCondition_of_equipment(String condition_of_equipment) {
        this.condition_of_equipment = condition_of_equipment;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Equipment equipment = (Equipment) o;
        return Objects.equals(id, equipment.id) && Objects.equals(inventory_numbers, equipment.inventory_numbers)&& Objects.equals(color, equipment.color)&& Objects.equals(body_material, equipment.body_material)&& Objects.equals(condition_of_equipment, equipment.condition_of_equipment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, inventory_numbers, color, body_material, condition_of_equipment);
    }

    public Equipment() {}

    public Equipment(Integer inventory_numbers, String color, String body_material, String condition_of_equipment ) {
        this.inventory_numbers = inventory_numbers;
        this.color = color;
        this.body_material = body_material;
        this.condition_of_equipment = condition_of_equipment;
    }

    @Override
    public String toString() {
        return "Equipment {" +
                "id=" + id +
                ", inventory_numbers='" + inventory_numbers + '\'' +
                ", color='" + color + '\'' +
                ", body_material='" + body_material + '\'' +
                ", condition_of_equipment='" + condition_of_equipment + '\'' +
                '}';
    }
}