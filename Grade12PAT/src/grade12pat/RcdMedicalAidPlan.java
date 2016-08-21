/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grade12pat;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author yaseen
 */
@Entity
@Table(name = "MEDICALAIDPLAN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RcdMedicalAidPlan.findAll", query = "SELECT r FROM RcdMedicalAidPlan r"),
    @NamedQuery(name = "RcdMedicalAidPlan.findById", query = "SELECT r FROM RcdMedicalAidPlan r WHERE r.id = :id"),
    @NamedQuery(name = "RcdMedicalAidPlan.findByMedicalaidnumber", query = "SELECT r FROM RcdMedicalAidPlan r WHERE r.medicalaidnumber = :medicalaidnumber")})
public class RcdMedicalAidPlan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "MEDICALAIDNUMBER")
    private String medicalaidnumber;
    @OneToMany(mappedBy = "medicalaidplanid")
    private List<RcdPatientBillingDetails> rcdPatientBillingDetailsList;
    @JoinColumn(name = "MEDICALAIDID", referencedColumnName = "ID")
    @ManyToOne
    private RcdMedicalAid medicalaidid;
    @JoinColumn(name = "PRIMARYMEMBERID", referencedColumnName = "ID")
    @ManyToOne
    private RcdPatient primarymemberid;

    public RcdMedicalAidPlan() {
    }

    public RcdMedicalAidPlan(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMedicalaidnumber() {
        return medicalaidnumber;
    }

    public void setMedicalaidnumber(String medicalaidnumber) {
        this.medicalaidnumber = medicalaidnumber;
    }

    @XmlTransient
    public List<RcdPatientBillingDetails> getRcdPatientBillingDetailsList() {
        return rcdPatientBillingDetailsList;
    }

    public void setRcdPatientBillingDetailsList(List<RcdPatientBillingDetails> rcdPatientBillingDetailsList) {
        this.rcdPatientBillingDetailsList = rcdPatientBillingDetailsList;
    }

    public RcdMedicalAid getMedicalaidid() {
        return medicalaidid;
    }

    public void setMedicalaidid(RcdMedicalAid medicalaidid) {
        this.medicalaidid = medicalaidid;
    }

    public RcdPatient getPrimarymemberid() {
        return primarymemberid;
    }

    public void setPrimarymemberid(RcdPatient primarymemberid) {
        this.primarymemberid = primarymemberid;
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
        if (!(object instanceof RcdMedicalAidPlan)) {
            return false;
        }
        RcdMedicalAidPlan other = (RcdMedicalAidPlan) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "grade12pat.RcdMedicalAidPlan[ id=" + id + " ]";
    }
    
}
