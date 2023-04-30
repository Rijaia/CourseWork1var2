package pro.sky.java.course2.coursework1var2.Service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.coursework1var2.Employee;

import java.util.ArrayList;
import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService{
     List<Employee> employees = new ArrayList<>(List.of(
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
     public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    @Override
    public String getEmployee(Integer number) {
        return null;
    }

    @Override
    public String getEmployee(Employee employee) {
        return employee.getEmployee(employee);
    }
}
