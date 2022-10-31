package neu.view.panel;

import java.awt.Image;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import neu.data.constants.AccessLevels;
import neu.data.directory.*;
import neu.data.model.Doctor;
import neu.data.model.Hospital;
import neu.data.validation.Validation;
import neu.util.customTypes.Address;
import neu.util.customTypes.ContactInfo;
import neu.util.customTypes.Email;
import neu.util.customTypes.Phone;

public class AddHospitalPanel extends javax.swing.JPanel {

    public AddHospitalPanel() {
        initComponents();
    }

    private String mode;
    private String id;
    private String access;
    public boolean isValidInput;
    
    public AddHospitalPanel(String id, String mode, String access) {
        initComponents();
        this.mode = mode;
        this.id = id;
        this.access = access;
        switch(this.mode) {
            case "view":
                setViewMode();
            case "edit":
                setEditMode();
            case "add":
                setAddMode();
        }
        populateComboBox();
        if (access.equals(AccessLevels.getHospitalAdminAccess())) {
            adminField.setEditable(false);
        }
    }
    
    public void populateComboBox() {
        stateComboBox.setModel(new DefaultComboBoxModel<String>(StateDirectory.stateList.toArray(new String[0])));
        cityComboBox.setModel(new DefaultComboBoxModel<String>(CityDirectory.cityList.toArray(new String[0])));
    }
    
    public void setViewMode() {
        hideInvalidLabels();
        disableEdit();
    }
    
    public void setEditMode() {
        hideInvalidLabels();
        enableEdit();
        showData();
    }
    
    public void setAddMode() {
        hideInvalidLabels();
    }
    
    public void hideInvalidLabels() {
        invalidNameLabel.setVisible(false);
        invalidPhoneLabel.setVisible(false);
        invalidEmailLabel.setVisible(false);
        invalidAddressLabel.setVisible(false);
        invalidZipLabel.setVisible(false);
        invalidAdminLabel.setVisible(false);
    }
    
    public void disableEdit() {
        saveButton.setEnabled(false);
    }
    
    public void emptyTextFields() {
        adminField.setText("");
        nameField.setText("");
                
        phoneField.setText("");
        emailField.setText("");
        zipField.setText("");
        
        addressField.setText("");
    }
    
    public void enableEdit() {
        nameField.setEditable(true);
        adminField.setEditable(true);
        
        addressField.setEditable(true);
        zipField.setEditable(true);
        
        phoneField.setEditable(true);
        emailField.setEditable(true);        
    }
    
    public void showData() {
        Hospital hos = HospitalDirectory.getHospitalById(id);
        nameField.setText(hos.getName());
        adminField.setText(hos.getAdminId());
                
        List<Email> emails = hos.getContactInfo().listOfEmails;
        List<Phone> phones = hos.getContactInfo().listOfPhoneNumbers;
        List<Address> addresses = hos.getContactInfo().listOfAddress;
        if (!phones.isEmpty()) {
           phoneField.setText(phones.get(0).number);
        }
        if (!emails.isEmpty()) {
           emailField.setText(emails.get(0).email);
        }
        if (!addresses.isEmpty()) {
           zipField.setText(addresses.get(0).zip);
           addressField.setText(addresses.get(0).address);
           cityComboBox.setSelectedItem(addresses.get(0).city);
           stateComboBox.setSelectedItem(addresses.get(0).state);
        }
    }
    
    public void reset() {
        emptyTextFields();
    }
    public boolean isInteger(String s) {
        boolean result = false;
        for (int i=0; i<s.length(); i++) {
            char t = s.charAt(i);
            String temp = t+"";
            if (isInteger(temp, 10)){
                // Do Nothing
            }
            else {
                result = true;
                break;
            }
        }
        return result;
    }
    
