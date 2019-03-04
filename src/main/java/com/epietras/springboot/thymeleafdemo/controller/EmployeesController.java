package com.epietras.springboot.thymeleafdemo.controller;

import com.epietras.springboot.thymeleafdemo.controller.dto.EmployeeDto;
import com.epietras.springboot.thymeleafdemo.entity.Employee;
import com.epietras.springboot.thymeleafdemo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeesController {

    private EmployeeService employeeService;

    public EmployeesController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String listEmployees(Model model) {
        List<Employee> list = employeeService.findAll();
        model.addAttribute("employees", list);
        model.addAttribute("theDate", new java.util.Date());

        return "employees/list-employees";
    }
    @GetMapping("/showFormForAdd")
    public String showFormFOrAdd(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee", employee);

        return "employees/employee-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) throws Exception {
        employeeService.save(employee);
        return "redirect:/employees/list";
    }

    @GetMapping("/showFormForUpdate")
    public String updateEmployee(@RequestParam("employeeId") Integer id, Model model) throws Exception {
        Employee employee = employeeService.findById(id);

        model.addAttribute("employee", employee);

        return "employees/employee-form";
    }

    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("employeeId") Integer id) throws Exception {
        employeeService.deleteById(id);

        return "redirect:/employees/list";
    }

}
