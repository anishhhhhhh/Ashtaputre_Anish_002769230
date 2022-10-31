package neu.data.directory;

import neu.data.model.*;

import java.util.ArrayList;
import java.util.List;

public class DoctorDirectory {
    private static final List<Doctor> doctorList = new ArrayList<>();
    
    public static List<Doctor> getDoctorList() {
        return doctorList;
    }

    public static Doctor getDoctorByPersonId(String id) {
        Doctor result = null;
        for (Doctor doc : doctorList) {
            if (doc.getPersonId().equals(id)) result = doc;
        }
        return result;
    }
    
    public static Doctor getDoctorByDoctorId(String id) {
        Doctor result = null;
        for (Doctor doc : doctorList) {
            if (doc.getDoctorId().equals(id)) result = doc;
        }
        return result;
    }

    public static void addNewDoctor(Doctor d) {
        doctorList.add(d);
    }
    
    public static List<Doctor> searchDoctors(String searchText) {
        List<Doctor> searchResult = new ArrayList<>();
        for (Doctor doc : doctorList) {
            int score = 0;
            if (searchText.equals(doc.getDoctorId())) {
                    score+= 10;
            }
            if (doc.getFirstName().toLowerCase().contains(searchText)) {
                    score+= 5;
            }
            if (doc.getLastName().toLowerCase().contains(searchText)) {
                    score+= 5;
            }
            if (doc.getSpecialization().toLowerCase().contains(searchText)) {
                    score+= 2;
            }
            if (score > 0) {
                doc.setSearchScore(score);
                searchResult.add(doc);
            }
        }
        return searchResult;
    }
    public static boolean deleteDoctor(String doctorId) {
        boolean isDeleted = false;
        for (int i=0; i<doctorList.size(); i++) {
            if (doctorId.equals(doctorList.get(i).getPersonId())) {
                doctorList.remove(i);
                isDeleted = true;
                break;
            }
        }
        return isDeleted;
    }
    
}
