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
@Table(name = "PATIENTREADINGS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RcdPatientReadings.findAll", query = "SELECT r FROM RcdPatientReadings r"),
    @NamedQuery(name = "RcdPatientReadings.findById", query = "SELECT r FROM RcdPatientReadings r WHERE r.id = :id"),
    @NamedQuery(name = "RcdPatientReadings.findByReading", query = "SELECT r FROM RcdPatientReadings r WHERE r.reading = :reading"),
    @NamedQuery(name = "RcdPatientReadings.findByReadingtype", query = "SELECT r FROM RcdPatientReadings r WHERE r.readingtype = :readingtype"),
    @NamedQuery(name = "RcdPatientReadings.findByTime", query = "SELECT r FROM RcdPatientReadings r WHERE r.time = :time")})
public class RcdPatientReadings implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "READING")
    private double reading;
    @Basic(optional = false)
    @Column(name = "READINGTYPE")
    private String readingtype;
    @Basic(optional = false)
    @Column(name = "TIME")
    @Temporal(TemporalType.DATE)
    private Date time;
    @JoinColumn(name = "MEDICALHISTORYID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private RcdPatientMedicalHistory medicalhistoryid;

    public RcdPatientReadings() {
    }

    public RcdPatientReadings(Integer id) {
        this.id = id;
    }

    public RcdPatientReadings(Integer id, double reading, String readingtype, Date time) {
        this.id = id;
        this.reading = reading;
        this.readingtype = readingtype;
        this.time = time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getReading() {
        return reading;
    }

    public void setReading(double reading) {
        this.reading = reading;
    }

    public String getReadingtype() {
        return readingtype;
    }

    public void setReadingtype(String readingtype) {
        this.readingtype = readingtype;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public RcdPatientMedicalHistory getMedicalhistoryid() {
        return medicalhistoryid;
    }

    public void setMedicalhistoryid(RcdPatientMedicalHistory medicalhistoryid) {
        this.medicalhistoryid = medicalhistoryid;
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
        if (!(object instanceof RcdPatientReadings)) {
            return false;
        }
        RcdPatientReadings other = (RcdPatientReadings) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "grade12pat.RcdPatientReadings[ id=" + id + " ]";
    }
    
}
