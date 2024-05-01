package course.springdata.loginregisterapp.employeeController;

import course.springdata.loginregisterapp.DTO.EmployeeDTO;
import course.springdata.loginregisterapp.DTO.LoginDTO;
import course.springdata.loginregisterapp.Service.EmployeeService;
import course.springdata.loginregisterapp.response.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping(path = "/save")
    public String saveEmployee(@RequestBody EmployeeDTO employeeDTO){
        return employeeService.addEmployee(employeeDTO);
    }

    @PostMapping(path = "/login")
    public ResponseEntity<?> loginEmployee(@RequestBody LoginDTO loginDTO){
        LoginResponse loginMessage = employeeService.loginEmployee(loginDTO);

        return ResponseEntity.ok(loginMessage);
    }
}