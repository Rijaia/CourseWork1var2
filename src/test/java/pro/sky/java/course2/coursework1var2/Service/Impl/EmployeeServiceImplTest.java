package pro.sky.java.course2.coursework1var2.Service.Impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.java.course2.coursework1var2.Employee;
import pro.sky.java.course2.coursework1var2.exception.EmployeeStorageIsFullExeption;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class EmployeeServiceImplTest {
    private EmployeeServiceImpl employeeService;


    @Test
    void shouldAddEmployee() throws EmployeeStorageIsFullExeption {
        //given
        List<Employee> employees = new ArrayList<>(){{
            add(new Employee("Ivan","Ivanov", 40000,1));
        }};
        //when
        List<Employee> expected = Collections.singletonList(employees.get(0));
        List<Employee> addEmployee = (List<Employee>) employeeService.addEmployee(
                "Ivan","Ivanov", 40000,1);
        List<Employee> actual = Collections.singletonList(addEmployee.get(0));
        //then
        Assertions.assertEquals(expected,actual);
    }

    @Test
    void shouldRemoveEmployee() {
    }

    @Test
    void shouldFindEmployee() {
    }

    @Test
    void shouldFindAll() {
    }

    @Test
    void shouldGetAllEmployees() {
    }
}