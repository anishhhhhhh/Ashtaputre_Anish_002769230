package neu.data.model;

import neu.data.directory.*;

public class Patient extends Person {
    private final static String RESOURCE_IDENTIFIER = "patient";

    public static String getRESOURCE_IDENTIFIER() {
        return RESOURCE_IDENTIFIER;
    }
    
    public Patient(String password, String access) {
        super(generatePersonId(), password, access);
    }
    
    public static String generatePersonId() {
        return "PAT" + Integer.toString(PatientDirectory.getPatientList().size());
    }

    public void addToDirectory() {
        PatientDirectory.addNewPatient(this);
        for (Community com : CommunityDirectory.getCommunityList()) {
            if (com.getZipCode().equals(this.getContactInfo().listOfAddress.get(0).zip)) {
                com.addPatient(this.getPersonId());
            }
        }
    }
}
