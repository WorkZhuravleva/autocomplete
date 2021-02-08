package word.autocomplete.service;

import java.util.List;

import word.autocomplete.model.Name;

public interface INameService {
	
	List<Name> getNames(String prefix);
	
	List<Name> getNamesIgnoreCase(String prefix);

}
