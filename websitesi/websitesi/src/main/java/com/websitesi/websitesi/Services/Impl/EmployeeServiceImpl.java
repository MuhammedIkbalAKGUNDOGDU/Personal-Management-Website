package com.websitesi.websitesi.Services.Impl;

import com.websitesi.websitesi.Dto.EmployeeDTO;
import com.websitesi.websitesi.Entity.Employee;
import com.websitesi.websitesi.Repo.IEmployeeRepo;
import com.websitesi.websitesi.Response.Response;
import com.websitesi.websitesi.Services.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    public IEmployeeRepo employeeRepo;

    @Override
    public Response addEmployee(EmployeeDTO employeeDTO) {

        Employee employee = new Employee(
                employeeDTO.getEmployeeId(),
                employeeDTO.getName(),
                employeeDTO.getSurname(),
                employeeDTO.getDepartment(),
                employeeDTO.getPhoneNumber(),
                employeeDTO.getPassword()
        );
        try {
            employeeRepo.save(employee);

            return new Response(employee.getName() + " başarı ile kayıt yaptı",true);
        }catch (Exception e) {
            return new Response("Register not success", false);
        }
    }

    @Override
    public Response deleteEmployee(Long employeeId) {

        try {
            employeeRepo.deleteById(employeeId.intValue());
            return new Response("Personel başarı ile silindi",true);
        }catch (Exception e){
            return new Response("Personel  silinemedi",false);
        }
    }

    @Override
    public Response getAllEmployee() {
        Response response = new Response("All Employee List",true);
        List<Employee> employees=employeeRepo.findAll();
        response.setData(employees);
        return response;
    }

    @Override
    public Response updateEmployee(EmployeeDTO employeeDTO) {
        Employee existingEmployee = employeeRepo.findById(employeeDTO.getEmployeeId());
        if(existingEmployee!=null) {
            existingEmployee.setPhoneNumber(employeeDTO.getPhoneNumber());
            existingEmployee.setDepartment(employeeDTO.getDepartment());
            employeeRepo.save(existingEmployee);
            return new Response(existingEmployee.getName() + " kişisinin bilgileri başarı ile güncellendi",true);

        }else{
            return new Response(existingEmployee.getName() + " kişisinin bilgileri güncellenemedi",false);
        }
    }
}
