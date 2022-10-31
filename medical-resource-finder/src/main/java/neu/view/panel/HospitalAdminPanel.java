package neu.view.panel;

import java.awt.FlowLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import neu.data.constants.AccessLevels;
import neu.data.directory.AdminDirectory;
import neu.data.model.Person;
import neu.view.manager.UIManager;
import static neu.view.panel.SystemAdminPanel.removeAndAddPanel;

public class HospitalAdminPanel extends javax.swing.JPanel {

    public HospitalAdminPanel() {
        initComponents();
    }
    
    private static String personId;
    private static final String ACCESS = AccessLevels.getHospitalAdminAccess();

    public HospitalAdminPanel(String personId) {
        this.personId = personId;
        initComponents();
        addHospitals();
        addPatients();
        addDoctors();
        addProfileDetails();
    }
    
    public static void addProfileDetails() {
        Person com = AdminDirectory.getAdminByPersonId(personId);
        fullnameLabel.setText(com.getFullName());
        genderField.setText(com.getGender());
        //ageField.setText(Integer.toString(com.getDateOfBirth().calculateAgeInYears()));
        ImageIcon icon = new ImageIcon(new ImageIcon(com.getPhotoPath()).getImage().getScaledInstance(130, 170, Image.SCALE_DEFAULT));
        photoLabel.setIcon(icon);
    }
    
    public static void goBack(String panel) {
        switch (panel) {
            case "Hospitals":
                removeAndAddPanel(new HospitalListPanel(ACCESS, personId), hospitalPanel);
            case "Patients":
                removeAndAddPanel(new PatientListPanel(ACCESS, personId), patientPanel); 
            case "Doctors":
                removeAndAddPanel(new DoctorListPanel(ACCESS, personId), doctorPanel); 
        }
    }
    
    public static void showAddDoctorPanel(String id, String mode) {
        removeAndAddPanel(new AddDoctorPanel(id, mode, ACCESS), doctorPanel);
    }
    
    public static void showAddHospitalPanel(String id, String mode) {
        System.out.println("saa");
        removeAndAddPanel(new AddHospitalPanel(id, mode, ACCESS), hospitalPanel);
    }
    
    private void addHospitals() {
        removeAndAddPanel(new HospitalListPanel(ACCESS, personId), hospitalPanel);
    }
    
    private void addPatients() {
        removeAndAddPanel(new PatientListPanel(ACCESS, personId), patientPanel);
    }
    
    private void addDoctors() {
        removeAndAddPanel(new DoctorListPanel(ACCESS, personId), doctorPanel);
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

        jTabbedPane = new javax.swing.JTabbedPane();
        hospitalPanel = new javax.swing.JPanel();
        patientPanel = new javax.swing.JPanel();
        doctorPanel = new javax.swing.JPanel();
        PatientProfilePanel = new javax.swing.JPanel();
        photoLabel = new javax.swing.JLabel();
        fullnameLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ageField = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        genderField = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        actionsPanel = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        backimageadminpanel = new javax.swing.JLabel();

        javax.swing.GroupLayout hospitalPanelLayout = new javax.swing.GroupLayout(hospitalPanel);
        hospitalPanel.setLayout(hospitalPanelLayout);
        hospitalPanelLayout.setHorizontalGroup(
            hospitalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 850, Short.MAX_VALUE)
        );
        hospitalPanelLayout.setVerticalGroup(
            hospitalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 470, Short.MAX_VALUE)
        );

        jTabbedPane.addTab("My Hospitals", hospitalPanel);

        javax.swing.GroupLayout patientPanelLayout = new javax.swing.GroupLayout(patientPanel);
        patientPanel.setLayout(patientPanelLayout);
        patientPanelLayout.setHorizontalGroup(
            patientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 850, Short.MAX_VALUE)
        );
        patientPanelLayout.setVerticalGroup(
            patientPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 470, Short.MAX_VALUE)
        );

        jTabbedPane.addTab("Patients", patientPanel);

        javax.swing.GroupLayout doctorPanelLayout = new javax.swing.GroupLayout(doctorPanel);
        doctorPanel.setLayout(doctorPanelLayout);
        doctorPanelLayout.setHorizontalGroup(
            doctorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 850, Short.MAX_VALUE)
        );
        doctorPanelLayout.setVerticalGroup(
            doctorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 470, Short.MAX_VALUE)
        );

        jTabbedPane.addTab("Doctors", doctorPanel);

        photoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        fullnameLabel.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        fullnameLabel.setText("Sudarshan Kudli");

        jLabel2.setText("Age: ");

        ageField.setText("24");

        jLabel4.setText("Sex:");

        genderField.setText("Male");

        jLabel6.setText("Latest Vital Signs");

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
                        .addComponent(fullnameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap(595, Short.MAX_VALUE))
                    .addGroup(PatientProfilePanelLayout.createSequentialGroup()
                        .addGroup(PatientProfilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PatientProfilePanelLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(genderField))
                            .addComponent(jLabel6)
                            .addGroup(PatientProfilePanelLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ageField)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                            .addComponent(ageField))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PatientProfilePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(genderField))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6))
                    .addComponent(photoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(305, Short.MAX_VALUE))
        );

        jTabbedPane.addTab("Profile", PatientProfilePanel);

        actionsPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setText("Logout");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        actionsPanel.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 200, -1, -1));

        backimageadminpanel.setIcon(new javax.swing.ImageIcon("/Users/skudli/Downloads/UI IMAGES/hospital admin panel.jpeg")); // NOI18N
        actionsPanel.add(backimageadminpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 470));

        jTabbedPane.addTab("Actions", actionsPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        UIManager.showLoginPanel();
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PatientProfilePanel;
    private javax.swing.JPanel actionsPanel;
    private static javax.swing.JLabel ageField;
    private javax.swing.JLabel backimageadminpanel;
    private static javax.swing.JPanel doctorPanel;
    private static javax.swing.JLabel fullnameLabel;
    private static javax.swing.JLabel genderField;
    private static javax.swing.JPanel hospitalPanel;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTabbedPane jTabbedPane;
    private static javax.swing.JPanel patientPanel;
    private static javax.swing.JLabel photoLabel;
    // End of variables declaration//GEN-END:variables
}
