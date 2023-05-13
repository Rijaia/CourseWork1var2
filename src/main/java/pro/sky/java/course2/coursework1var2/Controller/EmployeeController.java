package pro.sky.java.course2.coursework1var2.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.coursework1var2.Employee;
import pro.sky.java.course2.coursework1var2.Service.EmployeeService;
import pro.sky.java.course2.coursework1var2.exception.EmployeeStorageIsFullExeption;

import java.util.Collection;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam ("firstName") String firstName,
                                @RequestParam ("lastName") String lastName,
                                @RequestParam ("salary") Integer salary,
                                @RequestParam ("departmentId") Integer departmentId
                                ) throws EmployeeStorageIsFullExeption {
        return service.addEmployee(firstName, lastName, salary, departmentId);
    }
    @GetMapping("/remove")
    public void removeEmployee(@RequestParam ("firstName") String firstName,
                               @RequestParam ("lastName") String lastName) {
    }
    @GetMapping("/find")
    public Employee findEmployee(@RequestParam ("firstName") String firstName,
                                 @RequestParam ("lastName") String lastName) {
        return service.findEmployee(firstName, lastName);
    }

}
