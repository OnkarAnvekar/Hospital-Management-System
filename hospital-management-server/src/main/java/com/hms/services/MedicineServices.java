package com.hms.services;
import static com.hms.dtos.MedicineAssignedDataBackinBean.*;
import static com.hms.dtos.WardDataBackinBean.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hms.daos.IDoctorDao;
import com.hms.daos.IEmployeeDao;
import com.hms.daos.IMedicineAssignedDao;
import com.hms.daos.IMedicineDao;
import com.hms.daos.IUserDao;
import com.hms.daos.IWardDao;
import com.hms.dtos.DoctorDataBackinBean;
import com.hms.dtos.MedicineAssignedDataBackinBean;
import com.hms.dtos.WardDataBackinBean;
import com.hms.entities.Medicine;
import com.hms.entities.User;
import com.hms.entities.Ward;

@Service @Transactional
public class MedicineServices {
	@Autowired
	IUserDao userDao;
	@Autowired
	IEmployeeDao employeeDao;
	@Autowired
	IWardDao wardDao;
	@Autowired
	IMedicineDao medicineDao;
	@Autowired
	IMedicineAssignedDao medicineAssingedDao;
	
	public List<MedicineAssignedDataBackinBean> getAllMedicines(){
		List<Medicine> medicine=medicineDao.findAll();
		List<MedicineAssignedDataBackinBean> medicinesTosend=createAllMedicineList(medicine);
		return medicinesTosend;
		
	}

	public int addMedicine(MedicineAssignedDataBackinBean medicineData) {
		return  medicineDao.insertIntoMedicineTable(0, medicineData.getMedicineName(), medicineData.getMedicinePrice());
		
	}

	public void removeMedicine(int medicineId) {
		medicineDao.deleteById(medicineId);
		
	}
	
	
	
	
	

}
