package neu.view.manager;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.ScrollPane;

import neu.data.directory.*;
import neu.data.model.*;
import neu.view.frame.*;
import neu.view.panel.*;

public class UIManager {
    public static MainFrame frame = new MainFrame();
    private static LoginPanel lPanel;
    private static PatientPanel pPanel;
    private static DoctorPanel dPanel;
    private static SystemAdminPanel sysPanel;
    private static CommunityAdminPanel comPanel;
    private static HospitalAdminPanel hosPanel;
    
    public UIManager() {
        frame.setLayout(new FlowLayout());
        frame.setVisible(true);
        lPanel = new LoginPanel();
        removeAndAddPanel(lPanel);
    }
    
    public static void showLoginPanel() {
        removeAndAddPanel(lPanel);
    }
    
    public static void showPatientFrame(String patientId) {
        pPanel = new PatientPanel(patientId);
        pPanel.setVisible(true);
        pPanel.setLayout(new FlowLayout());
        
        removeAndAddPanel(pPanel);
    }
    
    public static void showDoctorFrame(String doctorId) {
        dPanel = new DoctorPanel(doctorId);
        dPanel.setVisible(true);
        dPanel.setLayout(new FlowLayout());
        
        removeAndAddPanel(dPanel);
    }
    
    public static void showSystemAdminFrame(String sysAdmId) {
        sysPanel = new SystemAdminPanel(sysAdmId);
        sysPanel.setVisible(true);
        sysPanel.setLayout(new FlowLayout());
        
        removeAndAddPanel(sysPanel);
    }
    
    public static void showCommunityAdminFrame(String comAdmId) {
        comPanel = new CommunityAdminPanel(comAdmId);
        comPanel.setVisible(true);
        comPanel.setLayout(new FlowLayout());
        
        removeAndAddPanel(comPanel);
    }
    
    public static void showHospitalAdminFrame(String hosAdmId) {
        hosPanel = new HospitalAdminPanel(hosAdmId);
        hosPanel.setVisible(true);
        hosPanel.setLayout(new FlowLayout());
        
        removeAndAddPanel(hosPanel);
    }
    
    public static void showDoctorDetails(String id) {
        removeAndAddPanel(new DoctorProfilePanel(id));
    }  
    
    public static void removeDoctorProfilePanel() {
        removeAndAddPanel(pPanel);
    }
    
    private static void removeAndAddPanel(javax.swing.JPanel panel) {
        frame.getContentPane().removeAll();
        frame.add(panel);
        frame.repaint();
        frame.revalidate();
    }
}
