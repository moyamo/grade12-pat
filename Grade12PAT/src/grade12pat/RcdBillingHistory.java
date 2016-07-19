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
@Table(name = "BILLINGHISTORY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RcdBillingHistory.findAll", query = "SELECT r FROM RcdBillingHistory r"),
    @NamedQuery(name = "RcdBillingHistory.findById", query = "SELECT r FROM RcdBillingHistory r WHERE r.id = :id"),
    @NamedQuery(name = "RcdBillingHistory.findByEmailaddress", query = "SELECT r FROM RcdBillingHistory r WHERE r.emailaddress = :emailaddress"),
    @NamedQuery(name = "RcdBillingHistory.findByDescription", query = "SELECT r FROM RcdBillingHistory r WHERE r.description = :description"),
    @NamedQuery(name = "RcdBillingHistory.findByPrice", query = "SELECT r FROM RcdBillingHistory r WHERE r.price = :price"),
    @NamedQuery(name = "RcdBillingHistory.findByTime", query = "SELECT r FROM RcdBillingHistory r WHERE r.time = :time")})
public class RcdBillingHistory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "EMAILADDRESS")
    private String emailaddress;
    @Basic(optional = false)
    @Column(name = "DESCRIPTION")
    private String description;
    @Basic(optional = false)
    @Column(name = "PRICE")
    private int price;
    @Column(name = "TIME")
    @Temporal(TemporalType.DATE)
    private Date time;
    @JoinColumn(name = "CONSULTATIONID", referencedColumnName = "ID")
    @ManyToOne
    private RcdAppointments consultationid;
    @JoinColumn(name = "PATIENTID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private RcdPatient patientid;

    public RcdBillingHistory() {
    }

    public RcdBillingHistory(Integer id) {
        this.id = id;
    }

    public RcdBillingHistory(Integer id, String description, int price) {
        this.id = id;
        this.description = description;
        this.price = price;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public RcdAppointments getConsultationid() {
        return consultationid;
    }

    public void setConsultationid(RcdAppointments consultationid) {
        this.consultationid = consultationid;
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
        if (!(object instanceof RcdBillingHistory)) {
            return false;
        }
        RcdBillingHistory other = (RcdBillingHistory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "grade12pat.RcdBillingHistory[ id=" + id + " ]";
    }
    
}
