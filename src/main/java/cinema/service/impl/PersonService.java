package cinema.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cinema.dto.PersonFull;
import cinema.dto.PersonLight;
import cinema.persistance.entity.Person;
import cinema.persistance.repository.MovieRepository;
import cinema.persistance.repository.PersonRepository;
import cinema.service.IPersonService;

@Service
@Transactional
public class PersonService implements IPersonService{
	
	@Autowired
	PersonRepository personRepository;
	
	@Autowired
	MovieRepository movieRepository;
	
	@Autowired
	ModelMapper mapper;


	@Override
	public List<PersonLight> getAllPersons() {
		List<Person> personEntity = personRepository.findAll();
		return personEntity.stream()
				.map(p -> mapper.map(p, PersonLight.class))
				.collect(Collectors.toList());
	}
	
	
	@Override
	public Optional<PersonLight> getMovieDirector(Integer idMovie) {
		return movieRepository.findById(idMovie)
			.map(me -> {
				Person d = me.getDirector();
				return Objects.isNull(d) ? null :mapper.map(me.getDirector(),PersonLight.class);
		});
	}
	
	
	@Override
	public List<PersonLight> getMovieActors(Integer idMovie) {
		return movieRepository.findById(idMovie)
				.map(me ->me.getActors().stream()
						.map(a -> mapper.map(a, PersonLight.class))
						.collect(Collectors.toList()))
				.orElse(List.of());
			
	}
			
	@Override
	public Optional<PersonFull> getPersonById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<PersonFull> getPersonByYear(int year) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<PersonFull> getPersonByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Person addNewPerson(Person newPerson) {
		// TODO Auto-generated method stub
		return null;
	}


}
