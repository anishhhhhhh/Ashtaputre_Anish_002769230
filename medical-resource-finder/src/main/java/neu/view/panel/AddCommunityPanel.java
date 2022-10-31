package neu.view.panel;

import java.awt.Image;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import neu.data.constants.AccessLevels;
import neu.data.directory.CityDirectory;
import neu.data.directory.CommunityDirectory;
import neu.data.directory.PatientDirectory;
import neu.data.directory.StateDirectory;
import neu.data.model.Community;
import neu.data.model.Patient;
import neu.data.validation.Validation;
import neu.util.customTypes.Address;
import neu.util.customTypes.Email;
import neu.util.customTypes.Phone;

public class AddCommunityPanel extends javax.swing.JPanel {

    private String mode;
    private String personId;
    private String zip;
    private String access;
    public boolean isValidInput;
    
    public AddCommunityPanel(String personId, String mode, String access, String zip) {
        initComponents();
        this.mode = mode;
        this.personId = personId;
        this.zip = zip;
        this.access = access;
        switch(this.mode) {
            case "view":
                setViewMode();
            case "edit":
                setEditMode();
            case "add":
                setAddMode();
        }
        if (access.equals(AccessLevels.getCommunityAdminAccess())) {
            adminField.setText(personId);
            adminField.setEditable(false);
            zipField.setEditable(false);
        }
    }
    
    public void setViewMode() {
        showData(zip);
        hideInvalidLabels();
        disableEdit();
    }
    
    public void setEditMode() {
        hideInvalidLabels();
        enableEdit();
        showData(zip);
    }
    
    public void setAddMode() {
        hideInvalidLabels();
    }
    
    public void hideInvalidLabels() {
        invalidNameLabel.setVisible(false);
        invalidZipLabel.setVisible(false);
        invalidAdminLabel.setVisible(false);
    }
    
    public void disableEdit() {        
        saveButton.setEnabled(false);
    }
    
    public void emptyTextFields() {
        nameField.setText("");
        zipField.setText("");
        adminField.setText("");
    }
    
    public void enableEdit() {
        nameField.setEditable(true);
        zipField.setEditable(true);
        adminField.setEditable(true);
    }
    
    public void showData(String zip) {
        Community com = CommunityDirectory.getCommunityByZip(zip);
        nameField.setText(com.getName());
        zipField.setText(com.getZipCode());
        adminField.setText(com.getAdminId()); 
    }
    
    public void reset() {
        emptyTextFields();
        hideInvalidLabels();
    }
    
    public void validateInputs(String zip, String name, String admin) {
        hideInvalidLabels();
        isValidInput = true;
        if (!Validation.isValidString(zip)) {
            isValidInput = false;
            invalidZipLabel.setVisible(true);
        }
        if (!Validation.isValidString(name)) {
            isValidInput = false;
            invalidNameLabel.setVisible(true);
        }
        if (!Validation.isValidString(admin)) {
            isValidInput = false;
            invalidAdminLabel.setVisible(true);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nameLabel = new javax.swing.JLabel();
        adminLabel = new javax.swing.JLabel();
        adminField = new javax.swing.JTextField();
        nameField = new javax.swing.JTextField();
        zipLabel = new javax.swing.JLabel();
        zipField = new javax.swing.JTextField();
        backButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        invalidNameLabel = new javax.swing.JLabel();
        invalidZipLabel = new javax.swing.JLabel();
        invalidAdminLabel = new javax.swing.JLabel();

        nameLabel.setText("Name");

        adminLabel.setText("Admin");

        adminField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        nameField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        nameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameFieldActionPerformed(evt);
            }
        });

        zipLabel.setText("Zip");

        zipField.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        zipField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zipFieldActionPerformed(evt);
            }
        });

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        invalidNameLabel.setForeground(new java.awt.Color(255, 102, 102));
        invalidNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        invalidNameLabel.setText("Invalid Name");
        invalidNameLabel.setToolTipText("");

        invalidZipLabel.setForeground(new java.awt.Color(255, 102, 102));
        invalidZipLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        invalidZipLabel.setText("Invalid Zip");

        invalidAdminLabel.setForeground(new java.awt.Color(255, 102, 102));
        invalidAdminLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        invalidAdminLabel.setText("Invalid Admin");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(260, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(109, 109, 109)
                        .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(301, 301, 301))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(zipLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(20, 20, 20)
                                        .addComponent(zipField, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(adminLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(20, 20, 20)
                                        .addComponent(adminField, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(invalidAdminLabel)
                                    .addComponent(invalidZipLabel)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(invalidNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(142, 142, 142))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(invalidNameLabel))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(adminLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(adminField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(invalidAdminLabel)))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(zipLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(zipField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(invalidZipLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 248, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void nameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameFieldActionPerformed

    private void zipFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zipFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_zipFieldActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        if (access.equals(AccessLevels.getCommunityAdminAccess())) {
            CommunityAdminPanel.goBack("Communities");  
        } else if (access.equals(AccessLevels.getSystemAdminAccess())) {
            SystemAdminPanel.goBack("Communities");  
        }
    }//GEN-LAST:event_backButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        validateInputs(zipField.getText(), nameField.getText(), adminField.getText());
        if (mode.equals("add") && isValidInput) {
            Community com = new Community(zipField.getText(), nameField.getText(), adminField.getText());
            CommunityDirectory.addNewCommunity(com);
            JOptionPane.showConfirmDialog(null, "Community Saved!", "Confirmation", JOptionPane.DEFAULT_OPTION);
            reset();
        } else if (mode.equals("edit") && isValidInput) {
            Community com = CommunityDirectory.getCommunityByZip(zip);
            com.setName(nameField.getText());
            com.setAdminId((adminField.getText()));
            if (access.equals(AccessLevels.getSystemAdminAccess())) {
                com.setZip(zipField.getText());
            }
            JOptionPane.showConfirmDialog(null, "Community Saved!", "Confirmation", JOptionPane.DEFAULT_OPTION);
            reset();
        } else {
            System.out.println("Wrong input");
        }
    }//GEN-LAST:event_saveButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField adminField;
    private javax.swing.JLabel adminLabel;
    private javax.swing.JButton backButton;
    private javax.swing.JLabel invalidAdminLabel;
    private javax.swing.JLabel invalidNameLabel;
    private javax.swing.JLabel invalidZipLabel;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JButton saveButton;
    private javax.swing.JTextField zipField;
    private javax.swing.JLabel zipLabel;
    // End of variables declaration//GEN-END:variables
}
