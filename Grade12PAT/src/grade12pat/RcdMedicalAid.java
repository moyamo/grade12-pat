/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grade12pat;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "MEDICALAID")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RcdMedicalAid.findAll", query = "SELECT r FROM RcdMedicalAid r"),
    @NamedQuery(name = "RcdMedicalAid.findById", query = "SELECT r FROM RcdMedicalAid r WHERE r.id = :id"),
    @NamedQuery(name = "RcdMedicalAid.findByName", query = "SELECT r FROM RcdMedicalAid r WHERE r.name = :name"),
    @NamedQuery(name = "RcdMedicalAid.findByAddress", query = "SELECT r FROM RcdMedicalAid r WHERE r.address = :address"),
    @NamedQuery(name = "RcdMedicalAid.findByPhonenumber", query = "SELECT r FROM RcdMedicalAid r WHERE r.phonenumber = :phonenumber"),
    @NamedQuery(name = "RcdMedicalAid.findByEmailaddress", query = "SELECT r FROM RcdMedicalAid r WHERE r.emailaddress = :emailaddress")})
public class RcdMedicalAid implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "PHONENUMBER")
    private String phonenumber;
    @Column(name = "EMAILADDRESS")
    private String emailaddress;
    @OneToMany(mappedBy = "medicalaidplanid")
    private Collection<RcdPatientBillingDetails> rcdPatientBillingDetailsCollection;
    @OneToMany(mappedBy = "medicalaidid")
    private Collection<RcdMedicalAidPlan> rcdMedicalAidPlanCollection;

    public RcdMedicalAid() {
    }

    public RcdMedicalAid(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmailaddress() {
        return emailaddress;
    }

    public void setEmailaddress(String emailaddress) {
        this.emailaddress = emailaddress;
    }

    @XmlTransient
    public Collection<RcdPatientBillingDetails> getRcdPatientBillingDetailsCollection() {
        return rcdPatientBillingDetailsCollection;
    }

    public void setRcdPatientBillingDetailsCollection(Collection<RcdPatientBillingDetails> rcdPatientBillingDetailsCollection) {
        this.rcdPatientBillingDetailsCollection = rcdPatientBillingDetailsCollection;
    }

    @XmlTransient
    public Collection<RcdMedicalAidPlan> getRcdMedicalAidPlanCollection() {
        return rcdMedicalAidPlanCollection;
    }

    public void setRcdMedicalAidPlanCollection(Collection<RcdMedicalAidPlan> rcdMedicalAidPlanCollection) {
        this.rcdMedicalAidPlanCollection = rcdMedicalAidPlanCollection;
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
        if (!(object instanceof RcdMedicalAid)) {
            return false;
        }
        RcdMedicalAid other = (RcdMedicalAid) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "grade12pat.RcdMedicalAid[ id=" + id + " ]";
    }
    
}
