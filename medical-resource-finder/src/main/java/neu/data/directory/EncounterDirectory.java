/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package neu.data.directory;

import neu.data.model.*;

import java.util.ArrayList;
import java.util.List;

public class EncounterDirectory {
    private static final List<Encounter> encounterList = new ArrayList<>();
    
    public static List<Encounter> getEncounterList() {
        return encounterList;
    }
    
    public static List<Encounter> filterEncountersByPatient(String id) {
        List<Encounter> patientEncounterList = new ArrayList<>();
        for (Encounter enc : encounterList) {
            if (enc.getPatientId().equals(id)) {
                patientEncounterList.add(enc);
            }
        }
        return patientEncounterList;
    }
    
    public static Encounter getEncounterById(String encounterId) {
        Encounter result = null;
        for (Encounter enc : encounterList) {
            if (enc.getEncounterId().equals(encounterId)) {
                result = enc;
            }
        }
        return result;
    }
    
    public static List<Encounter> getEncounterListByHospital(String hospitalId) {
        List<Encounter> result = new ArrayList<>();
        for (Encounter enc : encounterList) {
            if (DoctorDirectory.getDoctorByPersonId(enc.getDoctorId()).getHospitalId().equals(hospitalId)) {
                result.add(enc);
            }
        }
        return result;
    }
    
    public static boolean deleteEncounter(String id) {
        boolean isDeleted = false;
        for (int i=0; i<encounterList.size(); i++) {
            if (id.equals(encounterList.get(i).getEncounterId())) {
                encounterList.remove(i);
                isDeleted = true;
                break;
            }
        }
        return isDeleted;
    }
    
    public static void addNewEncounter(Encounter e) {
        encounterList.add(e);
    }
}
