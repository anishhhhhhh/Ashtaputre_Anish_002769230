package neu.view.panel;

import java.awt.Image;
import java.io.File;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import neu.data.constants.AccessLevels;
import neu.data.directory.CityDirectory;
import neu.data.directory.CommunityDirectory;
import neu.data.directory.PatientDirectory;
import neu.data.directory.StateDirectory;
import neu.data.model.Community;
import neu.data.model.Doctor;
import neu.data.model.Patient;
import neu.data.model.Person;
import neu.data.validation.Validation;
import neu.util.customTypes.Address;
import neu.util.customTypes.Email;
import neu.util.customTypes.Phone;

public class AddPatientPanel extends javax.swing.JPanel {
    
    private String mode;
    private String id;
    private String access;
    public boolean isValidInput;

    public AddPatientPanel(String id, String mode, String access) {
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
    }
    
    public void populateComboBox() {
        stateComboBox.setModel(new DefaultComboBoxModel<String>(StateDirectory.stateList.toArray(new String[0])));
        cityComboBox.setModel(new DefaultComboBoxModel<String>(CityDirectory.cityList.toArray(new String[0])));
    }
    
    public void setViewMode() {
        showData(id);
        hideInvalidLabels();
        disableEdit();
        hideAccessAndPassword();
    }
    
    public void setEditMode() {
        hideInvalidLabels();
        enableEdit();
        showData(id);
        hideAccessAndPassword();
    }
    
    public void setAddMode() {
        hideInvalidLabels();
    }
    
    public void hideAccessAndPassword() {
        accessField.setVisible(false);
        accessLabel.setVisible(false);
        passwordField.setVisible(false);
        passwordLabel.setVisible(false);
        invalidPasswordLabel.setVisible(false);
    }
    
    public void hideInvalidLabels() {
        invalidNameLabel.setVisible(false);
        invalidJoiningField.setVisible(false);
        invalidPhoneLabel.setVisible(false);
        photoPathField.setVisible(false);
        invalidEmailLabel.setVisible(false);
        invalidPasswordLabel.setVisible(false);
        invalidZipLabel.setVisible(false);
        invalidAddressLabel.setVisible(false);
    }
    
    public void disableEdit() {        
        saveButton.setEnabled(false);
        choosePhotoButton.setEnabled(false);
        photoLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    }
    
    public void emptyTextFields() {
        firstNameField.setText("");
        lastNameField.setText("");
        
        dayField.setText("DD");
        monthField.setText("MM");
        yearField.setText("YY");
        
        accessField.setText("");
        passwordField.setText("");
        
        phoneField.setText("");
        emailField.setText("");
        zipField.setText("");
        addressField.setText("");
        
        photoLabel.setText("No Photo Selected");
        photoLabel.setIcon(null);
    }
    
    public void enableEdit() {
        firstNameField.setEditable(true);
        lastNameField.setEditable(true);
        
        dayField.setEditable(true);
        monthField.setEditable(true);
        yearField.setEditable(true);
        zipField.setEditable(true);
        
        phoneField.setEditable(true);
        emailField.setEditable(true);        
    }
    
    public void showData(String id) {
        Patient pat = PatientDirectory.getPatientByPersonId(id);
        firstNameField.setText(pat.getFirstName());
        lastNameField.setText(pat.getLastName());
                
        genderField.setSelectedItem(pat.getGender());
        List<Email> emails = pat.getContactInfo().listOfEmails;
        List<Phone> phones = pat.getContactInfo().listOfPhoneNumbers;
        List<Address> addresses = pat.getContactInfo().listOfAddress;
        if (!phones.isEmpty()) {
           phoneField.setText(phones.get(0).number);
        }
        if (!emails.isEmpty()) {
            emailField.setText(emails.get(0).email);
        }
        if (!addresses.isEmpty()) {
            zipField.setText(addresses.get(0).zip);
        }
        if (!addresses.isEmpty()) {
            zipField.setText(addresses.get(0).zip);
            addressField.setText(addresses.get(0).address);
            cityComboBox.setSelectedItem(addresses.get(0).city);
            stateComboBox.setSelectedItem(addresses.get(0).state);
        }
        
        dayField.setText(Integer.toString(pat.getDateOfBirth().getDay()));
        monthField.setText(Integer.toString(pat.getDateOfBirth().getMonth()));
        yearField.setText(Integer.toString(pat.getDateOfBirth().getYear()));
        
        genderField.setSelectedItem(pat.getGender());
        
        ImageIcon icon = new ImageIcon(new ImageIcon(pat.getPhotoPath()).getImage().getScaledInstance(140, 191, Image.SCALE_DEFAULT));
        photoLabel.setIcon(icon); 
        
    }
    
