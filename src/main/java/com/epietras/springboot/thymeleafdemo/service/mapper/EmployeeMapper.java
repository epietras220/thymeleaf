package com.epietras.springboot.thymeleafdemo.service.mapper;

import com.epietras.springboot.thymeleafdemo.controller.dto.EmployeeDto;
import com.epietras.springboot.thymeleafdemo.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);
    Employee dtoToEntity(EmployeeDto employeeDto);
}
