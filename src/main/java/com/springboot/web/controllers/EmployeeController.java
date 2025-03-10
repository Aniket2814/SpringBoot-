package com.springboot.web.controllers;

import com.springboot.web.dto.EmployeeDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class EmployeeController {
//    @GetMapping(path = "/getSecretMessage")
//public String getSecretMessage()
//{
//    return "Seceret Message  :@347878y";
//}

    @GetMapping(path= "/employees/{employeeId}")
    public EmployeeDTO getEmployeeById(@PathVariable Long employeeId)
    {
        return new EmployeeDTO(employeeId,"Aniket Rathore","AniketRathore911@gmail.com",22, LocalDate.now(),true);

    }

    @GetMapping(path="/employees")
    public String getAllEmployees(@RequestParam(required = false) Integer age)
    {
        return "HI AGE" +age ;
    }

}