    public static boolean isInteger(String s, int radix) {
        if(s.isEmpty()) return false;
            for(int i = 0; i < s.length(); i++) {
                if(i == 0 && s.charAt(i) == '-') {
                    if(s.length() == 1) return false;
                    else continue;
                }
                if(Character.digit(s.charAt(i),radix) < 0) return false;
            }
        return true;
    }
    
    public void validateInputs(String fName, String phone, String email, String address, String zip, String admin) {
        hideInvalidLabels();
        isValidInput = true;
        if (!Validation.isValidString(fName)) {
            isValidInput = false;
            invalidNameLabel.setVisible(true);
        }
        if (!Validation.isValidString(admin)) {
            isValidInput = false;
            invalidAdminLabel.setVisible(true);
        }
        if (!Validation.isValidString(address)) {
            isValidInput = false;
            invalidAddressLabel.setVisible(true);
        }
        if (!Validation.isValidString(zip)) {
            isValidInput = false;
            invalidZipLabel.setVisible(true);
        }
        if (phone.length() < 10 || isInteger(phone) || phone.length() > 10) {
            isValidInput = false;
            invalidPhoneLabel.setVisible(true);
        }
        if (!email.contains("@") || !email.contains(".com")) {
            isValidInput = false;
            invalidEmailLabel.setVisible(true);
        }
    }
    
    public  void setDoctorAttributes(Hospital hos) {
        hos.setAdminId(adminField.getText());
        hos.setName(nameField.getText());
        
        Email email = new Email("Business", emailField.getText());
        hos.getContactInfo().listOfEmails.add(email);
        
        Phone phone = new Phone("Business", phoneField.getText(), "+1");
        hos.getContactInfo().listOfPhoneNumbers.add(phone);
        
        Address a1 = new Address();
        a1.address = addressField.getText();
        a1.city = "Boston";
        a1.country = "USA";
        a1.zip = zipField.getText();
        hos.getContactInfo().listOfAddress.add(a1);
        
        JOptionPane.showConfirmDialog(null, "Hospital Saved!", "Confirmation", JOptionPane.DEFAULT_OPTION);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addressLabel = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        accessLabel1 = new javax.swing.JLabel();
        passwordLabel1 = new javax.swing.JLabel();
        medicalIdLabel1 = new javax.swing.JLabel();
        zipField = new javax.swing.JTextField();
        cityComboBox = new javax.swing.JComboBox<>();
        stateComboBox = new javax.swing.JComboBox<>();
        invalidZipLabel = new javax.swing.JLabel();
        invalidNameLabel = new javax.swing.JLabel();
        addressField = new javax.swing.JTextField();
        phoneField = new javax.swing.JTextField();
        nameLabel = new javax.swing.JLabel();
        addressLabel1 = new javax.swing.JLabel();
        addressLabel2 = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        invalidPhoneLabel = new javax.swing.JLabel();
        invalidEmailLabel = new javax.swing.JLabel();
        invalidAddressLabel = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        nameLabel1 = new javax.swing.JLabel();
        adminField = new javax.swing.JTextField();
        invalidAdminLabel = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addressLabel.setText("Address");
        add(addressLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, 89, 27));

