package com.personalprojects.java_commerce.services;

import com.personalprojects.java_commerce.dto.EmployeeDTO;
import com.personalprojects.java_commerce.entities.EmployeeEntity;
import com.personalprojects.java_commerce.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    final EmployeeRepository employeeRepository;
    final ModelMapper modelMapper;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    public EmployeeDTO getEmployeeById(Integer id) {
        EmployeeEntity employeeEntity =  employeeRepository.getById(id);

        // now need to convert entity to DTO;
        return modelMapper.map(employeeEntity, EmployeeDTO.class);
    }

    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {
        // DTO to entity
        EmployeeEntity employeeEntity = modelMapper.map(employeeDTO, EmployeeEntity.class);

        // Save to employee
        // Now the conversion could be in controller as well like in MCMP.
        return modelMapper.map(employeeRepository.save(employeeEntity), EmployeeDTO.class);
    }

    public List<EmployeeDTO> getAllEmployees() {
        List<EmployeeEntity> employeeEntity = employeeRepository.findAll();
        // stream
        return employeeEntity.stream().map(employeeEntity1 -> modelMapper.map(employeeEntity1, EmployeeDTO.class)).collect(Collectors.toList());
    }

    public boolean deleteEmployeeById(Integer id) {
        boolean isPresent = employeeRepository.existsById(id);
        if(!isPresent) return false;
        employeeRepository.deleteById(id);
        return true;

    }
}
