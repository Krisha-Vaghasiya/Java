package com.example.employee.service.impl;

import com.example.employee.dto.EmpDto;
import com.example.employee.dto.NewEmpDto;
import com.example.employee.entity.Employee;
import com.example.employee.repository.EmpRepository;
import com.example.employee.service.EmpService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class empServiceImpl implements EmpService {

    private final EmpRepository empRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    @Override

    public List<EmpDto> getAllEmployee(){
        return empRepository.findAll()
                .stream()
                .map(employee -> {
                    return new EmpDto(employee.getId(), employee.getName(), employee.getEmail()
                    );
                }).toList();
    }

    @Override
    public EmpDto getEmployeeById(Long id){
        Employee employee = empRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid id: "+ id));
//        return new EmpDto(employee.getId(), student.getName(),student.getEmail());
        return modelMapper.map(employee, EmpDto.class);
    }

    @Override
    public EmpDto addNewEmployee(NewEmpDto NewEmpDto) {
        Employee newEmployee = modelMapper.map(NewEmpDto, Employee.class);
        newEmployee = empRepository.save(newEmployee);
        return modelMapper.map(newEmployee, EmpDto.class);
    }

    @Override
    public void deleteEmployeeById(Long id){
        if(!empRepository.existsById(id)){
            throw new IllegalArgumentException("employee id not valid" + id);

        }
        empRepository.deleteById(id);
    }

    @Override
    public EmpDto updateEmployee(Long id, NewEmpDto NewEmpDto) {
        Employee employee = empRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid id: "+ id));
        modelMapper.map(NewEmpDto, employee);

        return modelMapper.map(employee, EmpDto.class);
    }



}