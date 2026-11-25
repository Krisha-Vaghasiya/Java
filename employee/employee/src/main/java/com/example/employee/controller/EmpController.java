package com.example.employee.controller;

import com.example.employee.dto.EmpDto;
import com.example.employee.dto.NewEmpDto;
import com.example.employee.service.EmpService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/emp")
public class EmpController {

    private final EmpService empService;

    @GetMapping
    public ResponseEntity<List<EmpDto>> getEmployee(){
        return ResponseEntity.ok(empService.getAllEmployee());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpDto> getEmployeeById(@PathVariable Long id){
        return ResponseEntity.ok(empService.getEmployeeById(id));
    }

    @PostMapping
    public ResponseEntity<EmpDto> addNewEmployee(@RequestBody NewEmpDto NewEmpDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(empService.addNewEmployee(NewEmpDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        empService.deleteEmployeeById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<EmpDto> addNewEmployee(@PathVariable Long id, @RequestBody NewEmpDto NewEmpDto){
        return ResponseEntity.ok(empService.updateEmployee(id, NewEmpDto));
    }








}
