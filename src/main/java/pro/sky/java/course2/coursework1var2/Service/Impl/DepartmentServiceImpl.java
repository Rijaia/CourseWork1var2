package pro.sky.java.course2.coursework1var2.Service.Impl;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.coursework1var2.Employee;
import pro.sky.java.course2.coursework1var2.Service.DepartmentService;
import pro.sky.java.course2.coursework1var2.Service.EmployeeService;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
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
    public Map<Integer, List<Employee>> getGropedByDepartmentEmployees(Integer departmentId) {
        return employeeService.getAllEmployees().values().stream().
                filter(employee -> departmentId == null || employee.getDepartmentId().equals(departmentId))
                .collect(Collectors.groupingBy(Employee::getDepartmentId));

    }
}
