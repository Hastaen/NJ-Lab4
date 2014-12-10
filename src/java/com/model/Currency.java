/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Henrik
 */
@Entity
@Table(name = "CURRENCY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Currency.findAll", query = "SELECT c FROM Currency c"),
    @NamedQuery(name = "Currency.findBySrc", query = "SELECT c FROM Currency c WHERE c.src = :src"),
    @NamedQuery(name = "Currency.findByEuro", query = "SELECT c FROM Currency c WHERE c.euro = :euro"),
    @NamedQuery(name = "Currency.findByPounds", query = "SELECT c FROM Currency c WHERE c.pounds = :pounds"),
    @NamedQuery(name = "Currency.findByKronor", query = "SELECT c FROM Currency c WHERE c.kronor = :kronor"),
    @NamedQuery(name = "Currency.findByUsd", query = "SELECT c FROM Currency c WHERE c.usd = :usd")})
public class Currency implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "SRC")
    private String src;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EURO")
    private double euro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "POUNDS")
    private double pounds;
    @Basic(optional = false)
    @NotNull
    @Column(name = "KRONOR")
    private double kronor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "USD")
    private double usd;

    public Currency() {
    }

    public Currency(String src) {
        this.src = src;
    }

    public Currency(String src, double euro, double pounds, double kronor, double usd) {
        this.src = src;
        this.euro = euro;
        this.pounds = pounds;
        this.kronor = kronor;
        this.usd = usd;
    }

    public String convert(String toCurrency, int amount){
        System.out.println("INSIDE FUCKING JPA SHIT MF SHIT !!!!!!!!!!!!!!!!!!!!!!!!! ");
        double result = 0;
        
        switch (toCurrency) {
            case "euro":  result = calculateConversion(euro, amount);
                     break;
            case "pounds":  result = calculateConversion(pounds, amount);
                     break;
            case "kronor":  result = calculateConversion(kronor, amount);
                     break;
            case "usd":  result = calculateConversion(usd, amount);
                     break;
        }
        System.out.println(result);
        return String.valueOf(result);
    }
    
    private double calculateConversion(double currency, int amount){
        return currency * amount;
    }
        
    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public double getEuro() {
        return euro;
    }

    public void setEuro(double euro) {
        this.euro = euro;
    }

    public double getPounds() {
        return pounds;
    }

    public void setPounds(double pounds) {
        this.pounds = pounds;
    }

    public double getKronor() {
        return kronor;
    }

    public void setKronor(double kronor) {
        this.kronor = kronor;
    }

    public double getUsd() {
        return usd;
    }

    public void setUsd(double usd) {
        this.usd = usd;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (src != null ? src.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Currency)) {
            return false;
        }
        Currency other = (Currency) object;
        if ((this.src == null && other.src != null) || (this.src != null && !this.src.equals(other.src))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.model.Currency[ src=" + src + " ]";
    }
    
}
