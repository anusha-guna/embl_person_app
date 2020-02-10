package embl.Person;

import org.springframework.data.jpa.repository.JpaRepository;
//implementation for H2 Database
public interface PersonRepo extends JpaRepository<Person, Long> {

}
