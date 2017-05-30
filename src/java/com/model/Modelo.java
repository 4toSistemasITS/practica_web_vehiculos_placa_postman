/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Bianca_Valentina
 */
@Entity
@Table(name = "modelo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Modelo.findAll", query = "SELECT m FROM Modelo m")
    , @NamedQuery(name = "Modelo.findByPkmodelo", query = "SELECT m FROM Modelo m WHERE m.pkmodelo = :pkmodelo")
    , @NamedQuery(name = "Modelo.findByMarca", query = "SELECT m FROM Modelo m WHERE m.marca = :marca")
    , @NamedQuery(name = "Modelo.findByColor", query = "SELECT m FROM Modelo m WHERE m.color = :color")
    , @NamedQuery(name = "Modelo.findByFechaRegistro", query = "SELECT m FROM Modelo m WHERE m.fechaRegistro = :fechaRegistro")})
public class Modelo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pkmodelo")
    private Integer pkmodelo;
    @Size(max = 45)
    @Column(name = "marca")
    private String marca;
    @Size(max = 45)
    @Column(name = "color")
    private String color;
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;

    public Modelo() {
    }

    public Modelo(Integer pkmodelo) {
        this.pkmodelo = pkmodelo;
    }

    public Modelo(String marca, String color, Date fechaRegistro) {
        this.marca = marca;
        this.color = color;
        this.fechaRegistro = fechaRegistro;
    }
    

    public Integer getPkmodelo() {
        return pkmodelo;
    }

    public void setPkmodelo(Integer pkmodelo) {
        this.pkmodelo = pkmodelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkmodelo != null ? pkmodelo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Modelo)) {
            return false;
        }
        Modelo other = (Modelo) object;
        if ((this.pkmodelo == null && other.pkmodelo != null) || (this.pkmodelo != null && !this.pkmodelo.equals(other.pkmodelo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.model.Modelo[ pkmodelo=" + pkmodelo + " ]";
    }
    
}
