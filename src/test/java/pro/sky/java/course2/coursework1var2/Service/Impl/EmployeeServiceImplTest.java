package pro.sky.java.course2.coursework1var2.Service.Impl;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.java.course2.coursework1var2.Employee;
import pro.sky.java.course2.coursework1var2.exception.EmployeeStorageIsFullExeption;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        List<Employee> expected = employees;
        List<Employee> actual = (List<Employee>) employeeService.addEmployee(
                "Ivan","Ivanov", 40000,1);

        //when


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