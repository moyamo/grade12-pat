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
import javax.persistence.Lob;
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
@Table(name = "PATIENTFILEATTACHMENTS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RcdPatientFileAttachments.findAll", query = "SELECT r FROM RcdPatientFileAttachments r"),
    @NamedQuery(name = "RcdPatientFileAttachments.findById", query = "SELECT r FROM RcdPatientFileAttachments r WHERE r.id = :id"),
    @NamedQuery(name = "RcdPatientFileAttachments.findByFilename", query = "SELECT r FROM RcdPatientFileAttachments r WHERE r.filename = :filename")})
public class RcdPatientFileAttachments implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Lob
    @Column(name = "FILECONTENTS")
    private Serializable filecontents;
    @Basic(optional = false)
    @Column(name = "FILENAME")
    private String filename;
    @JoinColumn(name = "PATIENTID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private RcdPatient patientid;

    public RcdPatientFileAttachments() {
    }

    public RcdPatientFileAttachments(Integer id) {
        this.id = id;
    }

    public RcdPatientFileAttachments(Integer id, Serializable filecontents, String filename) {
        this.id = id;
        this.filecontents = filecontents;
        this.filename = filename;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Serializable getFilecontents() {
        return filecontents;
    }

    public void setFilecontents(Serializable filecontents) {
        this.filecontents = filecontents;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
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
        if (!(object instanceof RcdPatientFileAttachments)) {
            return false;
        }
        RcdPatientFileAttachments other = (RcdPatientFileAttachments) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "grade12pat.RcdPatientFileAttachments[ id=" + id + " ]";
    }
    
}
