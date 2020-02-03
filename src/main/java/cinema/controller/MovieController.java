package cinema.controller;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
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

<<<<<<< HEAD
import cinema.dto.FullMovie;
import cinema.dto.LightMovie;
=======
import cinema.dto.MovieFull;
import cinema.dto.MovieLight;
>>>>>>> 029585648c50d24aa196f0ac527321883b491959
import cinema.service.IMovieService;


@RestController
@RequestMapping("/api/movie")
public class MovieController {

	@Autowired(required = true)
	IMovieService movieService;

	@GetMapping
	@ResponseBody
<<<<<<< HEAD
	public List<LightMovie> allMovies(){
=======
	public List<MovieLight> allMovies(){
>>>>>>> 029585648c50d24aa196f0ac527321883b491959
		return movieService.getAllMovies();
	}

	@GetMapping(value="/{id}")
	@ResponseBody
<<<<<<< HEAD
	public Optional<FullMovie> singleMovie(@PathVariable("id") Integer id) {
=======
	public Optional<MovieFull> singleMovie(@PathVariable("id") Integer id) {
>>>>>>> 029585648c50d24aa196f0ac527321883b491959
		return movieService.getMovieById(id);
	}

	@GetMapping(value="/byTitle")
	@ResponseBody
<<<<<<< HEAD
	public Set<LightMovie> movieByTitle(@RequestParam("t") String title) {
=======
	public Set<MovieLight> movieByTitle(@RequestParam("t") String title) {
>>>>>>> 029585648c50d24aa196f0ac527321883b491959
		return movieService.getMovieByTitle(title);
	}

	@GetMapping(value="/byYear")
	@ResponseBody
<<<<<<< HEAD
	public Set<LightMovie> movieByYear(@RequestParam("s") int year) {
=======
	public Set<MovieLight> movieByYear(@RequestParam("s") int year) {
>>>>>>> 029585648c50d24aa196f0ac527321883b491959
		return movieService.getMovieByYear(year);
	}

	@GetMapping(value="/byYearBetween")
	@ResponseBody
<<<<<<< HEAD
	public Set<LightMovie> movieByYearBetween(@RequestParam("s") int year, @RequestParam("e") int year_end) {
=======
	public Set<MovieLight> movieByYearBetween(@RequestParam("s") int year, @RequestParam("e") int year_end) {
>>>>>>> 029585648c50d24aa196f0ac527321883b491959
		return movieService.getMovieByYearBetween(year, year_end);
	}

	/**
	 * Method: Post
	 */

	@PostMapping("/addMovie")
<<<<<<< HEAD
	public @ResponseBody FullMovie addMovie(@RequestBody FullMovie movie) {
		return movieService.addMovie(movie);
	}

	@PutMapping("/modify")
	public @ResponseBody Optional<FullMovie> mofiyMovie(@RequestBody FullMovie movie) {
		return movieService.modifyMovie(movie);
	}


	@PutMapping("/addActor")
	public Optional<FullMovie> addActorToMovie(@RequestParam("m") int movieId, @RequestParam("a") int actorId) {
		return movieService.addActorToMovie(movieId, actorId);
	}

=======
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
		
>>>>>>> 029585648c50d24aa196f0ac527321883b491959
	/**
	 * Delete
	 */

	@DeleteMapping("/deleteMovie/{id}")
	@ResponseBody
<<<<<<< HEAD
	public FullMovie deleteMovie(@PathVariable("id") int id_movie) {
=======
	public Optional<MovieFull> deleteMovie(@PathVariable("id") int id_movie) {
>>>>>>> 029585648c50d24aa196f0ac527321883b491959
		return movieService.deleteMovie(id_movie);
	}

}
