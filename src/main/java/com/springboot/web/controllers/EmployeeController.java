package com.springboot.web.controllers;

import com.springboot.web.dto.EmployeeDTO;
import com.springboot.web.entities.EmployeeEntity;
import com.springboot.web.repositories.EmployeeRepository;
import com.springboot.web.services.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;

@RestController
@RequestMapping(path="/employees")
public class EmployeeController {
//    @GetMapping(path = "/getSecretMessage")
//public String getSecretMessage()
//{
//    return "Seceret Message  :@347878y";
//}

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("{employeeId}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable(name="employeeId" ) Long Id)
    {

        Optional<EmployeeDTO> employeeDTO=employeeService.getEmployeeById(Id);
     return  employeeDTO.map(employeeDTO1 -> ResponseEntity.ok(employeeDTO1)).orElse(ResponseEntity.notFound().build());


    }

    @GetMapping
    public List<EmployeeDTO> getAllEmployees(@RequestParam(required = false,name="inputAge") Integer age)
    {
        return employeeService.getAllEmployees() ;
    }

    @PostMapping
    public EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO inputEmployee)
    {

        return employeeService.createNewEmployee(inputEmployee);
    }
@PutMapping(path="/{employeeId}")
    public EmployeeDTO updateEmployeeById(@RequestBody EmployeeDTO employeeDTO,@PathVariable Long employeeId)
{
    return employeeService.updateEmployeeById(employeeDTO,employeeId);
}
@DeleteMapping(path="/{employeeId}")
    public boolean deleteById(@PathVariable Long employeeId)
{
   return employeeService.deleteById(employeeId);
}
@PatchMapping(path="/{employeeId}")
    public EmployeeDTO updatePartialEmployeeById(@RequestBody Map<String,Object> updates ,@PathVariable  Long employeeId)
{
return employeeService.updatePartialEmployeeById(updates ,employeeId);
}

}
