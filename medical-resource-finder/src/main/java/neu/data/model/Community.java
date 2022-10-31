package neu.data.model;

import java.util.ArrayList;
import java.util.List;
import neu.data.directory.CommunityDirectory;

public class Community {
    private String zipCode;
    private String name;
    private String adminId;
    private final List<String> listOfPatients;
    private final List<String> listOfDoctors;
    private final List<String> listOfHospitals;

    public Community(String zipCode, String name, String adminId) {
        this.zipCode = zipCode;
        this.name = name;
        this.adminId = adminId;
        this.listOfPatients = new ArrayList<>();
        this.listOfDoctors = new ArrayList<>();
        this.listOfHospitals = new ArrayList<>();
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getName() {
        return name;
    }

    public String getAdminId() {
        return adminId;
    }

    public List<String> getListOfPatients() {
        return listOfPatients;
    }

    public List<String> getListOfDoctors() {
        return listOfDoctors;
    }

    public List<String> getListOfHospitals() {
        return listOfHospitals;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setZip(String zip) {
        this.zipCode = zip;
    }
    
    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }
    
    public void addPatient(String personId) {
        this.listOfPatients.add(personId);
    }
    
    public void addDoctor(String doctorId) {
        this.listOfDoctors.add(doctorId);
    }
    
    public void addHospital(String hospitalId) {
        this.listOfHospitals.add(hospitalId);
    }
    
    public void addToDirectory() {
        CommunityDirectory.addNewCommunity(this);
    }
}
