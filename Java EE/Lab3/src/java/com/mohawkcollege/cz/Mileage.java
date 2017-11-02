/*
 * StAuth10066: I Chao Zhang, 000306946 certify that this material is my original work. 
 * No other person's work has been used without due acknowledgement. 
 * I have not made my work available to anyone else.
 */
package com.mohawkcollege.cz;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Danny
 */
@Entity
@Table(name = "MILEAGE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mileage.findAll", query = "SELECT m FROM Mileage m"),
    @NamedQuery(name = "Mileage.findById", query = "SELECT m FROM Mileage m WHERE m.id = :id"),
    @NamedQuery(name = "Mileage.findByStartkm", query = "SELECT m FROM Mileage m WHERE m.startkm = :startkm"),
    @NamedQuery(name = "Mileage.findByEndkm", query = "SELECT m FROM Mileage m WHERE m.endkm = :endkm"),
    @NamedQuery(name = "Mileage.findByGasused", query = "SELECT m FROM Mileage m WHERE m.gasused = :gasused"),
    @NamedQuery(name = "Mileage.findByCarId", query = "SELECT m FROM Mileage m WHERE m.carId.id = :carId"),
    @NamedQuery(name = "Mileage.deleteMileageByCarId", query = "DELETE FROM Mileage m WHERE m.carId = :carId")})
public class Mileage implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "STARTKM")
    private int startkm;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ENDKM")
    private int endkm;
    @Basic(optional = false)
    @NotNull
    @Column(name = "GASUSED")
    private float gasused;
    @JoinColumn(name = "CAR_ID", referencedColumnName = "ID")
    @ManyToOne
    private Cars carId;
    
    public Mileage() {
    }

    public Mileage(Integer id) {
        this.id = id;
    }
    @Transient
    private int trip;

    /**
     * Get the value of trip
     *
     * @return the value of trip
     */
    public double getTrip() {
        trip = endkm - startkm;
        return trip;
    }
    
    @Transient
    private double fuelEconomy;

    /**
     * Get the value of fuelEconomy
     *
     * @return the value of fuelEconomy
     */
    public double getFuelEconomy() {
        fuelEconomy = gasused / trip * 100;
        return fuelEconomy;
    }


    public Mileage(Integer id, int startkm, int endkm, float gasused) {
        this.id = id;
        this.startkm = startkm;
        this.endkm = endkm;
        this.gasused = gasused;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getStartkm() {
        return startkm;
    }

    public void setStartkm(int startkm) {
        this.startkm = startkm;
    }

    public int getEndkm() {
        return endkm;
    }

    public void setEndkm(int endkm) {
        this.endkm = endkm;
    }

    public float getGasused() {
        return gasused;
    }

    public void setGasused(float gasused) {
        this.gasused = gasused;
    }

    public Cars getCarId() {
        return carId;
    }

    public void setCarId(Cars carId) {
        this.carId = carId;
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
        if (!(object instanceof Mileage)) {
            return false;
        }
        Mileage other = (Mileage) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mohawkcollege.cz.Mileage[ id=" + id + " ]";
    }
    
}
