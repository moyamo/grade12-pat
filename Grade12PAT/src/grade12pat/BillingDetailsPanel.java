/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grade12pat;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import javax.persistence.EntityManager;

/**
 *
 * @author yaseen
 */
public class BillingDetailsPanel extends javax.swing.JPanel {

    private Session session;
    private RcdPatientBillingDetails details;

    /**
     * Creates new form BillingDetailsPanel
     */
    public BillingDetailsPanel(Session session, RcdPatientBillingDetails details) {
        initComponents();
        this.session = session;
        txfMember.setSession(session);
        this.details = details;
        fillInformation();
    }

    private void fillInformation() {
        txfEmailAddress.setText(details.getEmailaddress());
        txaHomeAddress.setText(details.getHomeaddress());
        if (details.getPaymentmethod() != null) {
            cmbPaymentMethod.setSelectedIndex(details.getPaymentmethod().equals("MEDICALAID") ? 0 : 1);
        }
        if (details.getMedicalaidplanid() != null) {
            txfMember.setSelectedPatient(details.getMedicalaidplanid().getPrimarymemberid());
        }
        txfMember.setActive();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmbPaymentMethod = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txfEmailAddress = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaHomeAddress = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txfMember = new grade12pat.PatientTextField();

        cmbPaymentMethod.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Medical Aid", "Cash" }));
        cmbPaymentMethod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPaymentMethodActionPerformed(evt);
            }
        });

        jButton2.setText("Save");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("Email Address");

        jLabel2.setText("Home Address");

        jLabel3.setText("Payment Method");

        jButton1.setText("Edit Plan");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txaHomeAddress.setColumns(20);
        txaHomeAddress.setRows(5);
        jScrollPane1.setViewportView(txaHomeAddress);

        jLabel4.setText("Name of Member");

        jLabel5.setText("or");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel2)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addGap(18, 18, 18)
                            .addComponent(cmbPaymentMethod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(25, 25, 25)
                            .addComponent(txfEmailAddress))
                        .addComponent(jScrollPane1))
                    .addComponent(jButton2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txfMember, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(155, 155, 155))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txfEmailAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbPaymentMethod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txfMember, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmbPaymentMethodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPaymentMethodActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_cmbPaymentMethodActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        details.setEmailaddress(txfEmailAddress.getText());
        details.setHomeaddress(txaHomeAddress.getText());
        String paymentMethod = (String) cmbPaymentMethod.getSelectedItem();
        if (paymentMethod.equals("Medical Aid")) {
            details.setPaymentmethod("MEDICALAID");
            RcdPatient member = txfMember.getSelectedPatient();
            if (member == null) {
                member = details.getPatientid();
                txfMember.setSelectedPatient(member);
            }
            try {
                RcdMedicalAidPlan plan = txfMember.getSelectedPatient().getRcdMedicalAidPlanList().iterator().next();
                details.setMedicalaidplanid(plan);
            } catch (NoSuchElementException e) {
                EntityManager em = session.getEntityManager();
                em.getTransaction().begin();
                RcdMedicalAidPlan plan = new RcdMedicalAidPlan(session.nextId("MedicalAidPlan"));
                details.setMedicalaidplanid(plan);
                if (plan.getRcdPatientBillingDetailsList() == null) {
                    plan.setRcdPatientBillingDetailsList(new ArrayList());
                }
                plan.getRcdPatientBillingDetailsList().add(details);
                plan.setPrimarymemberid(member);
                em.persist(plan);
                em.getTransaction().commit();
            }
        } else if (paymentMethod.equals("Cash")) {
            details.setPaymentmethod("CASH");
        } else {
            throw new RuntimeException("ComboBox selection in BillingDetails was '" + paymentMethod + "' which is invalid");
        }

        session.getEntityManager().getTransaction().begin();
        session.getEntityManager().persist(details);
        if (session.commit()) {
            session.closeTab();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        session.showEditMedicalAid(details.getMedicalaidplanid());
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbPaymentMethod;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txaHomeAddress;
    private javax.swing.JTextField txfEmailAddress;
    private grade12pat.PatientTextField txfMember;
    // End of variables declaration//GEN-END:variables
}
