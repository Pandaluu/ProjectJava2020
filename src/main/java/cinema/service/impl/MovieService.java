package cinema.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
<<<<<<< HEAD
import java.util.stream.Collector;
=======
>>>>>>> 029585648c50d24aa196f0ac527321883b491959
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

<<<<<<< HEAD
import cinema.dto.FullMovie;
import cinema.dto.LightMovie;
=======
import cinema.dto.MovieFull;
import cinema.dto.MovieLight;
>>>>>>> 029585648c50d24aa196f0ac527321883b491959
import cinema.persistance.entity.Movie;
import cinema.persistance.entity.Person;
import cinema.persistance.repository.MovieRepository;
import cinema.persistance.repository.PersonRepository;
import cinema.service.IMovieService;

@Service
@Transactional
public class MovieService implements IMovieService {

	@Autowired
	private ModelMapper mapper;

	@Autowired
	MovieRepository movieRepository;

	@Autowired
	PersonRepository personRepository;
<<<<<<< HEAD

	@Override
	public List<LightMovie> getAllMovies() {
		List<Movie> movieEntity =  movieRepository.findAll();
		return movieEntity.stream()
				.map(me -> mapper.map(me, LightMovie.class))
				.collect(Collectors.toList());
	}

	@Override
	public Optional<FullMovie> getMovieById(int idMovie) {
		return	movieRepository.findById(idMovie)
				.map(me -> mapper.map(me, FullMovie.class));
	}

