package com.websitesi.websitesi.Repo;

import com.websitesi.websitesi.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface IEmployeeRepo extends JpaRepository<Employee, Integer> {
    Employee findById(int employeeId);
}
