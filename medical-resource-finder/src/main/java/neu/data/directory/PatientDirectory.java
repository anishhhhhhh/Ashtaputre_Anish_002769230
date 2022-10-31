package neu.data.directory;

import neu.data.model.*;

import java.util.ArrayList;
import java.util.List;

public class PatientDirectory {
    private static final List<Patient> patientList = new ArrayList<>();

    public static List<Patient> getPatientList() {
        return patientList;
    }
    
    public static Patient getPatientByPersonId(String id) {
        Patient result = null;
        for (int i=0; i<patientList.size(); i++) {
            Patient p = patientList.get(i);
            if (id.equals(p.getPersonId())) result = p;
        }
        return result;
    }
    
    public static List<Patient> getPatientByCommunity(String zip) {
        List<Patient> result = new ArrayList<>();
        for (int i=0; i<patientList.size(); i++) {
            Patient p = patientList.get(i);
            if (zip.equals(p.getContactInfo().listOfAddress.get(0).zip)
            || zip.equals(p.getContactInfo().listOfAddress.get(1).zip)) {
                result.add(p);
            }
        }
        return result;
    }
    
    public static void addNewPatient(Patient p) {
        patientList.add(p);
    }
    
    public static boolean deletePatient(String id) {
        boolean isDeleted = false;
        for (int i=0; i<patientList.size(); i++) {
            if (id.equals(patientList.get(i).getPersonId())) {
                patientList.remove(i);
                isDeleted = true;
                break;
            }
        }
        return isDeleted;
    }
}
