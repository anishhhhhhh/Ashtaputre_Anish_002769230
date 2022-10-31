package neu.data.model;

import neu.data.directory.EncounterDirectory;
import neu.util.customTypes.Date;

public class Encounter {
    private String encounterId;
    private Date date;
    private String patientId;
    private String doctorId;
    private VitalSigns vitalSigns;
    
    public Encounter(String patientId, int month, int day, int year ,String doctorId, VitalSigns vitalSigns) {
        this.encounterId = Integer.toString(EncounterDirectory.getEncounterList().size());
        this.date = new Date(month, day, year);
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.vitalSigns = vitalSigns;
    }

    public String getEncounterId() {
        return encounterId;
    }
    
    public Date getDate() {
        return this.date;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public VitalSigns getVitalSigns() {
        return vitalSigns;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }
    
    public void setVitalSigns(VitalSigns vitalSigns) {
        this.vitalSigns = vitalSigns;
    }
}
