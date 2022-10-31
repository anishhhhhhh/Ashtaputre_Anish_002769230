package neu.view.panel;

import java.awt.FlowLayout;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import neu.data.constants.AccessLevels;
import neu.data.directory.*;
import neu.data.model.*;
import neu.view.manager.UIManager;

public class SystemAdminPanel extends javax.swing.JPanel {
    
    private static String personId;
    private static final String access = AccessLevels.getSystemAdminAccess();

    public SystemAdminPanel(String sysAdmId) {
        this.personId = sysAdmId;
        initComponents();
        addPatients();
        addDoctors();
        addHospitals();
        addCommunities();
        addEncounters();
    }
    
    private void addPatients() {
        removeAndAddPanel(new PatientListPanel(access, personId), patientPanel);
        addCommunities();
    }
    
    private void addDoctors() {
        removeAndAddPanel(new DoctorListPanel(access, personId), doctorPanel);
        addCommunities();
    }
    
    private void addHospitals() {
        removeAndAddPanel(new HospitalListPanel(access, personId), hospitalPanel);
        addCommunities();
    }
    
    private void addCommunities() {
        removeAndAddPanel(new CommunityListPanel(access, personId), communityPanel);
    }
    
    private void addEncounters() {
        List<Encounter> encounterList = EncounterDirectory.getEncounterList();
        removeAndAddPanel(new EncounterListPanel(encounterList), encounterPanel);
    }
    
    public static void goBack(String panel) {
        switch (panel) {
            case "Patients":
                removeAndAddPanel(new PatientListPanel(access, personId), patientPanel);
            case "Doctors":
                removeAndAddPanel(new DoctorListPanel(access, personId), doctorPanel);
            case "Hospitals":
                removeAndAddPanel(new HospitalListPanel(access, personId), hospitalPanel);
            case "Communities":
                removeAndAddPanel(new CommunityListPanel(access, personId), communityPanel);
        }  
    }
    
    public static void showAddPatientPanel(String id, String mode) {
        removeAndAddPanel(new AddPatientPanel(id, mode, access), patientPanel);
    }
    
    public static void showAddDoctorPanel(String id, String mode) {
        removeAndAddPanel(new AddDoctorPanel(id, mode, access), doctorPanel);
    }
    
    public static void showAddHospitalPanel(String id, String mode) {
        removeAndAddPanel(new AddHospitalPanel(id, mode, access), hospitalPanel);
    }
    
    public static void showAddCommunityPanel(String mode, String zip) {
        removeAndAddPanel(new AddCommunityPanel(personId, mode, access, zip), communityPanel);
    }
    
    public static void showPatientProfilePanel(String patientId) {
        removeAndAddPanel(new DoctorProfilePanel(patientId), patientPanel);
    }
    
    public static void removeAndAddPanel(javax.swing.JPanel panel1, javax.swing.JPanel panel2) {
        panel2.removeAll();
        panel2.add(panel1);
        panel2.setLayout(new FlowLayout());
        panel2.repaint();
        panel2.revalidate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        patientPanel = new javax.swing.JPanel();
        doctorPanel = new javax.swing.JPanel();
        hospitalPanel = new javax.swing.JPanel();
        communityPanel = new javax.swing.JPanel();
        encounterPanel = new javax.swing.JPanel();
        actionsPanel = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        BCKIMGadminap = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout patientPanelLayout = new javax.swing.GroupLayout(patientPanel);
        patientPanel.setLayout(patientPanelLayout);
        patientPanelLayout.setHorizontalGroup(
            patientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 850, Short.MAX_VALUE)
        );
        patientPanelLayout.setVerticalGroup(
            patientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 469, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Patients", patientPanel);

        javax.swing.GroupLayout doctorPanelLayout = new javax.swing.GroupLayout(doctorPanel);
        doctorPanel.setLayout(doctorPanelLayout);
        doctorPanelLayout.setHorizontalGroup(
            doctorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 850, Short.MAX_VALUE)
        );
        doctorPanelLayout.setVerticalGroup(
            doctorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 469, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Doctors", doctorPanel);

        javax.swing.GroupLayout hospitalPanelLayout = new javax.swing.GroupLayout(hospitalPanel);
        hospitalPanel.setLayout(hospitalPanelLayout);
        hospitalPanelLayout.setHorizontalGroup(
            hospitalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 850, Short.MAX_VALUE)
        );
        hospitalPanelLayout.setVerticalGroup(
            hospitalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 469, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Hospitals", hospitalPanel);

        javax.swing.GroupLayout communityPanelLayout = new javax.swing.GroupLayout(communityPanel);
        communityPanel.setLayout(communityPanelLayout);
        communityPanelLayout.setHorizontalGroup(
            communityPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 850, Short.MAX_VALUE)
        );
        communityPanelLayout.setVerticalGroup(
            communityPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 469, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Community", communityPanel);

        javax.swing.GroupLayout encounterPanelLayout = new javax.swing.GroupLayout(encounterPanel);
        encounterPanel.setLayout(encounterPanelLayout);
        encounterPanelLayout.setHorizontalGroup(
            encounterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 850, Short.MAX_VALUE)
        );
        encounterPanelLayout.setVerticalGroup(
            encounterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 469, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Encounters", encounterPanel);

        actionsPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setText("Logout");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        actionsPanel.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 240, 80, -1));

        BCKIMGadminap.setIcon(new javax.swing.ImageIcon("/Users/skudli/Downloads/UI IMAGES/system admin.jpeg")); // NOI18N
        actionsPanel.add(BCKIMGadminap, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jTabbedPane1.addTab("Actions", actionsPanel);

        add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 500));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        UIManager.showLoginPanel();
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BCKIMGadminap;
    private javax.swing.JPanel actionsPanel;
    private static javax.swing.JPanel communityPanel;
    private static javax.swing.JPanel doctorPanel;
    private javax.swing.JPanel encounterPanel;
    private static javax.swing.JPanel hospitalPanel;
    private javax.swing.JButton jButton2;
    private static javax.swing.JTabbedPane jTabbedPane1;
    private static javax.swing.JPanel patientPanel;
    // End of variables declaration//GEN-END:variables
}
