package pro.sky.java.course2.coursework1var2.Service;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.coursework1var2.Employee;
import pro.sky.java.course2.coursework1var2.exception.EmployeeAlreadyAddedException;
import pro.sky.java.course2.coursework1var2.exception.EmployeeNotFoundException;
import pro.sky.java.course2.coursework1var2.exception.EmployeeStorageIsFullExeption;

import java.util.*;

@Service
public abstract class EmployeeServiceImpl implements EmployeeService{
    private final int EMPLOYEES_STORAGE_SIZE = 5;
     private final Map <String, Employee> employees = new HashMap<>();


    @Override
    public Employee addEmployee(String firstName, String lastName) throws EmployeeStorageIsFullExeption {
        String employeeKey = GetEmployeeKey(firstName, lastName);
        if (employees.containsKey(employeeKey)) {
            throw new EmployeeAlreadyAddedException();
        }
        if (employees.size() == EMPLOYEES_STORAGE_SIZE) {
            throw new EmployeeStorageIsFullExeption("Хранилище полное!");
        }
        employees.put(employeeKey, new Employee(firstName, lastName));

        return employees.get(employeeKey);
    }

    @Override
    public void removeEmployee(String firstName, String lastName) {
        String employeeKey = GetEmployeeKey(firstName, lastName);
        if (!employees.containsKey(employeeKey)) {
            throw new EmployeeNotFoundException("Такого сотрудника нет в хранилище!");}
            employees.remove(employeeKey);
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        String employeeKey = GetEmployeeKey(firstName, lastName);
        if (!employees.containsKey(employeeKey)) {
            throw new EmployeeNotFoundException("Такого сотрудника нет в хранилище!");
        }
        return employees.get(employeeKey);
    }

    @Override
    public Map<String, Employee> getAllEmployees() {
        return employees;
    }

    private String GetEmployeeKey(String firstName, String lastName) {
        return firstName+lastName;
    }
}
