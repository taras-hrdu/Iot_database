package com.hrudzinskyi.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user")
public class User {
    private Integer id;
    private String surname;
    private String name;
    private String student_number;
    private Integer zip;

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
    @Column(name = "surname")
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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
    @Column(name = "student_number")
    public String getStudent_number() {
        return student_number;
    }

    public void setStudent_number(String student_number) {
        this.student_number = student_number;
    }

    @Basic
    @Column(name = "zip")
    public Integer getZip() {
        return zip;
    }

    public void setZip(Integer zip) {
        this.zip = zip;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(surname, user.surname)&& Objects.equals(name, user.name)&& Objects.equals(student_number, user.student_number)&& Objects.equals(zip, user.zip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, surname, name, student_number, zip);
    }

    public User() {}

    public User(String surname, String name, String student_number, Integer zip ) {
        this.surname = surname;
        this.name = name;
        this.student_number = student_number;
        this.zip = zip;
    }

    @Override
    public String toString() {
        return "User {" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", student_number='" + student_number + '\'' +
                ", zip='" + zip + '\'' +
                '}';
    }
}