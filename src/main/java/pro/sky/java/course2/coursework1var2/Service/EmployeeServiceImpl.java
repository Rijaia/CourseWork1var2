package pro.sky.java.course2.coursework1var2.Service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.coursework1var2.Employee;
import pro.sky.java.course2.coursework1var2.exception.EmployeeAlreadyAddedException;
import pro.sky.java.course2.coursework1var2.exception.EmployeeNotFoundException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService{
     private final List<Employee> employees = new ArrayList<>(List.of(
            new Employee(
                    "David", "Duhovny"),
            new Employee(
                    "Mari","Ivanova"),
            new Employee(
                    "Natalia","Zakharova"),
            new Employee(
                    "Oleg","Medvedev"),
            new Employee(
                    "Irina","nikitina"),
            new Employee(
                    "Alexei","Perevalow")

    ));


    @Override
    public Employee addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.add(employee);
        return employee;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            employees.remove(employee);
            return employee;
        }

       throw new EmployeeNotFoundException();
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            return employee;
        }

        throw new EmployeeNotFoundException();
    }

    @Override
    public Collection<Employee> findAll() {
        return new ArrayList<>(employees);
    }
}
