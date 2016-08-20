/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grade12pat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
    private List<RcdAppointments> rcdAppointmentsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patientid")
    private List<RcdPatientFileAttachments> rcdPatientFileAttachmentsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patientid")
    private List<RcdPatientBillingDetails> rcdPatientBillingDetailsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patientid")
    private List<RcdPatientReadings> rcdPatientReadingsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patientid")
    private List<RcdAllergies> rcdAllergiesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patientid")
    private List<RcdPatientNotes> rcdPatientNotesList;
    @OneToMany(mappedBy = "primarymemberid")
    private List<RcdMedicalAidPlan> rcdMedicalAidPlanList;

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
    public List<RcdAppointments> getRcdAppointmentsList() {
        return rcdAppointmentsList;
    }

    public void setRcdAppointmentsList(List<RcdAppointments> rcdAppointmentsList) {
        this.rcdAppointmentsList = rcdAppointmentsList;
    }

    @XmlTransient
    public List<RcdPatientFileAttachments> getRcdPatientFileAttachmentsList() {
        return rcdPatientFileAttachmentsList;
    }

    public void setRcdPatientFileAttachmentsList(List<RcdPatientFileAttachments> rcdPatientFileAttachmentsList) {
        this.rcdPatientFileAttachmentsList = rcdPatientFileAttachmentsList;
    }

    @XmlTransient
    public List<RcdPatientBillingDetails> getRcdPatientBillingDetailsList() {
        return rcdPatientBillingDetailsList;
    }

    public void setRcdPatientBillingDetailsList(List<RcdPatientBillingDetails> rcdPatientBillingDetailsList) {
        this.rcdPatientBillingDetailsList = rcdPatientBillingDetailsList;
    }

    @XmlTransient
    public List<RcdPatientReadings> getRcdPatientReadingsList() {
        return rcdPatientReadingsList;
    }

    public void setRcdPatientReadingsList(List<RcdPatientReadings> rcdPatientReadingsList) {
        this.rcdPatientReadingsList = rcdPatientReadingsList;
    }

    @XmlTransient
    public List<RcdAllergies> getRcdAllergiesList() {
        return rcdAllergiesList;
    }

    public void setRcdAllergiesList(List<RcdAllergies> rcdAllergiesList) {
        this.rcdAllergiesList = rcdAllergiesList;
    }

    @XmlTransient
    public List<RcdPatientNotes> getRcdPatientNotesList() {
        return rcdPatientNotesList;
    }

    public void setRcdPatientNotesList(List<RcdPatientNotes> rcdPatientNotesList) {
        this.rcdPatientNotesList = rcdPatientNotesList;
    }

    @XmlTransient
    public List<RcdMedicalAidPlan> getRcdMedicalAidPlanList() {
        return rcdMedicalAidPlanList;
    }

    public void setRcdMedicalAidPlanList(List<RcdMedicalAidPlan> rcdMedicalAidPlanList) {
        this.rcdMedicalAidPlanList = rcdMedicalAidPlanList;
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
