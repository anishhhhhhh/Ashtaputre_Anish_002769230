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
import neu.data.directory.DoctorDirectory;
import neu.data.directory.PatientDirectory;
import neu.data.directory.StateDirectory;
import neu.data.model.Community;
import neu.data.model.Doctor;
import neu.data.model.Patient;
import neu.data.validation.Validation;
import neu.util.customTypes.Address;
import neu.util.customTypes.Email;
import neu.util.customTypes.Phone;

public class AddDoctorPanel extends javax.swing.JPanel {

    private String mode;
    private String id;
    private String access;
    public boolean isValidInput;
    
    public AddDoctorPanel() {
        initComponents();
    }
    
    public AddDoctorPanel(String id, String mode, String access) {
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
            hospitalIdField.setEditable(false);
        }
    }
    
    public void populateComboBox() {
        stateComboBox.setModel(new DefaultComboBoxModel<>(StateDirectory.stateList.toArray(new String[0])));
        cityComboBox.setModel(new DefaultComboBoxModel<>(CityDirectory.cityList.toArray(new String[0])));
    }
    
    public void setViewMode() {
        hideInvalidLabels();
        disableEdit();
        hideAccessAndPassword();
    }
    
    public void setEditMode() {
        hideInvalidLabels();
        enableEdit();
        showData();
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
        invalidMedicalIdLabel.setVisible(false);
        invalidAccessLabel.setVisible(false);
        invalidPasswordLabel.setVisible(false);
        invalidZipLabel.setVisible(false);
        invalidAddressLabel.setVisible(false);
        invalidHospitalLabel.setVisible(false);
    }
    
    public void disableEdit() {
        saveButton.setEnabled(false);
        photoLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        choosePhotoButton.setEnabled(false);
    }
    
    public void emptyTextFields() {
        firstNameField.setText("");
        lastNameField.setText("");
        
        dayField.setText("DD");
        monthField.setText("MM");
        yearField.setText("YY");
        
        accessField.setText("");
        passwordField.setText("");
        medicalIdField.setText("");
        
        phoneField.setText("");
        emailField.setText("");
        zipField.setText("");
        addressField.setText("");
        hospitalIdField.setText("");
        
        photoLabel.setText("No Photo Selected");
        photoLabel.setIcon(null);
    }
    
    public void enableEdit() {
        firstNameField.setEditable(true);
        lastNameField.setEditable(true);
        
        dayField.setEditable(true);
        monthField.setEditable(true);
        yearField.setEditable(true);
        medicalIdField.setEditable(true);
        zipField.setEditable(true);
        
        phoneField.setEditable(true);
        emailField.setEditable(true);        
    }
    
    public void showData() {
        Doctor doc = DoctorDirectory.getDoctorByPersonId(this.id);
        firstNameField.setText(doc.getFirstName());
        lastNameField.setText(doc.getLastName());
                
        genderField.setSelectedItem(doc.getGender());
        List<Email> emails = doc.getContactInfo().listOfEmails;
        List<Phone> phones = doc.getContactInfo().listOfPhoneNumbers;
        List<Address> addresses = doc.getContactInfo().listOfAddress;
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
        
        hospitalIdField.setText(doc.getHospitalId());
        dayField.setText(Integer.toString(doc.getDateOfBirth().getDay()));
        monthField.setText(Integer.toString(doc.getDateOfBirth().getMonth()));
        yearField.setText(Integer.toString(doc.getDateOfBirth().getYear()));
        
        genderField.setSelectedItem(doc.getGender());
        medicalIdField.setText(doc.getDoctorId());
        
        ImageIcon icon = new ImageIcon(new ImageIcon(doc.getPhotoPath()).getImage().getScaledInstance(140, 191, Image.SCALE_DEFAULT));
        photoLabel.setIcon(icon);
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
    
    public void validateInputs(String fName, String lName, String day, String month, String year, String phone, String email, String password, String address) {
        hideInvalidLabels();
        isValidInput = true;
        if (!Validation.isValidString(fName) || !Validation.isValidString(lName)) {
            isValidInput = false;
            invalidNameLabel.setVisible(isValidInput);
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
            System.out.println("Address not set");
            invalidAddressLabel.setVisible(true);
        }
    }
    
    public  void setDoctorAttributes(Doctor doc) {
        doc.setFirstName(firstNameField.getText());
        doc.setLastName(lastNameField.getText());
        doc.getDateOfBirth().setDay(Integer.parseInt(dayField.getText()));
        doc.getDateOfBirth().setMonth(Integer.parseInt(monthField.getText()));
        doc.getDateOfBirth().setYear(Integer.parseInt(yearField.getText()));
        doc.setGender(genderField.getSelectedItem().toString());
        doc.setPhotoPath(photoPathField.getText());
        doc.setDoctorId(medicalIdField.getText());
        
        Email email = new Email("Work", emailField.getText());
        doc.getContactInfo().listOfEmails.add(email);
        Phone phone = new Phone("Work", phoneField.getText(), "+1");
        doc.getContactInfo().listOfPhoneNumbers.add(phone);
        
        Address a = new Address();
        a.address = addressField.getText();
        a.city = cityComboBox.getSelectedItem().toString();
        a.state = stateComboBox.getSelectedItem().toString();
        a.zip = zipField.getText();
        doc.getContactInfo().listOfAddress.add(a);
        
        JOptionPane.showConfirmDialog(null, "Doctor Saved!", "Confirmation", JOptionPane.DEFAULT_OPTION);
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
        medicalIdLabel = new javax.swing.JLabel();
        medicalIdField = new javax.swing.JTextField();
        invalidAccessLabel = new javax.swing.JLabel();
        invalidPasswordLabel = new javax.swing.JLabel();
        invalidMedicalIdLabel = new javax.swing.JLabel();
        accessLabel1 = new javax.swing.JLabel();
        passwordLabel1 = new javax.swing.JLabel();
        medicalIdLabel1 = new javax.swing.JLabel();
        cityComboBox = new javax.swing.JComboBox<>();
        stateComboBox = new javax.swing.JComboBox<>();
        zipField = new javax.swing.JTextField();
        invalidZipLabel = new javax.swing.JLabel();
        addressField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        invalidAddressLabel = new javax.swing.JLabel();
        hospitalIdLabel = new javax.swing.JLabel();
        hospitalIdField = new javax.swing.JTextField();
        invalidHospitalLabel = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        firstNameLabel.setText("First Name");
        add(firstNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(299, 14, 89, 27));

        lastNameLabel.setText("Last Name");
        add(lastNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 50, 100, 27));

        dateOfBirthLabel.setText("Date of Birth");
        add(dateOfBirthLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(299, 126, -1, 27));

        genderLabel.setText("Gender");
        add(genderLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(299, 85, 100, 27));

        firstNameField.setText("Varad");
        firstNameField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        firstNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstNameFieldActionPerformed(evt);
            }
        });
        add(firstNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(417, 17, 215, 25));

        lastNameField.setText("Mohod");
        lastNameField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        add(lastNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(417, 50, 215, 25));

        dayField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        dayField.setText("23");
        dayField.setToolTipText("DD");
        dayField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        dayField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dayFieldActionPerformed(evt);
            }
        });
        add(dayField, new org.netbeans.lib.awtextra.AbsoluteConstraints(474, 128, 35, 25));

        monthField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        monthField.setText("11");
        monthField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        monthField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthFieldActionPerformed(evt);
            }
        });
        add(monthField, new org.netbeans.lib.awtextra.AbsoluteConstraints(417, 127, 39, 25));

        yearField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        yearField.setText("2000");
        yearField.setToolTipText("YYYY");
        yearField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        yearField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearFieldActionPerformed(evt);
            }
        });
        add(yearField, new org.netbeans.lib.awtextra.AbsoluteConstraints(534, 128, 49, 25));

        genderField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female", "Other" }));
        genderField.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        add(genderField, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 80, -1, 31));

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 420, 61, 31));

        invalidNameLabel.setForeground(new java.awt.Color(255, 102, 102));
        invalidNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        invalidNameLabel.setText("Invalid Name");
        invalidNameLabel.setToolTipText("");
        add(invalidNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(639, 54, 95, -1));

        invalidJoiningField.setForeground(new java.awt.Color(255, 102, 102));
        invalidJoiningField.setText("Invalid Date");
        add(invalidJoiningField, new org.netbeans.lib.awtextra.AbsoluteConstraints(652, 132, -1, -1));

        choosePhotoLabel.setText("Photo");
        add(choosePhotoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(299, 248, 100, 23));

        choosePhotoButton.setText("Choose from file");
        choosePhotoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                choosePhotoButtonActionPerformed(evt);
            }
        });
        add(choosePhotoButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(419, 248, -1, -1));

        photoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        photoLabel.setText("No photo selected");
        photoLabel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        add(photoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 140, 191));

        phoneLabel.setText("Phone");
        add(phoneLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(299, 171, 100, 27));

        phoneField.setText("8583784838");
        phoneField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        add(phoneField, new org.netbeans.lib.awtextra.AbsoluteConstraints(419, 171, 215, 25));

        invalidPhoneLabel.setForeground(new java.awt.Color(255, 102, 102));
        invalidPhoneLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        invalidPhoneLabel.setText("Invalid Phone");
        add(invalidPhoneLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(649, 171, 84, -1));
        add(photoPathField, new org.netbeans.lib.awtextra.AbsoluteConstraints(278, 266, 3, 7));

        emailLabel.setText("Email");
        add(emailLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(299, 211, 100, 25));

        passwordField.setText("test");
        passwordField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        add(passwordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 320, 215, 25));

        invalidEmailLabel.setForeground(new java.awt.Color(255, 102, 102));
        invalidEmailLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        invalidEmailLabel.setText("Invalid Email");
        add(invalidEmailLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(652, 215, 80, -1));

        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });
        add(saveButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 420, 61, 31));

        passwordLabel.setText("Password");
        add(passwordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 320, -1, -1));

        accessLabel.setText("Access");
        add(accessLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(299, 288, -1, -1));

        emailField.setText("murty@gmail.com");
        emailField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        add(emailField, new org.netbeans.lib.awtextra.AbsoluteConstraints(419, 211, 215, 25));

        accessField.setText("doctor");
        accessField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        add(accessField, new org.netbeans.lib.awtextra.AbsoluteConstraints(419, 288, 215, 25));

        medicalIdLabel.setText("Medical ID");
        add(medicalIdLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 370, -1, -1));

        medicalIdField.setText("8058");
        medicalIdField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        add(medicalIdField, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 360, 215, 25));

        invalidAccessLabel.setForeground(new java.awt.Color(255, 102, 102));
        invalidAccessLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        invalidAccessLabel.setText("Invalid Acces");
        add(invalidAccessLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 290, 80, -1));

        invalidPasswordLabel.setForeground(new java.awt.Color(255, 102, 102));
        invalidPasswordLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        invalidPasswordLabel.setText("Invalid Password");
        add(invalidPasswordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 320, -1, -1));

        invalidMedicalIdLabel.setForeground(new java.awt.Color(255, 102, 102));
        invalidMedicalIdLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        invalidMedicalIdLabel.setText("Invalid Medical ID");
        add(invalidMedicalIdLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 370, -1, -1));

        accessLabel1.setText("State");
        add(accessLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, -1, -1));

        passwordLabel1.setText("City");
        add(passwordLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, -1, -1));

        medicalIdLabel1.setText("Zip");
        add(medicalIdLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 30, 30));

        cityComboBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        add(cityComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 320, 190, 20));

        stateComboBox.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        add(stateComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 290, 190, 20));

        zipField.setText("02121");
        zipField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        add(zipField, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 410, 110, 25));

        invalidZipLabel.setForeground(new java.awt.Color(255, 102, 102));
        invalidZipLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        invalidZipLabel.setText("Invalid Zip");
        add(invalidZipLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 440, -1, -1));

        addressField.setText("28 Tremont Street");
        addressField.setToolTipText("");
        add(addressField, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, 190, -1));

        jLabel1.setText("Address");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        invalidAddressLabel.setForeground(new java.awt.Color(255, 102, 102));
        invalidAddressLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        invalidAddressLabel.setText("Invalid Address");
        add(invalidAddressLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 260, -1, -1));

        hospitalIdLabel.setText("Hospital ID");
        add(hospitalIdLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 70, 30));

        hospitalIdField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        add(hospitalIdField, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 360, 110, 25));

        invalidHospitalLabel.setForeground(new java.awt.Color(255, 102, 102));
        invalidHospitalLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        invalidHospitalLabel.setText("Invalid Hospital");
        add(invalidHospitalLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 390, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void firstNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_firstNameFieldActionPerformed

    private void dayFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dayFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dayFieldActionPerformed

    private void monthFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_monthFieldActionPerformed

    private void yearFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_yearFieldActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        if (access.equals(AccessLevels.getSystemAdminAccess())) {
            SystemAdminPanel.goBack("Doctors");    
        } else if (access.equals(AccessLevels.getHospitalAdminAccess())) {
            HospitalAdminPanel.goBack("Doctors");    
        } else if (access.equals(AccessLevels.getCommunityAdminAccess())) {
            CommunityAdminPanel.goBack("Doctors");    
        }
    }//GEN-LAST:event_backButtonActionPerformed

    private void choosePhotoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_choosePhotoButtonActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        int response = fileChooser.showOpenDialog(null);
        if (response == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            String path = file.getAbsolutePath();
            photoPathField.setText(path);
            ImageIcon icon = new ImageIcon(new ImageIcon(path).getImage().getScaledInstance(140, 191, Image.SCALE_DEFAULT));
            photoLabel.setIcon(icon);
            photoLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        }
    }//GEN-LAST:event_choosePhotoButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        validateInputs(firstNameField.getText(), lastNameField.getText(), dayField.getText(), monthField.getText(), yearField.getText(), phoneField.getText(), emailField.getText(), passwordField.getText(), addressField.getText());
        if (mode.equals("add") && isValidInput) {
            Doctor doc = new Doctor(accessField.getText(), firstNameField.getText());
            setDoctorAttributes(doc);
            doc.addToDirectory();
            reset();
        } else if (mode.equals("edit") && isValidInput) {
            Doctor doc = DoctorDirectory.getDoctorByPersonId(this.id);
            setDoctorAttributes(doc);
            backButtonActionPerformed(evt);
        } else {
            System.out.println("Wrong input");
        }
    }//GEN-LAST:event_saveButtonActionPerformed


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
    private javax.swing.JTextField hospitalIdField;
    private javax.swing.JLabel hospitalIdLabel;
    private javax.swing.JLabel invalidAccessLabel;
    private javax.swing.JLabel invalidAddressLabel;
    private javax.swing.JLabel invalidEmailLabel;
    private javax.swing.JLabel invalidHospitalLabel;
    private javax.swing.JLabel invalidJoiningField;
    private javax.swing.JLabel invalidMedicalIdLabel;
    private javax.swing.JLabel invalidNameLabel;
    private javax.swing.JLabel invalidPasswordLabel;
    private javax.swing.JLabel invalidPhoneLabel;
    private javax.swing.JLabel invalidZipLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField lastNameField;
    private javax.swing.JLabel lastNameLabel;
    private javax.swing.JTextField medicalIdField;
    private javax.swing.JLabel medicalIdLabel;
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
