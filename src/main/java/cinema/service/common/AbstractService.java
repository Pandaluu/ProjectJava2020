package cinema.service.common;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import cinema.exeption.ClientNotFoundException;

@Transactional
public abstract class AbstractService<T> implements IAbstractService<T> {

	@Autowired
	public abstract JpaRepository<T, Long> getRepo();
	
	@Override
	public List<T> findAll() {
		return getRepo().findAll();
	}

	@Transactional
	@Override
	public T findOne(Integer id) {
		Optional<T> opt = getRepo().findById(id);
		if (!opt.isPresent()) {
			throw new ClientNotFoundException("Pas de résultat");
		}
		return opt.get();
	}

	@Override
	public boolean deleteById(Long id) {
		return false;
	}

	@Override
	public boolean delete(T t) {
		return false;
	}
	
	@PostMapping
	@Override
	public T save(@RequestBody T t) {
		return getRepo().save(t);
	}
	
}