    public void reset() {
        emptyTextFields();
        hideInvalidLabels();
    }
    
    public void validateInputs(String fName, String lName, String day, String month, String year, String phone, String password, String email, String address) {
        hideInvalidLabels();
        isValidInput = true;
        if (!Validation.isValidString(fName) || !Validation.isValidString(lName)) {
            isValidInput = false;
            invalidNameLabel.setVisible(true);
        }
        if (!Validation.isValidInteger(day, 10) || !Validation.isValidInteger(month, 10) || !Validation.isValidInteger(year, 10) || Integer.parseInt(day) < 1 || Integer.parseInt(day) > 31 || Integer.parseInt(month) < 1 || Integer.parseInt(month) > 12 || Integer.parseInt(year) > 2023 || Integer.parseInt(year) < 1500) {
            isValidInput = false;
            invalidJoiningField.setVisible(true);
        }
        if (phone.length() < 10 || isInteger(phone) || phone.length() > 10) {
            isValidInput = false;
            invalidPhoneLabel.setVisible(true);
        }
        if (password.isBlank() && mode.equals("add")) {
            isValidInput = false;
            invalidPasswordLabel.setVisible(true);
        }
        if (!email.contains("@") || !email.contains(".com")) {
            isValidInput = false;
            invalidEmailLabel.setVisible(true);
        }
        if (!Validation.isValidString(address)) {
            isValidInput = false;
            invalidAddressLabel.setVisible(true);
        }
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
    
    public  void setPatientAttributes(Patient pat) {
        pat.setFirstName(firstNameField.getText());
        pat.setLastName(lastNameField.getText());
        pat.getDateOfBirth().setDay(Integer.parseInt(dayField.getText()));
        pat.getDateOfBirth().setMonth(Integer.parseInt(monthField.getText()));
        pat.getDateOfBirth().setYear(Integer.parseInt(yearField.getText()));
        pat.setGender(genderField.getSelectedItem().toString());
        pat.setPhotoPath(photoPathField.getText());
        pat.setPassword(passwordField.getText());
        pat.setAccess(accessField.getText());
        
        Email em = new Email("Home", emailField.getText());
        Phone ph = new Phone("Home", phoneField.getText(), "+1");
        Address a = new Address();
        a.address = addressField.getText();
        a.city = cityComboBox.getSelectedItem().toString();
        a.state = stateComboBox.getSelectedItem().toString();
        a.zip = zipField.getText();
        pat.getContactInfo().listOfEmails.add(em);
        pat.getContactInfo().listOfPhoneNumbers.add(ph);
        pat.getContactInfo().listOfAddress.add(a);
        
        JOptionPane.showConfirmDialog(null, "Employee Saved!", "Confirmation", JOptionPane.DEFAULT_OPTION);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        firstNameLabel = new javax.swing.JLabel();
        lastNameLabel = new javax.swing.JLabel();
        dateOfBirthLabel = new javax.swing.JLabel();
        genderLabel = new javax.swing.JLabel();
        firstNameField = new javax.swing.JTextField();
        lastNameField = new javax.swing.JTextField();
        dayField = new javax.swing.JTextField();
        monthField = new javax.swing.JTextField();
        yearField = new javax.swing.JTextField();
        genderField = new javax.swing.JComboBox<>();
        backButton = new javax.swing.JButton();
        invalidNameLabel = new javax.swing.JLabel();
        invalidJoiningField = new javax.swing.JLabel();
        choosePhotoLabel = new javax.swing.JLabel();
        choosePhotoButton = new javax.swing.JButton();
        photoLabel = new javax.swing.JLabel();
        phoneLabel = new javax.swing.JLabel();
        phoneField = new javax.swing.JTextField();
        invalidPhoneLabel = new javax.swing.JLabel();
        photoPathField = new javax.swing.JTextField();
        emailLabel = new javax.swing.JLabel();
        passwordField = new javax.swing.JTextField();
        invalidEmailLabel = new javax.swing.JLabel();
        saveButton = new javax.swing.JButton();
        passwordLabel = new javax.swing.JLabel();
        accessLabel = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        accessField = new javax.swing.JTextField();
        invalidPasswordLabel = new javax.swing.JLabel();
        stateComboBox = new javax.swing.JComboBox<>();
        accessLabel1 = new javax.swing.JLabel();
        passwordLabel1 = new javax.swing.JLabel();
        medicalIdLabel1 = new javax.swing.JLabel();
        zipField = new javax.swing.JTextField();
        invalidZipLabel = new javax.swing.JLabel();
        cityComboBox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        addressField = new javax.swing.JTextField();
        invalidAddressLabel = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        firstNameLabel.setText("First Name");
        add(firstNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 89, 27));

        lastNameLabel.setText("Last Name");
        add(lastNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 50, 100, 27));

