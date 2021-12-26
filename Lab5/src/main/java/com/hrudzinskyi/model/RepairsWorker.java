package com.hrudzinskyi.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "repairs_worker")
public class RepairsWorker {
    private Integer id;
    private String name;
    private String surname;
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
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "surname")
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RepairsWorker repairsWorker = (RepairsWorker) o;
        return Objects.equals(id, repairsWorker.id) && Objects.equals(name, repairsWorker.name)&& Objects.equals(surname, repairsWorker.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname);
    }

    public RepairsWorker() {}

    public RepairsWorker(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "RepairsWorker {" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}