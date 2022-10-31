package neu.view.panel;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import neu.data.directory.*;
import neu.data.model.Doctor;
import neu.data.model.Encounter;

public class EncounterListPanel extends javax.swing.JPanel {

    public EncounterListPanel(List<Encounter> encounterList) {
        initComponents();
        addEncountersToPanel();
    }
    
    private void addEncountersToPanel() {
        DefaultTableModel model = (DefaultTableModel) encountersTable.getModel();
        model.setRowCount(0);
        Object rowData[] = new Object[8];
        for (Encounter enc : EncounterDirectory.getEncounterList()) {
            rowData[0] = DoctorDirectory.getDoctorByPersonId(enc.getDoctorId()).getFullName();
            rowData[1] = PatientDirectory.getPatientByPersonId(enc.getPatientId()).getFullName();
            rowData[2] = enc.getDate().getFormattedDate();
            rowData[3] = enc.getVitalSigns().getBloodPressure();
            rowData[4] = enc.getVitalSigns().getBodyTemperature();
            rowData[5] = enc.getVitalSigns().getPulseRate();
            rowData[6] = enc.getVitalSigns().getRespirationRate();
            rowData[7] = enc.getEncounterId();
            model.addRow(rowData);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        encountersTable = new javax.swing.JTable();
        addEncounterButton = new javax.swing.JButton();
        editEncounterButton = new javax.swing.JButton();
        deleteEncounterButton = new javax.swing.JButton();
        viewEncounterButton = new javax.swing.JButton();

        encountersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Doctor", "Patient", "Date", "Blood Pressure", "Temperature", "Pulse Rate", "Resp Rate", "ID"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(encountersTable);
        if (encountersTable.getColumnModel().getColumnCount() > 0) {
            encountersTable.getColumnModel().getColumn(7).setPreferredWidth(60);
            encountersTable.getColumnModel().getColumn(7).setMaxWidth(60);
        }

        addEncounterButton.setText("Add");
        addEncounterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEncounterButtonActionPerformed(evt);
            }
        });

        editEncounterButton.setText("Edit");
        editEncounterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editEncounterButtonActionPerformed(evt);
            }
        });

        deleteEncounterButton.setText("Delete");
        deleteEncounterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteEncounterButtonActionPerformed(evt);
            }
        });

        viewEncounterButton.setText("View");
        viewEncounterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewEncounterButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(217, 217, 217)
                .addComponent(addEncounterButton)
                .addGap(36, 36, 36)
                .addComponent(editEncounterButton)
                .addGap(57, 57, 57)
                .addComponent(deleteEncounterButton)
                .addGap(29, 29, 29)
                .addComponent(viewEncounterButton)
                .addContainerGap(223, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addEncounterButton)
                    .addComponent(editEncounterButton)
                    .addComponent(deleteEncounterButton)
                    .addComponent(viewEncounterButton))
                .addGap(0, 14, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addEncounterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEncounterButtonActionPerformed
       // SystemAdminPanel.showAddDoctorPanel("", "add");
    }//GEN-LAST:event_addEncounterButtonActionPerformed

    private void editEncounterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editEncounterButtonActionPerformed
//        if (encountersTable.getSelectedRow() != -1 ) {
//            int row = encountersTable.getSelectedRow();
//            String doctorId = encountersTable.getModel().getValueAt(row, 1).toString();
//            SystemAdminPanel.showAddDoctorPanel(doctorId, "edit");
//        }
    }//GEN-LAST:event_editEncounterButtonActionPerformed

    private void deleteEncounterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteEncounterButtonActionPerformed
        if (encountersTable.getSelectedRow() != -1) {
            DefaultTableModel model = (DefaultTableModel) encountersTable.getModel();
            int row = encountersTable.getSelectedRow();
            String encId = encountersTable.getModel().getValueAt(row, 7).toString();
            if (EncounterDirectory.deleteEncounter(encId)) {
                model.removeRow(encountersTable.getSelectedRow());
                JOptionPane.showMessageDialog(null, "Deleted successfully");
            } else {
                JOptionPane.showMessageDialog(null, "Record not found");
            }
        }
    }//GEN-LAST:event_deleteEncounterButtonActionPerformed

    private void viewEncounterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewEncounterButtonActionPerformed
//        if (encountersTable.getSelectedRow() != -1) {
//            int row = encountersTable.getSelectedRow();
//            String doctorId = encountersTable.getModel().getValueAt(row, 1).toString();
//            SystemAdminPanel.showAddDoctorPanel(doctorId, "view");
//        }
    }//GEN-LAST:event_viewEncounterButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addEncounterButton;
    private javax.swing.JButton deleteEncounterButton;
    private javax.swing.JButton editEncounterButton;
    private javax.swing.JTable encountersTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton viewEncounterButton;
    // End of variables declaration//GEN-END:variables
}
