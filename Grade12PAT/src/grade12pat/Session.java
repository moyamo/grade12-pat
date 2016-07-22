/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grade12pat;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author yaseen
 */
public class Session  {
    private JFrame activeFrame = null;
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
    
    public void showAppointments() {
        disposeIfNotNull();
        activeFrame = new AppointmentBook(this);
        activeFrame.setVisible(true);
    }
    
    public void showAddAppointment() {
        disposeIfNotNull();
        activeFrame = new AddAppointment(this);
        activeFrame.setVisible(true);
    }
    
    public void addNewPatient() {
        disposeIfNotNull();
        activeFrame = new AddPatient(this);
        activeFrame.setVisible(true);
    }
    
    // TODO move login logic to here
    public void setLoggedInUser(User user) {
        loggedInUser = user;
        entityManager = Persistence.createEntityManagerFactory("Grade12PATPU").createEntityManager();
    }
    
    public void showSetup() {
        disposeIfNotNull();
        activeFrame = new Setup(settings);
        activeFrame.setVisible(true);
    }
    
    public void loadSettings() {
        settings = Settings.loadSettingsFromFile();
        if (settings == null) {
            JOptionPane.showMessageDialog(null, "You must enter the settings before proceeding");
            showSetup();
            activeFrame.addWindowListener(new SettingsRepeater());
        } else {
            showAppointments();
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

    void showViewMedicalHistory(RcdPatient patient) {
        disposeIfNotNull();
        activeFrame = new MedicalHistory(patient);
        activeFrame.setVisible(true);
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
