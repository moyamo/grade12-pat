/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grade12pat;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author yaseen
 */
@Entity
@Table(name = "ALLERGIES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RcdAllergies.findAll", query = "SELECT r FROM RcdAllergies r"),
    @NamedQuery(name = "RcdAllergies.findById", query = "SELECT r FROM RcdAllergies r WHERE r.id = :id"),
    @NamedQuery(name = "RcdAllergies.findByAllergytype", query = "SELECT r FROM RcdAllergies r WHERE r.allergytype = :allergytype")})
public class RcdAllergies implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "ALLERGYTYPE")
    private String allergytype;
    @JoinColumn(name = "PATIENTID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private RcdPatient patientid;

    public RcdAllergies() {
    }

    public RcdAllergies(Integer id) {
        this.id = id;
    }

    public RcdAllergies(Integer id, String allergytype) {
        this.id = id;
        this.allergytype = allergytype;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAllergytype() {
        return allergytype;
    }

    public void setAllergytype(String allergytype) {
        this.allergytype = allergytype;
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
        if (!(object instanceof RcdAllergies)) {
            return false;
        }
        RcdAllergies other = (RcdAllergies) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "grade12pat.RcdAllergies[ id=" + id + " ]";
    }
    
}
