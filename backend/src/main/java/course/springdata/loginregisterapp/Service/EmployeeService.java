package course.springdata.loginregisterapp.Service;

import course.springdata.loginregisterapp.DTO.EmployeeDTO;
import course.springdata.loginregisterapp.DTO.LoginDTO;
import course.springdata.loginregisterapp.response.LoginResponse;

public interface EmployeeService {
    String addEmployee(EmployeeDTO employeeDTO);

    LoginResponse loginEmployee(LoginDTO loginDTO);
}
