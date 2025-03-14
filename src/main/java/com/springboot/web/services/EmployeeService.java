package com.springboot.web.services;

import com.springboot.web.dto.EmployeeDTO;
import com.springboot.web.entities.EmployeeEntity;
import com.springboot.web.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

private final EmployeeRepository employeeRepository;
private final ModelMapper modelMapper;


    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    public EmployeeDTO getEmployeeById(Long id)
    {
        EmployeeEntity employeeEntity=  employeeRepository.findById(id).orElse(null);
       return modelMapper.map(employeeEntity,EmployeeDTO.class);
    }

    public List<EmployeeDTO> getAllEmployees() {
    List<EmployeeEntity> employeeEntities=employeeRepository.findAll();

        return employeeEntities.stream()
                .map(employeeEntity->modelMapper.map(employeeEntity,EmployeeDTO.class))
                .collect(Collectors.toList());
    }

    public EmployeeDTO createNewEmployee(EmployeeDTO inputEmployee) {
    EmployeeEntity toSaveEntity=modelMapper.map(inputEmployee,EmployeeEntity.class);
    EmployeeEntity savedemployeeEntity=employeeRepository.save(toSaveEntity);

        return modelMapper.map(savedemployeeEntity,EmployeeDTO.class);
    }

    public EmployeeDTO updateEmployeeById(EmployeeDTO employeeDTO, Long employeeId) {
//EmployeeEntity employeeEntity=modelMapper.map(employeeDTO,EmployeeEntity.class);
//employeeEntity.setId(employeeId);
//    EmployeeEntity savedEmployeeEntity=employeeRepository.save(employeeEntity);
//   return modelMapper.map(savedEmployeeEntity,EmployeeDTO.class);
        EmployeeEntity employeeEntity = modelMapper.map(employeeDTO, EmployeeEntity.class);
        employeeEntity.setId(employeeId);
        EmployeeEntity savedEmployeeEntity = employeeRepository.save(employeeEntity);
        return modelMapper.map(savedEmployeeEntity, EmployeeDTO.class);
    }

    public void deleteById(Long employeeId) {
   employeeRepository.deleteById(employeeId);
   System.out.println("Item is Succesfully Deleted");
    }

}
