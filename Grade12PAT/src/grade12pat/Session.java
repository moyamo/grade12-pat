/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grade12pat;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author yaseen
 */
public class Session  {
    private JFrame activeFrame = null;
    private MainScreen mainScreen = null;
    private User loggedInUser = null;
    private Settings settings = null;
    private EntityManager entityManager = null;
    
    public void disposeIfNotNull() {
        if (activeFrame != null) activeFrame.dispose();
    }
    
    public void showLoginScreen() {
        disposeIfNotNull();
        activeFrame = new LoginScreen(this);
        activeFrame.setVisible(true);
    }
    
    public void showMainScreen() {
        disposeIfNotNull();
        mainScreen = new MainScreen(this);
        activeFrame = mainScreen;
        activeFrame.setVisible(true);
    }
    public void showAppointments() {
        boolean alreadyOpen = false;
        int i = 0;
        JPanel tab = mainScreen.getTab(i);
        for ( ; tab != null; i++, tab = mainScreen.getTab(i)) {
            if (tab.getClass() == AppointmentBookPanel.class) {
                mainScreen.setFocus(i);
                alreadyOpen = true;
                break;
            }
        }
        if (!alreadyOpen) {
            mainScreen.addTab("Appointments", new AppointmentBookPanel(this));
        }
    }
    
    public void showAddAppointment() {
        mainScreen.addTab("Add Appointments", new AddAppointmentPanel());
    }
    
    public void showRecordPayment() {
        mainScreen.addTab("Record Payment", new ReceivePaymentPanel());
    }
    public void addNewPatient() {
       mainScreen.addTab("Add Patient", new AddPatientPanel(this));
    }
    
    public void showManageUsers() {
        mainScreen.addTab("Users", new ManageUsersPanel());
    }
    
    // TODO move login logic to here
    public void setLoggedInUser(User user) {
        loggedInUser = user;
        try {
            entityManager = Persistence.createEntityManagerFactory("Grade12PATPU").createEntityManager();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(activeFrame, "Unable to connect to Database. Make sure it is running.", "Database Connection Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void showSetup() {
        disposeIfNotNull();
        activeFrame = new Setup(settings);
        activeFrame.setVisible(true);
    }
    
    public void showViewBillingDetails(RcdPatient patient) {
        mainScreen.addTab("Edit Billing Details", new BillingDetailsPanel(this));
    }
    
    public void showBillPatient() {
        mainScreen.addTab("Bill patient", new BillPatientPanel());
    }
    
    public void showBillingItems() {
        mainScreen.addTab("Edit Billing Items", new AddBillingItemPanel());
    }
    
    public void showGraph(List<RcdPatientReadings> readings, String title) {
        disposeIfNotNull();
        activeFrame = new GraphView(readings, title);
        activeFrame.setVisible(true);
    }
    
    public void showPrintStatements() {
        mainScreen.addTab("Statements", new PrintStatementsPanel());
    }
    
    
    public void loadSettings() {
        settings = Settings.loadSettingsFromFile();
        if (settings == null) {
            JOptionPane.showMessageDialog(null, "You must enter the settings before proceeding");
            showSetup();
            activeFrame.addWindowListener(new SettingsRepeater());
        } else {
            showMainScreen();
        }
    }
    
    public EntityManager getEntityManager() {
        return this.entityManager;
    }
    
    public List sqlQuery(String query, Class resultClass) {
        Query q =  this.entityManager.createNativeQuery(query, resultClass);
        return q.getResultList();
    }
    
     public List sqlQuery(String query) {
        Query q =  this.entityManager.createNativeQuery(query);
        return q.getResultList();
    }
     
    public int nextId(String table) {
        Object biggestId = sqlQuery("SELECT MAX(id) FROM " + table).get(0);
        int id;
        if (biggestId == null) {
            id = 1;
        } else {
            id = ((int) biggestId) + 1;
        }
        return id;
    }
    public Settings getSettings(){
        return this.settings;
    }

    void showViewMedicalHistory() {
        JPanel wrapper = new JPanel();
        JScrollPane scroll = new JScrollPane();
        scroll.setViewportView(new MedicalHistoryPanel(this));
        wrapper.setLayout(new GridLayout(1, 1));
        wrapper.add(scroll);
        mainScreen.addTab("Medical History", wrapper);
    }

    void showEditMedicalAid() {
        this.mainScreen.addTab("Medical Aid Details", new MedicalAidPlan());
    }

   
    
    class SettingsRepeater implements WindowListener{
        @Override
        public void windowOpened(WindowEvent we) {
        }

        @Override
        public void windowClosing(WindowEvent we) {
        }

        @Override
        public void windowClosed(WindowEvent we) {
            settings = Settings.loadSettingsFromFile();
                if (settings == null) {
                    JOptionPane.showMessageDialog(null, "You must enter the settings before proceeding");
                    showSetup();
                    activeFrame.addWindowListener(this);
                } else {
                showAppointments();
                }
        }

        @Override
        public void windowIconified(WindowEvent we) {
        }

        @Override
        public void windowDeiconified(WindowEvent we) {
        }

        @Override
        public void windowActivated(WindowEvent we) {
        }

        @Override
        public void windowDeactivated(WindowEvent we) {
        }
    }
}
