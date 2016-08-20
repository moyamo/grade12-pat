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
@Table(name = "PAYMENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RcdPayment.findAll", query = "SELECT r FROM RcdPayment r"),
    @NamedQuery(name = "RcdPayment.findById", query = "SELECT r FROM RcdPayment r WHERE r.id = :id"),
    @NamedQuery(name = "RcdPayment.findByPatientid", query = "SELECT r FROM RcdPayment r WHERE r.patientid = :patientid"),
    @NamedQuery(name = "RcdPayment.findByAmount", query = "SELECT r FROM RcdPayment r WHERE r.amount = :amount"),
    @NamedQuery(name = "RcdPayment.findByTime", query = "SELECT r FROM RcdPayment r WHERE r.time = :time")})
public class RcdPayment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "PATIENTID")
    private int patientid;
    @Basic(optional = false)
    @Column(name = "AMOUNT")
    private int amount;
    @Basic(optional = false)
    @Column(name = "TIME")
    @Temporal(TemporalType.DATE)
    private Date time;

    public RcdPayment() {
    }

    public RcdPayment(Integer id) {
        this.id = id;
    }

    public RcdPayment(Integer id, int patientid, int amount, Date time) {
        this.id = id;
        this.patientid = patientid;
        this.amount = amount;
        this.time = time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getPatientid() {
        return patientid;
    }

    public void setPatientid(int patientid) {
        this.patientid = patientid;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
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
        if (!(object instanceof RcdPayment)) {
            return false;
        }
        RcdPayment other = (RcdPayment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "grade12pat.RcdPayment[ id=" + id + " ]";
    }
    
}
