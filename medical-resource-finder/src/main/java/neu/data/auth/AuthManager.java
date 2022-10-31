package neu.data.auth;

import neu.data.directory.*;
import neu.data.model.*;
import neu.data.constants.*;

public class AuthManager {
    public static Person checkIfPersonExists(String id, String access) {
        Person result = null;
        if (access.isEmpty()) {
            System.out.println("Wrong Input");
        } else if (access.equals(AccessLevels.getDoctorAccess())) {
            result = DoctorDirectory.getDoctorByPersonId(id);
        } else if (access.equals(AccessLevels.getPatientAccess())) {
            result = PatientDirectory.getPatientByPersonId(id);
        } else if (access.equals(AccessLevels.getHospitalAdminAccess())
                || access.equals(AccessLevels.getCommunityAdminAccess())
                || access.equals(AccessLevels.getSystemAdminAccess())) {
            result = AdminDirectory.getAdminByPersonId(id);
        }
        return result;
    }
    
    public static Boolean validatePersonCredentials(String id, String password, String access, Person p) {
        Boolean isValid = false;
        if (id.equals(p.getPersonId()) && password.equals(p.getPassword()) && access.equals(p.getAccess())) isValid = true;
        return isValid;
    }
}
