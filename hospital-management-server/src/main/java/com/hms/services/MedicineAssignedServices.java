package com.hms.services;
import static com.hms.dtos.WardDataBackinBean.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hms.custom_exception.NoSuchMedicineExistsException;
import com.hms.daos.IDoctorDao;
import com.hms.daos.IEmployeeDao;
import com.hms.daos.IMedicineAssignedDao;
import com.hms.daos.IMedicineDao;
import com.hms.daos.IUserDao;
import com.hms.daos.IWardDao;
import com.hms.dtos.DoctorDataBackinBean;
import com.hms.dtos.MedicineAssignedDataBackinBean;
import com.hms.dtos.WardDataBackinBean;
import com.hms.entities.User;
import com.hms.entities.Ward;

@Service @Transactional
public class MedicineAssignedServices {
	@Autowired
	IUserDao userDao;
	@Autowired
	IEmployeeDao employeeDao;
	@Autowired
	IWardDao wardDao;
	@Autowired
	IMedicineAssignedDao medicineAssingedDao;
	@Autowired
	IMedicineDao medicineDao;
	
	public void addMedicineToPatient(MedicineAssignedDataBackinBean medicineData) throws NoSuchMedicineExistsException {
		
			medicineAssingedDao.addIntoMedicineAssigned(medicineData.getPatId(), medicineData.getMedicineId(), medicineData.getMedicinePrescription(), medicineData.getMedicineQty());
		
		
		
	}
	
	public void removeMedicineOfPatient(int medicineAssignId) {
		medicineAssingedDao.deleteById(medicineAssignId);
	}
	
	
	
	

}
