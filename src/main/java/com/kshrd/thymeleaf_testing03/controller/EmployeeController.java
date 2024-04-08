package com.kshrd.thymeleaf_testing03.controller;

import com.kshrd.thymeleaf_testing03.model.Employee;
import com.kshrd.thymeleaf_testing03.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    protected final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/all")
    public String getAllEmp(Model model){
        model.addAttribute("employees", employeeService.getAllEmp());
        return "index";
    }

    @GetMapping("/{id}")
    public String getEmpById(@PathVariable("id") Integer empId, Model model){
        model.addAttribute("employee", employeeService.getById(empId));
        return "/pages/employee-view";
    }

    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable("id") Integer empId){
        employeeService.deleteById(empId);
        return "redirect:/employees/all";
    }
    // Post
    @GetMapping("/getForm-insert")
    public String getFormInsert(Model model){
        model.addAttribute("newEmployee", new Employee());
        return "/pages/employee-form";
    }

    @PostMapping("/insert")
    public String insertEmp(@ModelAttribute Employee employee){
        employeeService.saveEmp(employee);
        return "redirect:/employees/all";
    }

    // update
    @GetMapping("/getForm-update/{id}")
    public String getFormUpdate(@PathVariable("id") Integer empId, Model model){
        model.addAttribute("employee_up", employeeService.getById(empId));
        return "/pages/employee-edit";
    }
    @PostMapping("/update/{id}")
    public String updateEmp(@ModelAttribute Employee employee){
        employeeService.update(employee);
        return "redirect:/employees/all";
    }



}
