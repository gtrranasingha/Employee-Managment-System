package com.Lucifer.EmployeeManagmentSystem.Repository;

import com.Lucifer.EmployeeManagmentSystem.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
