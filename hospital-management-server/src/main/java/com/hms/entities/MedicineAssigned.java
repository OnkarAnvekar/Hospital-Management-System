package com.hms.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity@Table(name = "medicines_assigned")@Getter@Setter@NoArgsConstructor@AllArgsConstructor
public class MedicineAssigned {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
//	pat_id, medicine_id, prescription, medicine_qty
	//one patient may have more than one medicine
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "pat_id")
	private Patient patient ;
	
	

	
	public MedicineAssigned() {
		// TODO Auto-generated constructor stub
	}

	//foreign key from medicines table
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "medicine_id")
	private Medicine medicine ;
	
	private String prescription;
	
	private int medicineQty;
	
	//constructor without medicine
	public MedicineAssigned( String prescription, int medicineQty) {
		super();
		
		this.prescription = prescription;
		this.medicineQty = medicineQty;
	}

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

	public Medicine getMedicine() {
		return medicine;
	}

	public void setMedicine(Medicine medicine) {
		this.medicine = medicine;
	}

	public String getPrescription() {
		return prescription;
	}

	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}

	public int getMedicineQty() {
		return medicineQty;
	}

	public void setMedicineQty(int medicineQty) {
		this.medicineQty = medicineQty;
	}
	
	

}
