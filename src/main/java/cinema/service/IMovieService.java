package cinema.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

<<<<<<< HEAD
import cinema.dto.FullMovie;
import cinema.dto.LightMovie;

public interface IMovieService {
	List<LightMovie> getAllMovies();
	Optional<FullMovie> getMovieById(int idMovie);
	Set<LightMovie> getMovieByPartialTitle(String partialTitle);
	Set<LightMovie> getMovieByTitle(String title);
	Set<LightMovie> getMovieByYear(int year);
	Set<LightMovie> getMovieByYearBetween(int year, int year_end);
	
	FullMovie addMovie(FullMovie movie);
	Optional<FullMovie> addActorToMovie(int id_movie, int id_person);
	Optional<FullMovie> addDirectorToMovie(int id_movie, int id_person);
	
	Optional<FullMovie> modifyMovie(FullMovie movie);
	
	FullMovie deleteMovie(int id_movie);
=======
import cinema.dto.MovieFull;
import cinema.dto.MovieLight;
import cinema.persistance.entity.Movie;

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
	Optional<MovieFull> deleteMovie(int id_movie);
>>>>>>> 029585648c50d24aa196f0ac527321883b491959
	
}
