package pro.sky.java.course2.coursework1var2.Service.Impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.course2.coursework1var2.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.BDDAssumptions.given;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceImplTest {

    @Mock
    private EmployeeServiceImpl employeeService;
    @InjectMocks
    private DepartmentServiceImpl departmentService;
    private final List<Employee> employees = new ArrayList<>(){{
        add(new Employee("Ivan","Ivanov", 40000,1));
        add(new Employee("Alexey","Petrov", 50000,1));
        add(new Employee("Nikolay","Smirnov", 30000,1));
    }};

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void shouldReturnEmployeeWithMaxSalary() {
        //given
        final int departmentId = 1;
        final Map<String, Employee> employeeMap = new HashMap<>();
        for (Employee employee : employees) {
            employeeMap.put(employee.getFirstName()+employee.getLastName(), employee);
        };
        when(employeeService.getAllEmployees()).thenReturn(employeeMap);


        //when
        Employee employeeWithMaxSalary = departmentService.getEmployeeWithMaxSalary(departmentId);

        //then
        Assertions.assertEquals(employees.get(1), employeeWithMaxSalary);
    }
    @Test
    void shouldReturnNullWhenNoEmployeesInDepartment() {
        //given
        final int departmentId = 2;
        final Map<String, Employee> employeeMap = new HashMap<>();
        for (Employee employee : employees) {
            employeeMap.put(employee.getFirstName()+employee.getLastName(), employee);
        };
        when(employeeService.getAllEmployees()).thenReturn(employeeMap);


        //when
        Employee employeeWithMaxSalary = departmentService.getEmployeeWithMaxSalary(departmentId);

        //then
        Assertions.assertNull(employeeWithMaxSalary);
        verify(employeeService, times(1)).getAllEmployees();

    }

    @Test
    void shouldReturnEmployeeWithMinSalary() {
        //given
        final int departmentId = 1;
        final Map<String, Employee> employeeMap = new HashMap<>();
        for (Employee employee : employees) {
            employeeMap.put(employee.getFirstName()+employee.getLastName(), employee);
        };
        when(employeeService.getAllEmployees()).thenReturn(employeeMap);


        //when
        Employee employeeWithMinSalary = departmentService.getEmployeeWithMinSalary(departmentId);

        //then
        Assertions.assertEquals(employees.get(1), employeeWithMinSalary);
        verify(employeeService, times(1)).getAllEmployees();

    }


    @Test
    void shouldReturnGropedByDepartmentEmployees() {
        //given
        final int departmentId = 1;
        final Map<String, Employee> employeeMap = new HashMap<>();
        for (Employee employee : employees) {
            employeeMap.put(employee.getFirstName()+employee.getLastName(), employee);}
        when(employeeService.getAllEmployees()).thenReturn(employeeMap);
        //when
        Map<String, Employee> gropedByDepartmentEmployees =
                departmentService.getGropedByDepartmentEmployees(departmentId);
        //then
        Assertions.assertEquals(employeeMap, gropedByDepartmentEmployees);}
}