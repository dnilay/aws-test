package org.example.dao;
import org.example.model.Employee;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeDaoIml implements EmployeeDao {
    private DataSource dataSource;
    public EmployeeDaoIml(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    @Override
    public Employee createEmployee(Employee employee) throws SQLException {
        Connection connection=dataSource.getConnection();
        Integer id=employee.getEmployeeId();
        String firstName=employee.getFirstName();
        String lastName=employee.getLastName();
        String email=employee.getEmail();
        PreparedStatement preparedStatement=connection.prepareStatement("insert into employee(employee_id,first_name,last_name,email) values(?,?,?,?))");
        preparedStatement.setInt(1,id);
        preparedStatement.setString(2,firstName);
        preparedStatement.setString(3,lastName);
        preparedStatement.setString(4,email);
        preparedStatement.executeUpdate();
        System.out.println("Record Inserted Successfully");
        return employee;
    }
}
