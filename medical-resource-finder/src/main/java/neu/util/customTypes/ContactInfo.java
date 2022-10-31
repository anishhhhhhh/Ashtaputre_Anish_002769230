package neu.util.customTypes;

import java.util.ArrayList;
import java.util.List;

public class ContactInfo {
    public List<Phone> listOfPhoneNumbers;
    public List<Address> listOfAddress;
    public List<Email> listOfEmails;
    
    public ContactInfo() {
        this.listOfPhoneNumbers = new ArrayList<>();
        this.listOfAddress = new ArrayList<>();
        this.listOfEmails = new ArrayList<>();
    }
}