package com.hms.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.ToString.Exclude;

@Entity@Table(name = "doctor_visits")@Data
public class DoctorVisit {
	
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Exclude
	@ManyToOne(cascade = CascadeType.PERSIST)@JoinColumn(name = "pat_id")
	private Patient patient;
	
	@Exclude
	@ManyToOne(cascade = CascadeType.PERSIST)@JoinColumn(name = "doctor_id")
	private Doctor doctor;
	private int visits;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public int getVisits() {
		return visits;
	}
	public void setVisits(int visits) {
		this.visits = visits;
	}
	
	
}
