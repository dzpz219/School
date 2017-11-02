/*
 * StAuth10066: I Chao Zhang, 000306946 certify that this material is my original work. 
 * No other person's work has been used without due acknowledgement. 
 * I have not made my work available to anyone else.
 */
package com.mohawkcollege.cz;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Danny
 */
@Entity
@Table(name = "METERS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Meters.findAll", query = "SELECT m FROM Meters m"),
    @NamedQuery(name = "Meters.findById", query = "SELECT m FROM Meters m WHERE m.id = :id"),
    @NamedQuery(name = "Meters.findByMeterId", query = "SELECT m FROM Meters m WHERE m.meterId = :meterId"),
    @NamedQuery(name = "Meters.findByAddress", query = "SELECT m FROM Meters m WHERE m.address = :address")})
public class Meters implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "ID")
    private int id;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "METER_ID")
    private String meterId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "ADDRESS")
    private String address;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "meterId")
    private Collection<Users> usersCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "meterId")
    private Collection<Readings> readingsCollection;

    public Meters() {
    }

    public Meters(String meterId) {
        this.meterId = meterId;
    }

    public Meters(String meterId, int id, String address) {
        this.meterId = meterId;
        this.id = id;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMeterId() {
        return meterId;
    }

    public void setMeterId(String meterId) {
        this.meterId = meterId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @XmlTransient
    public Collection<Users> getUsersCollection() {
        return usersCollection;
    }

    public void setUsersCollection(Collection<Users> usersCollection) {
        this.usersCollection = usersCollection;
    }

    @XmlTransient
    public Collection<Readings> getReadingsCollection() {
        return readingsCollection;
    }

    public void setReadingsCollection(Collection<Readings> readingsCollection) {
        this.readingsCollection = readingsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (meterId != null ? meterId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Meters)) {
            return false;
        }
        Meters other = (Meters) object;
        if ((this.meterId == null && other.meterId != null) || (this.meterId != null && !this.meterId.equals(other.meterId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mohawkcollege.cz.Meters[ meterId=" + meterId + " ]";
    }
    
}
