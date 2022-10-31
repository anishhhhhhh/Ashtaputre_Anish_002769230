package neu.view.panel;

import java.awt.FlowLayout;
import java.time.LocalDate;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import neu.data.directory.*;
import neu.data.model.*;
import neu.view.manager.UIManager;

public class DoctorPanel extends javax.swing.JPanel {
    private static String doctorId;
    private static String patientId;

    public DoctorPanel(String doctorId) {
        this.doctorId = doctorId;
        initComponents();
        loadPatientList();
        loadEncounters(this.doctorId);
        loadDoctorProfile(this.doctorId);
        showNoPatientsPanel();
    }
    
    public static void loadPatientList() {
        DefaultTableModel model = (DefaultTableModel) patientListTable.getModel();
        model.setRowCount(0);
        Object rowData[] = new Object[4];
        List<Patient> patientList = PatientDirectory.getPatientList();
        for (Patient pat : patientList) {
            rowData[0] = pat.getFullName();
            rowData[1] = pat.getDateOfBirth().getFormattedDate();
            rowData[2] = pat.getPersonId();
            model.addRow(rowData);
        }
    }
    
    public static void loadEncounters(String doctorId) {
        DefaultTableModel model = (DefaultTableModel) encounterListTable.getModel();
        model.setRowCount(0);
        Object rowData[] = new Object[7];
        List<Encounter> encounterList = EncounterDirectory.getEncounterList();
        for (Encounter enc : encounterList) {
            rowData[0] = enc.getPatientId();
            rowData[1] = enc.getDate().getFormattedDate();
            rowData[2] = enc.getVitalSigns().getBloodPressure();
            rowData[3] = enc.getVitalSigns().getPulseRate();
            rowData[4] = enc.getVitalSigns().getRespirationRate();
            rowData[5] = enc.getVitalSigns().getBodyTemperature();
            rowData[6] = enc.getEncounterId();
            model.addRow(rowData);
        }
    }
    
    public static void loadDoctorProfile(String doctorId) {
        DoctorProfilePanel dPanel = new DoctorProfilePanel(doctorId);
        dPanel.disableBackButton();
        profilePanel.add(dPanel);
        profilePanel.setLayout(new FlowLayout());
    }
    
    public static void loadNewEncounterPanel(String patientId) {
        Patient pat = PatientDirectory.getPatientByPersonId(patientId);
        vitalSignsPanel.setVisible(true);
        noPatientsPanel.setVisible(false);
        nameTextField.setText(pat.getFullName());
        idTextField.setText(pat.getPersonId());
        genderTextField.setText(pat.getGender());
    }
    
