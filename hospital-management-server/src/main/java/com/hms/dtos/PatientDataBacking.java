package com.hms.dtos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.hms.entities.Patient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

 @NoArgsConstructor @Getter @Setter @ToString @AllArgsConstructor@JsonInclude(value = Include.NON_NULL)
public class PatientDataBacking {
	
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
		
//********************Patient extra Details*************************************************
		
		private int patId;
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		private Date dob;
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		private Date dateOfAdmission;
		private int wardId;
		private int doctorId;
		private String bloodGroup;
		private String prescription;
		private int bedAlloted;
		private String paymentStatus;
		private String patientProblem;
		private String doctorFirstName;
		private String doctorLastName;
		private String type;
		private String doctorCellNo;
		//medicine assigned list
		
		
		
		public static List<PatientDataBacking> createPatient(List<Patient> employees){
			List<PatientDataBacking> employeeDetails= new ArrayList<PatientDataBacking>();
			for(Patient p:employees) {
				PatientDataBacking createdPatient= new PatientDataBacking();
				createdPatient.setFirstName(p.getUser().getFirstName());
				createdPatient.setLastName(p.getUser().getLastName());
				createdPatient.setRole(p.getUser().getRole());
				createdPatient.setCellNo(p.getUser().getCellNo());
				createdPatient.setDob(p.getDob());
				createdPatient.setEmail(p.getUser().getEmail());
				createdPatient.setPatId(p.getId());
				createdPatient.setUserId(p.getUser().getId());
				createdPatient.setWardId(p.getWard().getId());
				createdPatient.setDoctorId(p.getDoctor().getId());
				createdPatient.setDateOfAdmission(p.getDateOfAdmission());
				createdPatient.setBloodGroup(p.getBloodGroup());
				if(p.getPrescription()==null) {
					createdPatient.setPrescription("doctor will prescribe you");//to see if prescription is empty or not 
				}else {
					createdPatient.setPrescription(p.getPrescription());
				}

				createdPatient.setBedAlloted(p.getBedAlloted());
				createdPatient.setPaymentStatus(p.getPaymentStatus());
				createdPatient.setPatientProblem(p.getPatientProblem());
				createdPatient.setDoctorFirstName(p.getDoctor().getEmployee().getUser().getFirstName());
				createdPatient.setDoctorLastName(p.getDoctor().getEmployee().getUser().getLastName());
				createdPatient.setPrescription(p.getPrescription());
				createdPatient.setType(p.getWard().getType());
				createdPatient.setDoctorCellNo(p.getUser().getCellNo());
				employeeDetails.add(createdPatient);
			}
			
			return employeeDetails;
		}
		//=====================================patient to send to front end
		
