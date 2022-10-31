package neu.data.model;

import neu.data.directory.AdminDirectory;

public class CommunityAdmin extends Person {
    private final static String RESOURCE_IDENTIFIER = "community_admin";
    
    public static String getRESOURCE_IDENTIFIER() {
        return RESOURCE_IDENTIFIER;
    }
    
    public CommunityAdmin(String password, String access) {
        super(generatePersonId(), password, access);
    }
    
    public static String generatePersonId() {
        return "COM" + Integer.toString(AdminDirectory.getAdminList().size());
    }
    
    public void addToDirectory() {
        AdminDirectory.addNewAdmin(this);
    }
}