    public static void showNoPatientsPanel() {
        vitalSignsPanel.setVisible(false);
        noPatientsPanel.setVisible(true);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        newEncounterPanel = new javax.swing.JPanel();
        patientListScrollPane = new javax.swing.JScrollPane();
        patientListTable = new javax.swing.JTable();
        createEncounterButton = new javax.swing.JButton();
        vitalSignsPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        pulseRateValueField = new javax.swing.JTextField();
        bloodPressureValueField = new javax.swing.JTextField();
        bodyTemperatureValueField = new javax.swing.JTextField();
        respirationRateValueField = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        remarksValueTextArea = new javax.swing.JTextArea();
        saveButton = new javax.swing.JButton();
        nameTextField = new javax.swing.JTextField();
        idTextField = new javax.swing.JTextField();
        genderTextField = new javax.swing.JTextField();
        noPatientsPanel = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        encountersPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        encounterListTable = new javax.swing.JTable();
        deleteEncounterButton = new javax.swing.JButton();
        profilePanel = new javax.swing.JPanel();
        actionsPanel = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        BCKIMGap = new javax.swing.JLabel();

        newEncounterPanel.setBackground(new java.awt.Color(255, 255, 255));

        patientListTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Name", "DOB", "ID"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        patientListScrollPane.setViewportView(patientListTable);

        createEncounterButton.setText("Create Encounter");
        createEncounterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createEncounterButtonActionPerformed(evt);
            }
        });

        vitalSignsPanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("Patient");

        jLabel2.setText("Name:");

        jLabel4.setText("ID:");

        jLabel6.setText("Gender:");
        jLabel6.setToolTipText("");

        jLabel8.setText("Vital Signs");

        jLabel9.setText("Pulse Rate");

        jLabel10.setText("Blood Pressure");

        jLabel11.setText("Body Temperature");

        jLabel12.setText("Respiration Rate");

        pulseRateValueField.setText("10");
        pulseRateValueField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pulseRateValueFieldActionPerformed(evt);
            }
        });

        bloodPressureValueField.setText("12");

        bodyTemperatureValueField.setText("100.2");

        respirationRateValueField.setText("20");

        jLabel13.setText("Remarks");

        remarksValueTextArea.setColumns(20);
        remarksValueTextArea.setLineWrap(true);
        remarksValueTextArea.setRows(5);
        remarksValueTextArea.setWrapStyleWord(true);
        jScrollPane3.setViewportView(remarksValueTextArea);

        saveButton.setText("Save");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        nameTextField.setEditable(false);

        idTextField.setEditable(false);

        genderTextField.setEditable(false);

        javax.swing.GroupLayout vitalSignsPanelLayout = new javax.swing.GroupLayout(vitalSignsPanel);
        vitalSignsPanel.setLayout(vitalSignsPanelLayout);
        vitalSignsPanelLayout.setHorizontalGroup(
            vitalSignsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vitalSignsPanelLayout.createSequentialGroup()
                .addGroup(vitalSignsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(vitalSignsPanelLayout.createSequentialGroup()
                        .addGap(163, 163, 163)
                        .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(vitalSignsPanelLayout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addGroup(vitalSignsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, vitalSignsPanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(vitalSignsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(vitalSignsPanelLayout.createSequentialGroup()
                                .addGroup(vitalSignsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4))
                                .addGap(21, 21, 21)
                                .addGroup(vitalSignsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(idTextField)
                                    .addComponent(nameTextField)))
                            .addGroup(vitalSignsPanelLayout.createSequentialGroup()
                                .addGroup(vitalSignsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(vitalSignsPanelLayout.createSequentialGroup()
                                        .addGroup(vitalSignsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel10)
                                            .addComponent(jLabel11)
                                            .addComponent(jLabel12))
                                        .addGap(18, 18, 18)
                                        .addGroup(vitalSignsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(respirationRateValueField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(bloodPressureValueField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(bodyTemperatureValueField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(pulseRateValueField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel1))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(vitalSignsPanelLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(genderTextField)))))
                .addGap(106, 106, 106))
        );
        vitalSignsPanelLayout.setVerticalGroup(
            vitalSignsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vitalSignsPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(12, 12, 12)
                .addGroup(vitalSignsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(vitalSignsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(6, 6, 6)
                .addGroup(vitalSignsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(genderTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(vitalSignsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(vitalSignsPanelLayout.createSequentialGroup()
                        .addComponent(pulseRateValueField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bloodPressureValueField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58))
                    .addGroup(vitalSignsPanelLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(9, 9, 9)
                        .addComponent(jLabel9)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel10)
                        .addGap(9, 9, 9)
                        .addGroup(vitalSignsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(bodyTemperatureValueField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(vitalSignsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(respirationRateValueField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(30, 30, 30)
                .addComponent(jLabel13)
                .addGap(6, 6, 6)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        jLabel14.setText("No Patient Selected");

        javax.swing.GroupLayout noPatientsPanelLayout = new javax.swing.GroupLayout(noPatientsPanel);
        noPatientsPanel.setLayout(noPatientsPanelLayout);
        noPatientsPanelLayout.setHorizontalGroup(
            noPatientsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(noPatientsPanelLayout.createSequentialGroup()
                .addGap(153, 153, 153)
                .addComponent(jLabel14)
                .addContainerGap(168, Short.MAX_VALUE))
        );
        noPatientsPanelLayout.setVerticalGroup(
            noPatientsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(noPatientsPanelLayout.createSequentialGroup()
                .addGap(211, 211, 211)
                .addComponent(jLabel14)
                .addContainerGap(259, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout newEncounterPanelLayout = new javax.swing.GroupLayout(newEncounterPanel);
        newEncounterPanel.setLayout(newEncounterPanelLayout);
        newEncounterPanelLayout.setHorizontalGroup(
            newEncounterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newEncounterPanelLayout.createSequentialGroup()
                .addGroup(newEncounterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(patientListScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(newEncounterPanelLayout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(createEncounterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(vitalSignsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(newEncounterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, newEncounterPanelLayout.createSequentialGroup()
                    .addGap(0, 427, Short.MAX_VALUE)
                    .addComponent(noPatientsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        newEncounterPanelLayout.setVerticalGroup(
            newEncounterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newEncounterPanelLayout.createSequentialGroup()
                .addComponent(patientListScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(createEncounterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
            .addComponent(vitalSignsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(newEncounterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, newEncounterPanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(noPatientsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jTabbedPane1.addTab("New Encounter", newEncounterPanel);

        encounterListTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Patient", "Date", "Blood Pressure", "Pulse Rate", "Respiration Rate", "Body Temperature", "ID"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(encounterListTable);

        deleteEncounterButton.setText("Delete");
        deleteEncounterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteEncounterButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout encountersPanelLayout = new javax.swing.GroupLayout(encountersPanel);
        encountersPanel.setLayout(encountersPanelLayout);
        encountersPanelLayout.setHorizontalGroup(
            encountersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 863, Short.MAX_VALUE)
            .addGroup(encountersPanelLayout.createSequentialGroup()
                .addGap(370, 370, 370)
                .addComponent(deleteEncounterButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        encountersPanelLayout.setVerticalGroup(
            encountersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(encountersPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(deleteEncounterButton)
                .addGap(0, 28, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Encounters", encountersPanel);

        javax.swing.GroupLayout profilePanelLayout = new javax.swing.GroupLayout(profilePanel);
        profilePanel.setLayout(profilePanelLayout);
        profilePanelLayout.setHorizontalGroup(
            profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 863, Short.MAX_VALUE)
        );
        profilePanelLayout.setVerticalGroup(
            profilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 490, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Profile", profilePanel);

        actionsPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton3.setText("Logout");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        actionsPanel.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 210, -1, -1));

        BCKIMGap.setIcon(new javax.swing.ImageIcon("/Users/skudli/Downloads/UI IMAGES/DOCTOR LOGIN.jpeg")); // NOI18N
        actionsPanel.add(BCKIMGap, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 490));

        jTabbedPane1.addTab("Actions", actionsPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void createEncounterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createEncounterButtonActionPerformed
        int row = patientListTable.getSelectedRow();
        patientId = patientListTable.getModel().getValueAt(row, 2).toString();
        loadNewEncounterPanel(patientId);
    }//GEN-LAST:event_createEncounterButtonActionPerformed

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        String remarks = remarksValueTextArea.getText();
        int pulseRate = Integer.parseInt(pulseRateValueField.getText());
        float bloodPrssure = Float.parseFloat(bloodPressureValueField.getText());
        float bodyTemperature = Float.parseFloat(bodyTemperatureValueField.getText());
        int respirationRate = Integer.parseInt(respirationRateValueField.getText());
        
        VitalSigns vs = new VitalSigns(remarks, "", bodyTemperature, bloodPrssure, pulseRate, respirationRate);
        Encounter enc = new Encounter(patientId, LocalDate.now().getMonthValue(), LocalDate.now().getDayOfMonth(), LocalDate.now().getYear(), doctorId, vs);
        EncounterDirectory.addNewEncounter(enc);
        JOptionPane.showConfirmDialog(null, "Encounter Saved", "Confirmation", JOptionPane.DEFAULT_OPTION);
        loadEncounters(doctorId);
    }//GEN-LAST:event_saveButtonActionPerformed

    private void pulseRateValueFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pulseRateValueFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pulseRateValueFieldActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        UIManager.showLoginPanel();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void deleteEncounterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteEncounterButtonActionPerformed
        int row = encounterListTable.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) encounterListTable.getModel();
        String encounterId = encounterListTable.getModel().getValueAt(row, 6).toString();
        if (EncounterDirectory.deleteEncounter(encounterId)) {
            model.removeRow(encounterListTable.getSelectedRow());
            JOptionPane.showConfirmDialog(null, "Encounter Deleted", "Confirmation", JOptionPane.DEFAULT_OPTION);
        }
    }//GEN-LAST:event_deleteEncounterButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BCKIMGap;
    private javax.swing.JPanel actionsPanel;
    private javax.swing.JTextField bloodPressureValueField;
    private javax.swing.JTextField bodyTemperatureValueField;
    private static javax.swing.JButton createEncounterButton;
    private javax.swing.JButton deleteEncounterButton;
    private static javax.swing.JTable encounterListTable;
    private javax.swing.JPanel encountersPanel;
    private static javax.swing.JTextField genderTextField;
    private static javax.swing.JTextField idTextField;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private static javax.swing.JTabbedPane jTabbedPane1;
    private static javax.swing.JTextField nameTextField;
    private javax.swing.JPanel newEncounterPanel;
    private static javax.swing.JPanel noPatientsPanel;
    private javax.swing.JScrollPane patientListScrollPane;
    private static javax.swing.JTable patientListTable;
    private static javax.swing.JPanel profilePanel;
    private javax.swing.JTextField pulseRateValueField;
    private javax.swing.JTextArea remarksValueTextArea;
    private javax.swing.JTextField respirationRateValueField;
    private javax.swing.JButton saveButton;
    private static javax.swing.JPanel vitalSignsPanel;
    // End of variables declaration//GEN-END:variables
}
