package com.hms.dtos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.hms.entities.Employee;
import com.hms.entities.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

 @NoArgsConstructor @Getter @Setter @ToString @AllArgsConstructor@JsonInclude(value = Include.NON_NULL)
public class EmployeeUserDataBacking {
	
	    private int userId;
		private String firstName;
		private String lastName;
		private String email;
		@JsonProperty(access = Access.WRITE_ONLY)
		private String password;
		private String role;
		private String cellNo;
		private String securityQuestion;
		private String securityAnswer;
		//to generate the jwt token
		private String token;
//*********************************************************************
		
		private int empId;
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		private Date dob;
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		private Date hireDate;
		private double salary;
		private double doctorCharges;
		private int patId;//required if role is patient
		private int doctorId;
		
		
//*********************************************************************
		@JsonProperty(access = Access.WRITE_ONLY)
		public Employee getEmployeeFromData() {
			Employee employee= new Employee(dob, hireDate, salary);
			User user =new User(firstName, lastName, email, password, role, cellNo, securityQuestion, securityAnswer);
			employee.setUser(user);
			return employee;
			
		}
//*********************************************************************
		public static List<EmployeeUserDataBacking> createEmployee(List<Employee> employees){
			List<EmployeeUserDataBacking> employeeDetails= new ArrayList<EmployeeUserDataBacking>();
			for(Employee e:employees) {
				EmployeeUserDataBacking emp= new EmployeeUserDataBacking();
				emp.setFirstName(e.getUser().getFirstName());
				emp.setLastName(e.getUser().getLastName());
				emp.setRole(e.getUser().getRole());
				emp.setCellNo(e.getUser().getCellNo());
				emp.setEmpId(e.getId());
				emp.setDob(e.getDob());
				emp.setHireDate(e.getHireDate());
				emp.setSalary(e.getSalary());
				emp.setEmail(e.getUser().getEmail());
				
				employeeDetails.add(emp);
			}
			
			return employeeDetails;
		}
		
//***************************************************************************
		
		public static EmployeeUserDataBacking createUser(User user) {
			
				
				EmployeeUserDataBacking validUser=new  EmployeeUserDataBacking();
				validUser.setEmail(user.getEmail());
				validUser.setRole(user.getRole());
				validUser.setPassword(user.getPassword());
				if(user.getRole().equals("patient")) {
					validUser.setPatId(user.getPatient().getId());
				}
				if(user.getRole().equals("doctor"))
					validUser.setDoctorId(user.getEmployee().getDoctor().getId());
				return validUser;
			}

///*****************************to update an employee*********************
		public static Employee updateEmployee(int userId,EmployeeUserDataBacking userData) {
			Employee updatedEmployee=new Employee();
			User corruspondingUser=new User();
			corruspondingUser.setId(userId);
			corruspondingUser.setFirstName(userData.getFirstName());
			corruspondingUser.setLastName(userData.getLastName());
			corruspondingUser.setRole(userData.getRole());
			updatedEmployee.setId(userData.getEmpId());
			
			return updatedEmployee;
			
		}
		public int getUserId() {
			return userId;
		}
		public void setUserId(int userId) {
			this.userId = userId;
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
		public String getToken() {
			return token;
		}
		public void setToken(String token) {
			this.token = token;
		}
		public int getEmpId() {
			return empId;
		}
		public void setEmpId(int empId) {
			this.empId = empId;
		}
		public Date getDob() {
			return dob;
		}
		public void setDob(Date dob) {
			this.dob = dob;
		}
		public Date getHireDate() {
			return hireDate;
		}
		public void setHireDate(Date hireDate) {
			this.hireDate = hireDate;
		}
		public double getSalary() {
			return salary;
		}
		public void setSalary(double salary) {
			this.salary = salary;
		}
		public double getDoctorCharges() {
			return doctorCharges;
		}
		public void setDoctorCharges(double doctorCharges) {
			this.doctorCharges = doctorCharges;
		}
		public int getPatId() {
			return patId;
		}
		public void setPatId(int patId) {
			this.patId = patId;
		}
		public int getDoctorId() {
			return doctorId;
		}
		public void setDoctorId(int doctorId) {
			this.doctorId = doctorId;
		}
		
		

}
