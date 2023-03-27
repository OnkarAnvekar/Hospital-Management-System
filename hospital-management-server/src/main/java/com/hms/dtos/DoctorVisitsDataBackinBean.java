package com.hms.dtos;
import lombok.Data;
@Data
public class DoctorVisitsDataBackinBean {
		private int visitId;
		private int patientId;
		private int doctorId;
		private int visits;
		public int getVisitId() {
			return visitId;
		}
		public void setVisitId(int visitId) {
			this.visitId = visitId;
		}
		public int getPatientId() {
			return patientId;
		}
		public void setPatientId(int patientId) {
			this.patientId = patientId;
		}
		public int getDoctorId() {
			return doctorId;
		}
		public void setDoctorId(int doctorId) {
			this.doctorId = doctorId;
		}
		public int getVisits() {
			return visits;
		}
		public void setVisits(int visits) {
			this.visits = visits;
		}
		
		
		
}
