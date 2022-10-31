package neu.data.model;

import neu.data.directory.CommunityDirectory;
import neu.data.directory.HospitalDirectory;
import neu.util.customTypes.*;
public class Hospital {
    private String hospitalId;
    private String name;
    private ContactInfo contactInfo;
    private String adminId;

    public Hospital(String adminId) {
        this.adminId = adminId;
        this.hospitalId = Integer.toString(HospitalDirectory.getListOfHospitals().size());
        this.contactInfo = new ContactInfo();
    }

    public String getHospitalId() {
        return hospitalId;
    }

    public String getAdminId() {
        return adminId;
    }
    
    public String getName() {
        return name;
    }

    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }
    
    public void addToDirectory() {
        HospitalDirectory.addNewHospital(this);
        for (Community com : CommunityDirectory.getCommunityList()) {
            if (com.getZipCode().equals(this.getContactInfo().listOfAddress.get(0).zip)) {
                com.addHospital(this.getHospitalId());
            }
        }
    }
   
}
