/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grade12pat;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author yaseen
 */
@Entity
@Table(name = "PATIENTNOTES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RcdPatientNotes.findAll", query = "SELECT r FROM RcdPatientNotes r"),
    @NamedQuery(name = "RcdPatientNotes.findById", query = "SELECT r FROM RcdPatientNotes r WHERE r.id = :id"),
    @NamedQuery(name = "RcdPatientNotes.findByTime", query = "SELECT r FROM RcdPatientNotes r WHERE r.time = :time")})
public class RcdPatientNotes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Lob
    @Column(name = "NOTES")
    private String notes;
    @Basic(optional = false)
    @Column(name = "TIME")
    @Temporal(TemporalType.DATE)
    private Date time;
    @JoinColumn(name = "PATIENTID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private RcdPatient patientid;

    public RcdPatientNotes() {
    }

    public RcdPatientNotes(Integer id) {
        this.id = id;
    }

    public RcdPatientNotes(Integer id, String notes, Date time) {
        this.id = id;
        this.notes = notes;
        this.time = time;
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

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
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
        if (!(object instanceof RcdPatientNotes)) {
            return false;
        }
        RcdPatientNotes other = (RcdPatientNotes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "grade12pat.RcdPatientNotes[ id=" + id + " ]";
    }
    
}
