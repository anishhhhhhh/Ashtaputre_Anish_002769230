package neu.view.panel;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import neu.data.constants.AccessLevels;
import neu.data.directory.*;
import neu.data.model.Community;
import neu.data.model.Doctor;
import neu.data.model.Hospital;
import neu.data.model.Patient;

public class DoctorListPanel extends javax.swing.JPanel {

    private String access;
    private String personId;
    
    public DoctorListPanel(String access, String personId) {
        this.access = access;
        this.personId = personId;
        initComponents();
        addDoctorsToPanel();
    }
    
    private void addDoctorsToPanel() {
        if (access.equals(AccessLevels.getSystemAdminAccess())) {
            DefaultTableModel model = (DefaultTableModel) doctorsTable.getModel();
            model.setRowCount(0);
            Object rowData[] = new Object[5];
            for (Doctor doc : DoctorDirectory.getDoctorList()) {
                rowData[0] = doc.getFullName();
                rowData[1] = doc.getPersonId();
                rowData[2] = doc.getDateOfBirth().getFormattedDate();
                rowData[3] = doc.getGender();
                rowData[4] = doc.getSpecialization();
                model.addRow(rowData);
            }
        } else if (access.equals(AccessLevels.getCommunityAdminAccess())) {
            List<Community> comList = CommunityDirectory.getCommunityListByCommunityAdmin(personId);
            List<Doctor> doctorList = DoctorDirectory.getDoctorList();
            DefaultTableModel model = (DefaultTableModel) doctorsTable.getModel();
            model.setRowCount(0);
            Object rowData[] = new Object[5];
            for (Doctor doc : doctorList) {
                if (isDoctorInCommunity(doc, comList)) {
                    rowData[0] = doc.getFullName();
                    rowData[1] = doc.getPersonId();
                    rowData[2] = doc.getDateOfBirth().getFormattedDate();
                    rowData[3] = doc.getGender();
                    rowData[4] = doc.getSpecialization();
                    model.addRow(rowData);
                }
            }
        } else if (access.equals(AccessLevels.getHospitalAdminAccess())) {
            List<Doctor> doctorList = DoctorDirectory.getDoctorList();
            DefaultTableModel model = (DefaultTableModel) doctorsTable.getModel();
            model.setRowCount(0);
            Object rowData[] = new Object[5];
            for (Doctor doc : doctorList) {
                Hospital hos = HospitalDirectory.getHospitalByAdminId(personId);
                if (hos!=null && doc.getHospitalId().equals( hos.getHospitalId())) {
                    rowData[0] = doc.getFullName();
                    rowData[1] = doc.getPersonId();
                    rowData[2] = doc.getDateOfBirth().getFormattedDate();
                    rowData[3] = doc.getGender();
                    rowData[4] = doc.getSpecialization();
                    model.addRow(rowData);
                }                
            }
        }
    }
    
    private boolean isDoctorInCommunity(Doctor doc, List<Community> comList) {
        boolean result = false;
        for (Community com : comList) {
            if (doc.getContactInfo().listOfAddress.get(0).zip.equals(com.getZipCode())) {
                result = true;
            }
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        doctorsTable = new javax.swing.JTable();
        addDoctorButton = new javax.swing.JButton();
        editDoctorButton = new javax.swing.JButton();
        deleteDoctorButton = new javax.swing.JButton();
        vieweDoctorButton = new javax.swing.JButton();

        doctorsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Name", "ID", "DOB", "Gender", "Specialization"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(doctorsTable);

        addDoctorButton.setText("Add");
        addDoctorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDoctorButtonActionPerformed(evt);
            }
        });

        editDoctorButton.setText("Edit");
        editDoctorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editDoctorButtonActionPerformed(evt);
            }
        });

        deleteDoctorButton.setText("Delete");
        deleteDoctorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteDoctorButtonActionPerformed(evt);
            }
        });

        vieweDoctorButton.setText("View");
        vieweDoctorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vieweDoctorButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(217, 217, 217)
                .addComponent(addDoctorButton)
                .addGap(36, 36, 36)
                .addComponent(editDoctorButton)
                .addGap(57, 57, 57)
                .addComponent(deleteDoctorButton)
                .addGap(29, 29, 29)
                .addComponent(vieweDoctorButton)
                .addContainerGap(223, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addDoctorButton)
                    .addComponent(editDoctorButton)
                    .addComponent(deleteDoctorButton)
                    .addComponent(vieweDoctorButton))
                .addGap(0, 14, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addDoctorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addDoctorButtonActionPerformed
        if (access.equals(AccessLevels.getSystemAdminAccess())) {
            SystemAdminPanel.showAddDoctorPanel("", "add");
        } else if (access.equals(AccessLevels.getHospitalAdminAccess())) {
            HospitalAdminPanel.showAddDoctorPanel("", "add");  
        } else if (access.equals(AccessLevels.getCommunityAdminAccess())) {
            CommunityAdminPanel.showAddDoctorPanel("", "add");  
        }
    }//GEN-LAST:event_addDoctorButtonActionPerformed

    private void deleteDoctorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteDoctorButtonActionPerformed
        if (doctorsTable.getSelectedRow() != -1) {
            DefaultTableModel model = (DefaultTableModel) doctorsTable.getModel();
            int row = doctorsTable.getSelectedRow();
            String doctorId = doctorsTable.getModel().getValueAt(row, 1).toString();
            if (DoctorDirectory.deleteDoctor(doctorId)) {
                model.removeRow(doctorsTable.getSelectedRow());
                JOptionPane.showMessageDialog(null, "Deleted successfully");
            } else {
                JOptionPane.showMessageDialog(null, "Record not found"); 
            }
        }
    }//GEN-LAST:event_deleteDoctorButtonActionPerformed

    private void editDoctorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editDoctorButtonActionPerformed
        if (doctorsTable.getSelectedRow() != -1) {
            int row = doctorsTable.getSelectedRow();
            String doctorId = doctorsTable.getModel().getValueAt(row, 1).toString();
            if (access.equals(AccessLevels.getSystemAdminAccess())) {
                SystemAdminPanel.showAddDoctorPanel(doctorId, "edit");
            } else if (access.equals(AccessLevels.getHospitalAdminAccess())) {
                HospitalAdminPanel.showAddDoctorPanel(doctorId, "edit"); 
            } else if (access.equals(AccessLevels.getCommunityAdminAccess())) {
                CommunityAdminPanel.showAddDoctorPanel(doctorId, "edit");  
            }
        }
    }//GEN-LAST:event_editDoctorButtonActionPerformed

    private void vieweDoctorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vieweDoctorButtonActionPerformed
        if (doctorsTable.getSelectedRow() != -1) {
            int row = doctorsTable.getSelectedRow();
            String doctorId = doctorsTable.getModel().getValueAt(row, 1).toString();
            SystemAdminPanel.showAddDoctorPanel(doctorId, "view");
        }
    }//GEN-LAST:event_vieweDoctorButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addDoctorButton;
    private javax.swing.JButton deleteDoctorButton;
    private javax.swing.JTable doctorsTable;
    private javax.swing.JButton editDoctorButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton vieweDoctorButton;
    // End of variables declaration//GEN-END:variables
}
