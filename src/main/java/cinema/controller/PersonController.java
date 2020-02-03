package cinema.controller;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cinema.dto.MovieLight;
import cinema.persistance.entity.Person;

import cinema.dto.PersonFull;
import cinema.dto.PersonLight;
import cinema.service.IPersonService;

@RestController
@RequestMapping("/api/person")
public class PersonController {
	
	@Autowired
	IPersonService personService;

	@GetMapping
	@ResponseBody
	public List<PersonLight> allPersons() {
		return personService.getAllPersons();
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	public Optional<PersonFull> singlePerson(@PathVariable("id") int id) {
		return personService.getPersonById(id);
	}
	

	@GetMapping("/findByName")
	@ResponseBody
	public Set<PersonFull> personByName(@RequestParam("n") String name) {
		return personService.getPersonByName(name);
	}

	
	@GetMapping("/findByYear")
	@ResponseBody
	public Set<PersonFull> findPersonByYear(@RequestParam("y") int year) {
		return personService.getPersonByYear(year);
	}
	
	@GetMapping("/directorByMovie/{idM}")
	@ResponseBody
	Optional<PersonLight> getMovieDirector(@PathVariable ("idM") Integer idMovie)  {
		return personService.getMovieDirector(idMovie);
	}
	
	@GetMapping("/actorsByMovie/{idM}")
	@ResponseBody
	List<PersonLight> getMovieActors(@PathVariable ("idM") Integer idMovie)  {
		return personService.getMovieActors(idMovie);
	}

	
	/**
	 * Method: Post
	 */
	
//	@PostMapping("/addNewPerson")
//	@ResponseBody
//	public Person addNewPerson(@RequestBody Person newPerson) {
//		return personService.addNewPerson(newPerson);
//	}
	
}
