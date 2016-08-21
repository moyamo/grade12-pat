/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grade12pat;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.PopupMenuListener;

/**
 *
 * @author yaseen
 */
public class PatientTextField extends JTextField implements DocumentListener {
    private List<RcdPatient> patients;
    private JPopupMenu popup;
    private RcdPatient selectedPatient;
    private Session session;
    private boolean active;
    
    
    public PatientTextField() {
        super();
        getDocument().addDocumentListener(this);
        popup = new JPopupMenu();
    }
    
    public void setList(List<RcdPatient> patients) {
        this.patients = patients;
    }
    
    public void setActive() {
        active = true;
    }
    
    public void refreshList() {
        this.patients = session.sqlQuery("SELECT * FROM Patient", RcdPatient.class);
    }
    
    public void setSession(Session session) {
        this.session = session;
    }
    
    public RcdPatient getSelectedPatient() {
        return selectedPatient;
    }
    
    public void setSelectedPatient(RcdPatient p) {
        selectedPatient = p;
        if (p != null) {
            setText(p.toString());
        } else {
            setText("");
        }
    }
    
    private boolean fuzzyMatch(String substring, String superstring) {
        String regex = ".*";
        for (int i = 0; i < substring.length(); ++i) {
            regex += substring.charAt(i) + ".*";
        }
        return superstring.matches(regex);
    }
    
    public void popupThing() {
        refreshList();
        popup.setVisible(false);
        popup.removeAll();
        ArrayList<RcdPatient> filter = new ArrayList<RcdPatient>();
        for (int i = 0; i < patients.size(); ++i) {
            if (fuzzyMatch(getText(), patients.get(i).toString())) {
                filter.add(patients.get(i));
            }
        }
        for (RcdPatient p: filter) {
            JMenuItem item = new JMenuItem(p.toString());
            
            item.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    setSelectedPatient(p);
                }
            });
            
            popup.add(item);
        }
        
        JMenuItem item = new JMenuItem("Add Patient");
            
        item.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                session.addNewPatient(null);
            }
        });
            
        popup.add(item);
        popup.show(this, 0, 20);
        this.requestFocus();
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        if (this.active){
        popupThing();
        }
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        if (this.active) {
        popupThing();
        }
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        if (this.active) {
            popupThing();
        }
    }

    void active() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}