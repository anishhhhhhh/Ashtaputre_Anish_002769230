package neu.data.model;

import neu.data.directory.AdminDirectory;

public class SystemAdmin extends Person {
    private final static String RESOURCE_IDENTIFIER = "system_admin";
    
    public static String getRESOURCE_IDENTIFIER() {
        return RESOURCE_IDENTIFIER;
    }
    
    public SystemAdmin(String password, String access) {
        super(generatePersonId(), password, access);
    }
    
    public static String generatePersonId() {
        return "SYS" + Integer.toString(AdminDirectory.getAdminList().size());
    }
    
    public void addToDirectory() {
        AdminDirectory.addNewAdmin(this);
    }
}
