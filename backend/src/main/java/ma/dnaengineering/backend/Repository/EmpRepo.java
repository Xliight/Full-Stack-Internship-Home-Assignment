package ma.dnaengineering.backend.Repository;


import ma.dnaengineering.backend.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpRepo extends JpaRepository<Employee, Long>{

}
