package com.websitesi.websitesi.Services;

import com.websitesi.websitesi.Dto.EmployeeDTO;
import com.websitesi.websitesi.Response.Response;


public interface IEmployeeService {

    Response addEmployee(EmployeeDTO employeeDTO);

    Response deleteEmployee(Long carId);

    Response getAllEmployee();

    Response updateEmployee(EmployeeDTO employeeDTO);
}
