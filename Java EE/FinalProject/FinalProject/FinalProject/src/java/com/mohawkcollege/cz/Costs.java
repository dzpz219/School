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
@Table(name = "COSTS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Costs.findAll", query = "SELECT c FROM Costs c"),
    @NamedQuery(name = "Costs.findById", query = "SELECT c FROM Costs c WHERE c.id = :id"),
    @NamedQuery(name = "Costs.findByLow", query = "SELECT c FROM Costs c WHERE c.low = :low"),
    @NamedQuery(name = "Costs.findByMedium", query = "SELECT c FROM Costs c WHERE c.medium = :medium"),
    @NamedQuery(name = "Costs.findByHigh", query = "SELECT c FROM Costs c WHERE c.high = :high"),
    @NamedQuery(name = "Costs.findByAdminfee", query = "SELECT c FROM Costs c WHERE c.adminfee = :adminfee"),
    @NamedQuery(name = "Costs.findBySubtotal", query = "SELECT c FROM Costs c WHERE c.subtotal = :subtotal"),
    @NamedQuery(name = "Costs.findByTax", query = "SELECT c FROM Costs c WHERE c.tax = :tax"),
    @NamedQuery(name = "Costs.findByTotal", query = "SELECT c FROM Costs c WHERE c.total = :total"),
    @NamedQuery(name = "Costs.findByMeterId", query = "SELECT c FROM Costs c WHERE c.meterId = :meterId"),
    @NamedQuery(name = "Costs.findByReadingDate", query = "SELECT c FROM Costs c WHERE c.readingDate = :readingDate")})
public class Costs implements Serializable {
    @Column(name = "LOW_AMOUNT")
    private Double lowAmount;
    @Column(name = "MEDIUM_AMOUNT")
    private Double mediumAmount;
    @Column(name = "HIGH_AMOUNT")
    private Double highAmount;
    @Column(name = "AVERAGE")
    private Double average;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "AMOUNT")
    private Double amount;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "LOW")
    private Double low;
    @Column(name = "MEDIUM")
    private Double medium;
    @Column(name = "HIGH")
    private Double high;
    @Column(name = "ADMINFEE")
    private Double adminfee;
    @Column(name = "SUBTOTAL")
    private Double subtotal;
    @Column(name = "TAX")
    private Double tax;
    @Column(name = "TOTAL")
    private Double total;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "METER_ID")
    private String meterId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "READING_DATE")
    private String readingDate;
    @JoinColumn(name = "ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Readings readings;

    public Costs() {
    }

    public Costs(Integer id) {
        this.id = id;
    }

    public Costs(Integer id, String meterId, String readingDate) {
        this.id = id;
        this.meterId = meterId;
        this.readingDate = readingDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getLow() {
        return low;
    }

    public void setLow(Double low) {
        this.low = low;
    }

    public Double getMedium() {
        return medium;
    }

    public void setMedium(Double medium) {
        this.medium = medium;
    }

    public Double getHigh() {
        return high;
    }

    public void setHigh(Double high) {
        this.high = high;
    }

    public Double getAdminfee() {
        return adminfee;
    }

    public void setAdminfee(Double adminfee) {
        this.adminfee = adminfee;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getMeterId() {
        return meterId;
    }

    public void setMeterId(String meterId) {
        this.meterId = meterId;
    }

    public String getReadingDate() {
        return readingDate;
    }

    public void setReadingDate(String readingDate) {
        this.readingDate = readingDate;
    }

    public Readings getReadings() {
        return readings;
    }

    public void setReadings(Readings readings) {
        this.readings = readings;
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
        if (!(object instanceof Costs)) {
            return false;
        }
        Costs other = (Costs) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mohawkcollege.cz.Costs[ id=" + id + " ]";
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getAverage() {
        return average;
    }

    public void setAverage(Double average) {
        this.average = average;
    }

    public Double getLowAmount() {
        return lowAmount;
    }

    public void setLowAmount(Double lowAmount) {
        this.lowAmount = lowAmount;
    }

    public Double getMediumAmount() {
        return mediumAmount;
    }

    public void setMediumAmount(Double mediumAmount) {
        this.mediumAmount = mediumAmount;
    }

    public Double getHighAmount() {
        return highAmount;
    }

    public void setHighAmount(Double highAmount) {
        this.highAmount = highAmount;
    }
    
}
