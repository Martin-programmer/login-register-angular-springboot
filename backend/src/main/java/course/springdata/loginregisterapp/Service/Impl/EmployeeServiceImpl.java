package course.springdata.loginregisterapp.Service.Impl;

import course.springdata.loginregisterapp.DTO.EmployeeDTO;
import course.springdata.loginregisterapp.DTO.LoginDTO;
import course.springdata.loginregisterapp.Entity.Employee;
import course.springdata.loginregisterapp.Repository.EmployeeRepository;
import course.springdata.loginregisterapp.Service.EmployeeService;
import course.springdata.loginregisterapp.response.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public String addEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee(
                employeeDTO.getEmployeeId(),
                employeeDTO.getEmployeeName(),
                employeeDTO.getEmail(),
                this.passwordEncoder.encode(employeeDTO.getPassword())
        );
        employeeRepository.save(employee);
        return employee.getEmployeeName();
    }

    @Override
    public LoginResponse loginEmployee(LoginDTO loginDTO) {
        String message = "";
        Employee employee = employeeRepository.findByEmail(loginDTO.getEmail());
        if (employee != null){
            String password = loginDTO.getPassword();
            String encodedPassword = employee.getPassword();
            boolean isPassRight = passwordEncoder.matches(password, encodedPassword);
            if (isPassRight){
                Optional<Employee> employeeToCheck = employeeRepository
                        .findOneByEmailAndPassword(loginDTO.getEmail(),encodedPassword);
                if (employeeToCheck.isPresent()){
                    return new LoginResponse("Login Success", true);
                }else {
                    return new LoginResponse("Login failed",false);
                }
            }else{
                return new LoginResponse("Password Not Match",false);
            }
        }else{
            return new LoginResponse("Email not exists!",false);
        }
    }
}
