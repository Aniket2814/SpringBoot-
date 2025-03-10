package com.springboot.web.controllers;

import com.springboot.web.dto.EmployeeDTO;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping(path="/employees")
public class EmployeeController {
//    @GetMapping(path = "/getSecretMessage")
//public String getSecretMessage()
//{
//    return "Seceret Message  :@347878y";
//}

    @GetMapping("{employeeId}")
    public EmployeeDTO getEmployeeById(@PathVariable(name="employeeId" ) Long Id)
    {
        return new EmployeeDTO(Id,"Aniket Rathore","AniketRathore911@gmail.com",22, LocalDate.now(),true);

    }

    @GetMapping()
    public String getAllEmployees(@RequestParam(required = false,name="inputAge") Integer age)
    {
        return "HI AGE" +age ;
    }

}
