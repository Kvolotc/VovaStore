package store.persistence.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import store.persistence.entity.enums.Gender;
import store.persistence.entity.enums.Role;



@Entity
@Table(name = "users")
public class User {
	
	public User() {};
	
	public User(int id, String firstName, String lastName, Timestamp birthDate, Timestamp registrationDate,
			Gender gender, String email, boolean isActivated, boolean isLogged, Role role, String password) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.registrationDate = registrationDate;
		this.gender = gender;
		this.email = email;
		this.isActivated = isActivated;
		this.isLogged = isLogged;
		this.role = role;
		this.password = password;
	}
	
	public User(User user) {
		this.id = user.id;
		this.firstName = user.firstName;
		this.lastName = user.lastName;
		this.birthDate = user.birthDate;
		this.registrationDate = user.registrationDate;
		this.gender = user.gender;
		this.email = user.email;
		this.isActivated = user.isActivated;
		this.isLogged = user.isLogged;
		this.role = user.role;
		this.password = user.password;
	}

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "first_name")
	@Size(max = 20)
	private String firstName;
	
	@Column(name = "last_name")
	@Size(max = 20)
	private String lastName;
	
	@Column(name = "birth_date")
	private Timestamp birthDate;
	
	@Column(name = "registration_date")
	private Timestamp registrationDate;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "gender")
	private Gender gender;
	
	@Column(name = "email", unique = true)
	private String email;
	
	@Column(name = "is_activated")
	private boolean isActivated;
	
	@Column(name = "is_logged")
	private boolean isLogged;
	
	@Column(name = "role")
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@Column(name = "password")
	private String password;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Timestamp getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Timestamp birthDate) {
		this.birthDate = birthDate;
	}

	public Timestamp getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Timestamp registrationDate) {
		this.registrationDate = registrationDate;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isActivated() {
		return isActivated;
	}

	public void setActivated(boolean isActivated) {
		this.isActivated = isActivated;
	}

	public boolean isLogged() {
		return isLogged;
	}

	public void setLogged(boolean isLogged) {
		this.isLogged = isLogged;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", birthDate=" + birthDate
				+ ", registrationDate=" + registrationDate + ", gender=" + gender + ", email=" + email
				+ ", isActivated=" + isActivated + ", isLogged=" + isLogged + ", role=" + role + ", password="
				+ password + "]";
	}
	
}
