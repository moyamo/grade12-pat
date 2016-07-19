/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grade12pat;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author yaseen
 */
@Entity
@Table(name = "PATIENTBILLINGDETAILS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RcdPatientBillingDetails.findAll", query = "SELECT r FROM RcdPatientBillingDetails r"),
    @NamedQuery(name = "RcdPatientBillingDetails.findById", query = "SELECT r FROM RcdPatientBillingDetails r WHERE r.id = :id"),
    @NamedQuery(name = "RcdPatientBillingDetails.findByEmailaddress", query = "SELECT r FROM RcdPatientBillingDetails r WHERE r.emailaddress = :emailaddress"),
    @NamedQuery(name = "RcdPatientBillingDetails.findByHomeaddress", query = "SELECT r FROM RcdPatientBillingDetails r WHERE r.homeaddress = :homeaddress"),
    @NamedQuery(name = "RcdPatientBillingDetails.findByPaymentmethod", query = "SELECT r FROM RcdPatientBillingDetails r WHERE r.paymentmethod = :paymentmethod")})
public class RcdPatientBillingDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "EMAILADDRESS")
    private String emailaddress;
    @Column(name = "HOMEADDRESS")
    private String homeaddress;
    @Column(name = "PAYMENTMETHOD")
    private String paymentmethod;
    @JoinColumn(name = "MEDICALAIDPLANID", referencedColumnName = "ID")
    @ManyToOne
    private RcdMedicalAid medicalaidplanid;
    @JoinColumn(name = "PATIENTID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private RcdPatient patientid;

    public RcdPatientBillingDetails() {
    }

    public RcdPatientBillingDetails(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmailaddress() {
        return emailaddress;
    }

    public void setEmailaddress(String emailaddress) {
        this.emailaddress = emailaddress;
    }

    public String getHomeaddress() {
        return homeaddress;
    }

    public void setHomeaddress(String homeaddress) {
        this.homeaddress = homeaddress;
    }

    public String getPaymentmethod() {
        return paymentmethod;
    }

    public void setPaymentmethod(String paymentmethod) {
        this.paymentmethod = paymentmethod;
    }

    public RcdMedicalAid getMedicalaidplanid() {
        return medicalaidplanid;
    }

    public void setMedicalaidplanid(RcdMedicalAid medicalaidplanid) {
        this.medicalaidplanid = medicalaidplanid;
    }

    public RcdPatient getPatientid() {
        return patientid;
    }

    public void setPatientid(RcdPatient patientid) {
        this.patientid = patientid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RcdPatientBillingDetails)) {
            return false;
        }
        RcdPatientBillingDetails other = (RcdPatientBillingDetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "grade12pat.RcdPatientBillingDetails[ id=" + id + " ]";
    }
    
}
