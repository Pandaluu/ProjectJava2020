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

<<<<<<< HEAD
import cinema.dto.FullPerson;
import cinema.dto.LightPerson;
=======
import cinema.dto.MovieFull;
import cinema.dto.MovieLight;
import cinema.dto.PersonFull;
import cinema.dto.PersonLight;
import cinema.persistance.entity.Movie;
>>>>>>> 029585648c50d24aa196f0ac527321883b491959
import cinema.persistance.entity.Person;
import cinema.persistance.repository.MovieRepository;
import cinema.persistance.repository.PersonRepository;
import cinema.service.IPersonService;

@Service
@Transactional
public class PersonService implements IPersonService{
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	PersonRepository personRepository;
	
	@Autowired
	MovieRepository movieRepository;
<<<<<<< HEAD

	@Override
	public List<LightPerson> getAllPersons() {
		List<Person> personEntity = personRepository.findAll();
		return personEntity.stream()
				.map(pe -> mapper.map(pe, LightPerson.class))
=======
	
	@Autowired
	ModelMapper mapper;


	@Override
	public List<PersonLight> getAllPersons() {
		List<Person> personEntity = personRepository.findAll();
		return personEntity.stream()
				.map(p -> mapper.map(p, PersonLight.class))
>>>>>>> 029585648c50d24aa196f0ac527321883b491959
				.collect(Collectors.toList());
	}
	
	
	@Override
<<<<<<< HEAD
	public Optional<FullPerson> getPersonById(int id) {
		return personRepository.findById(id)
				.map(pe -> mapper.map(pe, FullPerson.class));
=======
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
>>>>>>> 029585648c50d24aa196f0ac527321883b491959
	}
	
	@Override
<<<<<<< HEAD
	public Set<LightPerson> getPersonByName(String name) {
		Set<Person> personEntity = personRepository.findByName(name);
		return personEntity.stream()
				.map(pe -> mapper.map(pe, LightPerson.class))
=======
	public Set<PersonFull> getPersonByYear(int year) {
		Set<Person> personEntities = personRepository.findByBirthDateYear(year);
		return personEntities.stream()
				.map(me -> mapper.map(me, PersonFull.class))
>>>>>>> 029585648c50d24aa196f0ac527321883b491959
				.collect(Collectors.toSet());
	}

	@Override
<<<<<<< HEAD
	public Set<LightPerson> getPersonByYear(int year) {
		Set<Person> personEntity = personRepository.findByBirthDateYear(year);
		return personEntity.stream()
				.map(pe -> mapper.map(pe, LightPerson.class))
				.collect(Collectors.toSet());
	}

	@Override
	public Optional<LightPerson> getMovieDirector(int id_movie) {
		return movieRepository.findById(id_movie)
		.map(me -> {
			Person d = me.getDirector();
			return Objects.isNull(d) ? null : mapper.map(d, LightPerson.class);
		});
	}

	@Override
	public List<LightPerson> getMovieActors(int id_movie) {
		return movieRepository.findById(id_movie)
				.map(me -> me.getActors().stream()
						.map(a -> mapper.map(a, LightPerson.class))
						.collect(Collectors.toList()))
				.orElse(List.of());
	}	
	
	@Override
	public FullPerson addNewPerson(FullPerson personDto) {
		Person personEntity = mapper.map(personDto, Person.class);
		personRepository.save(personEntity);
		mapper.map(personEntity, personDto);
		return personDto;
	}
=======
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


>>>>>>> 029585648c50d24aa196f0ac527321883b491959
}