	@Override
	public Set<LightMovie> getMovieByPartialTitle(String partialTitle) {
		Set<Movie> movieEntity =  movieRepository.findByTitleContainingIgnoreCase(partialTitle);
		return movieEntity.stream()
				.map(me -> mapper.map(me, LightMovie.class))
=======
	
	@Autowired
	ModelMapper mapper;
	
	@Override
	public List<MovieLight> getAllMovies() {
		List<Movie> movieEntities = movieRepository.findAll();
		return movieEntities.stream()
			.map(me -> mapper.map(me, MovieLight.class))	
			.collect(Collectors.toList());
	}

	@Override
	public Optional<MovieFull> getMovieById(int idMovie) {
		return	movieRepository.findById(idMovie)
				.map(me -> mapper.map(me, MovieFull.class));
	}

	@Override
	public Set<MovieLight> getMovieByPartialTitle(String partialTitle) {
		Set<Movie> movieEntities = movieRepository.findByTitleContainingIgnoreCase(partialTitle);
		return movieEntities.stream()
				.map(me -> mapper.map(me, MovieLight.class))
>>>>>>> 029585648c50d24aa196f0ac527321883b491959
				.collect(Collectors.toSet());
	}

	@Override
<<<<<<< HEAD
	public Set<LightMovie> getMovieByTitle(String title) {
		Set<Movie> movieEntity = movieRepository.findByTitle(title);
		return movieEntity.stream()
				.map(me -> mapper.map(me, LightMovie.class))
=======
	public Set<MovieLight> getMovieByTitle(String title) {
		Set<Movie> movieEntities = movieRepository.findByTitle(title);
		return movieEntities.stream()
				.map(me -> mapper.map(me, MovieLight.class))
>>>>>>> 029585648c50d24aa196f0ac527321883b491959
				.collect(Collectors.toSet());
	}

	@Override
<<<<<<< HEAD
	public Set<LightMovie> getMovieByYear(int year) {
		Set<Movie> movieEntity = movieRepository.findByYear(year);
		return movieEntity.stream()
				.map(me -> mapper.map(me, LightMovie.class))
=======
	public Set<MovieLight> getMovieByYear(int year) {
		Set<Movie> movieEntities = movieRepository.findByYear(year);
		return movieEntities.stream()
				.map(me -> mapper.map(me, MovieLight.class))
>>>>>>> 029585648c50d24aa196f0ac527321883b491959
				.collect(Collectors.toSet());
	}

	@Override
<<<<<<< HEAD
	public Set<LightMovie> getMovieByYearBetween(int year, int year_end) {
		Set<Movie> movieEntity = movieRepository.findByYearBetween(year, year_end);
		return movieEntity.stream()
				.map(me -> mapper.map(me, LightMovie.class))
=======
	public Set<MovieLight> getMovieByYearBetween(int year, int year_end) {
		Set<Movie> movieEntities = movieRepository.findByYearBetween(year, year_end);
		return movieEntities.stream()
				.map(me -> mapper.map(me, MovieLight.class))
>>>>>>> 029585648c50d24aa196f0ac527321883b491959
				.collect(Collectors.toSet());
	}

	@Override
<<<<<<< HEAD
	public FullMovie addMovie(FullMovie movieDto) {
		Movie movieEntity = mapper.map(movieDto, Movie.class);
		movieRepository.save(movieEntity);
		mapper.map(movieEntity, movieDto);
		return movieDto;
	}

	@Override
	public Optional<FullMovie> addActorToMovie(int id_movie, int id_person) {
		return movieRepository.findById(id_movie)
		.flatMap(me -> personRepository.findById(id_person)
				.map(( Person a) -> {
					me.getActors().add(a);
					movieRepository.flush();
					return mapper.map(me, FullMovie.class);
				}));
	}
	
	@Override
	public Optional<FullMovie> addDirectorToMovie(int id_movie, int id_person) {
		return movieRepository.findById(id_movie)
				.flatMap(me -> personRepository.findById(id_person)
						.map(d -> {
							me.setDirector(d);
							movieRepository.flush();
							return mapper.map(me, FullMovie.class);
						}));
	}

	@Override
	public Optional<FullMovie> modifyMovie(FullMovie movieDto) {
		Optional<Movie> movieEntity = movieRepository.findById(movieDto.getIdMovie())
				.map(me -> mapper.map(me, Movie.class));

		movieEntity.ifPresent(m-> {
			m.setTitle(movieDto.getTitle());
			m.setYear(movieDto.getYear());
			m.setDuration(movieDto.getDuration());
			movieRepository.flush();
		});

		return movieEntity.map(me-> mapper.map(me, FullMovie.class));
	}

	@Override
	public FullMovie deleteMovie(int id_movie) {
		var movieEntity = movieRepository.findById(id_movie);

		movieEntity.ifPresent(m -> {
			movieRepository.delete(m);
			movieRepository.flush();
		});
		return mapper.map(movieEntity, FullMovie.class);
	}
=======
	public MovieFull addMovie(MovieFull movie) {
		Movie movieEntity = mapper.map(movie, Movie.class);
		movieRepository.save(movieEntity);
		mapper.map(movieEntity,movie); //changement de wagon entre Movie entity et Movie dto
		return movie;
	}

	@Override
	public Optional<MovieFull> modifyMovie(MovieFull movie) {
		return null;
	}

	@Override
	public Optional<MovieFull> deleteMovie(int id_movie) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<MovieFull> addActorToMovie(int movieId, int actorId) {
		return movieRepository.findById(movieId)
		.flatMap(me -> personRepository.findById(actorId)
				.map(a -> {
						me.getActors().add(a);
							return mapper.map(me, MovieFull.class);
				}));
	}

//	@Override
//	public Set<MovieLight> getMovieByPartialTitle(String partialTitle) {
//		return	movieRepository.findByTitleContainingIgnoreCase(partialTitle);	
//	}
//
//	@Override
//	public Set<MovieLight> getMovieByTitle(String title) {
//		return movieRepository.findByTitle(title);
//	}
//
//	@Override
//	public Set<MovieLight> getMovieByYear(int year) {
//		return movieRepository.findByYear(year);
//	}
//
//	@Override
//	public Set<MovieLight> getMovieByYearBetween(int year, int year_end) {
//		return movieRepository.findByYearBetween(year, year_end);
//	}
//
//	@Override
//	public MovieFull addMovie(MovieFull movie) {
//		return movieRepository.save(movie);
//	}
//
//	
//	@Override
//	public Optional<MovieFull> modifyMovie(MovieFull movie) {
//		var optMovie = movieRepository.findById(movie.getId_movie());
//		optMovie.ifPresent(m -> {
//			m.setTitle(movie.getTitle());
//			m.setYear(movie.getYear());
//			m.setDuration(movie.getDuration());
//			m.setDirector(movie.getDirector());
//		});	
//		movieRepository.flush();
//		return optMovie;
//	}
//	
//	@Override
//	public Optional<MovieFull> deleteMovie(int id_movie) {
//		var delMovie = movieRepository.findById(id_movie);
//		delMovie.ifPresent(m -> {
//			movieRepository.delete(m);
//			movieRepository.flush();
//		});
//		return delMovie;
//	}

>>>>>>> 029585648c50d24aa196f0ac527321883b491959
}
