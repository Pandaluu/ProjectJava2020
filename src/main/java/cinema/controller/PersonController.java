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

<<<<<<< HEAD
import cinema.dto.FullPerson;
import cinema.dto.LightPerson;
import cinema.persistance.entity.Person;
=======
import cinema.dto.PersonFull;
import cinema.dto.PersonLight;
>>>>>>> 029585648c50d24aa196f0ac527321883b491959
import cinema.service.IPersonService;

@RestController
@RequestMapping("/api/person")
public class PersonController {
	
	@Autowired
	IPersonService personService;

	@GetMapping
	@ResponseBody
<<<<<<< HEAD
	public List<LightPerson> allPersons() {
=======
	public List<PersonLight> allPersons() {
>>>>>>> 029585648c50d24aa196f0ac527321883b491959
		return personService.getAllPersons();
	}
	
	@GetMapping("/{id}")
	@ResponseBody
<<<<<<< HEAD
	public Optional<FullPerson> singlePerson(@PathVariable("id") int id) {
=======
	public Optional<PersonFull> singlePerson(@PathVariable("id") int id) {
>>>>>>> 029585648c50d24aa196f0ac527321883b491959
		return personService.getPersonById(id);
	}
	
	@GetMapping("/getMovieDirector/{id}")
	@ResponseBody
	Optional<LightPerson> getMovieDirector( @PathVariable("id") int id_movie){
		return personService.getMovieDirector(id_movie);
	}
	
	@GetMapping("/getActorsByMovie/{id}")
	@ResponseBody
	List<LightPerson> getMovieActors( @PathVariable("id") int id_movie){
		return personService.getMovieActors(id_movie);
	}
	
	@GetMapping("/findByYear")
	@ResponseBody
<<<<<<< HEAD
	public Set<LightPerson> findPersonByYear(@RequestParam("y") int year) {
		return personService.getPersonByYear(year);
	}
	
	@PostMapping("/addNewPerson")
	@ResponseBody
	public FullPerson addNewPerson(@RequestBody FullPerson newPerson) {
		return personService.addNewPerson(newPerson);
	}
=======
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
	
>>>>>>> 029585648c50d24aa196f0ac527321883b491959
}
