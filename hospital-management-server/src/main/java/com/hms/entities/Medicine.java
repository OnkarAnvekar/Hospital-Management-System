package com.hms.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity@Table(name = "medicines")@Getter@Setter@NoArgsConstructor@AllArgsConstructor
public class Medicine {
//	id, name, price
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private Double price;
	
	@OneToMany(mappedBy = "medicine",cascade = CascadeType.PERSIST)
	private List<MedicineAssigned> mappedMedicines;
	
	//to set the medicine id in assigned medicine
	public void addAssignedMedicine(MedicineAssigned medicineAssigned) {
		medicineAssigned.setMedicine(this);
		mappedMedicines.add(medicineAssigned);
		
	}

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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public List<MedicineAssigned> getMappedMedicines() {
		return mappedMedicines;
	}

	public void setMappedMedicines(List<MedicineAssigned> mappedMedicines) {
		this.mappedMedicines = mappedMedicines;
	}
	
	
	

}
