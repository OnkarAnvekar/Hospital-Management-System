package com.hms.dtos;

import java.util.List;

import com.hms.entities.DoctorVisit;
import com.hms.entities.MedicineAssigned;
import com.hms.entities.Patient;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter@NoArgsConstructor@AllArgsConstructor
public class ChargesCalculationBeanPatient {
	private double wardCharges;
	private double doctorCharges;
	private double medicineCharges;
	
	
	
	public static ChargesCalculationBeanPatient calculateCharges(Patient patient,int daysStayed) {
		ChargesCalculationBeanPatient totalCharges=new ChargesCalculationBeanPatient();
		double unitWardCharges=patient.getWard().getCharges();
		double wardCharges=unitWardCharges*daysStayed;
		
		
		double totalMedicineCharges=0;
		for(MedicineAssigned m:patient.getMedicines()) {
			totalMedicineCharges=totalMedicineCharges+ m.getMedicine().getPrice()*m.getMedicineQty();
		}
		totalCharges.setMedicineCharges(totalMedicineCharges);
		
		totalCharges.setWardCharges(wardCharges);
		List<DoctorVisit> visitList=patient.getVisits();
		double visitTotal=0;
		for(DoctorVisit d :visitList) {
			visitTotal =visitTotal+d.getVisits()*d.getDoctor().getCharges();
			
		}
		totalCharges.setDoctorCharges(visitTotal);
		
		return totalCharges;
		
	}



	public double getWardCharges() {
		return wardCharges;
	}



	public void setWardCharges(double wardCharges) {
		this.wardCharges = wardCharges;
	}



	public double getDoctorCharges() {
		return doctorCharges;
	}



	public void setDoctorCharges(double doctorCharges) {
		this.doctorCharges = doctorCharges;
	}



	public double getMedicineCharges() {
		return medicineCharges;
	}



	public void setMedicineCharges(double medicineCharges) {
		this.medicineCharges = medicineCharges;
	}
	
	

}
