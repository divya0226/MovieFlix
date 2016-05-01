package io.movieflix.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;



@Entity
@Table
public class RatingAndComment {

	@Id
	@GenericGenerator(strategy="uuid2", name="myuuid")
	@GeneratedValue(generator="myuuid")
	private String Userid;
	
	private String id;
	private String firstName;
	private String imdbId;
	private String rating;
	private String comment;
	
	public RatingAndComment(){
		
	}
	
	public RatingAndComment(String userid, String id, String firstName, String imdbId, String rating, String comment) {
		super();
		Userid = userid;
		this.id = id;
		this.firstName = firstName;
		this.imdbId = imdbId;
		this.rating = rating;
		this.comment = comment;
	}
	public String getUserid() {
		return Userid;
	}
	public void setUserid(String userid) {
		Userid = userid;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getImdbId() {
		return imdbId;
	}
	public void setImdbId(String imdbId) {
		this.imdbId = imdbId;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
}
