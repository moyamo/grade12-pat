/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grade12pat;

import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.BadLocationException;
import javax.swing.text.rtf.RTFEditorKit;

/**
 *
 * @author yaseen
 */
public class PrintStatementsPanel extends javax.swing.JPanel {

    Session session;
    List<RcdPatient> patients;

    /**
     * Creates new form PrintStatementsPanel
     */
    public PrintStatementsPanel(Session session) {
        initComponents();
        this.session = session;
        fillList();
    }

    private void fillList() {
        patients = session.sqlQuery("SELECT * FROM patient", RcdPatient.class);
        String[] names = new String[patients.size()];
        for (int i = 0; i < names.length; ++i) {
            RcdPatient p = patients.get(i);
            names[i] = p.getFirstnames() + " " + p.getSurname();
        }
        lstPatients.setListData(names);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lstPatients = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        epnPreview = new javax.swing.JEditorPane();

        lstPatients.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(lstPatients);

        jButton1.setText("Preview");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Print");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Email");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(epnPreview);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)
                        .addGap(0, 111, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO make preview a popup
        RTFEditorKit rtf = new RTFEditorKit();
        try {
            BufferedReader br = new BufferedReader(new FileReader("account-statement.rtf"));
            epnPreview.setEditorKit(rtf);
            epnPreview.setEditable(false);
            rtf.read(br, epnPreview.getDocument(), 0);
        } catch (IOException ex) {
            // TODO Catch Error Properly
            Logger.getLogger(Settings.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadLocationException ex) {
            Logger.getLogger(PrintStatementsPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        PrinterJob job = PrinterJob.getPrinterJob();
        MessageFormat empty = new MessageFormat("");
        jButton1ActionPerformed(null);
        job.setPrintable(epnPreview.getPrintable(empty, empty));
        boolean result = job.printDialog();
        if (result) {
            try {
                job.print();
            } catch (PrinterException ex) {
                Logger.getLogger(PrintStatementsPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
//        javax.mail.Session mailSession = javax.mail.Session.getInstance(System.getProperties());
//        Message message = new MimeMessage(mailSession);
//        try {
//            message.setFrom(new InternetAddress("noreply@practicedomain.com"));
//            message.addRecipient(Message.RecipientType.TO, new InternetAddress("yaseenmowzer@gmail.com"));
//            message.setSubject("Test");
//            BufferedReader br = new BufferedReader(new FileReader("account-statement.rtf"));
//            char[] rtfDocument = new char[(int) new File("account-statement.rtf").length()];
//            br.read(rtfDocument);
//            br.close();
//            message.setContent(rtfDocument, "application/rtf");
//            Transport.send(message);
//        } catch (MessagingException ex) {
//            Logger.getLogger(PrintStatementsPanel.class.getName()).log(Level.SEVERE, null, ex);
//        }

    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JEditorPane epnPreview;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> lstPatients;
    // End of variables declaration//GEN-END:variables
}
