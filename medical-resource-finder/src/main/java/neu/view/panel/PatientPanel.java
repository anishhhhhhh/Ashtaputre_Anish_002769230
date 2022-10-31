package neu.view.panel;

import java.awt.Image;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

import neu.data.directory.*;
import neu.data.model.*;
import neu.view.manager.UIManager;

public class PatientPanel extends javax.swing.JPanel {
    public String searchResultMessage = "all";

    public PatientPanel(String personId) {
        List<Encounter> filteredEncounters = EncounterDirectory.filterEncountersByPatient(personId);
        initComponents();
        setSearchResultMessage("");
        addProfileDetails(personId);
        addDoctorsToPanel(DoctorDirectory.getDoctorList());
        addEncountersToPanel(filteredEncounters);
    }
    
    private void addProfileDetails(String personId) {
        Patient p = PatientDirectory.getPatientByPersonId(personId);
        ImageIcon icon = new ImageIcon(new ImageIcon(p.getPhotoPath()).getImage().getScaledInstance(130, 170, Image.SCALE_DEFAULT));
        photoLabel.setIcon(icon);
        fullnameLabel.setText(p.getFirstName());
        emailField.setText(p.getContactInfo().listOfEmails.get(0).email);
        phoneField.setText(p.getContactInfo().listOfPhoneNumbers.get(0).number);
        genderField.setText(p.getGender());
    }
    
    private void addDoctorsToPanel(List<Doctor> doctorList) {
        DefaultTableModel model = (DefaultTableModel) doctorListTable.getModel();
        model.setRowCount(0);
        Object rowData[] = new Object[4];
        for (Doctor doc : doctorList) {
            rowData[0] = doc.getFullName();
            rowData[1] = doc.getSpecialization();
            rowData[2] = doc.getDoctorId();
            rowData[3] = doc.getContactInfo().listOfAddress.get(0).city;
            model.addRow(rowData);
        }
    }
    
    private void addEncountersToPanel(List<Encounter> encounterList) {
        DefaultTableModel model = (DefaultTableModel) encounterListTable.getModel();
        model.setRowCount(0);
        Object rowData[] = new Object[6];
        for (Encounter enc : encounterList) {
            rowData[0] = DoctorDirectory.getDoctorByPersonId(enc.getDoctorId()).getFullName();
            rowData[1] = enc.getDate().getFormattedDate();
            rowData[2] = enc.getVitalSigns().getBloodPressure();
            rowData[3] = enc.getVitalSigns().getPulseRate();
            rowData[4] = enc.getVitalSigns().getRespirationRate();
            rowData[5] = enc.getVitalSigns().getBodyTemperature();
            model.addRow(rowData);
        }
    }
    
