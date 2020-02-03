package cinema.service;  
import java.util.List; 
import java.util.Optional; 
import java.util.Set;

<<<<<<< HEAD
import cinema.dto.FullPerson;
import cinema.dto.LightPerson;
import cinema.persistance.entity.Person;  

public interface IPersonService {     
	List<LightPerson> getAllPersons();     
	Optional<FullPerson> getPersonById(int id);     
	Set<LightPerson> getPersonByYear(int year);     
	Set<LightPerson> getPersonByName(String name);
	Optional<LightPerson> getMovieDirector(int id_movie);
	List<LightPerson> getMovieActors(int id_movie);

	FullPerson addNewPerson(FullPerson newPerson);
=======
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
	
	     
>>>>>>> 029585648c50d24aa196f0ac527321883b491959
}
