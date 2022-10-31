package neu.view.panel;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import neu.data.constants.AccessLevels;
import neu.data.directory.AdminDirectory;
import neu.data.directory.DoctorDirectory;
import neu.data.directory.HospitalDirectory;
import neu.data.model.Community;
import neu.data.model.Doctor;
import neu.data.model.Hospital;
import neu.data.model.Person;
import neu.util.customTypes.Address;

public class HospitalListPanel extends javax.swing.JPanel {
    private String personId;
    private String access;

    public HospitalListPanel(String access, String personId) {
        this.access = access;
        this.personId = personId;
        initComponents();
        addHospitalsToPanel();
    }
    
    public void addHospitalsToPanel() {
        if (access.equals(AccessLevels.getSystemAdminAccess())) {
            DefaultTableModel model = (DefaultTableModel) hospitalsTable.getModel();
            model.setRowCount(0);
            Object rowData[] = new Object[5];
            for (Hospital hos : HospitalDirectory.getListOfHospitals()) {
                rowData[0] = hos.getName();
                rowData[1] = hos.getHospitalId();
                Address add = hos.getContactInfo().listOfAddress.get(0);
                rowData[2] = add.address+", "+add.city+", "+add.zip;
                rowData[3] = hos.getContactInfo().listOfEmails.get(0).email;
                rowData[4] = hos.getContactInfo().listOfPhoneNumbers.get(0).number;
                model.addRow(rowData);
            }
        } else if (access.equals(AccessLevels.getHospitalAdminAccess())) {
            DefaultTableModel model = (DefaultTableModel) hospitalsTable.getModel();
            model.setRowCount(0);
            Object rowData[] = new Object[5];
            for (Hospital hos : HospitalDirectory.getListOfHospitals()) {
                if (hos.getAdminId().equals(this.personId)) {
                    rowData[0] = hos.getName();
                    rowData[1] = hos.getHospitalId();
                    Address add = hos.getContactInfo().listOfAddress.get(0);
                    rowData[2] = add.address+", "+add.city+", "+add.zip;
                    rowData[3] = hos.getContactInfo().listOfEmails.get(0).email;
                    rowData[4] = hos.getContactInfo().listOfPhoneNumbers.get(0).number;
                    model.addRow(rowData);
                }

            }
        } else if (access.equals(AccessLevels.getCommunityAdminAccess())) {
            DefaultTableModel model = (DefaultTableModel) hospitalsTable.getModel();
            model.setRowCount(0);
            Object rowData[] = new Object[5];
            for (Hospital hos : HospitalDirectory.getListOfHospitals()) {
                Person admin = AdminDirectory.getAdminByPersonId(personId);
                if (hos.getContactInfo().listOfAddress.get(0).zip.equals(admin.getContactInfo().listOfAddress.get(0).zip)) {
                    rowData[0] = hos.getName();
                    rowData[1] = hos.getHospitalId();
                    Address add = hos.getContactInfo().listOfAddress.get(0);
                    rowData[2] = add.address+", "+add.city+", "+add.zip;
                    rowData[3] = hos.getContactInfo().listOfEmails.get(0).email;
                    rowData[4] = hos.getContactInfo().listOfPhoneNumbers.get(0).number;
                    model.addRow(rowData);
                }

            }
        }
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        hospitalsTable = new javax.swing.JTable();
        addHospitalButton = new javax.swing.JButton();
        editHospitalButton = new javax.swing.JButton();
        deleteHospitalButton = new javax.swing.JButton();
        vieweHospitalButton = new javax.swing.JButton();

        hospitalsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Name", "ID", "Address", "Email", "Phone"
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
        jScrollPane1.setViewportView(hospitalsTable);
        if (hospitalsTable.getColumnModel().getColumnCount() > 0) {
            hospitalsTable.getColumnModel().getColumn(1).setPreferredWidth(50);
            hospitalsTable.getColumnModel().getColumn(1).setMaxWidth(50);
            hospitalsTable.getColumnModel().getColumn(4).setPreferredWidth(150);
            hospitalsTable.getColumnModel().getColumn(4).setMaxWidth(150);
        }

        addHospitalButton.setText("Add");
        addHospitalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addHospitalButtonActionPerformed(evt);
            }
        });

        editHospitalButton.setText("Edit");
        editHospitalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editHospitalButtonActionPerformed(evt);
            }
        });

        deleteHospitalButton.setText("Delete");
        deleteHospitalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteHospitalButtonActionPerformed(evt);
            }
        });

        vieweHospitalButton.setText("View");
        vieweHospitalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vieweHospitalButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(217, 217, 217)
                .addComponent(addHospitalButton)
                .addGap(36, 36, 36)
                .addComponent(editHospitalButton)
                .addGap(57, 57, 57)
                .addComponent(deleteHospitalButton)
                .addGap(29, 29, 29)
                .addComponent(vieweHospitalButton)
                .addContainerGap(223, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addHospitalButton)
                    .addComponent(editHospitalButton)
                    .addComponent(deleteHospitalButton)
                    .addComponent(vieweHospitalButton))
                .addGap(0, 14, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addHospitalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addHospitalButtonActionPerformed
        System.out.println(access);
        if (access.equals(AccessLevels.getSystemAdminAccess())) {
            SystemAdminPanel.showAddHospitalPanel("", "add");
        }
    }//GEN-LAST:event_addHospitalButtonActionPerformed

    private void editHospitalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editHospitalButtonActionPerformed
        if (access.equals(AccessLevels.getSystemAdminAccess())) {
            if (hospitalsTable.getSelectedRow() != -1) {
                int row = hospitalsTable.getSelectedRow();
                String hospitalId = hospitalsTable.getModel().getValueAt(row, 1).toString();
                SystemAdminPanel.showAddHospitalPanel(hospitalId, "edit");
            }
        } else if (access.equals(AccessLevels.getHospitalAdminAccess())) {
            if (hospitalsTable.getSelectedRow() != -1) {
                int row = hospitalsTable.getSelectedRow();
                String hospitalId = hospitalsTable.getModel().getValueAt(row, 1).toString();
                HospitalAdminPanel.showAddHospitalPanel(hospitalId, "edit");
            }
        }
        
    }//GEN-LAST:event_editHospitalButtonActionPerformed

    private void deleteHospitalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteHospitalButtonActionPerformed
        if (hospitalsTable.getSelectedRow() != -1) {
            DefaultTableModel model = (DefaultTableModel) hospitalsTable.getModel();
            int row = hospitalsTable.getSelectedRow();
            String doctorId = hospitalsTable.getModel().getValueAt(row, 1).toString();
            if (HospitalDirectory.deleteHospital(doctorId)) {
                model.removeRow(hospitalsTable.getSelectedRow());
                JOptionPane.showMessageDialog(null, "Deleted successfully");
            } else {
                JOptionPane.showMessageDialog(null, "Record not found");
            }
        }
    }//GEN-LAST:event_deleteHospitalButtonActionPerformed

    private void vieweHospitalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vieweHospitalButtonActionPerformed
        if (hospitalsTable.getSelectedRow() != -1) {
            int row = hospitalsTable.getSelectedRow();
            String doctorId = hospitalsTable.getModel().getValueAt(row, 1).toString();
            SystemAdminPanel.showAddDoctorPanel(doctorId, "view");
        }
    }//GEN-LAST:event_vieweHospitalButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addHospitalButton;
    private javax.swing.JButton deleteHospitalButton;
    private javax.swing.JButton editHospitalButton;
    private javax.swing.JTable hospitalsTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton vieweHospitalButton;
    // End of variables declaration//GEN-END:variables
}
