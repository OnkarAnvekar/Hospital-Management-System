package com.hms.dtos;

import java.util.ArrayList;
import java.util.List;

import com.hms.entities.Medicine;
import com.hms.entities.MedicineAssigned;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter@Setter@NoArgsConstructor@AllArgsConstructor@ToString
public class MedicineAssignedDataBackinBean {
//	pat_id, medicine_id, prescription, medicine_qty, name, price
	private int patId;
	private int medicineId;
	private String medicinePrescription;
	private int medicineQty;
	private String medicineName;
	private double medicinePrice;
	private int medicineAssignedId;
	
	public static List<MedicineAssignedDataBackinBean> createMedicineListForPatient(List<MedicineAssigned> medicines){
		List<MedicineAssignedDataBackinBean> medicineDtoList=new ArrayList<MedicineAssignedDataBackinBean>();
		
		for(MedicineAssigned medicineAssigned:medicines) {
			MedicineAssignedDataBackinBean medicineAssignedDto=new MedicineAssignedDataBackinBean();
			medicineAssignedDto.setMedicineId(medicineAssigned.getMedicine().getId());
			medicineAssignedDto.setMedicineName(medicineAssigned.getMedicine().getName());
			medicineAssignedDto.setMedicinePrice(medicineAssigned.getMedicine().getPrice());
			medicineAssignedDto.setMedicineQty(medicineAssigned.getMedicineQty());
			medicineAssignedDto.setPatId(medicineAssigned.getPatient().getId());
			medicineAssignedDto.setMedicinePrescription(medicineAssigned.getPrescription());
			medicineAssignedDto.setMedicineAssignedId(medicineAssigned.getId());
			
			medicineDtoList.add(medicineAssignedDto);
			
		}
		
		
		return medicineDtoList;
		
		
	}
	public static List<MedicineAssignedDataBackinBean> createAllMedicineList(List<Medicine> medicines){
		List<MedicineAssignedDataBackinBean> medicineDtoList=new ArrayList<MedicineAssignedDataBackinBean>();
		for(Medicine medicine:medicines) {
			MedicineAssignedDataBackinBean medicineAssignedDto=new MedicineAssignedDataBackinBean();
			medicineAssignedDto.setMedicinePrice(medicine.getPrice());
			medicineAssignedDto.setMedicineName(medicine.getName());
			medicineAssignedDto.setMedicineId(medicine.getId());
			medicineDtoList.add(medicineAssignedDto);
		}
		return medicineDtoList;
	}
	public int getPatId() {
		return patId;
	}
	public void setPatId(int patId) {
		this.patId = patId;
	}
	public int getMedicineId() {
		return medicineId;
	}
	public void setMedicineId(int medicineId) {
		this.medicineId = medicineId;
	}
	public String getMedicinePrescription() {
		return medicinePrescription;
	}
	public void setMedicinePrescription(String medicinePrescription) {
		this.medicinePrescription = medicinePrescription;
	}
	public int getMedicineQty() {
		return medicineQty;
	}
	public void setMedicineQty(int medicineQty) {
		this.medicineQty = medicineQty;
	}
	public String getMedicineName() {
		return medicineName;
	}
	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}
	public double getMedicinePrice() {
		return medicinePrice;
	}
	public void setMedicinePrice(double medicinePrice) {
		this.medicinePrice = medicinePrice;
	}
	public int getMedicineAssignedId() {
		return medicineAssignedId;
	}
	public void setMedicineAssignedId(int medicineAssignedId) {
		this.medicineAssignedId = medicineAssignedId;
	}

	
}
