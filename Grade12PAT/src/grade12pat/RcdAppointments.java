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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "APPOINTMENTS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RcdAppointments.findAll", query = "SELECT r FROM RcdAppointments r"),
    @NamedQuery(name = "RcdAppointments.findById", query = "SELECT r FROM RcdAppointments r WHERE r.id = :id"),
    @NamedQuery(name = "RcdAppointments.findByDoctor", query = "SELECT r FROM RcdAppointments r WHERE r.doctor = :doctor"),
    @NamedQuery(name = "RcdAppointments.findByTime", query = "SELECT r FROM RcdAppointments r WHERE r.time = :time")})
public class RcdAppointments implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "DOCTOR")
    private String doctor;
    @Basic(optional = false)
    @Column(name = "TIME")
    @Temporal(TemporalType.DATE)
    private Date time;
    @JoinColumn(name = "PATIENTID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private RcdPatient patientid;
    @OneToMany(mappedBy = "appointmentid")
    private List<RcdBillingHistory> rcdBillingHistoryList;

    public RcdAppointments() {
    }

    public RcdAppointments(Integer id) {
        this.id = id;
    }

    public RcdAppointments(Integer id, String doctor, Date time) {
        this.id = id;
        this.doctor = doctor;
        this.time = time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
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

    @XmlTransient
    public List<RcdBillingHistory> getRcdBillingHistoryList() {
        return rcdBillingHistoryList;
    }

    public void setRcdBillingHistoryList(List<RcdBillingHistory> rcdBillingHistoryList) {
        this.rcdBillingHistoryList = rcdBillingHistoryList;
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
        if (!(object instanceof RcdAppointments)) {
            return false;
        }
        RcdAppointments other = (RcdAppointments) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "grade12pat.RcdAppointments[ id=" + id + " ]";
    }
    
}
