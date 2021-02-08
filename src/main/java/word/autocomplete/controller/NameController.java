package word.autocomplete.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import word.autocomplete.model.Name;
import word.autocomplete.service.INameService;

@RestController
public class NameController {
	
	@Autowired
	INameService service;
	
	@GetMapping("/names")
	public List<Name> getNames(@RequestParam String prefix){
		return service.getNames(prefix);
	}
	
	@GetMapping("/names/ignorecase")
	public List<Name> getNamesIgnoreCase(@RequestParam String prefix){
		return service.getNamesIgnoreCase(prefix);
	}
}
