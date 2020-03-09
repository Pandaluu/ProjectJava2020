package cinema.persistance.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Account")
public class Account {
	
	@Column
	private Integer id;
	private String userName;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	
	@OneToMany(mappedBy = "account")
	private Set<LikedMovies> likedMovies;
	
	@Column
	@ElementCollection(targetClass = String.class)
	private List<String> roles = new ArrayList<String>();
		
	public Account() {
		super();
	}
	
	public Account(Integer id, String email, String password) {
		this(id,null,null,null,email,password,null);
		
	}

	public Account(Integer id, String userName, String firstName, String lastName, String email, String password,
			Set<LikedMovies> likedMovies) {
		super();
		this.id = id;
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.likedMovies = likedMovies;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_account")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "username", nullable = false)
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "first_name", nullable = false)
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "last_name", nullable = false)
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
//
//	@Column(name = "movieLiked")
//	@ManyToMany
//	@JoinTable(name="likedMovie",
//    joinColumns=
//        @JoinColumn(name="id_movie"),
//    inverseJoinColumns=
//        @JoinColumn(name="id_account")
//	)

//	public Set<LikedMovies> getLikedmovies() {
//		return likedmovies;
//	}
//
//	public void setLikedmovies(Set<LikedMovies> likedmovies) {
//		this.likedmovies = likedmovies;
//	}

	
	
	
}
