package pro.sky.java.course2.coursework1var2.Service.Impl;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.coursework1var2.Employee;
import pro.sky.java.course2.coursework1var2.Service.DepartmentService;
import pro.sky.java.course2.coursework1var2.Service.EmployeeService;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @Override
    public Employee getEmployeeWithMaxSalary(Integer departmentId) {
        return employeeService.getAllEmployees().values().stream().
                filter(employee -> employee.getDepartmentId().equals(departmentId)).
                max(Comparator.comparing(Employee::getSalary)).orElse(null);
    }

    @Override
    public Employee getEmployeeWithMinSalary(Integer departmentId) {
        return employeeService.getAllEmployees().values().stream().
                filter(employee -> employee.getDepartmentId().equals(departmentId)).
                max(Comparator.comparing(Employee::getSalary)).orElse(null);
    }

    @Override
    public Double getSumSalaryByDepartment(Integer departmentId) {
        List<Employee> salary = employeeService.getAllEmployees().values().stream().
                filter(employee -> employee.getDepartmentId().equals(departmentId)).
                collect(Collectors.toList());
        double sumSalaryByDepartment = 0;
        for (int i = 0; i <= salary.size(); i ++) {
            sumSalaryByDepartment = sumSalaryByDepartment + salary.get(i).getSalary();

        }
        return sumSalaryByDepartment;
    }

    @Override
    public Map<String, Employee> getGropedByDepartmentEmployees(Integer departmentId) {
        Map<String, Employee> map = new HashMap<>();
        for (Employee employee : employeeService.getAllEmployees().values()) {
            if (departmentId == null || employee.getDepartmentId().equals(departmentId)) {
                map.computeIfAbsent(employee.getFirstName()+employee.getLastName(),
                        k -> employee);
            }
        }
        return map;

    }
}
