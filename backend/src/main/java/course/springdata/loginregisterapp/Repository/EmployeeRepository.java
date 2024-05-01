package course.springdata.loginregisterapp.Repository;

import course.springdata.loginregisterapp.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    Employee findByEmail(String email);
    Optional<Employee> findOneByEmailAndPassword(String email, String password);
}
