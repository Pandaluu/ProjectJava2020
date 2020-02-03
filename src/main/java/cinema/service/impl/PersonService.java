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

import cinema.dto.MovieFull;
import cinema.dto.MovieLight;
import cinema.dto.PersonFull;
import cinema.dto.PersonLight;
import cinema.persistance.entity.Movie;
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
	public Optional<PersonFull> getPersonById (int id) {
			return personRepository.findById(id)
					.map(p -> mapper.map(p, PersonFull.class));
	}

	@Override
	public Set<PersonFull> getPersonByYear(int year) {
		Set<Person> personEntities = personRepository.findByBirthDateYear(year);
		return personEntities.stream()
				.map(me -> mapper.map(me, PersonFull.class))
				.collect(Collectors.toSet());
	}

	@Override
	public Set<PersonFull> getPersonByName(String name) {
		Set<Person> personEntities = personRepository.findByName(name);
		return personEntities.stream()
				.map(me -> mapper.map(me, PersonFull.class))
				.collect(Collectors.toSet());
	}


	@Override
	public Person addNewPerson(Person newPerson) {
		// TODO Auto-generated method stub
		return null;
	}


}
