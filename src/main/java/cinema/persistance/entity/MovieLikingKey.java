package cinema.persistance.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class MovieLikingKey implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Column(name = "id_account")
	Integer accountId;
	
	@Column(name = "id_movie")
	Integer movieId;
	

}
