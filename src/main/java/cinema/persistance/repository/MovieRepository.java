package cinema.persistance.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import cinema.persistance.entity.Movie;
import cinema.persistance.entity.Person;

public interface MovieRepository extends JpaRepository<Movie, Integer>{
	Set<Movie> findByTitle(String title);
	Set<Movie> findByDirector(Person director);
	Set<Movie> findByTitleContainingIgnoreCase(String partialTitle);
	Set<Movie> findByYear(int year);
	Set<Movie> findByYearGreaterThan(int year);
	Set<Movie> findByYearBetween(int StarttYear, int LastYear);
	Set<Movie> findByTitleAndYear(String title, int year);
<<<<<<< HEAD
	
=======
>>>>>>> 029585648c50d24aa196f0ac527321883b491959
	Set<Movie> findByActorsIdPerson(int idPerson);
	Set<Movie> findByActors(Person actor);
	Set<Movie> findByActorsNameEndingWith(String name);

}