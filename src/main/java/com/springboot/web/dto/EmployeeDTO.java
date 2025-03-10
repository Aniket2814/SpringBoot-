package com.springboot.web.dto;

import java.time.LocalDate;

public class EmployeeDTO {

    private Long id;
  private   String name;
    private String  email;
    private Integer age;
     private LocalDate dateofJoining;
    private Boolean isActive;

    public LocalDate getDateofJoining() {
        return dateofJoining;
    }

    public void setDateofJoining(LocalDate dateofJoining) {
        this.dateofJoining = dateofJoining;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public  EmployeeDTO()
    {

    }
    public EmployeeDTO(Long id, String name, String email, Integer age, LocalDate dateofJoining, Boolean isActive) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.dateofJoining = dateofJoining;
        this.isActive = isActive;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
