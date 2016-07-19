/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grade12pat;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author yaseen
 */
@Entity
@Table(name = "PATIENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RcdPatient.findAll", query = "SELECT r FROM RcdPatient r"),
    @NamedQuery(name = "RcdPatient.findById", query = "SELECT r FROM RcdPatient r WHERE r.id = :id"),
    @NamedQuery(name = "RcdPatient.findByFirstnames", query = "SELECT r FROM RcdPatient r WHERE r.firstnames = :firstnames"),
    @NamedQuery(name = "RcdPatient.findBySurname", query = "SELECT r FROM RcdPatient r WHERE r.surname = :surname"),
    @NamedQuery(name = "RcdPatient.findByIdnumber", query = "SELECT r FROM RcdPatient r WHERE r.idnumber = :idnumber"),
    @NamedQuery(name = "RcdPatient.findByCellphonenumber", query = "SELECT r FROM RcdPatient r WHERE r.cellphonenumber = :cellphonenumber"),
    @NamedQuery(name = "RcdPatient.findByBirthday", query = "SELECT r FROM RcdPatient r WHERE r.birthday = :birthday")})
public class RcdPatient implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "FIRSTNAMES")
    private String firstnames;
    @Column(name = "SURNAME")
    private String surname;
    @Column(name = "IDNUMBER")
    private String idnumber;
    @Column(name = "CELLPHONENUMBER")
    private String cellphonenumber;
    @Column(name = "BIRTHDAY")
    @Temporal(TemporalType.DATE)
    private Date birthday;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patientid")
    private Collection<RcdAppointments> rcdAppointmentsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patientid")
    private Collection<RcdPatientMedicalHistory> rcdPatientMedicalHistoryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patientid")
    private Collection<RcdPatientBillingDetails> rcdPatientBillingDetailsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patientid")
    private Collection<RcdAllergies> rcdAllergiesCollection;
    @OneToMany(mappedBy = "primarymemberid")
    private Collection<RcdMedicalAidPlan> rcdMedicalAidPlanCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patientid")
    private Collection<RcdBillingHistory> rcdBillingHistoryCollection;

    public RcdPatient() {
    }

    public RcdPatient(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstnames() {
        return firstnames;
    }

    public void setFirstnames(String firstnames) {
        this.firstnames = firstnames;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber;
    }

    public String getCellphonenumber() {
        return cellphonenumber;
    }

    public void setCellphonenumber(String cellphonenumber) {
        this.cellphonenumber = cellphonenumber;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @XmlTransient
    public Collection<RcdAppointments> getRcdAppointmentsCollection() {
        return rcdAppointmentsCollection;
    }

    public void setRcdAppointmentsCollection(Collection<RcdAppointments> rcdAppointmentsCollection) {
        this.rcdAppointmentsCollection = rcdAppointmentsCollection;
    }

    @XmlTransient
    public Collection<RcdPatientMedicalHistory> getRcdPatientMedicalHistoryCollection() {
        return rcdPatientMedicalHistoryCollection;
    }

    public void setRcdPatientMedicalHistoryCollection(Collection<RcdPatientMedicalHistory> rcdPatientMedicalHistoryCollection) {
        this.rcdPatientMedicalHistoryCollection = rcdPatientMedicalHistoryCollection;
    }

    @XmlTransient
    public Collection<RcdPatientBillingDetails> getRcdPatientBillingDetailsCollection() {
        return rcdPatientBillingDetailsCollection;
    }

    public void setRcdPatientBillingDetailsCollection(Collection<RcdPatientBillingDetails> rcdPatientBillingDetailsCollection) {
        this.rcdPatientBillingDetailsCollection = rcdPatientBillingDetailsCollection;
    }

    @XmlTransient
    public Collection<RcdAllergies> getRcdAllergiesCollection() {
        return rcdAllergiesCollection;
    }

    public void setRcdAllergiesCollection(Collection<RcdAllergies> rcdAllergiesCollection) {
        this.rcdAllergiesCollection = rcdAllergiesCollection;
    }

    @XmlTransient
    public Collection<RcdMedicalAidPlan> getRcdMedicalAidPlanCollection() {
        return rcdMedicalAidPlanCollection;
    }

    public void setRcdMedicalAidPlanCollection(Collection<RcdMedicalAidPlan> rcdMedicalAidPlanCollection) {
        this.rcdMedicalAidPlanCollection = rcdMedicalAidPlanCollection;
    }

    @XmlTransient
    public Collection<RcdBillingHistory> getRcdBillingHistoryCollection() {
        return rcdBillingHistoryCollection;
    }

    public void setRcdBillingHistoryCollection(Collection<RcdBillingHistory> rcdBillingHistoryCollection) {
        this.rcdBillingHistoryCollection = rcdBillingHistoryCollection;
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
        if (!(object instanceof RcdPatient)) {
            return false;
        }
        RcdPatient other = (RcdPatient) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "grade12pat.RcdPatient[ id=" + id + " ]";
    }
    
}
