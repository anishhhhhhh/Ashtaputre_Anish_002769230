package neu.data.model;

import neu.data.directory.*;

public class Doctor extends Person {
    private final static String RESOURCE_IDENTIFIER = "doctor";
    private String specialization;
    private String doctorId;
    private String hospitalId;
    
    private int searchScore;
    
    public Doctor(String password, String access) {
        super(generatePersonId(), password, access);
    }
    
    public static String getRESOURCE_IDENTIFIER() {
        return RESOURCE_IDENTIFIER;
    }
    
    public static String generatePersonId() {
        return "DOC" + Integer.toString(DoctorDirectory.getDoctorList().size());
    }

    public String getSpecialization() {
        return specialization;
    }

    public String getDoctorId() {
        return doctorId;
    }
    
    public int getSearchScore() {
        return searchScore;
    }

    public String getHospitalId() {
        return hospitalId;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public void setDoctorId(String medicalId) {
        this.doctorId = medicalId;
    }
    
    public void setSearchScore(int score) {
        this.searchScore = score;
    }

    public void setHospitalId(String hospitalId) {
        this.hospitalId = hospitalId;
    }

    public void addToDirectory() {
        DoctorDirectory.addNewDoctor(this);
        for (Community com : CommunityDirectory.getCommunityList()) {
            if (com.getZipCode().equals(this.getContactInfo().listOfAddress.get(0).zip)) {
                com.addDoctor(this.getPersonId());
            }
        }
    }
}
