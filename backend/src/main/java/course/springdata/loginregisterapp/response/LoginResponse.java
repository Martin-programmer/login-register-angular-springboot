package course.springdata.loginregisterapp.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LoginResponse {
    String message;
    Boolean status;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("LoginResponse{");
        sb.append("message='").append(message).append('\'');
        sb.append(", status=").append(status);
        sb.append('}');
        return sb.toString();
    }
}
