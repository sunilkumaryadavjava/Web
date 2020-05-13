package com.san.net.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection ="UserRegistrationDB" )
public class UserRegistrationMongoDomain {

	@Id
	private String id;
	private String name;
	@Indexed(direction = IndexDirection.ASCENDING)
	private String email;
	private String password;
	private String gender;
	private String note;
	private String dob;
	private boolean married;
	private String professional;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getProfessional() {
		return professional;
	}
	public void setProfessional(String professional) {
		this.professional = professional;
	}
	@Override
	public String toString() {
		return "UserRegistration [name=" + name + ", email=" + email + ", password=" + password + ", gender=" + gender
				+ ", note=" + note + ", dob=" + dob + ", professional=" + professional + "]";
	}
	public boolean getMarried() {
		return married;
	}
	public void setMarried(boolean married) {
		this.married = married;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public UserRegistrationMongoDomain(String name, String email, String password, String gender,
			String note, String dob, boolean married, String professional) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.note = note;
		this.dob = dob;
		this.married = married;
		this.professional = professional;
	}
	public UserRegistrationMongoDomain() {}
	
}
