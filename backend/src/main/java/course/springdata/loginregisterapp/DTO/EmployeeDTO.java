package course.springdata.loginregisterapp.DTO;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EmployeeDTO {

    private Long employeeId;
    private String employeeName;
    private String email;
    private String password;

    public EmployeeDTO() {
    }

    public EmployeeDTO(Long employeeId, String employeeName, String email, String password) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("EmployeeDTO{");
        sb.append("employeeId=").append(employeeId);
        sb.append(", employeeName='").append(employeeName).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
