package neu.view.panel;

import javax.swing.JPanel;
import neu.data.directory.DoctorDirectory;
import neu.data.model.Doctor;
import neu.view.manager.UIManager;

public class DoctorSinglePanel extends javax.swing.JPanel {
    
    public DoctorSinglePanel(String id) {
        initComponents();
        addDynamicData(id);
    }
    
    private void addDynamicData(String id) {
        Doctor doc = DoctorDirectory.getDoctorByDoctorId(id);
        hospitalTextField.setText(doc.getHospitalId());
        nameLabel.setText(doc.getFirstName());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        hospitalTextField = new javax.swing.JTextField();
        nameLabel = new javax.swing.JLabel();
        specializationLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 204));
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setMaximumSize(new java.awt.Dimension(300, 90));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        hospitalTextField.setEditable(false);
        hospitalTextField.setBackground(new java.awt.Color(204, 255, 102));
        hospitalTextField.setText("Wellness");

        nameLabel.setText("Dr. Sudarshan Kudli");

        specializationLabel.setText("Therapist");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(hospitalTextField)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(specializationLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(177, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(hospitalTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(specializationLabel)
                .addGap(0, 9, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        JPanel panel = (JPanel) evt.getSource();
        Object medicalId = panel.getClientProperty("medicalId");
        UIManager.showDoctorDetails(medicalId.toString());
    }//GEN-LAST:event_formMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField hospitalTextField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel specializationLabel;
    // End of variables declaration//GEN-END:variables
}
