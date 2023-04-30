package pro.sky.java.course2.coursework1var2.Service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.coursework1var2.Employee;

import java.util.List;

public interface EmployeeService {


    void addEmployee(Employee employee);

    String getEmployee(Integer number);

    String getEmployee(Employee employee);
}
