package neu.data.directory;

import neu.data.model.*;

import java.util.List;
import java.util.ArrayList;

public abstract class HospitalDirectory {
    private static final List<Hospital> listOfHospitals = new ArrayList<>();
    
    public static List<Hospital> getListOfHospitals() {
        return listOfHospitals;
    }
    
    public static void addNewHospital(Hospital h) {
        listOfHospitals.add(h);
    }
    
    public static Hospital getHospitalById(String hospitalId) {
        Hospital result = null;
        for (Hospital hos : listOfHospitals) {
            if (hos.getHospitalId().equals(hospitalId)) {
                result = hos;
            }
        }
        return result;
    }
    
    public static Hospital getHospitalByAdminId(String personId) {
        Hospital result = null;
        for (Hospital hos : listOfHospitals) {
            if (hos.getAdminId().equals(personId)) {
                result = hos;
            }
        }
        return result;
    }
    
    public static boolean deleteHospital(String id) {
        boolean isDeleted = false;
        for (int i=0; i<listOfHospitals.size(); i++) {
            if (id.equals(listOfHospitals.get(i).getHospitalId())) {
                listOfHospitals.remove(i);
                isDeleted = true;
                break;
            }
        }
        return isDeleted;
    }
}
