package com.hms.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.ToString.Exclude;

@SuppressWarnings("serial")
@Entity@Data
@Table(name = "users")@Getter @Setter @NoArgsConstructor @ToString@JsonInclude(value = Include.NON_NULL)
public class User implements UserDetails {

//	+---------+------------+------------+-------------------+----------+------------+------------+
//	| user_userId | first_name | last_name  | email             | password | role       | cell_no    |
//	+---------+------------+------------+-------------------+----------+------------+------------+
//	|       1 | aakash     | virdhe   | aakash.virdhe@gmail.com  | 1234     | admin      | 8668472002 |
//	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String role;
	private String cellNo;
	private String securityQuestion;
	private String securityAnswer;
	
	
	
	@Exclude
	@OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
	private Employee employee;
	
	@Exclude
	@OneToOne(mappedBy = "user",cascade = CascadeType.ALL)
	private Patient patient ;
	
	
	//***************connection to employee 
	public void addEmployee(Employee e) {
		this.employee=e;
		this.employee.setUser(this);
		
	}
	//***************connection to patient 
	public void addPatient(Patient p) {
		this.patient=p;
		this.patient.setUser(this);
		
	}



	public User() {
		// TODO Auto-generated constructor stub
	}
	public User(String firstName, String lastName, String email, String password, String role, String cellNo,
			String securityQuestion, String securityAnswer) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.role = role;
		this.cellNo = cellNo;
		this.securityQuestion = securityQuestion;
		this.securityAnswer = securityAnswer;
	}


	//***********created for testing purpose
	public User(int id, String firstName) {
		super();
		this.id = id;
		this.firstName = firstName;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> grantedAuthorities=new ArrayList<GrantedAuthority>();
		grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_"+this.getRole().toUpperCase()));

		return grantedAuthorities;
		
	}
	@Override
	public String getUsername() {
		
		return email;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getCellNo() {
		return cellNo;
	}
	public void setCellNo(String cellNo) {
		this.cellNo = cellNo;
	}
	public String getSecurityQuestion() {
		return securityQuestion;
	}
	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}
	public String getSecurityAnswer() {
		return securityAnswer;
	}
	public void setSecurityAnswer(String securityAnswer) {
		this.securityAnswer = securityAnswer;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	
	


	

	

	

	
}
