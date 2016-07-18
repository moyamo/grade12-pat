/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grade12pat;

import javax.swing.JFrame;

/**
 *
 * @author yaseen
 */
public class Session {
    private JFrame activeFrame = null;
    private User loggedInUser = null;
    
    public void showLoginScreen() {
        activeFrame = new LoginScreen(this);
        activeFrame.setVisible(true);
    }
    
    public void showAppointments() {
        activeFrame.dispose();
        activeFrame = new AppointmentBook();
        activeFrame.setVisible(true);
    }
    
    // TODO move login logic to here
    public void setLoggedInUser(User user) {
        loggedInUser = user;
    }
}
