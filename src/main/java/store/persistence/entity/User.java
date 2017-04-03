package store.persistence.entity;

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
public class User<T> {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "name")
	@Size(max = 20)
	private String name;
	
	@Column(name = "second_name")
	@Size(max = 20)
	private String secondName;
	
	@Column(name = "age")
	private int age;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@Column(name = "email", unique = true)
	private String eMail;
	
	@Column(name = "role")
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@Column(name = "password")
	@Size(min = 4, max = 10)
	private String password;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
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
	
}
