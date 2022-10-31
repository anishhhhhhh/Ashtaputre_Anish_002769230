package neu.data.model;

import neu.data.directory.AdminDirectory;

public class HospitalAdmin extends Person {
    private final static String RESOURCE_IDENTIFIER = "hospital_admin";
    
    public static String getRESOURCE_IDENTIFIER() {
        return RESOURCE_IDENTIFIER;
    }
    
    public HospitalAdmin(String password, String access) {
        super(generatePersonId(), password, access);
    }
    
    public static String generatePersonId() {
        return "HOS" + Integer.toString(AdminDirectory.getAdminList().size());
    }
    
    public void addToDirectory() {
        AdminDirectory.addNewAdmin(this);
    }
}
