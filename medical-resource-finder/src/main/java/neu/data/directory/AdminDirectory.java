package neu.data.directory;

import java.util.ArrayList;
import java.util.List;
import neu.data.model.Person;

public class AdminDirectory {
    private static final List<Person> adminList = new ArrayList<>();
    
    public static List<Person> getAdminList() {
        return adminList;
    }

    public static Person getAdminByPersonId(String id) {
        Person result = null;
        for (int i=0; i<adminList.size(); i++) {
            Person p = adminList.get(i);
            if (id.equals(p.getPersonId())) result = p;
        }
        return result;
    }

    public static void addNewAdmin(Person p) {
        adminList.add(p);
    }
}
