package org.example;


import org.example.dao.EmployeeDao;
import org.example.dao.EmployeeDaoIml;
import org.example.model.Employee;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

public class App
{
    private static Scanner scanner;
    static {
        scanner=new Scanner(System.in);
    }
    public static void main( String[] args ) throws SQLException {
        System.out.print("Enter First Name: ");
        String firstName=scanner.next();
        System.out.print("Enter Last Name: ");
        String lastName=scanner.next();
        System.out.print("Enter Email: ");
        String email=scanner.next();
        Employee employee=new Employee(new Random().nextInt(1000),firstName,lastName,email);
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        EmployeeDao employeeDao=context.getBean("employeeDao", EmployeeDao.class);
        employeeDao.createEmployee(employee);

    }
}