    private void setSearchResultMessage(String text) {
        if (text.isBlank()) searchResultMessageLabel.setText(" ");
        else searchResultMessageLabel.setText("Showing results for \"" + text + "\"");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        PatientDoctorsPanel = new javax.swing.JPanel();
        doctorSearchButton = new javax.swing.JButton();
        doctorSearchField = new javax.swing.JTextField();
        searchResultMessageLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        doctorListTable = new javax.swing.JTable();
        patientEncounterPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        encounterListTable = new javax.swing.JTable();
        PatientProfilePanel = new javax.swing.JPanel();
        photoLabel = new javax.swing.JLabel();
        fullnameLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        genderField = new javax.swing.JLabel();
        phoneLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        phoneField = new javax.swing.JLabel();
        emailField = new javax.swing.JLabel();
        actionsPanel = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        backimg = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(700, 500));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setName(""); // NOI18N
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(850, 500));

        doctorSearchButton.setText("Search");
        doctorSearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doctorSearchButtonActionPerformed(evt);
            }
        });

        doctorListTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Doctor", "Specialization", "Doctor ID", "City"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(doctorListTable);

        javax.swing.GroupLayout PatientDoctorsPanelLayout = new javax.swing.GroupLayout(PatientDoctorsPanel);
        PatientDoctorsPanel.setLayout(PatientDoctorsPanelLayout);
        PatientDoctorsPanelLayout.setHorizontalGroup(
            PatientDoctorsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PatientDoctorsPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(searchResultMessageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(doctorSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(doctorSearchButton)
                .addGap(259, 259, 259))
            .addGroup(PatientDoctorsPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        PatientDoctorsPanelLayout.setVerticalGroup(
            PatientDoctorsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PatientDoctorsPanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(PatientDoctorsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PatientDoctorsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(doctorSearchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(doctorSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(searchResultMessageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );

        jTabbedPane1.addTab("Doctors", PatientDoctorsPanel);

        encounterListTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Doctor", "Date", "Blood Pressure", "Respiration rate", "Temperature", "Pulse rate"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(encounterListTable);

        javax.swing.GroupLayout patientEncounterPanelLayout = new javax.swing.GroupLayout(patientEncounterPanel);
        patientEncounterPanel.setLayout(patientEncounterPanelLayout);
        patientEncounterPanelLayout.setHorizontalGroup(
            patientEncounterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE)
        );
        patientEncounterPanelLayout.setVerticalGroup(
            patientEncounterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Encounters", patientEncounterPanel);

        photoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        fullnameLabel.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        fullnameLabel.setText("Sudarshan Kudli");

        jLabel2.setText("Age: ");

        jLabel3.setText("24");

        jLabel4.setText("Sex:");

        genderField.setText("Male");

        phoneLabel.setText("Phone:");

        emailLabel.setText("Email");

        phoneField.setText("8472772626");

        emailField.setText("sumeet.somu@gmail.com");

        javax.swing.GroupLayout PatientProfilePanelLayout = new javax.swing.GroupLayout(PatientProfilePanel);
        PatientProfilePanel.setLayout(PatientProfilePanelLayout);
        PatientProfilePanelLayout.setHorizontalGroup(
            PatientProfilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PatientProfilePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(photoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(PatientProfilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PatientProfilePanelLayout.createSequentialGroup()
                        .addGroup(PatientProfilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PatientProfilePanelLayout.createSequentialGroup()
                                .addGroup(PatientProfilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(emailLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(phoneLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(PatientProfilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(phoneField, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(PatientProfilePanelLayout.createSequentialGroup()
                                .addGroup(PatientProfilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4))
                                .addGap(29, 29, 29)
                                .addGroup(PatientProfilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(genderField)
                                    .addComponent(jLabel3))))
                        .addContainerGap(467, Short.MAX_VALUE))
                    .addGroup(PatientProfilePanelLayout.createSequentialGroup()
                        .addComponent(fullnameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap(594, Short.MAX_VALUE))))
        );
        PatientProfilePanelLayout.setVerticalGroup(
            PatientProfilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PatientProfilePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PatientProfilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PatientProfilePanelLayout.createSequentialGroup()
                        .addComponent(fullnameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PatientProfilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PatientProfilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(genderField))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PatientProfilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(phoneLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(phoneField))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PatientProfilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(emailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(emailField)))
                    .addComponent(photoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(284, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Profile", PatientProfilePanel);

        jButton2.setText("Logout");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        backimg.setIcon(new javax.swing.ImageIcon("/Users/skudli/Downloads/UI IMAGES/patient.png")); // NOI18N

        javax.swing.GroupLayout actionsPanelLayout = new javax.swing.GroupLayout(actionsPanel);
        actionsPanel.setLayout(actionsPanelLayout);
        actionsPanelLayout.setHorizontalGroup(
            actionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(actionsPanelLayout.createSequentialGroup()
                .addGap(394, 394, 394)
                .addComponent(jButton2))
            .addComponent(backimg, javax.swing.GroupLayout.PREFERRED_SIZE, 889, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        actionsPanelLayout.setVerticalGroup(
            actionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(actionsPanelLayout.createSequentialGroup()
                .addGap(156, 156, 156)
                .addComponent(jButton2))
            .addComponent(backimg)
        );

        jTabbedPane1.addTab("Actions", actionsPanel);

        add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 480));
        jTabbedPane1.getAccessibleContext().setAccessibleName("Doctors");
    }// </editor-fold>//GEN-END:initComponents

    private void doctorSearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doctorSearchButtonActionPerformed
        String searchText = doctorSearchField.getText();
        setSearchResultMessage(searchText);
        List<Doctor> searchResult = DoctorDirectory.searchDoctors(searchText);
        addDoctorsToPanel(searchResult);
    }//GEN-LAST:event_doctorSearchButtonActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        UIManager.showLoginPanel();
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PatientDoctorsPanel;
    private javax.swing.JPanel PatientProfilePanel;
    private javax.swing.JPanel actionsPanel;
    private javax.swing.JLabel backimg;
    private javax.swing.JTable doctorListTable;
    private javax.swing.JButton doctorSearchButton;
    private javax.swing.JTextField doctorSearchField;
    private javax.swing.JLabel emailField;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JTable encounterListTable;
    private javax.swing.JLabel fullnameLabel;
    private javax.swing.JLabel genderField;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel patientEncounterPanel;
    private javax.swing.JLabel phoneField;
    private javax.swing.JLabel phoneLabel;
    private javax.swing.JLabel photoLabel;
    private javax.swing.JLabel searchResultMessageLabel;
    // End of variables declaration//GEN-END:variables
}
