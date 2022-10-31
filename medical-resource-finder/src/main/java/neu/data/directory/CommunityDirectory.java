package neu.data.directory;

import neu.data.model.*;

import java.util.ArrayList;
import java.util.List;

public class CommunityDirectory {
    private static final List<Community> communityList = new ArrayList<>();
    
    public static List<Community> getCommunityList() {
        return communityList;
    }

    public static Community getCommunityByZip(String zip) {
        Community result = null;
        for (Community com : communityList) {
            if (com.getZipCode().equals(zip)) result = com;
        }
        return result;
    }

    public static void addNewCommunity(Community c) {
        communityList.add(c);
    }
    
    public static boolean deleteCommunity(String zip) {
        boolean isDeleted = false;
        for (int i=0; i<communityList.size(); i++) {
            if (zip.equals(communityList.get(i).getZipCode())) {
                communityList.remove(i);
                isDeleted = true;
                break;
            }
        }
        return isDeleted;
    }
    
    public static List<Community> getCommunityListByCommunityAdmin(String personId) {
        List<Community> result = new ArrayList<>();
        for (Community com : communityList) {
            if (com.getAdminId().equals(personId)) result.add(com);
        }
        return result;
    }
    
}
