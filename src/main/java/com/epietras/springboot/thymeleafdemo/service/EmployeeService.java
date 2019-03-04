package com.epietras.springboot.thymeleafdemo.service;

import com.epietras.springboot.thymeleafdemo.entity.Employee;
import com.epietras.springboot.thymeleafdemo.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> findAll() {
        return employeeRepository.findAllByOrderByLastNameAsc();
    }

    public Employee findById(Integer id) throws Exception {
        Optional<Employee> result = employeeRepository.findById(id);
        if (result.isPresent()) {
            return result.get();
        } else {
            throw new Exception("This id \" + id + \" is not found in the database ");
        }
    }

    public void save(Employee employee) throws Exception {
//        Employee employee = EmployeeMapper.INSTANCE.dtoToEntity(employeeDto);
//        if (employeeRepository.findById(employee.getId()).isPresent()) {
//            throw new Exception("Employee already exist");
//        }
        employeeRepository.save(employee);
    }

    public void deleteById(Integer id){
            employeeRepository.deleteById(id);
    }
}