package word.autocomplete.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import word.autocomplete.exceptions.InvalidInputArgument;
import word.autocomplete.model.Name;
import word.autocomplete.repository.INameRepository;

@Service
public class NameServiceImpl implements INameService {

	@Autowired
	INameRepository repository;

	@Autowired
	EntityManager entityManager;


	@Override
	public List<Name> getNames(String prefix) {
		if (prefix == null || prefix.isEmpty()) {
			throw new InvalidInputArgument();
		}else {
			List<Name> names = repository.findNames(prefix);
			return names;
		}
	}

	@Override
	public List<Name> getNamesIgnoreCase(String prefix) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Name> criteriaQuery = builder.createQuery(Name.class);
		Root<Name> root = criteriaQuery.from(Name.class);
		List<Predicate> names = new ArrayList<>();
		Predicate name = null;
		if (prefix != null && !prefix.isEmpty()) {
			name = builder.like(builder.lower(root.get("name")), (prefix + "%").toLowerCase());
			names.add(name);
		}else {
			throw new InvalidInputArgument();
		}
		criteriaQuery.where(names.toArray(new Predicate[0]));
		TypedQuery<Name> query = entityManager.unwrap(Session.class).createQuery(criteriaQuery);
		return query.getResultList();
	}

}
