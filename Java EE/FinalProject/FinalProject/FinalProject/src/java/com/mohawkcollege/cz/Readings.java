/*
 * StAuth10066: I Chao Zhang, 000306946 certify that this material is my original work. 
 * No other person's work has been used without due acknowledgement. 
 * I have not made my work available to anyone else.
 */
package com.mohawkcollege.cz;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Danny
 */
@Entity
@Table(name = "READINGS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Readings.findAll", query = "SELECT r FROM Readings r"),
    @NamedQuery(name = "Readings.findById", query = "SELECT r FROM Readings r WHERE r.id = :id"),
    @NamedQuery(name = "Readings.findByReadingDate", query = "SELECT r FROM Readings r WHERE r.readingDate = :readingDate"),
    @NamedQuery(name = "Readings.findByReading", query = "SELECT r FROM Readings r WHERE r.reading = :reading"),
    @NamedQuery(name = "Readings.findByMeterID", query = "SELECT r FROM Readings r WHERE r.meterId.meterId = :meterId")})
public class Readings implements Serializable {
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "AMOUNT")
    private Double amount;
    @Column(name = "TOTAL")
    private Double total;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "readings")
    private Costs costs;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "READING_DATE")
    private String readingDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "READING")
    private String reading;
    @JoinColumn(name = "METER_ID", referencedColumnName = "METER_ID")
    @ManyToOne(optional = false)
    private Meters meterId;

    public Readings() {
    }

    public Readings(Integer id) {
        this.id = id;
    }

    public Readings(Integer id, String readingDate, String reading) {
        this.id = id;
        this.readingDate = readingDate;
        this.reading = reading;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReadingDate() {
        return readingDate;
    }

    public void setReadingDate(String readingDate) {
        this.readingDate = readingDate;
    }

    public String getReading() {
        return reading;
    }

    public void setReading(String reading) {
        this.reading = reading;
    }

    public Meters getMeterId() {
        return meterId;
    }

    public void setMeterId(Meters meterId) {
        this.meterId = meterId;
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
        if (!(object instanceof Readings)) {
            return false;
        }
        Readings other = (Readings) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mohawkcollege.cz.Readings[ id=" + id + " ]";
    }

    public Costs getCosts() {
        return costs;
    }

    public void setCosts(Costs costs) {
        this.costs = costs;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
    
}
