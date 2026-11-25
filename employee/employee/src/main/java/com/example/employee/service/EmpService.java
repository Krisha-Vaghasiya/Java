package com.example.employee.service;

import com.example.employee.dto.EmpDto;
import com.example.employee.dto.NewEmpDto;

import java.util.List;

public interface EmpService {
    List<EmpDto> getAllEmployee();

     EmpDto getEmployeeById(Long id);

    EmpDto addNewEmployee(NewEmpDto newEmpDto);

    void deleteEmployeeById(Long id);

    EmpDto updateEmployee(Long id, NewEmpDto NewEmpDto);

}
