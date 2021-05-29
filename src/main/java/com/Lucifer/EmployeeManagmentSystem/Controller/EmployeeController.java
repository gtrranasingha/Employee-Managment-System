package com.Lucifer.EmployeeManagmentSystem.Controller;

import com.Lucifer.EmployeeManagmentSystem.Model.Employee;
import com.Lucifer.EmployeeManagmentSystem.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    //Display list of employee
    @GetMapping("/")
    public String viewHomePage(Model model){
        model.addAttribute("listEmployee",employeeService.getAllEmployees());
        return  "index";
    }

    //Create model attribute to bind from data
    @GetMapping("/showNewEmployeeForm")
    public  String showNewEmployeeForm(Model model){
        Employee employee=new Employee();
        model.addAttribute("employee",employee);
        return "Add_Employee";
    }


    @PostMapping("/addNewEmployee/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        //Save Employee data base
        employeeService.saveEmployee(employee);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value ="id") long id,Model model){
        //Get Employee from the service
        Employee employee=employeeService.getEmployeeById(id);
        //set employee as model attribute to pre-populate the form
        model.addAttribute("employee",employee);
        return "Update_Employee";
    }
    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable(value ="id") long id){
        //call delete employee method
        employeeService.deleteEmployeeById(id);
        return "redirect:/";
    }
}
