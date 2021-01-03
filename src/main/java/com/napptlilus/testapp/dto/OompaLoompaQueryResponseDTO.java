package com.napptlilus.testapp.dto;

import java.io.Serializable;

public class OompaLoompaQueryResponseDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private Integer age;
    private String job;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "OompaLoompaQueryResponseDTO{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", job='" + job + '\'' +
                '}';
    }
}
