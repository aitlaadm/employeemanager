package com.example.EmployeeManager.service;

import java.util.List;

import com.example.EmployeeManager.exception.EmployeeNonTrouverException;
import com.example.EmployeeManager.model.Employee;
import com.example.EmployeeManager.repertoire.repertoireEmploye;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
@Transactional
public class employeeService {
    private final repertoireEmploye repertoireEmploye;
    @Autowired
    public employeeService(repertoireEmploye repertoireEmploye) {
        this.repertoireEmploye = repertoireEmploye;
    }

    public Employee ajouterEmploye(Employee emp){
        emp.setCodeEmploye(UUID.randomUUID().toString());
        return repertoireEmploye.save(emp);
    }

    public List<Employee> trouvertoutEmp(){
        return repertoireEmploye.findAll();
    }

    public Employee modifieEmp(Employee emp){
        return repertoireEmploye.save(emp);
    }

    public Employee trouverEmp(Long id){
        return repertoireEmploye.findEmployeeById(id).orElseThrow(()->new EmployeeNonTrouverException("l'employé(e) d'id "+id+" n'existe pas"));
    }

    public void supprimerEmp(Long id){
        repertoireEmploye.deleteEmployeeById(id);
    }
}
