package com.napptlilus.testapp.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Objects;

@Document
public class OompaLoompa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    private String name;
    private int age;
    private float height;
    private float weight;
    private String job;
    private String description;

    public OompaLoompa(String name, String job, Integer age) {
        this.name=name;
        this.job=job;
        this.age=age;
    }

    public OompaLoompa() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }


    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OompaLoompa that = (OompaLoompa) o;
        return age == that.age &&
                Float.compare(that.height, height) == 0 &&
                Float.compare(that.weight, weight) == 0 &&
                id.equals(that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(job, that.job) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, height, weight, job, description);
    }

    @Override
    public String toString() {
        return "OompaLoompa{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                ", weight=" + weight +
                ", job='" + job + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
