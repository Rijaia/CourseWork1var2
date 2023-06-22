package pro.sky.java.course2.coursework1var2.Service;

import pro.sky.java.course2.coursework1var2.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {


    Employee getEmployeeWithMaxSalary(Integer departmentId);

    Employee getEmployeeWithMinSalary(Integer departmentId);

    Double getSumSalaryByDepartment(Integer departmentId);

    Map<Integer, List<Employee>> getGropedByDepartmentEmployees(Integer departmentId);
}
