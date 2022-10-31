package neu.view.panel;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import neu.data.constants.AccessLevels;
import neu.data.directory.CommunityDirectory;
import neu.data.directory.DoctorDirectory;
import neu.data.model.Community;
import neu.data.model.Doctor;

public class CommunityListPanel extends javax.swing.JPanel {
    private String personId;
    private String access;

    public CommunityListPanel(String access, String personId) {
        this.access = access;
        this.personId = personId;
        initComponents();
        addCommunitiesToPanel();
    }
    
    private void addCommunitiesToPanel() {
        DefaultTableModel model = (DefaultTableModel) communityPanel.getModel();
        model.setRowCount(0);
        Object rowData[] = new Object[5];
        if (this.access.equals(AccessLevels.getSystemAdminAccess())) {   
            for (Community com : CommunityDirectory.getCommunityList()) {
                addRowData(rowData, com);
                model.addRow(rowData);
            }
        } else if (this.access.equals(AccessLevels.getCommunityAdminAccess())) {
            for (Community com : CommunityDirectory.getCommunityListByCommunityAdmin(this.personId)) {
                addRowData(rowData, com);
                model.addRow(rowData);
            }
        }
    }
    
    public void addRowData(Object[] rowData, Community com) {
        rowData[0] = com.getName();
        rowData[1] = com.getZipCode();
        rowData[2] = com.getListOfPatients().size();
        rowData[3] = com.getListOfDoctors().size();
        rowData[4] = com.getListOfHospitals().size();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        communityPanel = new javax.swing.JTable();
        addCommunityButton = new javax.swing.JButton();
        editCommunityButton = new javax.swing.JButton();
        deleteCommunityButton = new javax.swing.JButton();
        viewCommunityButton = new javax.swing.JButton();

        communityPanel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Name", "zip", "Number of Patients", "Number of Doctors", "Number of Hospitals"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
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
        jScrollPane1.setViewportView(communityPanel);
        if (communityPanel.getColumnModel().getColumnCount() > 0) {
            communityPanel.getColumnModel().getColumn(1).setPreferredWidth(100);
            communityPanel.getColumnModel().getColumn(1).setMaxWidth(100);
            communityPanel.getColumnModel().getColumn(2).setPreferredWidth(130);
            communityPanel.getColumnModel().getColumn(2).setMaxWidth(130);
            communityPanel.getColumnModel().getColumn(3).setPreferredWidth(130);
            communityPanel.getColumnModel().getColumn(3).setMaxWidth(130);
            communityPanel.getColumnModel().getColumn(4).setPreferredWidth(130);
            communityPanel.getColumnModel().getColumn(4).setMaxWidth(130);
        }

        addCommunityButton.setText("Add");
        addCommunityButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCommunityButtonActionPerformed(evt);
            }
        });

        editCommunityButton.setText("Edit");
        editCommunityButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editCommunityButtonActionPerformed(evt);
            }
        });

        deleteCommunityButton.setText("Delete");
        deleteCommunityButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteCommunityButtonActionPerformed(evt);
            }
        });

        viewCommunityButton.setText("View");
        viewCommunityButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewCommunityButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(217, 217, 217)
                .addComponent(addCommunityButton)
                .addGap(36, 36, 36)
                .addComponent(editCommunityButton)
                .addGap(57, 57, 57)
                .addComponent(deleteCommunityButton)
                .addGap(29, 29, 29)
                .addComponent(viewCommunityButton)
                .addContainerGap(223, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addCommunityButton)
                    .addComponent(editCommunityButton)
                    .addComponent(deleteCommunityButton)
                    .addComponent(viewCommunityButton))
                .addGap(0, 14, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addCommunityButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCommunityButtonActionPerformed
        if (access.equals(AccessLevels.getCommunityAdminAccess())) {
            CommunityAdminPanel.showAddCommunityPanel("add", "");
        } else if (access.equals(AccessLevels.getSystemAdminAccess())) {
            SystemAdminPanel.showAddCommunityPanel("add", "");
        }
    }//GEN-LAST:event_addCommunityButtonActionPerformed

    private void editCommunityButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editCommunityButtonActionPerformed
        if (communityPanel.getSelectedRow() != -1) {
            int row = communityPanel.getSelectedRow();
            String zip = communityPanel.getModel().getValueAt(row, 1).toString();
            if (access.equals(AccessLevels.getCommunityAdminAccess())) {
                CommunityAdminPanel.showAddCommunityPanel("edit", zip);
            } else if (access.equals(AccessLevels.getSystemAdminAccess())) {
                SystemAdminPanel.showAddCommunityPanel("edit", zip);
            }
        }
    }//GEN-LAST:event_editCommunityButtonActionPerformed

    private void deleteCommunityButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteCommunityButtonActionPerformed
        if (communityPanel.getSelectedRow() != -1) {
            DefaultTableModel model = (DefaultTableModel) communityPanel.getModel();
            int row = communityPanel.getSelectedRow();
            String zip = communityPanel.getModel().getValueAt(row, 1).toString();
            if (CommunityDirectory.deleteCommunity(zip)) {
                model.removeRow(communityPanel.getSelectedRow());
                JOptionPane.showMessageDialog(null, "Deleted successfully");
            } else {
                JOptionPane.showMessageDialog(null, "Record not found");
            }
        }
    }//GEN-LAST:event_deleteCommunityButtonActionPerformed

    private void viewCommunityButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewCommunityButtonActionPerformed
        addCommunitiesToPanel();
    }//GEN-LAST:event_viewCommunityButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addCommunityButton;
    private javax.swing.JTable communityPanel;
    private javax.swing.JButton deleteCommunityButton;
    private javax.swing.JButton editCommunityButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton viewCommunityButton;
    // End of variables declaration//GEN-END:variables
}
