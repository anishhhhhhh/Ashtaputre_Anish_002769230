package neu.view.panel;

import java.awt.Image;
import javax.swing.ImageIcon;
import neu.data.directory.DoctorDirectory;
import neu.data.model.Doctor;
import neu.view.manager.UIManager;

public class DoctorProfilePanel extends javax.swing.JPanel {
    
    private String personId;

    public DoctorProfilePanel(String personId) {
        this.personId = personId;
        initComponents();
        loadData();
    }
    
    public void disableBackButton() {
        backButton.setEnabled(false);
        backButton.setVisible(false);
    }
    
    private void loadData() {
        Doctor doc = DoctorDirectory.getDoctorByPersonId(personId);
        nameLabel.setText(doc.getFullName());
        specializationLabel.setText(doc.getSpecialization());
        numberLabel.setText(doc.getContactInfo().listOfPhoneNumbers.get(0).number);
        emailLabel.setText(doc.getContactInfo().listOfEmails.get(0).email);
        ImageIcon icon = new ImageIcon(new ImageIcon(doc.getPhotoPath()).getImage().getScaledInstance(130, 170, Image.SCALE_DEFAULT));
        photoLabel.setIcon(icon);
        
        aboutTextField.setText("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages.");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nameLabel = new java.awt.Label();
        specializationLabel = new java.awt.Label();
        contactLabel = new java.awt.Label();
        numberLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        aboutLabel = new java.awt.Label();
        photoLabel = new javax.swing.JLabel();
        specialitiesLabel = new javax.swing.JLabel();
        specialitiesTextArea = new javax.swing.JTextArea();
        qualificationsLabel = new javax.swing.JLabel();
        qualificationsTextField = new javax.swing.JTextArea();
        aboutTextField = new javax.swing.JTextArea();
        backButton = new javax.swing.JButton();

        nameLabel.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        nameLabel.setText("Sudarshan Kudli");

        specializationLabel.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
        specializationLabel.setText("Therapist (Boston, MA)");

        contactLabel.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        contactLabel.setName(""); // NOI18N
        contactLabel.setText("Contact");

        numberLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 12)); // NOI18N
        numberLabel.setText("8577990481");

        emailLabel.setFont(new java.awt.Font("Helvetica Neue", 0, 12)); // NOI18N
        emailLabel.setText("sudarshan97.kudli@gmail.com");

        aboutLabel.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        aboutLabel.setText("About");

        photoLabel.setBackground(new java.awt.Color(153, 153, 153));
        photoLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        specialitiesLabel.setFont(new java.awt.Font("Helvetica Neue", 1, 12)); // NOI18N
        specialitiesLabel.setText("Specialities");

        specialitiesTextArea.setBackground(new java.awt.Color(242, 242, 242));
        specialitiesTextArea.setColumns(20);
        specialitiesTextArea.setFont(new java.awt.Font("Helvetica Neue", 0, 12)); // NOI18N
        specialitiesTextArea.setRows(5);
        specialitiesTextArea.setText("Life Transitions\nRelationship Issues\nMood Disorders");
        specialitiesTextArea.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        qualificationsLabel.setFont(new java.awt.Font("Helvetica Neue", 1, 12)); // NOI18N
        qualificationsLabel.setText("Qualifications");

        qualificationsTextField.setBackground(new java.awt.Color(242, 242, 242));
        qualificationsTextField.setColumns(20);
        qualificationsTextField.setFont(new java.awt.Font("Helvetica Neue", 0, 12)); // NOI18N
        qualificationsTextField.setRows(5);
        qualificationsTextField.setText("Years in Practice: 9\nLicence: Massachusetts/120763");
        qualificationsTextField.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        aboutTextField.setBackground(new java.awt.Color(242, 242, 242));
        aboutTextField.setColumns(20);
        aboutTextField.setLineWrap(true);
        aboutTextField.setRows(5);
        aboutTextField.setWrapStyleWord(true);
        aboutTextField.setPreferredSize(new java.awt.Dimension(400, 80));

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(backButton)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(specialitiesLabel)
                            .addComponent(specialitiesTextArea, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(qualificationsLabel)
                            .addComponent(photoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(qualificationsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(aboutLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(specializationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(contactLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(numberLabel)
                            .addComponent(emailLabel)
                            .addComponent(aboutTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(195, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(photoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(specialitiesLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(specialitiesTextArea, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(qualificationsLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(qualificationsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(specializationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(contactLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(numberLabel)
                        .addGap(3, 3, 3)
                        .addComponent(emailLabel)
                        .addGap(16, 16, 16)
                        .addComponent(aboutLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(aboutTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(backButton)
                .addGap(38, 38, 38))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        UIManager.removeDoctorProfilePanel();
    }//GEN-LAST:event_backButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Label aboutLabel;
    private javax.swing.JTextArea aboutTextField;
    private javax.swing.JButton backButton;
    private java.awt.Label contactLabel;
    private javax.swing.JLabel emailLabel;
    private java.awt.Label nameLabel;
    private javax.swing.JLabel numberLabel;
    private javax.swing.JLabel photoLabel;
    private javax.swing.JLabel qualificationsLabel;
    private javax.swing.JTextArea qualificationsTextField;
    private javax.swing.JLabel specialitiesLabel;
    private javax.swing.JTextArea specialitiesTextArea;
    private java.awt.Label specializationLabel;
    // End of variables declaration//GEN-END:variables
}
