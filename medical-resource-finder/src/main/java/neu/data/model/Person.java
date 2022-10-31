package neu.data.model;


import neu.data.directory.*;
import neu.util.customTypes.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import neu.data.auth.Role;

public class Person {
    private final String personId;
    private String password;
    private String access;
    private Role role;
    
    private String firstName;
    private String lastName;
    private String gender;
 
    private String photoPath = "";
    
    private Date dateOfBirth;
    private ContactInfo contactInfo;
  
    public Person(String id, String password, String access) {
       this.personId = id;
       this.password = password;
       this.access = access;
       this.contactInfo = new ContactInfo();
       this.dateOfBirth = new Date();
    }

    public String getPersonId() {
        return personId;
    }
    
    public String getPassword() {
        return password;
    }
    
    public String getAccess() {
        return access;
    }
    
    public Role getRole() {
        return role;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    
    public String getFullName() {
        String empty = " ";
        return firstName + empty + lastName;
    }

    public String getGender() {
        return gender;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public ContactInfo getContactInfo() {
        return contactInfo;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public void setAccess(String access) {
        this.access = access;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public void setContactInfo(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(Role role) {
        this.role = role;
    }
    
    private boolean verifyRole(Person p, String operation) {
        boolean roleGranted = false;
        // verify if person has required role
        return roleGranted; 
    }
}
