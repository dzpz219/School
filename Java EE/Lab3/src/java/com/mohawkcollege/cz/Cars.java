/*
 * StAuth10066: I Chao Zhang, 000306946 certify that this material is my original work. 
 * No other person's work has been used without due acknowledgement. 
 * I have not made my work available to anyone else.
 */
package com.mohawkcollege.cz;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "CARS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cars.findAll", query = "SELECT c FROM Cars c"),
    @NamedQuery(name = "Cars.findById", query = "SELECT c FROM Cars c WHERE c.id = :id"),
    @NamedQuery(name = "Cars.findByMake", query = "SELECT c FROM Cars c WHERE c.make = :make"),
    @NamedQuery(name = "Cars.findByModel", query = "SELECT c FROM Cars c WHERE c.model = :model"),
    @NamedQuery(name = "Cars.findByModelyear", query = "SELECT c FROM Cars c WHERE c.modelyear = :modelyear"),
    @NamedQuery(name = "Cars.deleteById", query = "DELETE FROM Cars c WHERE c.id = :id")})
public class Cars implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "MAKE")
    private String make;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "MODEL")
    private String model;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "MODELYEAR")
    private String modelyear;
    @OneToMany(mappedBy = "carId")
    private Collection<Mileage> mileageCollection;

    public Cars() {
    }

    public Cars(Integer id) {
        this.id = id;
    }

    public Cars(Integer id, String make, String model, String modelyear) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.modelyear = modelyear;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModelyear() {
        return modelyear;
    }

    public void setModelyear(String modelyear) {
        this.modelyear = modelyear;
    }

    @XmlTransient
    public Collection<Mileage> getMileageCollection() {
        return mileageCollection;
    }

    public void setMileageCollection(Collection<Mileage> mileageCollection) {
        this.mileageCollection = mileageCollection;
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
        if (!(object instanceof Cars)) {
            return false;
        }
        Cars other = (Cars) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mohawkcollege.cz.Cars[ id=" + id + " ]";
    }
    
}