		public static PatientDataBacking getByIdPatient(Patient p) {
			PatientDataBacking createdPatient=new PatientDataBacking();
			createdPatient.setFirstName(p.getUser().getFirstName());
			createdPatient.setLastName(p.getUser().getLastName());
			createdPatient.setRole(p.getUser().getRole());
			createdPatient.setCellNo(p.getUser().getCellNo());
			createdPatient.setDob(p.getDob());
			createdPatient.setEmail(p.getUser().getEmail());
			createdPatient.setPatId(p.getId());
			createdPatient.setUserId(p.getUser().getId());
			createdPatient.setWardId(p.getWard().getId());
			createdPatient.setDoctorId(p.getDoctor().getId());
			createdPatient.setDateOfAdmission(p.getDateOfAdmission());
			createdPatient.setBloodGroup(p.getBloodGroup());
			createdPatient.setPrescription(p.getPrescription());
			createdPatient.setBedAlloted(p.getBedAlloted());
			createdPatient.setPaymentStatus(p.getPaymentStatus());
			createdPatient.setPatientProblem(p.getPatientProblem());
			createdPatient.setDoctorFirstName(p.getDoctor().getEmployee().getUser().getFirstName());
			createdPatient.setDoctorLastName(p.getDoctor().getEmployee().getUser().getLastName());
			createdPatient.setPrescription(p.getPrescription());
			createdPatient.setType(p.getWard().getType());
			createdPatient.setDoctorCellNo(p.getDoctor().getEmployee().getUser().getCellNo());
			
			return createdPatient;
			
		}
		
		
		
//***********************************patients of doctor**********************************
		public static List<PatientDataBacking> createPatientsOfDoctor(List<Patient> employees,int doctorId){
			List<PatientDataBacking> employeeDetails= new ArrayList<PatientDataBacking>();
			for(Patient p:employees) {
				if(p.getDoctor().getId()==doctorId) {
					
					PatientDataBacking createdPatient= new PatientDataBacking();
					createdPatient.setFirstName(p.getUser().getFirstName());
					createdPatient.setLastName(p.getUser().getLastName());
					createdPatient.setRole(p.getUser().getRole());
					createdPatient.setCellNo(p.getUser().getCellNo());
					createdPatient.setDob(p.getDob());
					createdPatient.setEmail(p.getUser().getEmail());
					createdPatient.setPatId(p.getId());
					createdPatient.setUserId(p.getUser().getId());
					createdPatient.setWardId(p.getWard().getId());
					createdPatient.setDoctorId(p.getDoctor().getId());
					createdPatient.setDateOfAdmission(p.getDateOfAdmission());
					createdPatient.setBloodGroup(p.getBloodGroup());
					if(p.getPrescription()==null) {
						createdPatient.setPrescription("doctor will prescribe you");//to see if prescription is empty or not 
					}else {
						createdPatient.setPrescription(p.getPrescription());
					}

					createdPatient.setBedAlloted(p.getBedAlloted());
					createdPatient.setPaymentStatus(p.getPaymentStatus());
					createdPatient.setPatientProblem(p.getPatientProblem());
					createdPatient.setDoctorFirstName(p.getDoctor().getEmployee().getUser().getFirstName());
					createdPatient.setDoctorLastName(p.getDoctor().getEmployee().getUser().getLastName());
					createdPatient.setPrescription(p.getPrescription());
					createdPatient.setType(p.getWard().getType());
					createdPatient.setDoctorCellNo(p.getUser().getCellNo());
					employeeDetails.add(createdPatient);
				}

				}
							
			return employeeDetails;
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

		public int getPatId() {
			return patId;
		}

		public void setPatId(int patId) {
			this.patId = patId;
		}

		public Date getDob() {
			return dob;
		}

		public void setDob(Date dob) {
			this.dob = dob;
		}

		public Date getDateOfAdmission() {
			return dateOfAdmission;
		}

		public void setDateOfAdmission(Date dateOfAdmission) {
			this.dateOfAdmission = dateOfAdmission;
		}

		public int getWardId() {
			return wardId;
		}

		public void setWardId(int wardId) {
			this.wardId = wardId;
		}

		public int getDoctorId() {
			return doctorId;
		}

		public void setDoctorId(int doctorId) {
			this.doctorId = doctorId;
		}

		public String getBloodGroup() {
			return bloodGroup;
		}

		public void setBloodGroup(String bloodGroup) {
			this.bloodGroup = bloodGroup;
		}

		public String getPrescription() {
			return prescription;
		}

		public void setPrescription(String prescription) {
			this.prescription = prescription;
		}

		public int getBedAlloted() {
			return bedAlloted;
		}

		public void setBedAlloted(int bedAlloted) {
			this.bedAlloted = bedAlloted;
		}

		public String getPaymentStatus() {
			return paymentStatus;
		}

		public void setPaymentStatus(String paymentStatus) {
			this.paymentStatus = paymentStatus;
		}

		public String getPatientProblem() {
			return patientProblem;
		}

		public void setPatientProblem(String patientProblem) {
			this.patientProblem = patientProblem;
		}

		public String getDoctorFirstName() {
			return doctorFirstName;
		}

		public void setDoctorFirstName(String doctorFirstName) {
			this.doctorFirstName = doctorFirstName;
		}

		public String getDoctorLastName() {
			return doctorLastName;
		}

		public void setDoctorLastName(String doctorLastName) {
			this.doctorLastName = doctorLastName;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getDoctorCellNo() {
			return doctorCellNo;
		}

		public void setDoctorCellNo(String doctorCellNo) {
			this.doctorCellNo = doctorCellNo;
		}
			
		
//*********************************************************************
		
		
//***************************************************************************
		
		
///*****************************to update an employee*********************
		
		

}
