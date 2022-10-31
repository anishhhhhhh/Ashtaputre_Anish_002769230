
package neu.view.panel;

import java.io.PrintStream;
import neu.view.manager.UIManager;
import neu.data.auth.*;
import neu.data.directory.*;
import neu.data.constants.*;
import neu.data.model.Person;
import neu.util.swing.SwingUtils;

public class LoginPanel extends javax.swing.JPanel {
    PrintStream sout = System.out;

    public LoginPanel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        accessButtonGroup = new javax.swing.ButtonGroup();
        usernameField = new javax.swing.JTextField();
        passwordField = new javax.swing.JPasswordField();
        usernameLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        adminRadioButton = new javax.swing.JRadioButton();
        patientRadioButton = new javax.swing.JRadioButton();
        doctorRadioButton = new javax.swing.JRadioButton();
        loginButton = new javax.swing.JButton();
        adminRadioButton1 = new javax.swing.JRadioButton();
        adminRadioButton2 = new javax.swing.JRadioButton();
        bckimg = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 204));

        usernameField.setText("HOS4");
        usernameField.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), javax.swing.BorderFactory.createEmptyBorder(2, 8, 2, 8)));
        usernameField.setMargin(new java.awt.Insets(2, 10, 2, 10));
        usernameField.setMinimumSize(new java.awt.Dimension(235, 29));
        usernameField.setPreferredSize(new java.awt.Dimension(235, 29));
        usernameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameFieldActionPerformed(evt);
            }
        });

        passwordField.setText("test");
        passwordField.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), javax.swing.BorderFactory.createEmptyBorder(2, 8, 2, 8)));
        passwordField.setMinimumSize(new java.awt.Dimension(235, 29));
        passwordField.setPreferredSize(new java.awt.Dimension(235, 29));
        passwordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordFieldActionPerformed(evt);
            }
        });

        usernameLabel.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        usernameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        usernameLabel.setText("Username");

        passwordLabel.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        passwordLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        passwordLabel.setText("Password");

        accessButtonGroup.add(adminRadioButton);
        adminRadioButton.setSelected(true);
        adminRadioButton.setText("Hospital Admin");
        adminRadioButton.setActionCommand("hos_adm");
        adminRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminRadioButtonActionPerformed(evt);
            }
        });

        accessButtonGroup.add(patientRadioButton);
        patientRadioButton.setText("Patient");
        patientRadioButton.setActionCommand("patient");
        patientRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                patientRadioButtonActionPerformed(evt);
            }
        });

        accessButtonGroup.add(doctorRadioButton);
        doctorRadioButton.setText("Doctor");
        doctorRadioButton.setActionCommand("doctor");
        doctorRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doctorRadioButtonActionPerformed(evt);
            }
        });

        loginButton.setBackground(new java.awt.Color(153, 153, 153));
        loginButton.setText("Login");
        loginButton.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(153, 153, 153), 1, true));
        loginButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        loginButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        accessButtonGroup.add(adminRadioButton1);
        adminRadioButton1.setText("Community Admin");
        adminRadioButton1.setActionCommand("com_adm");

        accessButtonGroup.add(adminRadioButton2);
        adminRadioButton2.setText("System Admin");
        adminRadioButton2.setActionCommand("sys_adm");

        bckimg.setIcon(new javax.swing.ImageIcon("/Users/skudli/Downloads/UI IMAGES/LOG IN.jpeg")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(461, 461, 461)
                        .addComponent(adminRadioButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(284, 284, 284)
                        .addComponent(adminRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(388, 388, 388)
                        .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(275, 275, 275)
                        .addComponent(usernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(373, 373, 373)
                        .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(275, 275, 275)
                        .addComponent(passwordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(284, 284, 284)
                        .addComponent(patientRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(373, 373, 373)
                        .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(451, 451, 451)
                        .addComponent(adminRadioButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(371, 371, 371)
                        .addComponent(doctorRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(bckimg, javax.swing.GroupLayout.PREFERRED_SIZE, 850, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(229, 229, 229)
                        .addComponent(adminRadioButton)
                        .addGap(18, 18, 18)
                        .addComponent(adminRadioButton1)
                        .addGap(52, 52, 52)
                        .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(usernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addComponent(passwordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(229, 229, 229)
                        .addComponent(patientRadioButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(268, 268, 268)
                        .addComponent(adminRadioButton2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(229, 229, 229)
                        .addComponent(doctorRadioButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(bckimg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void usernameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameFieldActionPerformed

    private void passwordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordFieldActionPerformed

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        String id = usernameField.getText();
        String password = passwordField.getText();
        String access = SwingUtils.getSelectedButtonText(accessButtonGroup);
        Person p = AuthManager.checkIfPersonExists(id, access);
        if (p != null) {
            Boolean isValidPerson = AuthManager.validatePersonCredentials(id, password, access, p);
            if (isValidPerson && p.getAccess().equals(AccessLevels.getPatientAccess())) {
                UIManager.showPatientFrame(usernameField.getText());
            } else if (isValidPerson && p.getAccess().equals(AccessLevels.getDoctorAccess())) {
                UIManager.showDoctorFrame(usernameField.getText());
            } else if (isValidPerson && p.getAccess().equals(AccessLevels.getSystemAdminAccess())) {
                UIManager.showSystemAdminFrame(usernameField.getText());
            } else if (isValidPerson && p.getAccess().equals(AccessLevels.getCommunityAdminAccess())) {
                UIManager.showCommunityAdminFrame(usernameField.getText());
            } else if (isValidPerson && p.getAccess().equals(AccessLevels.getHospitalAdminAccess())) {
                UIManager.showHospitalAdminFrame(usernameField.getText());
            }
        } else {
            sout.println("Ïnvalid ID");
        }
    }//GEN-LAST:event_loginButtonActionPerformed

    private void doctorRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doctorRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_doctorRadioButtonActionPerformed

    private void patientRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_patientRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_patientRadioButtonActionPerformed

    private void adminRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_adminRadioButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup accessButtonGroup;
    private javax.swing.JRadioButton adminRadioButton;
    private javax.swing.JRadioButton adminRadioButton1;
    private javax.swing.JRadioButton adminRadioButton2;
    private javax.swing.JLabel bckimg;
    private javax.swing.JRadioButton doctorRadioButton;
    private javax.swing.JButton loginButton;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JRadioButton patientRadioButton;
    private javax.swing.JTextField usernameField;
    private javax.swing.JLabel usernameLabel;
    // End of variables declaration//GEN-END:variables
}
