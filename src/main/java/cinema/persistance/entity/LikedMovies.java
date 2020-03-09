package cinema.persistance.entity;


import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class LikedMovies {
	
	@EmbeddedId
	MovieLikingKey id;
	
	@ManyToOne
	@MapsId("id_account")
	@JoinColumn(name = "id_account")
	Account account;
	
	
	@ManyToOne
	@MapsId("id_movie")
	@JoinColumn(name = "id_movie")
	Movie movie;
}
