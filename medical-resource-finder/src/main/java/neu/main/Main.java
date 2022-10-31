package neu.main;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import java.util.ArrayList;
import java.util.List;
import neu.view.manager.*;
import neu.data.directory.*;
import neu.data.model.*;
import neu.data.auth.*;
import neu.data.constants.*;
import neu.util.customTypes.*;

import neu.view.panel.*;
import neu.view.frame.*;

public class Main {

    public static void main(String[] args) {
        String imagePath1 = "/Users/skudli/Downloads/UI IMAGES/1.jpeg";
        String imagePath2 = "/Users/skudli/Downloads/UI IMAGES/2.jpeg";
        
        Email em1 = new Email("Business", "bostonmedical@yahoo.com");
        Email em2 = new Email("Business", "neuhealthcare@yahoo.com");
        
        Phone ph1 = new Phone("Business", "8577990481", "+1");
        
        Address a1 = new Address();
        a1.address = "75 St Alphonsus St";
        a1.city = "Boston";
        a1.country = "USA";
        a1.zip = "02120";
        
        Address a2 = new Address();
        a2.address = "360 Huntington Ave";
        a2.city = "Boston";
        a2.country = "USA";
        a2.zip = "02115";
        
        StateDirectory.stateList.add("Massachusetts");  
        
        CityDirectory.cityList.add("Boston");
        CityDirectory.cityList.add("Salem");
        
        String docAccess = AccessLevels.getDoctorAccess();
        String patAccess = AccessLevels.getPatientAccess();
        String sysAdmAccess = AccessLevels.getSystemAdminAccess();
        String comAdmAccess = AccessLevels.getCommunityAdminAccess();
        String hosAdmAccess = AccessLevels.getHospitalAdminAccess();
        String password = "test";
        
        Community c1 = new Community("02120", "Longwood Medical community", "COM1");
        c1.addToDirectory();
        
        Community c2 = new Community("02121", "Tremont Community", "COM1");
        c2.addToDirectory();
        
        Community c3 = new Community("02115", "Northeastern University", "COM2");
        c3.addToDirectory();
        
        Doctor d1 = new Doctor(password, docAccess);
        d1.setDoctorId("0");
        d1.setSpecialization("Pschylogy");
        d1.setFirstName("Sudarshan");
        d1.setLastName("Kudli");
        d1.setGender("Male");
        d1.getContactInfo().listOfEmails.add(em1);
        d1.getContactInfo().listOfPhoneNumbers.add(ph1);
        d1.getContactInfo().listOfAddress.add(a1);
        d1.setHospitalId("0");
        d1.addToDirectory();
        
        Doctor d2 = new Doctor(password, docAccess);
        d2.setDoctorId("1");
        d2.setSpecialization("Physicist");
        d2.setFirstName("Suraksha");
        d2.setLastName("Nadig");
        d2.setGender("Female");
        d2.getContactInfo().listOfEmails.add(em2);
        d2.getContactInfo().listOfPhoneNumbers.add(ph1);
        d2.getContactInfo().listOfAddress.add(a2);
        d2.setHospitalId("1");
        d2.addToDirectory();
        
        SystemAdmin s1 = new SystemAdmin(password, sysAdmAccess);
        s1.setFirstName("Sumanth");
        s1.setLastName("NS");
        s1.addToDirectory();
        
        CommunityAdmin ca1 = new CommunityAdmin(password, comAdmAccess);
        ca1.setFirstName("Arun");
        ca1.setLastName("Ashok");
        ca1.setGender("Male");
        ca1.getContactInfo().listOfAddress.add(a1);
        ca1.addToDirectory();
        
        CommunityAdmin ca2 = new CommunityAdmin(password, comAdmAccess);
        ca2.setFirstName("Sameer");
        ca2.setLastName("Kumar");
        ca2.setGender("Male");
        ca2.getContactInfo().listOfAddress.add(a2);
        ca2.addToDirectory();
        
        HospitalAdmin ha1 = new HospitalAdmin(password, hosAdmAccess);
        ha1.setFirstName("Sanjeeva");
        ha1.setLastName("Rao");
        ha1.setGender("Male");
        ha1.addToDirectory();
        
        HospitalAdmin ha2 = new HospitalAdmin(password, hosAdmAccess);
        ha2.setFirstName("Akshay");
        ha2.setLastName("VM");
        ha2.setGender("Male");
        ha2.addToDirectory();
        
        Patient p1 = new Patient(password, patAccess);
        p1.setFirstName("Sumanth");
        p1.setLastName("NS");
        p1.getDateOfBirth().setDay(19);
        p1.getDateOfBirth().setMonth(12);
        p1.getDateOfBirth().setYear(1997);
        p1.setGender("Male");
        p1.getContactInfo().listOfAddress.add(a1);
        p1.getContactInfo().listOfEmails.add(em1);
        p1.getContactInfo().listOfPhoneNumbers.add(ph1);
        p1.setPhotoPath(imagePath1);
        p1.addToDirectory();
        
        Role personEditRole = new Role("perso_edit_role", "person", p1.getPersonId());
        p1.setRole(personEditRole);
        
        Patient p2 = new Patient(password, patAccess);
        p2.setFirstName("Rachana");
        p2.setLastName("M");
        p2.getDateOfBirth().setDay(19);
        p2.getDateOfBirth().setMonth(12);
        p2.getDateOfBirth().setYear(1997);
        p2.setGender("Female");
        p2.getContactInfo().listOfAddress.add(a2);
        p2.getContactInfo().listOfEmails.add(em1);
        p2.getContactInfo().listOfPhoneNumbers.add(ph1);
        p2.setPhotoPath(imagePath2);
        p2.addToDirectory();
        
        
        VitalSigns vs = new VitalSigns("", "", 100, 100, 20, 30);
        Encounter e1 = new Encounter(p1.getPersonId(), 10, 10, 1992, d1.getPersonId(), vs);
        EncounterDirectory.addNewEncounter(e1);
        
        Hospital h1 = new Hospital("HOS3");
        h1.getContactInfo().listOfAddress.add(a1);
        h1.getContactInfo().listOfEmails.add(em1);
        h1.getContactInfo().listOfPhoneNumbers.add(ph1);
        h1.setName("Boston Medical Center");
        h1.addToDirectory();
        
        Hospital h2 = new Hospital("HOS4");
        h2.getContactInfo().listOfAddress.add(a1);
        h2.getContactInfo().listOfEmails.add(em1);
        h2.getContactInfo().listOfPhoneNumbers.add(ph1);
        h2.setName("Harvard Medical");
        h2.addToDirectory();
        
        UIManager manager = new UIManager();
    }
}
