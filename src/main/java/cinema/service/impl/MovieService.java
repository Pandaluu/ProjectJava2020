package cinema.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cinema.dto.MovieFull;
import cinema.dto.MovieLight;
import cinema.persistance.entity.Movie;
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
	public Set<MovieLight> getMovieByTitle(String title) {
		Set<Movie> movieEntities = movieRepository.findByTitle(title);
		return movieEntities.stream()
				.map(me -> mapper.map(me, MovieLight.class))
				.collect(Collectors.toSet());
	}

	@Override
	public Set<MovieLight> getMovieByYear(int year) {
		Set<Movie> movieEntities = movieRepository.findByYear(year);
		return movieEntities.stream()
				.map(me -> mapper.map(me, MovieLight.class))
				.collect(Collectors.toSet());
	}

	@Override
	public Set<MovieLight> getMovieByYearBetween(int year, int year_end) {
		Set<Movie> movieEntities = movieRepository.findByYearBetween(year, year_end);
		return movieEntities.stream()
				.map(me -> mapper.map(me, MovieLight.class))
				.collect(Collectors.toSet());
	}

	@Override
	public MovieFull addMovie(MovieFull movie) {
		Movie movieEntity = mapper.map(movie, Movie.class);
		movieRepository.save(movieEntity);
		mapper.map(movieEntity,movie); //changement de wagon entre Movie entity et Movie dto
		return movie;
	}

	@Override
	public Optional<MovieFull> modifyMovie(MovieFull movie) {
        Optional<Movie> movieEntity = movieRepository.findById(movie.getIdMovie())
                .map(me -> mapper.map(me, Movie.class));

        movieEntity.ifPresent(m-> {
            m.setTitle(movie.getTitle());
            m.setYear(movie.getYear());
            m.setDuration(movie.getDuration());
            movieRepository.flush();
        });
        
        return movieEntity.map(me -> mapper.map(me, MovieFull.class));
    }

    @Override
    public MovieFull deleteMovie(int id_movie) {
        var movieEntity = movieRepository.findById(id_movie);

        movieEntity.ifPresent(m -> {
            movieRepository.delete(m);
            movieRepository.flush();
        });
        return mapper.map(movieEntity, MovieFull.class);
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

	@Override
	public Set<MovieLight> getMovieByPartialTitle(String partialTitle) {
		// TODO Auto-generated method stub
		return null;
	}
	
}

