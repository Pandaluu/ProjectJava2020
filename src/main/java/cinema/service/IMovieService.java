package cinema.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import cinema.dto.MovieFull;
import cinema.dto.MovieLight;

public interface IMovieService {
	List<MovieLight> getAllMovies();
	Optional<MovieFull> getMovieById(int idMovie);
	Set<MovieLight> getMovieByPartialTitle(String partialTitle);
	Set<MovieLight> getMovieByTitle(String title);
	Set<MovieLight> getMovieByYear(int year);
	Set<MovieLight> getMovieByYearBetween(int year, int year_end);
	MovieFull addMovie(MovieFull movie);
	Optional<MovieFull> addActorToMovie(int movieId, int actorId);
	Optional<MovieFull> modifyMovie(MovieFull movie);
	MovieFull deleteMovie(int id_movie);
	
}
