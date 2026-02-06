package com.example.client.infrastructure.persistence.entities;

import com.example.client.core.value_objects.Gender;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

import java.util.Objects;

@Entity
@Table(name = "customers")

public class CustomerEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @Column(nullable = false) private String name;
    @Column(nullable = false) private Gender sex;
    @Column(nullable = false) private String city;



    public CustomerEntity() {}
    public CustomerEntity(String name, Gender sex, String city) {
        this.name = name;
        this.sex = sex;
        this.city = city;
    }



    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Gender getSex() { return sex; }
    public void setSex(Gender sex) { this.sex = sex;}
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CustomerEntity that = (CustomerEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && sex == that.sex && Objects.equals(city, that.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, sex, city);
    }


    @Override
    public String toString() {
        return "CustomerEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", city='" + city + '\'' +
                '}';
    }
}