        dateOfBirthLabel.setText("Date of Birth");
        add(dateOfBirthLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 140, -1, 27));

        genderLabel.setText("Gender");
        add(genderLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, 100, 27));

        firstNameField.setText("Sumeet");
        firstNameField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        firstNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstNameFieldActionPerformed(evt);
            }
        });
        add(firstNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 20, 215, 25));

        lastNameField.setText("Sarkar");
        lastNameField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        add(lastNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 50, 215, 25));

        dayField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        dayField.setText("15");
        dayField.setToolTipText("DD");
        dayField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        dayField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dayFieldActionPerformed(evt);
            }
        });
        add(dayField, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 140, 35, 25));

        monthField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        monthField.setText("1");
        monthField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        monthField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthFieldActionPerformed(evt);
            }
        });
        add(monthField, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 140, 39, 25));

        yearField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        yearField.setText("1999");
        yearField.setToolTipText("YYYY");
        yearField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        yearField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearFieldActionPerformed(evt);
            }
        });
        add(yearField, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 140, 49, 25));

        genderField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female", "Other" }));
        genderField.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        add(genderField, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 90, -1, 31));

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 420, 61, 31));

        invalidNameLabel.setForeground(new java.awt.Color(255, 102, 102));
        invalidNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        invalidNameLabel.setText("Invalid Name");
        invalidNameLabel.setToolTipText("");
        add(invalidNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 50, 95, -1));

        invalidJoiningField.setForeground(new java.awt.Color(255, 102, 102));
        invalidJoiningField.setText("Invalid Date");
        add(invalidJoiningField, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 140, -1, -1));

        choosePhotoLabel.setText("Photo");
        add(choosePhotoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 270, 100, 23));

        choosePhotoButton.setText("Choose from file");
        choosePhotoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                choosePhotoButtonActionPerformed(evt);
            }
        });
        add(choosePhotoButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 270, -1, -1));

        photoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        photoLabel.setText("No photo selected");
        photoLabel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        add(photoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 140, 191));

        phoneLabel.setText("Phone");
        add(phoneLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 190, 100, 27));

        phoneField.setText("8472772626");
        phoneField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        add(phoneField, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 190, 215, 25));

        invalidPhoneLabel.setForeground(new java.awt.Color(255, 102, 102));
        invalidPhoneLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        invalidPhoneLabel.setText("Invalid Phone");
        add(invalidPhoneLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 190, 84, -1));
        add(photoPathField, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 270, 3, 7));

        emailLabel.setText("Email");
        add(emailLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 230, 100, 25));

        passwordField.setText("test");
        passwordField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        add(passwordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 340, 215, 25));

        invalidEmailLabel.setForeground(new java.awt.Color(255, 102, 102));
        invalidEmailLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        invalidEmailLabel.setText("Invalid Email");
        add(invalidEmailLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 240, 80, -1));

        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });
        add(saveButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 420, 61, 31));

        passwordLabel.setText("Password");
        add(passwordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 340, -1, -1));

        accessLabel.setText("Access");
        add(accessLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 310, -1, -1));

        emailField.setText("sumeet.somu@gmail.com");
        emailField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        add(emailField, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 230, 215, 25));

        accessField.setText("patient");
        accessField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        add(accessField, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 310, 215, 25));

        invalidPasswordLabel.setForeground(new java.awt.Color(255, 102, 102));
        invalidPasswordLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        invalidPasswordLabel.setText("Invalid Password");
        add(invalidPasswordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 340, 110, -1));

        stateComboBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        add(stateComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, 110, 20));

        accessLabel1.setText("State");
        add(accessLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, -1, -1));

        passwordLabel1.setText("City");
        add(passwordLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, -1, -1));

        medicalIdLabel1.setText("Zip");
        add(medicalIdLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 30, 30));

        zipField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        add(zipField, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, 110, 25));

        invalidZipLabel.setForeground(new java.awt.Color(255, 102, 102));
        invalidZipLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        invalidZipLabel.setText("Invalid Zip");
        add(invalidZipLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 380, -1, -1));

        cityComboBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        add(cityComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 320, 110, 20));

        jLabel1.setText("Address");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, -1, -1));

        addressField.setToolTipText("");
        add(addressField, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, 190, -1));

        invalidAddressLabel.setForeground(new java.awt.Color(255, 102, 102));
        invalidAddressLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        invalidAddressLabel.setText("Invalid Address");
        add(invalidAddressLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 270, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void firstNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_firstNameFieldActionPerformed

    private void yearFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_yearFieldActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        if (access.equals(AccessLevels.getCommunityAdminAccess())) {
            CommunityAdminPanel.goBack("Patients");
        } else if (access.equals(AccessLevels.getSystemAdminAccess())) {
            SystemAdminPanel.goBack("Patients");
        }
    }//GEN-LAST:event_backButtonActionPerformed

    private void choosePhotoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_choosePhotoButtonActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        int response = fileChooser.showOpenDialog(null);
        if (response == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            String path = file.getAbsolutePath();
            photoPathField.setText(path);
            ImageIcon icon = new ImageIcon(new ImageIcon(path).getImage().getScaledInstance(photoLabel.getWidth(), photoLabel.getHeight(), Image.SCALE_DEFAULT));
            photoLabel.setIcon(icon);
            photoLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        }
    }//GEN-LAST:event_choosePhotoButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        validateInputs(firstNameField.getText(), lastNameField.getText(), dayField.getText(), monthField.getText(), yearField.getText(), phoneField.getText(), passwordField.getText(), emailField.getText(), addressField.getText());
        if (mode.equals("add") && isValidInput) {
            Patient pat = new Patient(accessField.getText(), firstNameField.getText());
            setPatientAttributes(pat);
            PatientDirectory.addNewPatient(pat);
            Community c = CommunityDirectory.getCommunityByZip(zipField.getText());
            if (c != null) {
                c.getListOfPatients().add(pat.getPersonId());
            }
            reset();
        } else if (mode.equals("edit") && isValidInput) {
            Patient pat = PatientDirectory.getPatientByPersonId(this.id);
            setPatientAttributes(pat);           
            SystemAdminPanel.goBack("Patients");
        } else {
            System.out.println("Wrong input");
        }
    }//GEN-LAST:event_saveButtonActionPerformed

    private void monthFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_monthFieldActionPerformed

    private void dayFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dayFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dayFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField accessField;
    private javax.swing.JLabel accessLabel;
    private javax.swing.JLabel accessLabel1;
    private javax.swing.JTextField addressField;
    private javax.swing.JButton backButton;
    private javax.swing.JButton choosePhotoButton;
    private javax.swing.JLabel choosePhotoLabel;
    private javax.swing.JComboBox<String> cityComboBox;
    private javax.swing.JLabel dateOfBirthLabel;
    private javax.swing.JTextField dayField;
    private javax.swing.JTextField emailField;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JTextField firstNameField;
    private javax.swing.JLabel firstNameLabel;
    private javax.swing.JComboBox<String> genderField;
    private javax.swing.JLabel genderLabel;
    private javax.swing.JLabel invalidAddressLabel;
    private javax.swing.JLabel invalidEmailLabel;
    private javax.swing.JLabel invalidJoiningField;
    private javax.swing.JLabel invalidNameLabel;
    private javax.swing.JLabel invalidPasswordLabel;
    private javax.swing.JLabel invalidPhoneLabel;
    private javax.swing.JLabel invalidZipLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField lastNameField;
    private javax.swing.JLabel lastNameLabel;
    private javax.swing.JLabel medicalIdLabel1;
    private javax.swing.JTextField monthField;
    private javax.swing.JTextField passwordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JLabel passwordLabel1;
    private javax.swing.JTextField phoneField;
    private javax.swing.JLabel phoneLabel;
    private javax.swing.JLabel photoLabel;
    private javax.swing.JTextField photoPathField;
    private javax.swing.JButton saveButton;
    private javax.swing.JComboBox<String> stateComboBox;
    private javax.swing.JTextField yearField;
    private javax.swing.JTextField zipField;
    // End of variables declaration//GEN-END:variables
}
