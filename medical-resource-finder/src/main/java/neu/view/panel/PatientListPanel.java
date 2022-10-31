package neu.view.panel;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import neu.data.constants.AccessLevels;
import neu.data.directory.*;
import neu.data.model.*;
import static neu.view.panel.DoctorPanel.loadNewEncounterPanel;

public class PatientListPanel extends javax.swing.JPanel {
    
    private String access;
    private String personId;

    public PatientListPanel(String access, String personId) {
        this.access = access;
        this.personId = personId;
        initComponents();
        addPatientsToPanel();
    }
    
    private void addPatientsToPanel() {
        if (access.equals(AccessLevels.getSystemAdminAccess())) {
            List<Patient> patientList = PatientDirectory.getPatientList();
            DefaultTableModel model = (DefaultTableModel) patientsTable.getModel();
            model.setRowCount(0);
            Object rowData[] = new Object[4];
            for (Patient pat : patientList) {
                rowData[0] = pat.getFullName();
                rowData[1] = pat.getPersonId();
                rowData[2] = pat.getDateOfBirth().getFormattedDate();
                rowData[3] = pat.getGender();
                model.addRow(rowData);
            } 
        } else if (access.equals(AccessLevels.getCommunityAdminAccess())) {
            List<Community> comList = CommunityDirectory.getCommunityListByCommunityAdmin(personId);
            List<Patient> patientList = PatientDirectory.getPatientList();
            DefaultTableModel model = (DefaultTableModel) patientsTable.getModel();
            model.setRowCount(0);
            Object rowData[] = new Object[4];
            for (Patient pat : patientList) {
                if (isPatientInCommunity(pat, comList)) {
                    rowData[0] = pat.getFullName();
                    rowData[1] = pat.getPersonId();
                    rowData[2] = pat.getDateOfBirth().getFormattedDate();
                    rowData[3] = pat.getGender();
                    model.addRow(rowData);
                }
            }
        }  else if (access.equals(AccessLevels.getHospitalAdminAccess())) {
            Hospital hos = HospitalDirectory.getHospitalByAdminId(personId);
            if (hos!=null) {
                List<Encounter> encList = EncounterDirectory.getEncounterListByHospital(hos.getHospitalId());
                DefaultTableModel model = (DefaultTableModel) patientsTable.getModel();
                model.setRowCount(0);
                Object rowData[] = new Object[4];
                for (Encounter enc : encList) {
                   Patient pat = PatientDirectory.getPatientByPersonId(enc.getPatientId());
                   rowData[0] = pat.getFullName();
                   rowData[1] = pat.getPersonId();
                   rowData[2] = pat.getDateOfBirth().getFormattedDate();
                   rowData[3] = pat.getGender();
                   model.addRow(rowData);
                }   
            }
            
        }
    }
    
    private boolean isPatientInCommunity(Patient pat, List<Community> comList) {
        boolean result = false;
        for (Community com : comList) {
            if (pat.getContactInfo().listOfAddress.get(0).zip.equals(com.getZipCode())) {
                result = true;
            }
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane5 = new javax.swing.JScrollPane();
        patientsTable = new javax.swing.JTable();
        addPatientButton = new javax.swing.JButton();
        editPatientButton = new javax.swing.JButton();
        deletePatientButton = new javax.swing.JButton();
        viewPatientButton = new javax.swing.JButton();

        patientsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Name", "ID", "DOB", "Gender"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(patientsTable);

        addPatientButton.setText("Add");
        addPatientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPatientButtonActionPerformed(evt);
            }
        });

        editPatientButton.setText("Edit");
        editPatientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editPatientButtonActionPerformed(evt);
            }
        });

        deletePatientButton.setText("Delete");
        deletePatientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletePatientButtonActionPerformed(evt);
            }
        });

        viewPatientButton.setText("View");
        viewPatientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewPatientButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(218, 218, 218)
                .addComponent(addPatientButton)
                .addGap(36, 36, 36)
                .addComponent(editPatientButton)
                .addGap(57, 57, 57)
                .addComponent(deletePatientButton)
                .addGap(29, 29, 29)
                .addComponent(viewPatientButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addPatientButton)
                    .addComponent(editPatientButton)
                    .addComponent(deletePatientButton)
                    .addComponent(viewPatientButton))
                .addContainerGap(15, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addPatientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPatientButtonActionPerformed
        if (access.equals(AccessLevels.getCommunityAdminAccess())) {
            CommunityAdminPanel.showAddPatientPanel("", "add");
        } else if (access.equals(AccessLevels.getSystemAdminAccess())) {
            SystemAdminPanel.showAddPatientPanel("", "add");
        }
    }//GEN-LAST:event_addPatientButtonActionPerformed

    private void deletePatientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletePatientButtonActionPerformed
        if (patientsTable.getSelectedRow() != -1) {
            DefaultTableModel model = (DefaultTableModel) patientsTable.getModel();
            int row = patientsTable.getSelectedRow();
            String patientId = patientsTable.getModel().getValueAt(row, 1).toString();
            if (PatientDirectory.deletePatient(patientId)) {
                model.removeRow(patientsTable.getSelectedRow());
                JOptionPane.showMessageDialog(null, "Deleted successfully");
            } else {
                JOptionPane.showMessageDialog(null, "Record not found"); 
            }
        }
    }//GEN-LAST:event_deletePatientButtonActionPerformed

    private void editPatientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editPatientButtonActionPerformed
        if (patientsTable.getSelectedRow() != -1) {
            int row = patientsTable.getSelectedRow();
            String patientId = patientsTable.getModel().getValueAt(row, 1).toString();
            if (access.equals(AccessLevels.getCommunityAdminAccess())) {
                CommunityAdminPanel.showAddPatientPanel(patientId, "edit");
            } else if (access.equals(AccessLevels.getSystemAdminAccess())) {
                SystemAdminPanel.showAddPatientPanel(patientId, "edit");
            }
        }
    }//GEN-LAST:event_editPatientButtonActionPerformed

    private void viewPatientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewPatientButtonActionPerformed
        if (patientsTable.getSelectedRow() != -1) {
            int row = patientsTable.getSelectedRow();
            String patientId = patientsTable.getModel().getValueAt(row, 1).toString();
            SystemAdminPanel.showAddPatientPanel(patientId, "view");
        }
    }//GEN-LAST:event_viewPatientButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addPatientButton;
    private javax.swing.JButton deletePatientButton;
    private javax.swing.JButton editPatientButton;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable patientsTable;
    private javax.swing.JButton viewPatientButton;
    // End of variables declaration//GEN-END:variables
}
