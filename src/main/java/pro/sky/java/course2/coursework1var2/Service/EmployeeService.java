package pro.sky.java.course2.coursework1var2.Service;

import pro.sky.java.course2.coursework1var2.Employee;
import pro.sky.java.course2.coursework1var2.exception.EmployeeStorageIsFullExeption;

import java.util.Collection;
import java.util.Map;

public interface EmployeeService {

    Employee addEmployee(String firstName, String lastName, int salary, int departmentId)
            throws EmployeeStorageIsFullExeption;

    void removeEmployee(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName);

    Collection<Employee> findAll();

    Map<String, Employee> getAllEmployees();
}
