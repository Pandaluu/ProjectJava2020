package cinema.controller;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import cinema.dto.MovieFull;
import cinema.dto.MovieLight;
import cinema.persistance.entity.Movie;
import cinema.persistance.repository.MovieRepository;
import cinema.service.IMovieService;


@RestController
@RequestMapping("/api/movie")
public class MovieController {

	@Autowired(required = true)
	IMovieService movieService;
	
	@Autowired
	MovieRepository mrepo;

	@CrossOrigin
	@GetMapping
	@ResponseBody
	public List<MovieLight> allMovies(){
		return movieService.getAllMovies();
	}

	@CrossOrigin
	@GetMapping(value="/{id}")
	@ResponseBody
	public Optional<MovieFull> singleMovie(@PathVariable("id") Integer id) {
		return movieService.getMovieById(id);
	}

	@CrossOrigin
	@GetMapping(value="/byTitle")
	@ResponseBody
	public Set<MovieLight> movieByTitle(@RequestParam("t") String title) {
		return movieService.getMovieByTitle(title);
	}
	
	@CrossOrigin
	@GetMapping(value="/byTitleP")
	@ResponseBody
	public Set<Movie> movieByPartialTitle(@RequestParam("t") String title) {
		return mrepo.findByTitleContainingIgnoreCase(title);
	}
	

	@CrossOrigin
	@GetMapping(value="/byYear")
	@ResponseBody
	public Set<MovieLight> movieByYear(@RequestParam("s") int year) {
		return movieService.getMovieByYear(year);
	}

	@CrossOrigin
	@GetMapping(value="/byYearBetween")
	@ResponseBody
	public Set<MovieLight> movieByYearBetween(@RequestParam("s") int year, @RequestParam("e") int year_end) {
		return movieService.getMovieByYearBetween(year, year_end);
	}

	/**
	 * Method: Post
	 */

	public @ResponseBody MovieFull addMovie(@RequestBody MovieFull movie) {
		return movieService.addMovie(movie);
	}

	/**
	 * Method: Put
	 */
	
	@PutMapping("/modify")
	public @ResponseBody Optional<MovieFull> mofiyMovie(@RequestBody MovieFull movie) {
		return movieService.modifyMovie(movie);
	}
	
	@PutMapping("/addActor")
	public Optional<MovieFull> addActorToMovie(@RequestParam("m") int movieId, @RequestParam("a") int actorId) {		
		return movieService.addActorToMovie(movieId, actorId);
	}

	/**
	 * Delete
	 */

	@DeleteMapping("/deleteMovie/{id}")
	@ResponseBody
	public MovieFull deleteMovie(@PathVariable("id") int id_movie) {
		return movieService.deleteMovie(id_movie);
	}

}
