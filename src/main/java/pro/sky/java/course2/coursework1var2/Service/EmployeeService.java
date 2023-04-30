package pro.sky.java.course2.coursework1var2.Service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.coursework1var2.Employee;

import java.util.Collection;
import java.util.List;

public interface EmployeeService {


    Employee addEmployee(String firstName, String lastName);

    Employee removeEmployee(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName);

    Collection<Employee> findAll();
}
