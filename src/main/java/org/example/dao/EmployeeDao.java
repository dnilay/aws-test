package org.example.dao;

import org.example.model.Employee;

import javax.sql.DataSource;
import java.sql.SQLException;

public interface EmployeeDao {

    public Employee createEmployee(Employee employee) throws SQLException;
}
