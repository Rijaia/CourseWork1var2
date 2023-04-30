package pro.sky.java.course2.coursework1var2.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.coursework1var2.Employee;
import pro.sky.java.course2.coursework1var2.Service.EmployeeService;

@RestController
public class EmployeeController {
    private final EmployeeService employeeService;
    private Employee employee;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public String start() {
        return "Список сотрудников ";

    }
    @GetMapping(path = "/employee")
    public String getEmployeeInfo(@RequestParam("number") Integer number) {

        return employeeService.getEmployee(number);
    }
    @GetMapping(path = "/employee/add")
    public String addEmployee(@RequestParam("firstName") String firstName,
                              @RequestParam("lastName") String lastName) {
        Employee employee = new Employee(
                firstName,
                lastName);
        employeeService.addEmployee(employee);

        return "Добавлевленный сотрудник";
    }
}
