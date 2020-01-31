package cinema.dto;

import java.util.List;

public class PersonFull extends PersonLight {
	
	private List<String> nationalities;
	private String biography;
	
	
	public List<String> getNationalities() {
		return nationalities;
	}
	public void setNationalities(List<String> nationalities) {
		this.nationalities = nationalities;
	}
	public String getBiography() {
		return biography;
	}
	public void setBiography(String biography) {
		this.biography = biography;
	}
	
	

}
