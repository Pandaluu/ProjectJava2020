package cinema.service;  
import java.util.List; 
import java.util.Optional; 
import java.util.Set;

import cinema.dto.PersonFull;
import cinema.dto.PersonLight;
import cinema.persistance.entity.Person;  

public interface IPersonService {     
	List<PersonLight> getAllPersons();     
	Optional<PersonFull> getPersonById(int id);     
	Set<PersonFull> getPersonByYear(int year);     
	Set<PersonFull> getPersonByName(String name);
	Optional<PersonLight> getMovieDirector(Integer idMovie);
	List<PersonLight> getMovieActors(Integer idMovie);
	Person addNewPerson(Person newPerson);
	
	     
}
