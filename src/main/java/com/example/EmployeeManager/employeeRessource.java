package com.example.EmployeeManager;

import com.example.EmployeeManager.model.Employee;
import com.example.EmployeeManager.service.employeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class employeeRessource {
    private final employeeService employeeService;

    public employeeRessource(employeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getToutLesEmployees(){
        List<Employee> employees=employeeService.trouvertoutEmp();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id")Long id){
        Employee employee=employeeService.trouverEmp(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        Employee nouveauEmployee=employeeService.ajouterEmploye(employee);
        return new ResponseEntity<>(nouveauEmployee,HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
        Employee updateEmployee=employeeService.modifieEmp(employee);
        return new ResponseEntity<>(updateEmployee,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id")Long id){
        employeeService.supprimerEmp(id);
        return new ResponseEntity<>( HttpStatus.OK);
    }
}
