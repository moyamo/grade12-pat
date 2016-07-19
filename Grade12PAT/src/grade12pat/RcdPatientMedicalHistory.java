/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grade12pat;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author yaseen
 */
@Entity
@Table(name = "PATIENTMEDICALHISTORY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RcdPatientMedicalHistory.findAll", query = "SELECT r FROM RcdPatientMedicalHistory r"),
    @NamedQuery(name = "RcdPatientMedicalHistory.findById", query = "SELECT r FROM RcdPatientMedicalHistory r WHERE r.id = :id")})
public class RcdPatientMedicalHistory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Lob
    @Column(name = "NOTES")
    private String notes;
    @JoinColumn(name = "PATIENTID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private RcdPatient patientid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medicalhistoryid")
    private Collection<RcdPatientFileAttachments> rcdPatientFileAttachmentsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medicalhistoryid")
    private Collection<RcdPatientReadings> rcdPatientReadingsCollection;

    public RcdPatientMedicalHistory() {
    }

    public RcdPatientMedicalHistory(Integer id) {
        this.id = id;
    }

    public RcdPatientMedicalHistory(Integer id, String notes) {
        this.id = id;
        this.notes = notes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public RcdPatient getPatientid() {
        return patientid;
    }

    public void setPatientid(RcdPatient patientid) {
        this.patientid = patientid;
    }

    @XmlTransient
    public Collection<RcdPatientFileAttachments> getRcdPatientFileAttachmentsCollection() {
        return rcdPatientFileAttachmentsCollection;
    }

    public void setRcdPatientFileAttachmentsCollection(Collection<RcdPatientFileAttachments> rcdPatientFileAttachmentsCollection) {
        this.rcdPatientFileAttachmentsCollection = rcdPatientFileAttachmentsCollection;
    }

    @XmlTransient
    public Collection<RcdPatientReadings> getRcdPatientReadingsCollection() {
        return rcdPatientReadingsCollection;
    }

    public void setRcdPatientReadingsCollection(Collection<RcdPatientReadings> rcdPatientReadingsCollection) {
        this.rcdPatientReadingsCollection = rcdPatientReadingsCollection;
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
        if (!(object instanceof RcdPatientMedicalHistory)) {
            return false;
        }
        RcdPatientMedicalHistory other = (RcdPatientMedicalHistory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "grade12pat.RcdPatientMedicalHistory[ id=" + id + " ]";
    }
    
}
