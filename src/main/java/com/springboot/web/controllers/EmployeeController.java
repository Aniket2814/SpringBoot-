package com.springboot.web.controllers;

import com.springboot.web.dto.EmployeeDTO;
import com.springboot.web.entities.EmployeeEntity;
import com.springboot.web.repositories.EmployeeRepository;
import com.springboot.web.services.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees(@RequestParam(required = false,name="inputAge") Integer age)
    {
        return ResponseEntity.ok(employeeService.getAllEmployees()) ;
    }

    @PostMapping
    public ResponseEntity<EmployeeDTO> createNewEmployee(@RequestBody EmployeeDTO inputEmployee)
    {

        EmployeeDTO savedemployeedto= employeeService.createNewEmployee(inputEmployee);
    return new ResponseEntity<>(savedemployeedto, HttpStatus.CREATED);
    }
@PutMapping(path="/{employeeId}")
    public ResponseEntity<EmployeeDTO> updateEmployeeById(@RequestBody EmployeeDTO employeeDTO,@PathVariable Long employeeId)
{
    return ResponseEntity.ok(employeeService.updateEmployeeById(employeeDTO,employeeId));
}
@DeleteMapping(path="/{employeeId}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Long employeeId)
{
Boolean gotDeleted= employeeService.deleteById(employeeId);
if(gotDeleted) return ResponseEntity.ok(true);
return ResponseEntity.notFound().build();
}
@PatchMapping(path="/{employeeId}")
    public ResponseEntity<EmployeeDTO> updatePartialEmployeeById(@RequestBody Map<String,Object> updates ,@PathVariable  Long employeeId)
{
EmployeeDTO employeeDTO=employeeService.updatePartialEmployeeById(updates ,employeeId);
if(employeeDTO == null) return ResponseEntity.notFound().build();
return ResponseEntity.ok(employeeDTO);
}

}
