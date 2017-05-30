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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.metamodel.SingularAttribute;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Bianca_Valentina
 */
@Entity
@Table(name = "vehiculo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vehiculo.findAll", query = "SELECT v FROM Vehiculo v")
    , @NamedQuery(name = "Vehiculo.findByPkVehiculo", query = "SELECT v FROM Vehiculo v WHERE v.pkVehiculo = :pkVehiculo")
    , @NamedQuery(name = "Vehiculo.findBySubtipo", query = "SELECT v FROM Vehiculo v WHERE v.subtipo = :subtipo")
    , @NamedQuery(name = "Vehiculo.findByPlaca", query = "SELECT v FROM Vehiculo v WHERE v.placa = :placa")
    , @NamedQuery(name = "Vehiculo.findByEliminado", query = "SELECT v FROM Vehiculo v WHERE v.eliminado = :eliminado")})
public class Vehiculo implements Serializable {


    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pk_vehiculo")
    private Integer pkVehiculo;
    @Size(max = 45)
    @Column(name = "subtipo")
    private String subtipo;
    @Size(max = 45)
    @Column(name = "placa")
    private String placa;
    @Column(name = "eliminado")
    private Boolean eliminado;

    public Vehiculo() {
    }

    

    public Vehiculo(Integer pkVehiculo) {
        this.pkVehiculo = pkVehiculo;
    }
    //consturctor

    public Vehiculo(String subtipo, String placa, Boolean eliminado) {
        this.subtipo = subtipo;
        this.placa = placa;
        this.eliminado = eliminado;
    } 
    

    public Integer getPkVehiculo() {
        return pkVehiculo;
    }

    public void setPkVehiculo(Integer pkVehiculo) {
        this.pkVehiculo = pkVehiculo;
    }

    public String getSubtipo() {
        return subtipo;
    }

    public void setSubtipo(String subtipo) {
        this.subtipo = subtipo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Boolean getEliminado() {
        return eliminado;
    }

    public void setEliminado(Boolean eliminado) {
        this.eliminado = eliminado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkVehiculo != null ? pkVehiculo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vehiculo)) {
            return false;
        }
        Vehiculo other = (Vehiculo) object;
        if ((this.pkVehiculo == null && other.pkVehiculo != null) || (this.pkVehiculo != null && !this.pkVehiculo.equals(other.pkVehiculo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.model.Vehiculo[ pkVehiculo=" + pkVehiculo + " ]";
    }
    
}
