package pro.sky.java.course2.coursework1var2.Service.Impl;

import pro.sky.java.course2.coursework1var2.Employee;
import pro.sky.java.course2.coursework1var2.Service.DepartmentService;
import pro.sky.java.course2.coursework1var2.Service.EmployeeService;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
    public Map<Integer, List<Employee>> getGropedByDepartmentEmployees(Integer departmentId) {
        return employeeService.getAllEmployees().values().stream().
                filter(employee -> departmentId == null || employee.getDepartmentId().equals(departmentId))
                .collect(Collectors.groupingBy(Employee::getDepartmentId));
    }
}