        nameField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        nameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameFieldActionPerformed(evt);
            }
        });
        add(nameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 70, 215, 25));

        accessLabel1.setText("State");
        add(accessLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 260, -1, -1));

        passwordLabel1.setText("City");
        add(passwordLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 230, -1, -1));

        medicalIdLabel1.setText("Zip");
        add(medicalIdLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 290, 30, 30));

        zipField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        add(zipField, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 300, 90, 25));

        cityComboBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        add(cityComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 230, 210, 20));

        stateComboBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        add(stateComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 260, 210, 20));

        invalidZipLabel.setForeground(new java.awt.Color(255, 102, 102));
        invalidZipLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        invalidZipLabel.setText("Invalid Zip");
        add(invalidZipLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 300, -1, -1));

        invalidNameLabel.setForeground(new java.awt.Color(255, 102, 102));
        invalidNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        invalidNameLabel.setText("Invalid Name");
        invalidNameLabel.setToolTipText("");
        add(invalidNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 70, 95, -1));

        addressField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        add(addressField, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 110, 215, 25));

        phoneField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        add(phoneField, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 190, 215, 25));

        nameLabel.setText("Name");
        add(nameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, 89, 27));

        addressLabel1.setText("Phone");
        add(addressLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, 89, 27));

        addressLabel2.setText("Email");
        add(addressLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, 89, 27));

        emailField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        add(emailField, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 150, 215, 25));

        invalidPhoneLabel.setForeground(new java.awt.Color(255, 102, 102));
        invalidPhoneLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        invalidPhoneLabel.setText("Invalid Phone");
        add(invalidPhoneLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 190, 84, -1));

        invalidEmailLabel.setForeground(new java.awt.Color(255, 102, 102));
        invalidEmailLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        invalidEmailLabel.setText("Invalid Email");
        add(invalidEmailLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 150, 80, -1));

        invalidAddressLabel.setForeground(new java.awt.Color(255, 102, 102));
        invalidAddressLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        invalidAddressLabel.setText("Invalid Address");
        add(invalidAddressLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 110, 110, -1));

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 400, 61, 31));

        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });
        add(saveButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 400, 61, 31));

        nameLabel1.setText("Admin");
        add(nameLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 40, 89, -1));

        adminField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        adminField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminFieldActionPerformed(evt);
            }
        });
        add(adminField, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 30, 215, 25));

        invalidAdminLabel.setForeground(new java.awt.Color(255, 102, 102));
        invalidAdminLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        invalidAdminLabel.setText("Invalid Name");
        invalidAdminLabel.setToolTipText("");
        add(invalidAdminLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 40, 95, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void nameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameFieldActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        if (access.equals(AccessLevels.getSystemAdminAccess())) {
            SystemAdminPanel.goBack("Hospitals");    
        } else if (access.equals(AccessLevels.getHospitalAdminAccess())) {
            HospitalAdminPanel.goBack("Hospitals");    
        }
    }//GEN-LAST:event_backButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        validateInputs(nameField.getText(), phoneField.getText(), emailField.getText(), addressField.getText(), zipField.getText(), adminField.getText());
        if (mode.equals("add") && isValidInput) {
            Hospital hos = new Hospital(adminField.getText());
            setDoctorAttributes(hos);
            hos.addToDirectory();
            reset();
        } else if (mode.equals("edit") && isValidInput) {
            Hospital hos = HospitalDirectory.getHospitalById(id);
            setDoctorAttributes(hos);
            backButtonActionPerformed(evt);
        } else {
            System.out.println("Wrong input");
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void adminFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_adminFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel accessLabel1;
    private javax.swing.JTextField addressField;
    private javax.swing.JLabel addressLabel;
    private javax.swing.JLabel addressLabel1;
    private javax.swing.JLabel addressLabel2;
    private javax.swing.JTextField adminField;
    private javax.swing.JButton backButton;
    private javax.swing.JComboBox<String> cityComboBox;
    private javax.swing.JTextField emailField;
    private javax.swing.JLabel invalidAddressLabel;
    private javax.swing.JLabel invalidAdminLabel;
    private javax.swing.JLabel invalidEmailLabel;
    private javax.swing.JLabel invalidNameLabel;
    private javax.swing.JLabel invalidPhoneLabel;
    private javax.swing.JLabel invalidZipLabel;
    private javax.swing.JLabel medicalIdLabel1;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel nameLabel1;
    private javax.swing.JLabel passwordLabel1;
    private javax.swing.JTextField phoneField;
    private javax.swing.JButton saveButton;
    private javax.swing.JComboBox<String> stateComboBox;
    private javax.swing.JTextField zipField;
    // End of variables declaration//GEN-END:variables
}
