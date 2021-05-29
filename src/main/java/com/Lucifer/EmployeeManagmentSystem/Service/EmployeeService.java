package com.Lucifer.EmployeeManagmentSystem.Service;

import com.Lucifer.EmployeeManagmentSystem.Model.Employee;

import java.util.List;


public interface EmployeeService {
    List<Employee>  getAllEmployees();
    void saveEmployee(Employee employee);
    Employee getEmployeeById(long id);
    void deleteEmployeeById(long id);
}
