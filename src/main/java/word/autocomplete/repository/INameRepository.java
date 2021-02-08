package word.autocomplete.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import word.autocomplete.model.Name;

public interface INameRepository extends JpaRepository<Name, String> {
	
	@Query("select n from Name n where n.name like ?1%")
	List<Name> findNames(String prefix);

}
